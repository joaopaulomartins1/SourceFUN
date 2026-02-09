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

    /** Quantos ticks esperar entre execuções (20 ticks = 1s) */
    private static final int TICK_DELAY = 4; // 5x por segundo
    private int ticker = 0;

    public NetworkGrabber(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe, NodeType.GRABBER);
    }

    @Override
    protected void onTick(@Nullable BlockMenu blockMenu, @Nonnull Block block) {
        super.onTick(blockMenu, block);

        if (blockMenu == null) {
            return;
        }

        // 🔹 Throttle simples e eficiente
        if (++ticker % TICK_DELAY != 0) {
            return;
        }

        tryGrabItem(blockMenu);
    }

    private void tryGrabItem(@Nonnull BlockMenu blockMenu) {
        // 🔹 Lookup único
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

        // 🔹 Pega slots uma única vez
        final int[] slots = targetMenu.getPreset()
                .getSlotsAccessedByItemTransport(targetMenu, ItemTransportFlow.WITHDRAW, null);

        for (int slot : slots) {
            final ItemStack itemStack = targetMenu.getItemInSlot(slot);

            if (itemStack == null || itemStack.getType() == Material.AIR) {
                continue;
            }

            final int before = itemStack.getAmount();

            // 🔹 Chamada cara só quando realmente há item
            definition.getNode().getRoot().addItemStack(itemStack);

            if (definition.getNode().getRoot().isDisplayParticles()
                    && itemStack.getAmount() < before) {
                showParticle(blockMenu.getLocation(), direction);
            }

            // 🔹 Limite: 1 transferência por execução
            return;
        }
    }

    @Override
    protected Particle.DustOptions getDustOptions() {
        return new Particle.DustOptions(Color.FUCHSIA, 1);
    }
}
