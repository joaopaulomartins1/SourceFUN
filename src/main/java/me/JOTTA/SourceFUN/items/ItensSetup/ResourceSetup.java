package me.JOTTA.SourceFUN.items.ItensSetup;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
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
    public static SlimefunItemStack completstar;
    public static SlimefunItemStack wardenHeartInfected;

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

        voidingWardenEssence = new SlimefunItemStack("SOURCE_VOIDING_ESSENCE", Material.NETHERITE_INGOT, "§x§0§B§3§C§2§4Voiding Warden Essence", "","§x§3§5§0§A§0§AA essência da morte em sua forma mais pura...");
        new SlimefunItem(SourceFUNItemGroups.RESOURCES, voidingWardenEssence, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[9]).register(plugin);

        voidingWardenEssenceBlock = new SlimefunItemStack("SOURCE_VOIDING_ESSENCE_BLOCK", Material.SCULK_SENSOR, "§x§0§B§3§C§2§4Voiding Warden Essence Block", "", "§x§A§0§0§0§0§0Bloco de essência vinda do vazio");
        new SlimefunItem(SourceFUNItemGroups.RESOURCES, voidingWardenEssenceBlock, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[9]).register(plugin);

        voidingCetrusLumium = new SlimefunItemStack("SOURCE_VOIDING_CETRUS_LUMIUM", Material.NETHER_STAR, "§x§F§F§6§7§0§0Voiding Cetrus Lumium", "", "§x§7§7§0§0§0§0Uma versão sombria de sua verdadeira forma...");
        new SlimefunItem(SourceFUNItemGroups.RESOURCES, voidingCetrusLumium, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[9]).register(plugin);

        // --- Hearts & Sourcenium ---
        wardenHeart = new SlimefunItemStack("SOURCE_WARDEN_HEART", Material.HEART_OF_THE_SEA, "§x§0§0§5§3§1§DWarden Heart", "",  """
                        §x§0§0§2§B§5§3Coração de uma criatura formidável
                        extraído das profundezas mais sombrias do mundo.""");
        new SlimefunItem(SourceFUNItemGroups.RESOURCES, wardenHeart, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[9]).register(plugin);
        wardenHeartInfected = new SlimefunItemStack(
                "SOURCE_WARDEN_HEART_INFECTED",
                Material.ENDER_EYE,
                "§x§0§0§5§3§1§DInfected Warden Heart",
                "",
                "§7O núcleo infestado de uma abominação tão temida",
                "§7que a simples menção de seu nome instaura o pânico.");


        new SlimefunItem(
                SourceFUNItemGroups.RESOURCES,
                wardenHeartInfected,
                RecipeType.MOB_DROP,
                new ItemStack[] {
                        null, null, null,
                        null, new CustomItemStack(Material.WARDEN_SPAWN_EGG, "§d§lCorrupted Warden"), null,
                        null, null, null
                }).register(plugin);

        sourceniumX = new SlimefunItemStack("SOURCENIUM_X", Material.NETHERITE_INGOT, "§x§A§B§E§6§C§ES§x§8§8§C§8§D§Co§x§6§5§A§9§E§Au§x§4§2§8§B§F§8r§x§5§3§9§5§F§7c§x§6§5§A§0§F§6e§x§7§6§A§A§F§5n§x§6§6§6§5§D§Bi§x§5§5§2§0§C§0u§x§8§3§2§7§B§5m§x§B§1§2§E§A§B-§x§D§F§3§5§A§0X", "", "§x§F§F§0§0§0§AA divindade metálica absoluta.");
        new SlimefunItem(SourceFUNItemGroups.RESOURCES, sourceniumX, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[9]).register(plugin);

        sourceniumXblock = new SlimefunItemStack(
                "SOURCENIUM_X_BLOCK",
                Material.NETHERITE_BLOCK,
                "§x§5§7§0§D§9§8Sourcenium-X Block",
                "", "§x§F§F§0§0§0§AA divindade metálica absoluta e transcendental",
                "§x§F§F§0§0§0§A um soberano material cuja mera posse coroa o ápice da existência.");
        new SlimefunItem(SourceFUNItemGroups.RESOURCES,
                sourceniumXblock,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[9]).register(plugin);

        completstar = new SlimefunItemStack(
                "SOURCE_COMPLETSTAR",
                Material.NETHER_STAR,
                "&x&B&A&3&5&D&AC&x&B&6&4&0&A&Fo&x&B&2&4&B&8&5m&x&A&D&5&7&5&Ap&x&A&9&6&2&3&0l&x&A&5&6&D&0&5e&x&8&7&6&4&1&Dt&x&6&A&5&B&3&5S&x&4&C&5&1&4&Et&x&2&F&4&8&6&6a&x&1&1&3&F&7&Er",
                "", "&x&1&3&A&C&B&1A &x&B&B&9&7&F&9s&x&8&1&7&A&C&Ai&x&4&8&5&D&9&Cn&x&0&E&4&0&6&Dg&x&2&C&4&9&5&8u&x&4&A&5&2&4&3l&x&6&9&5&B&2&Fa&x&8&7&6&4&1&Ar&x&A&5&6&D&0&5i&x&7&1&9&9&4&5d&x&3&C&C&4&8&6a&x&0&8&F&0&C&6d&x&1&A&A&2&B&De &x&2&B&5&5&B&3c&x&2&B&5&6&B&2o&x&2&A&5&6&B&0m&x&2&9&5&7&A&Fp&x&6&1&3&F&B&4l&x&9&9&2&7&B&Ae&x&D&1&0&F&B&Ft&x&7&7&7&F&C&3a&x&1&1&3&F&7&E.");
        new SlimefunItem(SourceFUNItemGroups.RESOURCES,
                completstar,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[9]).register(plugin);

        
    }
}