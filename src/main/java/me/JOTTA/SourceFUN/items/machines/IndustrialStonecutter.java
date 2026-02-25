package me.JOTTA.SourceFUN.items.machines;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.EnergyNetComponent;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
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
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class IndustrialStonecutter extends SlimefunItem implements EnergyNetComponent, RecipeDisplayItem {

    // --- LAYOUT ANEL 3x3 ---

    // Slot central de INPUT
    private static final int INPUT_SLOT = 10;
    // Borda decorativa do Input
    private static final int[] INPUT_BORDER = { 0, 1, 2, 9, 11, 18, 19, 20 };

    // Slot central de OUTPUT
    private static final int OUTPUT_SLOT = 37;
    // Borda decorativa do Output
    private static final int[] OUTPUT_BORDER = { 27, 28, 29, 36, 38, 45, 46, 47 };

    // Lado direito inteiro para receitas
    private static final int[] DISPLAY_SLOTS = {
            3, 4, 5, 6, 7, 8,
            12, 13, 14, 15, 16, 17,
            21, 22, 23, 24, 25, 26,
            30, 31, 32, 33, 34, 35,
            39, 40, 41, 42, 43, 44,
            48, 49, 50, 51, 52, 53
    };



    private final List<CutterRecipe> recipes = new ArrayList<>();
    private final int energyConsumption;
    private final int capacity;
    private final int processingSpeed;

    public IndustrialStonecutter(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, int energy, int capacity, int speed) {
        super(itemGroup, item, recipeType, recipe);
        this.energyConsumption = energy;
        this.capacity = capacity;
        this.processingSpeed = speed;

        createPreset();
    }

    public IndustrialStonecutter addRecipe(ItemStack input, int inAmount, ItemStack output, int outAmount) {
        recipes.add(new CutterRecipe(input, inAmount, output, outAmount));
        return this;
    }

    public List<CutterRecipe> getRecipes() {
        return recipes;
    }

    private void createPreset() {
        new BlockMenuPreset(getId(), getItemName()) {
            @Override
            public void init() {
                // Vidros Azuis (Input)
                for (int slot : INPUT_BORDER) {
                    addItem(slot, new CustomItemStack(Material.BLUE_STAINED_GLASS_PANE, "§9Entrada", "§7Coloque o bloco no centro"));
                    addMenuClickHandler(slot, ChestMenuUtils.getEmptyClickHandler());
                }

                // Vidros Vermelhos (Output)
                for (int slot : OUTPUT_BORDER) {
                    addItem(slot, new CustomItemStack(Material.RED_STAINED_GLASS_PANE, "§cSaída", "§7Retire o item do centro"));
                    addMenuClickHandler(slot, ChestMenuUtils.getEmptyClickHandler());
                }

                // Limpa a direita
                for (int slot : DISPLAY_SLOTS) {
                    addMenuClickHandler(slot, ChestMenuUtils.getEmptyClickHandler());
                }
            }

            @Override
            public void newInstance(@Nonnull BlockMenu menu, @Nonnull Block b) {
                if (menu.hasViewer()) {
                    updateRecipeMenu(menu, b);
                }
            }

            @Override
            public boolean canOpen(@Nonnull Block b, @Nonnull Player p) {
                return true;
            }

            @Override
            public int[] getSlotsAccessedByItemTransport(ItemTransportFlow flow) {
                return flow == ItemTransportFlow.INSERT ? new int[]{INPUT_SLOT} : new int[]{OUTPUT_SLOT};
            }
        };
    }

    @Override
    public void preRegister() {
        addItemHandler(new BlockTicker() {
            @Override
            public void tick(Block b, SlimefunItem item, Config data) {
                IndustrialStonecutter.this.tick(b);
            }
            @Override
            public boolean isSynchronized() { return true; }
        });
    }

    protected void tick(Block b) {
        BlockMenu menu = BlockStorage.getInventory(b);
        if (menu == null) return;

        if (menu.hasViewer()) {
            updateRecipeMenu(menu, b);
        }

        processMachine(b, menu);
    }

    private void updateRecipeMenu(BlockMenu menu, Block b) {
        ItemStack inputItem = menu.getItemInSlot(INPUT_SLOT);

        // Se input vazio, limpa a direita
        if (inputItem == null || inputItem.getType() == Material.AIR) {
            // Verifica se já está limpo para não spammar
            if (menu.getItemInSlot(DISPLAY_SLOTS[0]) != null && menu.getItemInSlot(DISPLAY_SLOTS[0]).getType() != Material.GRAY_STAINED_GLASS_PANE) {
                for (int slot : DISPLAY_SLOTS) {
                    menu.replaceExistingItem(slot, new CustomItemStack(Material.GRAY_STAINED_GLASS_PANE, " "));
                    menu.addMenuClickHandler(slot, ChestMenuUtils.getEmptyClickHandler());
                }
            }
            return;
        }

        // Filtra receitas
        List<CutterRecipe> matchingRecipes = new ArrayList<>();
        for (CutterRecipe r : recipes) {
            if (r.input.isSimilar(inputItem)) {
                matchingRecipes.add(r);
            }
        }

        // Pega receita ativa
        int selectedIndex = -1;
        try {
            String s = BlockStorage.getLocationInfo(b.getLocation(), "active_recipe");
            if (s != null) selectedIndex = Integer.parseInt(s);
        } catch (Exception ignored) {}

        // Preenche Slots
        for (int i = 0; i < DISPLAY_SLOTS.length; i++) {
            int slot = DISPLAY_SLOTS[i];

            if (i < matchingRecipes.size()) {
                CutterRecipe recipe = matchingRecipes.get(i);
                int realIndex = recipes.indexOf(recipe);

                boolean isSelected = (realIndex == selectedIndex);
                ItemStack icon = recipe.output.clone();
                icon.setAmount(recipe.outputAmount);

                // --- AQUI ESTÁ A CORREÇÃO DO GLOW ---
                if (isSelected) {
                    addGlow(icon);
                }

                menu.replaceExistingItem(slot, new CustomItemStack(icon,
                        isSelected ? "§a§l[ SELECIONADO ]" : "§eFabricar: " + formatName(recipe.output),
                        "",
                        "§7Entrada: §b" + recipe.inputAmount + "x " + formatName(recipe.input),
                        "§7Saída: §a" + recipe.outputAmount + "x " + formatName(recipe.output),
                        "",
                        isSelected ? "§aReceita Ativa" : "§eClique para selecionar"
                ));

                menu.addMenuClickHandler(slot, (p, s, item, action) -> {
                    BlockStorage.addBlockInfo(b.getLocation(), "active_recipe", String.valueOf(realIndex));
                    p.playSound(p.getLocation(), Sound.UI_BUTTON_CLICK, 1, 1);
                    updateRecipeMenu(menu, b);
                    return false;
                });

            } else {
                menu.replaceExistingItem(slot, new CustomItemStack(Material.GRAY_STAINED_GLASS_PANE, " "));
                menu.addMenuClickHandler(slot, ChestMenuUtils.getEmptyClickHandler());
            }
        }
    }

    private void processMachine(Block b, BlockMenu menu) {
        String s = BlockStorage.getLocationInfo(b.getLocation(), "active_recipe");
        if (s == null) return;

        int index = Integer.parseInt(s);
        if (index < 0 || index >= recipes.size()) return;

        CutterRecipe recipe = recipes.get(index);

        if (getCharge(b.getLocation()) < energyConsumption) return;

        // Verifica Slot 10
        ItemStack itemInInput = menu.getItemInSlot(INPUT_SLOT);
        if (itemInInput != null && itemInInput.isSimilar(recipe.input) && itemInInput.getAmount() >= recipe.inputAmount) {

            ItemStack result = recipe.output.clone();
            result.setAmount(recipe.outputAmount);

            // Verifica Slot 37
            if (menu.fits(result, new int[]{OUTPUT_SLOT})) {

                int progress = 0;
                try { progress = Integer.parseInt(BlockStorage.getLocationInfo(b.getLocation(), "progress")); } catch (Exception ignored) {}

                removeCharge(b.getLocation(), energyConsumption);
                progress++;

                if (progress >= processingSpeed) {
                    menu.consumeItem(INPUT_SLOT, recipe.inputAmount);
                    menu.pushItem(result, new int[]{OUTPUT_SLOT});
                    progress = 0;
                }
                BlockStorage.addBlockInfo(b.getLocation(), "progress", String.valueOf(progress));
            }
        } else {
            BlockStorage.addBlockInfo(b.getLocation(), "progress", "0");
        }
    }

    // --- MÉTODOS AUXILIARES ---

    // Substitui o ItemUtils.addGlow
    private void addGlow(ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.addEnchant(Enchantment.DURABILITY, 1, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
        }
    }

    private String formatName(ItemStack item) {
        if (item.hasItemMeta() && item.getItemMeta().hasDisplayName()) return item.getItemMeta().getDisplayName();
        return item.getType().name().replace("_", " ");
    }

    @Override
    @Nonnull
    public List<ItemStack> getDisplayRecipes() {
        List<ItemStack> display = new ArrayList<>();

        for (CutterRecipe recipe : recipes) {
            // 1. Adiciona a Entrada
            ItemStack input = recipe.input.clone();
            input.setAmount(recipe.inputAmount);
            display.add(input);

            // 2. Adiciona a Saída
            ItemStack output = recipe.output.clone();
            output.setAmount(recipe.outputAmount);
            display.add(output);
        }

        return display;
    }

    private static class CutterRecipe {
        ItemStack input;
        int inputAmount;
        ItemStack output;
        int outputAmount;

        public CutterRecipe(ItemStack input, int inputAmount, ItemStack output, int outputAmount) {
            this.input = input;
            this.inputAmount = inputAmount;
            this.output = output;
            this.outputAmount = outputAmount;
        }
    }

    @Override
    public EnergyNetComponentType getEnergyComponentType() { return EnergyNetComponentType.CONSUMER; }
    @Override
    public int getCapacity() { return capacity; }
}