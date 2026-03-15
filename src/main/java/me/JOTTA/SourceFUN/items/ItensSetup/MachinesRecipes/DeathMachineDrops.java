package me.JOTTA.SourceFUN.items.ItensSetup.MachinesRecipes;

import me.JOTTA.SourceFUN.items.ItensSetup.ResourceSetup;
import me.JOTTA.SourceFUN.items.machines.IndustrialMachine;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;


public class DeathMachineDrops {


    public static void registerAll(IndustrialMachine deathMachine) {
        ItemStack basicMeat = ResourceSetup.meatCore;
        deathMachine.addRecipe(basicMeat, 1, new ItemStack(Material.BEEF), 4);
        deathMachine.addRecipe(basicMeat, 1, new ItemStack(Material.CHICKEN), 4);
        deathMachine.addRecipe(basicMeat, 1, new ItemStack(Material.MUTTON), 4);
        deathMachine.addRecipe(basicMeat, 1, new ItemStack(Material.PORKCHOP), 4);
        deathMachine.addRecipe(basicMeat, 1, new ItemStack(Material.ROTTEN_FLESH), 4);
        deathMachine.addRecipe(basicMeat, 1, new ItemStack(Material.COD), 4);
        deathMachine.addRecipe(basicMeat, 1, new ItemStack(Material.SALMON), 4);
        deathMachine.addRecipe(basicMeat, 1, new ItemStack(Material.SPIDER_EYE), 4);

        ItemStack advMeat = ResourceSetup.advancedMeatCore;
        deathMachine.addRecipe(advMeat, 1, new ItemStack(Material.BEEF), 8);
        deathMachine.addRecipe(advMeat, 1, new ItemStack(Material.CHICKEN), 8);
        deathMachine.addRecipe(advMeat, 1, new ItemStack(Material.MUTTON), 8);
        deathMachine.addRecipe(advMeat, 1, new ItemStack(Material.PORKCHOP), 8);
        deathMachine.addRecipe(advMeat, 1, new ItemStack(Material.ROTTEN_FLESH), 8);
        deathMachine.addRecipe(advMeat, 1, new ItemStack(Material.COD), 8);
        deathMachine.addRecipe(advMeat, 1, new ItemStack(Material.SALMON), 8);
        deathMachine.addRecipe(advMeat, 1, new ItemStack(Material.SPIDER_EYE), 8);

        ItemStack wardenMeat = ResourceSetup.wardenMeatCore;
        deathMachine.addRecipe(wardenMeat, 1, new ItemStack(Material.BEEF), 16);
        deathMachine.addRecipe(wardenMeat, 1, new ItemStack(Material.CHICKEN), 16);
        deathMachine.addRecipe(wardenMeat, 1, new ItemStack(Material.MUTTON), 16);
        deathMachine.addRecipe(wardenMeat, 1, new ItemStack(Material.PORKCHOP), 16);
        deathMachine.addRecipe(wardenMeat, 1, new ItemStack(Material.ROTTEN_FLESH), 16);
        deathMachine.addRecipe(wardenMeat, 1, new ItemStack(Material.COD), 16);
        deathMachine.addRecipe(wardenMeat, 1, new ItemStack(Material.SALMON), 16);
        deathMachine.addRecipe(wardenMeat, 1, new ItemStack(Material.SPIDER_EYE), 16);

    }
}