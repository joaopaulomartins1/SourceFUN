package me.JOTTA.SourceFUN.items.machines;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import me.JOTTA.SourceFUN.backgrounds.MachineLayout;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineRecipe;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class GenericMachine extends AContainer implements RecipeDisplayItem {

    private final int consumoEnergia;
    private final int capacidadeEnergia;
    private final int velocidade;
    private final List<MachineRecipe> receitasCustomizadas = new ArrayList<>();

    public GenericMachine(ItemGroup category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, int consumoEnergia, int capacidadeEnergia, int velocidade) {
        super(category, item, recipeType, recipe);
        this.consumoEnergia = consumoEnergia;
        this.capacidadeEnergia = capacidadeEnergia;
        this.velocidade = velocidade;
    }

    public void addRecipe(int tempoTicks, ItemStack input, ItemStack output) {
        MachineRecipe recipe = new MachineRecipe(tempoTicks, new ItemStack[]{input}, new ItemStack[]{output});
        receitasCustomizadas.add(recipe);
        registerRecipe(recipe);
    }

    @Override
    protected void registerDefaultRecipes() {}

    @Override
    protected void constructMenu(BlockMenuPreset preset) {
        MachineLayout.applyGenericMachineLayout(preset);
        }


    @Override
    public int[] getInputSlots() { return MachineLayout.INPUT_SLOTS; }

    @Override
    public int[] getOutputSlots() { return MachineLayout.OUTPUT_SLOTS; }

    @Override
    public int getEnergyConsumption() { return consumoEnergia; }

    @Override
    public int getCapacity() { return capacidadeEnergia; }

    @Override
    public int getSpeed() { return velocidade; }

    @Override
    public String getMachineIdentifier() { return "GENERIC_MACHINE_" + this.getId(); }

    @Override
    public ItemStack getProgressBar() { return new ItemStack(Material.FLINT_AND_STEEL); }

    @Override
    @Nonnull
    public List<ItemStack> getDisplayRecipes() {
        List<ItemStack> display = new ArrayList<>();
        for (MachineRecipe recipe : receitasCustomizadas) {
            display.add(recipe.getInput()[0]);
            display.add(recipe.getOutput()[0]);
        }
        return display;
    }
}