package me.JOTTA.SourceFUN.items.ItensSetup;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.JOTTA.SourceFUN.SourceFUN;
import me.JOTTA.SourceFUN.items.groups.SourceFUNItemGroups;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ResourceSetup {

    public static SlimefunItemStack wardenEssence;
    public static SlimefunItemStack warderEssenceBlock;
    public static SlimefunItemStack sourceniumX;
    public static SlimefunItemStack sourceniumXblock;
    public static SlimefunItemStack maraging;
    public static SlimefunItemStack maragingPlate;
    public static SlimefunItemStack titaniumPlate;
    public static SlimefunItemStack voidingWardenEssence;
    public static SlimefunItemStack voidingWardenEssenceBlock;
    public static SlimefunItemStack voidingCetrusLumium;
    public static SlimefunItemStack wardenHeart;

    public static void setup(SourceFUN plugin) {
        // --- Warden Essence ---
        wardenEssence = new SlimefunItemStack("WARDEN_ESSENCE", Material.ECHO_SHARD, "&x&5&4&D&A&F&4Warden Essence", "", "§7Essência vinda de tempos antigos");
        new SlimefunItem(SourceFUNItemGroups.RESOURCES, wardenEssence, RecipeType.NULL, new ItemStack[9]).register(plugin);

        warderEssenceBlock = new SlimefunItemStack("SOURCE_WARDEN_ESSENCE_BLOCK", Material.SCULK, "&x&5&4&D&A&F&4Warden Essence Block", "", "§7Bloco de warden essence");
        new SlimefunItem(SourceFUNItemGroups.RESOURCES, warderEssenceBlock, RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{ wardenEssence, wardenEssence, wardenEssence, wardenEssence, wardenEssence, wardenEssence, wardenEssence, wardenEssence, wardenEssence }).register(plugin);

        // --- Maraging ---
        maraging = new SlimefunItemStack("SOURCE_MARAGING", Material.IRON_INGOT, "§x§5§4§D§A§F§4Maraging", "");
        new SlimefunItem(SourceFUNItemGroups.RESOURCES, maraging, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[9]).register(plugin);

        maragingPlate = new SlimefunItemStack("SOURCE_MARAGING_PLATE", Material.PAPER, "§x§5§4§D§A§F§4Maraging Plate", "");
        new SlimefunItem(SourceFUNItemGroups.RESOURCES, maragingPlate, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[9]).register(plugin);

        // --- Titanium & Voiding ---
        titaniumPlate = new SlimefunItemStack("SOURCE_TITANIUM_PLATE", Material.PAPER, "§x§5§4§D§A§F§4Titanium Plate", "");
        new SlimefunItem(SourceFUNItemGroups.RESOURCES, titaniumPlate, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[9]).register(plugin);

        voidingWardenEssence = new SlimefunItemStack("SOURCE_VOIDING_ESSENCE", Material.NETHERITE_INGOT, "§x§0§B§3§C§2§4Voiding Warden Essence", "", "§x§3§5§0§A§0§AA essência da morte...");
        new SlimefunItem(SourceFUNItemGroups.RESOURCES, voidingWardenEssence, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[9]).register(plugin);

        voidingWardenEssenceBlock = new SlimefunItemStack("SOURCE_VOIDING_ESSENCE_BLOCK", Material.SCULK_SENSOR, "§x§0§B§3§C§2§4Voiding Warden Essence Block", "", "§x§A§0§0§0§0§0Bloco do vazio");
        new SlimefunItem(SourceFUNItemGroups.RESOURCES, voidingWardenEssenceBlock, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[9]).register(plugin);

        voidingCetrusLumium = new SlimefunItemStack("SOURCE_VOIDING_CETRUS_LUMIUM", Material.NETHER_STAR, "§x§F§F§6§7§0§0Voiding Cetrus Lumium", "", "§x§7§7§0§0§0§0Uma versão sombria...");
        new SlimefunItem(SourceFUNItemGroups.RESOURCES, voidingCetrusLumium, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[9]).register(plugin);

        // --- Hearts & Sourcenium ---
        wardenHeart = new SlimefunItemStack("SOURCE_WARDEN_HEART", Material.HEART_OF_THE_SEA, "§x§0§0§5§3§1§DWarden Heart", "", "§x§0§0§2§B§5§3Coração extraído das profundezas.");
        new SlimefunItem(SourceFUNItemGroups.RESOURCES, wardenHeart, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[9]).register(plugin);

        sourceniumX = new SlimefunItemStack("SOURCENIUM_X", Material.NETHERITE_INGOT, "§x§F§D§0§0§0§0S§x§D§6§3§1§0§4o§x§B§0§6§2§0§8u...-X", "", "§x§F§F§0§0§0§AA divindade metálica absoluta.");
        new SlimefunItem(SourceFUNItemGroups.RESOURCES, sourceniumX, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[9]).register(plugin);

        sourceniumXblock = new SlimefunItemStack("SOURCENIUM_X_BLOCK", Material.NETHERITE_BLOCK, "§x§5§7§0§D§9§8Sourcenium-X Block", "", "§x§F§F§0§0§0§AForma absoluta em bloco.");
        new SlimefunItem(SourceFUNItemGroups.RESOURCES, sourceniumXblock, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[9]).register(plugin);
    }
}