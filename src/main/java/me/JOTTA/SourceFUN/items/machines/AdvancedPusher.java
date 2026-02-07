package me.JOTTA.SourceFUN.items.machines;

import io.github.sefiraat.networks.slimefun.network.NetworkDirectional;
import io.github.sefiraat.networks.network.NodeType;
import io.github.sefiraat.networks.NetworkStorage;
import io.github.sefiraat.networks.network.NodeDefinition;
import io.github.sefiraat.networks.network.stackcaches.ItemRequest;
import io.github.sefiraat.networks.utils.StackUtils;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
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

public class AdvancedPusher extends NetworkDirectional {


    private static final int[] BACKGROUND_SLOTS = new int[]{
            0, 1, 2, 3, 4, 5, 6, 7, 8,
            9, 13, 14, 15, 16, 17,
            18, 22, 23, 24, 25, 26,
            27, 31, 32, 33, 34, 35,
            36, 37, 38, 39, 40, 41, 42, 43, 44
    };

    private static final int[] ITEM_SLOTS = new int[]{
            10, 11, 12,
            19, 20, 21,
            28, 29, 30
    };


    private static final int NORTH_SLOT = 7;
    private static final int SOUTH_SLOT = 25;
    private static final int EAST_SLOT = 17;
    private static final int WEST_SLOT = 15;
    private static final int UP_SLOT = 8;
    private static final int DOWN_SLOT = 26;

    public AdvancedPusher(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe, NodeType.PUSHER);
        for (int slot : ITEM_SLOTS) {
            this.getSlotsToDrop().add(slot);
        }
    }

    @Override
    protected void onTick(@Nullable BlockMenu blockMenu, @Nonnull Block block) {
        super.onTick(blockMenu, block);
        if (blockMenu != null) {
            tryPushItem(blockMenu);
        }
    }

    private void tryPushItem(@Nonnull BlockMenu blockMenu) {
        final NodeDefinition definition = NetworkStorage.getAllNetworkObjects().get(blockMenu.getLocation());

        if (definition == null || definition.getNode() == null) {
            return;
        }

        final BlockFace direction = getCurrentDirection(blockMenu);
        final BlockMenu targetMenu = BlockStorage.getInventory(blockMenu.getBlock().getRelative(direction));

        if (targetMenu == null) {
            return;
        }


        for (int itemSlot : this.getItemSlots()) {
            final ItemStack testItem = blockMenu.getItemInSlot(itemSlot);

            if (testItem == null || testItem.getType() == Material.AIR) {
                continue;
            }

            final ItemStack clone = testItem.clone();
            clone.setAmount(1);
            final ItemRequest itemRequest = new ItemRequest(clone, clone.getMaxStackSize());

            int[] slots = targetMenu.getPreset().getSlotsAccessedByItemTransport(targetMenu, ItemTransportFlow.INSERT, clone);

            for (int slot : slots) {
                final ItemStack itemStack = targetMenu.getItemInSlot(slot);

                if (itemStack != null && itemStack.getType() != Material.AIR) {
                    final int space = itemStack.getMaxStackSize() - itemStack.getAmount();
                    if (space > 0 && StackUtils.itemsMatch(itemRequest, itemStack, true)) {
                        itemRequest.setAmount(space);
                    } else {
                        continue;
                    }
                }

                ItemStack retrieved = definition.getNode().getRoot().getItemStack(itemRequest);
                if (retrieved != null) {
                    targetMenu.pushItem(retrieved, slots);
                    if (definition.getNode().getRoot().isDisplayParticles()) {
                        showParticle(blockMenu.getLocation(), direction);
                    }
                }
                break;
            }
        }
    }

    @Override
    public int[] getItemSlots() {
        return ITEM_SLOTS;
    }

    @Nonnull
    @Override
    protected int[] getBackgroundSlots() {
        return BACKGROUND_SLOTS;
    }

    @Override public int getNorthSlot() { return NORTH_SLOT; }
    @Override public int getSouthSlot() { return SOUTH_SLOT; }
    @Override public int getEastSlot() { return EAST_SLOT; }
    @Override public int getWestSlot() { return WEST_SLOT; }
    @Override public int getUpSlot() { return UP_SLOT; }
    @Override public int getDownSlot() { return DOWN_SLOT; }

    @Override
    protected Particle.DustOptions getDustOptions() {
        return new Particle.DustOptions(Color.fromRGB(255, 165, 0), 1);
    }
}