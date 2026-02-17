package me.JOTTA.SourceFUN.items.machines;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.EnergyNetComponent;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;

import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.Objects.handlers.BlockTicker;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class WardenQuarry extends SlimefunItem implements EnergyNetComponent, RecipeDisplayItem {

    private final int energyConsumption;
    private final int capacity;
    private final int maxProgress;

    private final List<ItemStack> guaranteedDrops = new ArrayList<>();
    private final Map<ItemStack, Double> chanceDrops = new HashMap<>();

    private static final int[] OUTPUT_SLOTS = {29,30,31,32,33,38,39,40,41,42};

    public WardenQuarry(ItemGroup itemGroup,
                        SlimefunItemStack item,
                        RecipeType recipeType,
                        ItemStack[] recipe,
                        int energy,
                        int speed,
                        int cap) {

        super(itemGroup, item, recipeType, recipe);

        this.energyConsumption = energy;
        this.maxProgress = speed;
        this.capacity = cap;

        new BlockMenuPreset(getId(), getItemName()) {

            @Override
            public void init() {

                int[] background = {
                        0,1,2,3,5,6,7,8,
                        9,10,11,12,13,14,15,16,17,
                        18,26,27,35,36,44,45,53
                };

                for (int slot : background) {
                    addItem(slot, new CustomItemStack(Material.BLACK_STAINED_GLASS_PANE, " "));
                    addMenuClickHandler(slot, (p, s, i, a) -> false);
                }

                addItem(4, new CustomItemStack(Material.GRAY_STAINED_GLASS_PANE, "§7Aguardando energia..."));
                addMenuClickHandler(4, (p, s, i, a) -> false);
            }

            @Override
            public int[] getSlotsAccessedByItemTransport(ItemTransportFlow flow) {
                return flow == ItemTransportFlow.WITHDRAW ? OUTPUT_SLOTS : new int[0];
            }

            @Override
            public boolean canOpen(@Nonnull Block b, @Nonnull org.bukkit.entity.Player p) {
                return true;
            }
        };
    }

    /* =========================
       DROPS
       ========================= */

    public WardenQuarry addGuaranteedDrop(ItemStack item) {
        guaranteedDrops.add(item);
        return this;
    }

    public WardenQuarry addChanceDrop(ItemStack item, double chance) {
        chanceDrops.put(item, chance);
        return this;
    }

    /* =========================
       DISPLAY RECEITAS
       ========================= */

    @Override
    @Nonnull
    public List<ItemStack> getDisplayRecipes() {

        List<ItemStack> display = new ArrayList<>();

        for (ItemStack is : guaranteedDrops) {
            ItemStack clone = is.clone();
            display.add(new CustomItemStack(
                    clone,
                    "§a" + getProperName(clone) + " x" + clone.getAmount() + " §7(100%)"
            ));
        }

        for (Map.Entry<ItemStack, Double> entry : chanceDrops.entrySet()) {
            ItemStack clone = entry.getKey().clone();
            display.add(new CustomItemStack(
                    clone,
                    "§e" + getProperName(clone) + " x" + clone.getAmount() + " §7(" + entry.getValue() + "%)"
            ));
        }

        return display;
    }

    private String getProperName(ItemStack stack) {

        SlimefunItem sf = SlimefunItem.getByItem(stack);

        if (sf != null) {
            return sf.getItemName();
        }

        if (stack.hasItemMeta() && stack.getItemMeta().hasDisplayName()) {
            return stack.getItemMeta().getDisplayName();
        }

        return stack.getType().name();
    }

    /* =========================
       TICK SYSTEM
       ========================= */

    @Override
    public void preRegister() {

        addItemHandler(new BlockTicker() {

            @Override
            public void tick(Block b, SlimefunItem item, Config data) {
                WardenQuarry.this.tick(b);
            }

            @Override
            public boolean isSynchronized() {
                return true;
            }
        });
    }

    protected void tick(Block b) {

        BlockMenu inv = BlockStorage.getInventory(b);
        if (inv == null) return;

        int energyPerTick = energyConsumption;


        if (getCharge(b.getLocation()) < energyPerTick) {
            inv.replaceExistingItem(4,
                    new CustomItemStack(Material.RED_STAINED_GLASS_PANE, "§cSem Energia!"));
            return;
        }

        // 🔥 REMOVE ENERGIA TODO TICK
        removeCharge(b.getLocation(), energyPerTick);

        int progress = 0;
        String raw = BlockStorage.getLocationInfo(b.getLocation(), "progress");

        if (raw != null) {
            try {
                progress = Integer.parseInt(raw);
            } catch (Exception ignored) {}
        }

        progress++;

        if (progress >= maxProgress) {

            List<ItemStack> toDeliver = new ArrayList<>();

            for (ItemStack stack : guaranteedDrops) {
                toDeliver.add(stack.clone());
            }

            for (Map.Entry<ItemStack, Double> entry : chanceDrops.entrySet()) {
                if (ThreadLocalRandom.current().nextDouble(100.0) <= entry.getValue()) {
                    toDeliver.add(entry.getKey().clone());
                }
            }

            if (!canFitAll(inv, toDeliver)) {
                inv.replaceExistingItem(4,
                        new CustomItemStack(Material.ORANGE_STAINED_GLASS_PANE, "§6Inventário Cheio!"));
                return;
            }

            for (ItemStack drop : toDeliver) {
                inv.pushItem(drop, OUTPUT_SLOTS);
            }

            progress = 0;
        }

        inv.replaceExistingItem(4,
                new CustomItemStack(Material.LIME_STAINED_GLASS_PANE,
                        "§aMinerando...",
                        "§7Progresso: §e" + (progress * 100 / maxProgress) + "%"));

        BlockStorage.addBlockInfo(b.getLocation(), "progress", String.valueOf(progress));
    }

    private boolean canFitAll(BlockMenu inv, List<ItemStack> items) {
        for (ItemStack item : items) {
            if (!inv.fits(item, OUTPUT_SLOTS)) return false;
        }
        return true;
    }

    /* =========================
       ENERGY
       ========================= */

    @Nonnull
    @Override
    public EnergyNetComponentType getEnergyComponentType() {
        return EnergyNetComponentType.CONSUMER;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }
}
