package me.JOTTA.SourceFUN.items.ItensSetup;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.JOTTA.SourceFUN.SourceFUN;
import me.JOTTA.SourceFUN.items.Tools.QuebraTreco;
import me.JOTTA.SourceFUN.items.groups.SourceFUNItemGroups;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ToolSetup {

    public static void setup(SourceFUN plugin) {
        ItemStack essence = (ResourceSetup.wardenEssence != null) ? ResourceSetup.wardenEssence : new ItemStack(Material.NETHERITE_INGOT);

        SlimefunItemStack unbSword = new SlimefunItemStack("SOURCE_UNBREAKING_SWORD", Material.IRON_SWORD,
                "&x&5&4&D&A&F&4Espada indestrutível ", "", "&7Lâmina indestrutível");
        applyUnbreakable(unbSword);

        new SlimefunItem(SourceFUNItemGroups.TOOLS, unbSword, RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        null, essence, null,
                        null, essence, null,
                        null, new ItemStack(Material.STICK), null
                }).register(plugin);


        SlimefunItemStack unbFisher = new SlimefunItemStack("SOURCE_UNBREAKING_FISHER", Material.FISHING_ROD,
                "&x&5&4&D&A&F&4Vara de pesca indestrutível ", "", "&7Pesca infinita sem quebrar");
        applyUnbreakable(unbFisher);


        new SlimefunItem(SourceFUNItemGroups.TOOLS, unbFisher, RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        null, null, essence,
                        null, essence, new ItemStack(Material.STRING),
                        essence, null, new ItemStack(Material.STRING)
                }).register(plugin);


        new QuebraTreco(SourceFUNItemGroups.TOOLS,
                new SlimefunItemStack("SOURCE_QUEBRA_TECO", Material.NETHERITE_HOE, "§x§E§5§9§6§0§5Tira Treco", "",
                        "§x§6§D§6§D§6§DQuebra Items do slimefun em geral"),
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        new ItemStack(Material.BARRIER), new ItemStack(Material.GOLD_INGOT), new ItemStack(Material.PISTON),
                        new ItemStack(Material.GOLD_INGOT), new ItemStack(Material.REDSTONE_BLOCK), new ItemStack(Material.GOLD_INGOT),
                        new ItemStack(Material.PISTON), new ItemStack(Material.GOLD_INGOT), new ItemStack(Material.PISTON)
                }).register(plugin);
    }

    private static void applyUnbreakable(ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setUnbreakable(true);
            meta.addEnchant(Enchantment.UNBREAKING, 1, true);
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
        }
    }
}