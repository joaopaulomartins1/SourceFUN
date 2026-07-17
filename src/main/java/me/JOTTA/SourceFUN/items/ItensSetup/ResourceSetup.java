package me.JOTTA.SourceFUN.items.ItensSetup;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.JOTTA.SourceFUN.SourceFUN;
import me.JOTTA.SourceFUN.items.groups.SourceFUNItemGroups;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

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
    public static SlimefunItemStack advancedMachinePlate;
    public static SlimefunItemStack conjutiveAlloy;
    public static SlimefunItemStack meatCore;
    public static SlimefunItemStack advancedMeatCore;
    public static SlimefunItemStack wardenMeatCore;

    public static void setup(SourceFUN plugin) {

        // ==========================================
        // RECEITA GLOBAL (Tudo setado para Barrier)
        // ==========================================
        ItemStack[] barrierRecipe = new ItemStack[] {
                new ItemStack(Material.BARRIER), new ItemStack(Material.BARRIER), new ItemStack(Material.BARRIER),
                new ItemStack(Material.BARRIER), new ItemStack(Material.BARRIER), new ItemStack(Material.BARRIER),
                new ItemStack(Material.BARRIER), new ItemStack(Material.BARRIER), new ItemStack(Material.BARRIER)
        };

        // --- Warden Essence ---
        wardenEssence = new SlimefunItemStack("WARDEN_ESSENCE", Material.ECHO_SHARD, "&x&5&4&D&A&F&4Warden Essence", "", "§7Essência vinda de tempos antigos");
        new SlimefunItem(SourceFUNItemGroups.RESOURCES, wardenEssence, RecipeType.NULL, barrierRecipe).register(plugin);

        // Esse já estava configurado, mantido!
        warderEssenceBlock = new SlimefunItemStack("SOURCE_WARDEN_ESSENCE_BLOCK", Material.SCULK, "&x&5&4&D&A&F&4Warden Essence Block", "", "§7Bloco de warden essence");
        new SlimefunItem(SourceFUNItemGroups.RESOURCES, warderEssenceBlock, RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{ wardenEssence, wardenEssence, wardenEssence, wardenEssence, wardenEssence, wardenEssence, wardenEssence, wardenEssence, wardenEssence }).register(plugin);

        // --- Maraging ---
        maraging = new SlimefunItemStack("SOURCE_MARAGING", Material.IRON_INGOT, "§x§5§4§D§A§F§4Maraging", "");
        new SlimefunItem(SourceFUNItemGroups.RESOURCES, maraging, RecipeType.ENHANCED_CRAFTING_TABLE, barrierRecipe).register(plugin);

        maragingPlate = new SlimefunItemStack("SOURCE_MARAGING_PLATE", Material.PAPER, "§x§5§4§D§A§F§4Maraging Plate", "");
        new SlimefunItem(SourceFUNItemGroups.RESOURCES, maragingPlate, RecipeType.ENHANCED_CRAFTING_TABLE, barrierRecipe).register(plugin);

        // --- Titanium & Voiding ---
        titaniumPlate = new SlimefunItemStack("SOURCE_TITANIUM_PLATE", Material.PAPER, "§x§5§4§D§A§F§4Titanium Plate", "");
        new SlimefunItem(SourceFUNItemGroups.RESOURCES, titaniumPlate, RecipeType.ENHANCED_CRAFTING_TABLE, barrierRecipe).register(plugin);

        // Já estava configurado com Barreiras
        advancedMachinePlate = new SlimefunItemStack(
                "SOURCE_ADVANCED_MACHINE_PLATE",
                Material.PAPER,
                "§x§B§8§B§8§B§8Advanced Machine Plate",
                ""
        );
        new SlimefunItem(SourceFUNItemGroups.RESOURCES, advancedMachinePlate, RecipeType.ENHANCED_CRAFTING_TABLE, barrierRecipe).register(plugin);

        // Já estava configurado com Barreiras
        conjutiveAlloy = new SlimefunItemStack(
                "SOURCE_CONJUTIVE_ALLOY",
                Material.IRON_INGOT,
                "§x§B§8§B§8§B§8Conjuctive Alloy",
                ""
        );
        new SlimefunItem(SourceFUNItemGroups.RESOURCES, conjutiveAlloy, RecipeType.ENHANCED_CRAFTING_TABLE, barrierRecipe).register(plugin);

        voidingWardenEssence = new SlimefunItemStack("SOURCE_VOIDING_ESSENCE", Material.NETHERITE_INGOT, "§x§0§B§3§C§2§4Voiding Warden Essence", "","§x§3§5§0§A§0§AA essência da morte em sua forma mais pura...");
        new SlimefunItem(SourceFUNItemGroups.RESOURCES, voidingWardenEssence, RecipeType.ENHANCED_CRAFTING_TABLE, barrierRecipe).register(plugin);

        voidingWardenEssenceBlock = new SlimefunItemStack("SOURCE_VOIDING_ESSENCE_BLOCK", Material.SCULK_SENSOR, "§x§0§B§3§C§2§4Voiding Warden Essence Block", "", "§x§A§0§0§0§0§0Bloco de essência vinda do vazio");
        new SlimefunItem(SourceFUNItemGroups.RESOURCES, voidingWardenEssenceBlock, RecipeType.ENHANCED_CRAFTING_TABLE, barrierRecipe).register(plugin);

        voidingCetrusLumium = new SlimefunItemStack("SOURCE_VOIDING_CETRUS_LUMIUM", Material.NETHER_STAR, "§x§F§F§6§7§0§0Voiding Cetrus Lumium", "", "§x§7§7§0§0§0§0Uma versão sombria de sua verdadeira forma...");
        new SlimefunItem(SourceFUNItemGroups.RESOURCES, voidingCetrusLumium, RecipeType.ENHANCED_CRAFTING_TABLE, barrierRecipe).register(plugin);

        // --- Hearts & Sourcenium ---
        wardenHeart = new SlimefunItemStack("SOURCE_WARDEN_HEART", Material.HEART_OF_THE_SEA, "§x§0§0§5§3§1§DWarden Heart", "",  """
                        §x§0§0§2§B§5§3Coração de uma criatura formidável
                        extraído das profundezas mais sombrias do mundo.""");
        new SlimefunItem(SourceFUNItemGroups.RESOURCES, wardenHeart, RecipeType.ENHANCED_CRAFTING_TABLE, barrierRecipe).register(plugin);

        // Mantido (Já configurado com o Egg)
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
        new SlimefunItem(SourceFUNItemGroups.RESOURCES, sourceniumX, RecipeType.ENHANCED_CRAFTING_TABLE, barrierRecipe).register(plugin);

        sourceniumXblock = new SlimefunItemStack(
                "SOURCENIUM_X_BLOCK",
                Material.NETHERITE_BLOCK,
                "§x§5§7§0§D§9§8Sourcenium-X Block",
                "", "§x§F§F§0§0§0§AA divindade metálica absoluta e transcendental",
                "§x§F§F§0§0§0§A um soberano material cuja mera posse coroa o ápice da existência.");
        new SlimefunItem(SourceFUNItemGroups.RESOURCES, sourceniumXblock, RecipeType.ENHANCED_CRAFTING_TABLE, barrierRecipe).register(plugin);

        // Syntax error corrigido aqui!
        completstar = new SlimefunItemStack(
                "SOURCE_COMPLETSTAR",
                Material.NETHER_STAR,
                "&x&B&A&3&5&D&AC&x&B&6&4&0&A&Fo&x&B&2&4&B&8&5m&x&A&D&5&7&5&Ap&x&A&9&6&2&3&0l&x&A&5&6&D&0&5e&x&8&7&6&4&1&Dt&x&6&A&5&B&3&5S&x&4&C&5&1&4&Et&x&2&F&4&8&6&6a&x&1&1&3&F&7&Er",
                "", "&x&1&3&A&C&B&1A &x&B&B&9&7&F&9s&x&8&1&7&A&C&Ai&x&4&8&5&D&9&Cn&x&0&E&4&0&6&Dg&x&2&C&4&9&5&8u&x&4&A&5&2&4&3l&x&6&9&5&B&2&Fa&x&8&7&6&4&1&Ar&x&A&5&6&D&0&5i&x&7&1&9&9&4&5d&x&3&C&C&4&8&6a&x&0&8&F&0&C&6d&x&1&A&A&2&B&De &x&2&B&5&5&B&3c&x&2&B&5&6&B&2o&x&2&A&5&6&B&0m&x&2&9&5&7&A&Fp&x&6&1&3&F&B&4l&x&9&9&2&7&B&Ae&x&D&1&0&F&B&Ft&x&7&7&7&F&C&3a&x&1&1&3&F&7&E.");
        new SlimefunItem(
                SourceFUNItemGroups.RESOURCES,
                wardenHeartInfected,
                RecipeType.MOB_DROP,
                new ItemStack[] {
                        null, null, null,
                        null, new ItemStack(Material.WARDEN_SPAWN_EGG), null,
                        null, null, null
                }).register(plugin);
        // Mantido
        meatCore = new SlimefunItemStack(
                "MEAT_CORE",
                Material.BEEF,
                "§x§F§F§8§0§8§0Meat Core",
                "",
                "§x§B§E§B§E§B§ENúcleo básico de carne");
        new SlimefunItem(
                SourceFUNItemGroups.RESOURCES,
                meatCore,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        null, null, null,
                        null, new CustomItemStack(Material.BARRIER), null,
                        null, null, null
                }).register(plugin);

        // Mantido
        advancedMeatCore = new SlimefunItemStack(
                "ADVANCED_MEAT_CORE",
                Material.MUTTON,
                "§x§F§F§8§0§8§0Advanced Meat Core",
                "",
                "§x§B§E§B§E§B§ENúcleo avançado de carne");
        new SlimefunItem(
                SourceFUNItemGroups.RESOURCES,
                advancedMeatCore,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        null, null, null,
                        null, new CustomItemStack(Material.BARRIER), null,
                        null, null, null
                }).register(plugin);

        // Mantido
        wardenMeatCore = new SlimefunItemStack(
                "WARDEN_MEAT_CORE",
                Material.ENDER_EYE,
                "§x§0§0§A§7§9§3Warden Meat Core",
                "",
                "§x§7§9§6§C§0§0Núcleo De carne vindo de uma civilização antiga");
        new SlimefunItem(
                SourceFUNItemGroups.RESOURCES,
                wardenMeatCore,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        null, null, null,
                        null, new CustomItemStack(Material.BARRIER), null,
                        null, null, null
                }).register(plugin);

        // Já estava com Barreiras
        SlimefunItemStack cudogui = new SlimefunItemStack(
                "ANELDOGUI",
                Material.GOLD_NUGGET,
                "§x§B§1§0§0§0§0A§x§A§E§2§3§3§3n§x§A§C§4§6§6§6e§x§A§9§6§8§9§9l §x§A§4§A§E§F§Fd§x§9§D§8§C§E§2o §x§8§E§4§9§A§8G§x§8§7§2§8§8§BU§x§8§0§0§6§6§EI§x§9§9§1§3§7§8S§x§B§2§2§0§8§2E§x§C§B§2§D§8§CN§x§E§4§3§A§9§6P§x§D§3§4§B§9§9A§x§C§2§5§C§9§BI§x§B§1§6§C§9§EI§x§A§0§7§D§A§02§x§8§F§8§E§A§32",
                "§x§B§7§0§B§6§CE§x§A§9§2§4§8§2s§x§9§B§3§D§9§9s§x§8§D§5§5§A§Fe §x§6§D§7§D§B§9a§x§5§B§8§C§A§Cn§x§4§8§9§A§A§0e§x§3§6§A§9§9§3l §x§4§E§C§7§9§5é §x§A§3§E§6§B§0u§x§C§D§F§5§B§Dm§x§A§D§D§D§9§9a §x§6§C§A§C§5§2d§x§4§C§9§3§2§Fe§x§2§C§7§B§0§Bl§x§3§4§6§7§3§9i§x§3§D§5§4§6§6c§x§4§5§4§0§9§4i§x§4§D§2§C§C§1a",
                "§x§1§3§6§F§F§FSaturação",
                "§x§1§3§6§F§F§FForça III",
                "§x§1§3§6§F§F§FRegeneração II"
        );
        new SlimefunItem(SourceFUNItemGroups.RESOURCES, cudogui, RecipeType.ENHANCED_CRAFTING_TABLE, barrierRecipe).register(plugin);

        // ==========================================
        // EFEITOS DO ANELDOGUI
        // ==========================================
        org.bukkit.Bukkit.getScheduler().runTaskTimer(plugin, () -> {
            for (org.bukkit.entity.Player p : org.bukkit.Bukkit.getOnlinePlayers()) {
                for (ItemStack item : p.getInventory().getContents()) {
                    if (item != null && item.getType() != Material.AIR) {
                        io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem sfItem = io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem.getByItem(item);

                        if (sfItem != null && sfItem.getId().equals("ANELDOGUI")) {
                            p.addPotionEffect(new org.bukkit.potion.PotionEffect(org.bukkit.potion.PotionEffectType.SATURATION, 40, 0, true, false));
                            p.addPotionEffect(new org.bukkit.potion.PotionEffect(PotionEffectType.REGENERATION, 40, 2, true, false));
                            p.addPotionEffect(new org.bukkit.potion.PotionEffect(PotionEffectType.STRENGTH, 60, 2, true, false));
                            break;
                        }
                    }
                }
            }
        }, 0L, 20L);

    }
}