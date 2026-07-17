package me.JOTTA.SourceFUN.items.machines;

import io.github.bakedlibs.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.EnergyNetComponent;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.mrCookieSlime.Slimefun.Objects.handlers.BlockTicker;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

public class WardenEssenceMiner extends SlimefunItem implements EnergyNetComponent {

    // --- CONFIGURAÇÕES DA MÁQUINA ---
    private static final int STATUS_SLOT = 4;
    private static final int[] OUTPUT_SLOTS = { 19,20,21,22,23,24,25,28,29,30,31,32,33,34,37,38,39,40,41,42,43,46,47,48,49,50,51,52 };
    private static final int REQUIRED_PROGRESS = 30;
    private final int energyConsumption = 4096;
    private final int capacity = 8024;


    private static final ItemStack UI_NO_ENERGY = new CustomItemStack(Material.RED_STAINED_GLASS_PANE, "&cEnergia Insuficiente!", "&7Precisa de: &e4096 J/t");
    private static final ItemStack UI_FULL = new CustomItemStack(Material.ORANGE_STAINED_GLASS_PANE, "&6Inventário Cheio!", "&7A máquina parou.");
    private static final ItemStack UI_LOADING = new CustomItemStack(Material.BLACK_STAINED_GLASS_PANE, "&8Carregando...");


    private ItemStack cachedOutputItem;

    public WardenEssenceMiner(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
        setupMenu();
    }

    private void setupMenu() {
        new BlockMenuPreset(getId(), getItemName()) {
            @Override
            public void init() {
                int[] background = {0,1,2,3,5,6,7,8,9,10,11,12,13,14,15,16,17,18,26,27,35,36,44,45,53};
                for (int i : background) {
                    addItem(i, ChestMenuUtils.getBackground());
                    addMenuClickHandler(i, ChestMenuUtils.getEmptyClickHandler());
                }
                addItem(STATUS_SLOT, UI_LOADING);
                addMenuClickHandler(STATUS_SLOT, ChestMenuUtils.getEmptyClickHandler());
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

    @Override
    public void preRegister() {
        addItemHandler(new BlockTicker() {
            @SuppressWarnings("deprecation")
            @Override
            public void tick(Block b, SlimefunItem item, me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config data) {
                processMachineTick(b);
            }

            @Override
            public boolean isSynchronized() {
                return true;
            }
        });
    }



    private ItemStack getOutputItem() {
        if (cachedOutputItem == null) {
            SlimefunItem essence = SlimefunItem.getById("WARDEN_ESSENCE");
            cachedOutputItem = (essence != null) ? essence.getItem().clone() : new ItemStack(Material.SCULK);
        }
        return cachedOutputItem;
    }

    private void processMachineTick(Block b) {
        BlockMenu inv = BlockStorage.getInventory(b);
        if (inv == null) return;

        ItemStack output = getOutputItem();


        if (!inv.fits(output, OUTPUT_SLOTS)) {
            updateVisualStatus(inv, UI_FULL);
            return;
        }


        if (getCharge(b.getLocation()) < energyConsumption) {
            updateVisualStatus(inv, UI_NO_ENERGY);
            return;
        }


        removeCharge(b.getLocation(), energyConsumption);
        int progress = getProgress(b);
        progress++;

        if (progress >= REQUIRED_PROGRESS) {
            inv.pushItem(output.clone(), OUTPUT_SLOTS);
            progress = 0;
        }

        saveProgress(b, progress);


        if (inv.hasViewer()) {
            ItemStack progressItem = new CustomItemStack(Material.LIME_STAINED_GLASS_PANE,
                    "&aMinerando...",
                    "&7Progresso: &f" + progress + "/" + REQUIRED_PROGRESS,
                    "&7Energia: &e" + energyConsumption + " J/t");
            inv.replaceExistingItem(STATUS_SLOT, progressItem);
        }
    }



    private void updateVisualStatus(BlockMenu inv, ItemStack statusItem) {

        if (inv.hasViewer()) {
            inv.replaceExistingItem(STATUS_SLOT, statusItem);
        }
    }

    private int getProgress(Block b) {
        String saved = BlockStorage.getLocationInfo(b.getLocation(), "progress");
        if (saved == null) return 0;
        try {
            return Integer.parseInt(saved);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private void saveProgress(Block b, int progress) {
        BlockStorage.addBlockInfo(b, "progress", String.valueOf(progress));
    }

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