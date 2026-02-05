package me.JOTTA.SourceFUN.items.machines;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.EnergyNetComponent;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
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

public class WardenEssenceMiner extends SlimefunItem implements EnergyNetComponent {

    private static final int STATUS_SLOT = 4;
    private static final int[] OUTPUT_SLOTS = { 29, 30, 31, 32, 33, 38, 39, 40, 41, 42 };
    private final int energyConsumption = 4096;
    private final int capacity = 8024;

    public WardenEssenceMiner(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);

        new BlockMenuPreset(getId(), getItemName()) {
            @Override
            public void init() {
                int[] background = {0,1,2,3,5,6,7,8,9,10,11,12,13,14,15,16,17,18,26,27,35,36,44,45,53};
                for (int i : background) {
                    addItem(i, ChestMenuUtils.getBackground(), ChestMenuUtils.getEmptyClickHandler());
                }
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
            @Override
            public void tick(Block b, SlimefunItem item, Config data) {
                WardenEssenceMiner.this.tick(b, data);
            }

            @Override
            public boolean isSynchronized() {
                return true;
            }
        });
    }

    protected void tick(Block b, Config data) {
        BlockMenu inv = BlockStorage.getInventory(b);
        if (inv == null) return;

        // Energia (Consumo atualizado para 4096 J/t)
        int charge = getCharge(b.getLocation(), data);
        if (charge < energyConsumption) {
            inv.replaceExistingItem(STATUS_SLOT, new CustomItemStack(Material.RED_STAINED_GLASS_PANE, "&cEnergia Insuficiente!", "&7Precisa de: &e" + energyConsumption + " J"));
            return;
        }
        removeCharge(b.getLocation(), energyConsumption);

        // Progresso
        int progress = 0;
        try {
            String saved = data.getString("progress");
            if (saved != null) progress = Integer.parseInt(saved);
        } catch (Exception e) {}

        if (progress >= 30) {
            SlimefunItem essence = SlimefunItem.getById("WARDEN_ESSENCE");
            if (essence != null && inv.fits(essence.getItem(), OUTPUT_SLOTS)) {
                inv.pushItem(essence.getItem().clone(), OUTPUT_SLOTS);
                progress = 0;
            }
        } else {
            progress++;
        }

        inv.replaceExistingItem(STATUS_SLOT, new CustomItemStack(Material.LIME_STAINED_GLASS_PANE, "&aMinerando...", "&7Progresso: " + progress + "/30", "&7Energia: &e" + energyConsumption + " J/t"));
        BlockStorage.addBlockInfo(b, "progress", String.valueOf(progress));
    }

    @Nonnull
    @Override
    public EnergyNetComponentType getEnergyComponentType() {
        return EnergyNetComponentType.CONSUMER;
    }

    @Override
    public int getCapacity() {
        return capacity; // Buffer de 8024 J
    }
}