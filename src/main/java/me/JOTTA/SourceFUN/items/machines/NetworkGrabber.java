package me.JOTTA.SourceFUN.items.machines;

import io.github.sefiraat.networks.NetworkStorage;
import io.github.sefiraat.networks.network.NodeDefinition;
import io.github.sefiraat.networks.network.NodeType;
import io.github.sefiraat.networks.slimefun.network.NetworkDirectional;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class NetworkGrabber extends NetworkDirectional {

    /** Delay entre execuções (20 ticks = 1s) */
    private static final int TICK_DELAY = 4;

    /** Chave persistente por bloco */
    private static final String KEY_TICK = "grabber-tick";

    public NetworkGrabber(
            ItemGroup itemGroup,
            SlimefunItemStack item,
            RecipeType recipeType,
            ItemStack[] recipe
    ) {
        super(itemGroup, item, recipeType, recipe, NodeType.GRABBER);
    }

    @Override
    protected void onTick(@Nullable BlockMenu blockMenu, @Nonnull Block block) {
        super.onTick(blockMenu, block);

        if (blockMenu == null) {
            return;
        }

        // 🔹 Ticker por BLOCO (não global)
        int tick = 0;
        String raw = BlockStorage.getLocationInfo(blockMenu.getLocation(), KEY_TICK);
        if (raw != null) {
            try {
                tick = Integer.parseInt(raw);
            } catch (NumberFormatException ignored) {}
        }

        tick++;

        BlockStorage.addBlockInfo(
                blockMenu.getLocation(),
                KEY_TICK,
                Integer.toString(tick)
        );

        if (tick % TICK_DELAY != 0) {
            return;
        }

        tryGrabItem(blockMenu);
    }

    private void tryGrabItem(@Nonnull BlockMenu blockMenu) {

        final NodeDefinition definition =
                NetworkStorage.getAllNetworkObjects().get(blockMenu.getLocation());

        if (definition == null || definition.getNode() == null) {
            return;
        }

        final BlockFace direction = getCurrentDirection(blockMenu);
        final BlockMenu targetMenu =
                BlockStorage.getInventory(blockMenu.getBlock().getRelative(direction));

        if (targetMenu == null) {
            return;
        }

        final int[] slots = targetMenu.getPreset()
                .getSlotsAccessedByItemTransport(
                        targetMenu,
                        ItemTransportFlow.WITHDRAW,
                        null
                );

        final var root = definition.getNode().getRoot();

        for (int slot : slots) {
            final ItemStack itemStack = targetMenu.getItemInSlot(slot);

            if (itemStack == null || itemStack.getType() == Material.AIR) {
                continue;
            }

            final int before = itemStack.getAmount();

            //  Transfere para a network
            root.addItemStack(itemStack);

            if (root.isDisplayParticles() && itemStack.getAmount() < before) {
                showParticle(blockMenu.getLocation(), direction);
            }

            //  Limite rígido: 1 item por execução
            return;
        }
    }

    @Override
    protected Particle.DustOptions getDustOptions() {
        return new Particle.DustOptions(Color.FUCHSIA, 1);
    }
}
