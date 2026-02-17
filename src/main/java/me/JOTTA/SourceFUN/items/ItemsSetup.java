package me.JOTTA.SourceFUN.items;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.JOTTA.SourceFUN.SourceFUN;
import me.JOTTA.SourceFUN.items.groups.SourceFUNItemGroups;
import me.JOTTA.SourceFUN.items.machines.*;
import net.guizhanss.infinityexpansion2.implementation.items.machines.InfinityWorkbench;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;

public class ItemsSetup {

    public static SlimefunItemStack wardenEssence;
    public static SlimefunItemStack warderEssenceBlock;
    public static SlimefunItemStack wardenHeartInfected;

    public static void setup(SourceFUN plugin) {
        // --- ITENS EXISTENTES ---
        new AdvancedPusher(SourceFUNItemGroups.MACHINES,
                new SlimefunItemStack("SOURCE_ADVANCED_PUSHER",
                        Material.RED_STAINED_GLASS, "§6Advanced Pusher",
                        "", "§7Pusher padrão com mais slots"), RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] { new ItemStack(Material.BARRIER),
                        new ItemStack(Material.GOLD_INGOT), new ItemStack(Material.PISTON),
                        new ItemStack(Material.GOLD_INGOT), new ItemStack(Material.REDSTONE_BLOCK),
                        new ItemStack(Material.GOLD_INGOT), new ItemStack(Material.PISTON), new ItemStack(Material.GOLD_INGOT),
                        new ItemStack(Material.PISTON) }).register(plugin);

        new NetworkGrabber(
                SourceFUNItemGroups.MACHINES,
                new SlimefunItemStack("SOURCE_GRABBER",
                        Material.YELLOW_STAINED_GLASS,
                        "§6Network Grabber", "",
                        "§7Tira itens dos slots input das máquinas e coloca no sistema"),
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        new ItemStack(Material.BARRIER), new ItemStack(Material.GOLD_INGOT), new ItemStack(Material.PISTON),
                        new ItemStack(Material.GOLD_INGOT), new ItemStack(Material.REDSTONE_BLOCK), new ItemStack(Material.GOLD_INGOT),
                        new ItemStack(Material.PISTON), new ItemStack(Material.GOLD_INGOT), new ItemStack(Material.PISTON) })
                .register(plugin);

        new Wardenassembly(SourceFUNItemGroups.MACHINES,
                new SlimefunItemStack("SOURCE_WARDEN_ASSEMBLER",
                        Material.SCULK_CATALYST, "§5Warden Assembler",
                        "", "§x§9§2§0§0§0§0End-Game Machine",
                        "§8⇨ §e⚡ §7Consumo: 4096 J/t", "§8⇨ §b❄ §7Capacidade: 8192 J"),
                RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]
                { new ItemStack(Material.SCULK_CATALYST), null, null, null, null, null, null, null, null }).register(plugin);

        wardenEssence = new SlimefunItemStack
                ("WARDEN_ESSENCE",
                        Material.ECHO_SHARD,
                        "&x&5&4&D&A&F&4Warden Essence",
                        "", "§7Essência vinda de tempos antigos");
        new SlimefunItem(
                SourceFUNItemGroups.RESOURCES,
                wardenEssence, RecipeType.NULL,
                new ItemStack[] { null, null, null, null, new ItemStack(Material.WARDEN_SPAWN_EGG),
                        null, null, null, null }).register(plugin);

        warderEssenceBlock = new SlimefunItemStack(
                "SOURCE_WARDEN_ESSENCE_BLOCK",
                Material.SCULK,
                "&x&5&4&D&A&F&4Warden Essence Block",
                "", "§7Bloco de warden essence");
        new SlimefunItem(SourceFUNItemGroups.RESOURCES,
                warderEssenceBlock,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{ wardenEssence, wardenEssence, wardenEssence,
                        wardenEssence, wardenEssence, wardenEssence,
                        wardenEssence, wardenEssence, wardenEssence }).register(plugin);

        // --- ESPADA E VARA ---
        SlimefunItemStack unbreakableSword = new SlimefunItemStack(
                "SOURCE_UNBREAKING_SWORD",
                Material.IRON_SWORD,
                "&x&5&4&D&A&F&4Espada indestrutível ",
                "", "&7Lâmina indestrutível", "&8(Indestrutível)");
        ItemMeta swordMeta = unbreakableSword.getItemMeta();
        if (swordMeta != null) { swordMeta.setUnbreakable(true); swordMeta.addEnchant(Enchantment.DURABILITY, 1, true); swordMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ENCHANTS); unbreakableSword.setItemMeta(swordMeta); }
        new SlimefunItem(SourceFUNItemGroups.TOOLS, unbreakableSword, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] { null, wardenEssence, null, null, wardenEssence, null, null, new ItemStack(Material.STICK), null }).register(plugin);

        SlimefunItemStack unbreakingfisher = new SlimefunItemStack("SOURCE_UNBREAKING_FISHER", Material.FISHING_ROD, "&x&5&4&D&A&F&4Vara de pesca indestrutível ", "", "&7Fio indestrutível", "&8(Indestrutível)");
        ItemMeta fisherMeta = unbreakingfisher.getItemMeta();
        if (fisherMeta != null) { fisherMeta.setUnbreakable(true); fisherMeta.addEnchant(Enchantment.DURABILITY, 1, true); fisherMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ENCHANTS); unbreakingfisher.setItemMeta(fisherMeta); }
        new SlimefunItem(SourceFUNItemGroups.TOOLS, unbreakingfisher, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] { null, null, wardenEssence, null, new ItemStack(Material.STICK), new ItemStack(Material.STRING), new ItemStack(Material.STICK), null, new ItemStack(Material.STRING) }).register(plugin);

        new WardenEssenceMiner(SourceFUNItemGroups.MACHINES, new SlimefunItemStack("SOURCE_WARDEN_ESSENCE_MINER", Material.SCULK_CATALYST, "&5Warden Essence Miner", "", "§x§9§2§0§0§0§0End-Game Machine", "§8⇨ §e⚡ §7Consumo: 4096 J/t", "§8⇨ §b❄ §7Capacidade: 8024 J"), RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] { new ItemStack(Material.BARRIER), wardenEssence, new ItemStack(Material.NETHERITE_BLOCK), wardenEssence, new ItemStack(Material.NETHER_STAR), wardenEssence, new ItemStack(Material.NETHERITE_BLOCK), wardenEssence, new ItemStack(Material.NETHERITE_BLOCK) }).register(plugin);

        SlimefunItemStack maraging = new SlimefunItemStack("SOURCE_MARAGING", Material.IRON_INGOT, "§x§5§4§D§A§F§4Maraging", "");
        new SlimefunItem(SourceFUNItemGroups.RESOURCES, maraging, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{ new ItemStack(Material.BARRIER), wardenEssence, wardenEssence, wardenEssence, wardenEssence, wardenEssence, wardenEssence, wardenEssence, wardenEssence }).register(plugin);

        SlimefunItemStack maragingPlate = new SlimefunItemStack("SOURCE_MARAGING_PLATE", Material.PAPER, "§x§5§4§D§A§F§4Maraging Plate", "");
        new SlimefunItem(SourceFUNItemGroups.RESOURCES, maragingPlate, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{ new ItemStack(Material.BARRIER), wardenEssence, wardenEssence, wardenEssence, wardenEssence, wardenEssence, wardenEssence, wardenEssence, wardenEssence }).register(plugin);


        // --- CONFIGURAÇÃO DAS QUARRY ---
        ItemStack[] qRecipe = new ItemStack[] {
                new ItemStack(Material.BARRIER), new ItemStack(Material.GOLD_INGOT), new ItemStack(Material.PISTON),
                new ItemStack(Material.GOLD_INGOT), new ItemStack(Material.REDSTONE_BLOCK), new ItemStack(Material.GOLD_INGOT),
                new ItemStack(Material.PISTON), new ItemStack(Material.GOLD_INGOT), new ItemStack(Material.PISTON)
        };

        SlimefunItem thornBit = SlimefunItem.getById("SUPREME_THORNIUM_BIT");
        SlimefunItem supNuggets = SlimefunItem.getById("SUPREME_SUPREME_NUGGET");

        // ================= TIER I =================
        WardenQuarry tier1 = new WardenQuarry(SourceFUNItemGroups.MACHINES,
                new SlimefunItemStack("SOURCE_WARDEN_QUARRY_T1", Material.QUARTZ_PILLAR,
                        "§7Warden Quarry §fTier I", "", "§8> §7Velocidade: §f40s", "§8> §e⚡ §7Consumo: §b5246 J/t"),
                RecipeType.ENHANCED_CRAFTING_TABLE, qRecipe, 5246, 80, 10240);
        tier1.addGuaranteedDrop(new ItemStack(Material.COAL, 2))
                .addGuaranteedDrop(new ItemStack(Material.COPPER_INGOT, 2))
                .addGuaranteedDrop(new ItemStack(Material.IRON_INGOT, 2))
                .addGuaranteedDrop(new ItemStack(Material.QUARTZ, 2))
                .addGuaranteedDrop(new ItemStack(Material.GOLD_INGOT, 2))
                .addGuaranteedDrop(new ItemStack(Material.LAPIS_LAZULI, 2))
                .addGuaranteedDrop(new ItemStack(Material.EMERALD, 2))
                .addGuaranteedDrop(new ItemStack(Material.DIAMOND, 2));
        tier1.register(plugin);

        // ================= TIER II =================
        WardenQuarry tier2 = new WardenQuarry(SourceFUNItemGroups.MACHINES,
                new SlimefunItemStack("SOURCE_WARDEN_QUARRY_T2", Material.CHISELED_QUARTZ_BLOCK,
                        "§fWarden Quarry §aTier II", "", "§8> §7Velocidade: §f40s", "§8> §e⚡ §7Consumo: §b8264 J/t"),
                RecipeType.ENHANCED_CRAFTING_TABLE, qRecipe, 8264, 80, 15654);
        tier2.addGuaranteedDrop(new ItemStack(Material.COAL, 4))
                .addGuaranteedDrop(new ItemStack(Material.COPPER_INGOT, 4))
                .addGuaranteedDrop(new ItemStack(Material.IRON_INGOT, 4))
                .addGuaranteedDrop(new ItemStack(Material.QUARTZ, 4))
                .addGuaranteedDrop(new ItemStack(Material.GOLD_INGOT, 4))
                .addGuaranteedDrop(new ItemStack(Material.LAPIS_LAZULI, 4))
                .addGuaranteedDrop(new ItemStack(Material.EMERALD, 4))
                .addGuaranteedDrop(new ItemStack(Material.REDSTONE, 4))
                .addGuaranteedDrop(new ItemStack(Material.DIAMOND, 4));
        tier2.register(plugin);

        // ================= TIER III =================
        WardenQuarry tier3 = new WardenQuarry(SourceFUNItemGroups.MACHINES,
                new SlimefunItemStack("SOURCE_WARDEN_QUARRY_T3", Material.CHISELED_NETHER_BRICKS,
                        "§aWarden Quarry §bTier III", "", "§8> §7Velocidade: §f40s", "§8> §e⚡ §7Consumo: §b12972 J/t"),
                RecipeType.ENHANCED_CRAFTING_TABLE, qRecipe, 12972, 80, 20654);
        tier3.addGuaranteedDrop(new ItemStack(Material.COAL, 8))
                .addGuaranteedDrop(new ItemStack(Material.COPPER_INGOT, 8))
                .addGuaranteedDrop(new ItemStack(Material.IRON_INGOT, 8))
                .addGuaranteedDrop(new ItemStack(Material.QUARTZ, 8))
                .addGuaranteedDrop(new ItemStack(Material.GOLD_INGOT, 8))
                .addGuaranteedDrop(new ItemStack(Material.LAPIS_LAZULI, 8))
                .addGuaranteedDrop(new ItemStack(Material.EMERALD, 8))
                .addGuaranteedDrop(new ItemStack(Material.NETHERITE_INGOT, 4))
                .addGuaranteedDrop(new ItemStack(Material.DIAMOND, 8));
        tier3.register(plugin);

        // ================= TIER IV =================
        WardenQuarry tier4 = new WardenQuarry(SourceFUNItemGroups.MACHINES,
                new SlimefunItemStack("SOURCE_WARDEN_QUARRY_T4", Material.CHISELED_POLISHED_BLACKSTONE,
                        "§bWarden Quarry §eTier IV", "", "§8> §7Velocidade: §f40s", "§8> §e⚡ §7Consumo: §b46750 J/t"),
                RecipeType.ENHANCED_CRAFTING_TABLE, qRecipe, 46750, 80, 78560);
        tier4.addGuaranteedDrop(new ItemStack(Material.COAL, 16))
                .addGuaranteedDrop(new ItemStack(Material.COPPER_INGOT, 16))
                .addGuaranteedDrop(new ItemStack(Material.IRON_INGOT, 16))
                .addGuaranteedDrop(new ItemStack(Material.QUARTZ, 16))
                .addGuaranteedDrop(new ItemStack(Material.GOLD_INGOT, 16))
                .addGuaranteedDrop(new ItemStack(Material.LAPIS_LAZULI, 16))
                .addGuaranteedDrop(new ItemStack(Material.EMERALD, 16))
                .addGuaranteedDrop(new ItemStack(Material.NETHERITE_INGOT, 16))
                .addGuaranteedDrop(new ItemStack(Material.DIAMOND, 16));
        if (thornBit != null) {
            ItemStack s4 = thornBit.getItem().clone(); s4.setAmount(20);
            tier4.addChanceDrop(s4, 20.0);
        }
        tier4.register(plugin);

        // ================= TIER V =================
        WardenQuarry tier5 = new WardenQuarry(SourceFUNItemGroups.MACHINES,
                new SlimefunItemStack("SOURCE_WARDEN_QUARRY_T5", Material.CHISELED_DEEPSLATE,
                        "§eWarden Quarry §6Tier V", "", "§8> §7Velocidade: §f40s", "§8> §e⚡ §7Consumo: §b256839 J/t"),
                RecipeType.ENHANCED_CRAFTING_TABLE, qRecipe, 256839, 80, 259604);
        tier5.addGuaranteedDrop(new ItemStack(Material.COAL, 32))
                .addGuaranteedDrop(new ItemStack(Material.COPPER_INGOT, 32))
                .addGuaranteedDrop(new ItemStack(Material.IRON_INGOT, 32))
                .addGuaranteedDrop(new ItemStack(Material.QUARTZ, 32))
                .addGuaranteedDrop(new ItemStack(Material.GOLD_INGOT, 32))
                .addGuaranteedDrop(new ItemStack(Material.LAPIS_LAZULI, 32))
                .addGuaranteedDrop(new ItemStack(Material.EMERALD, 32))
                .addGuaranteedDrop(new ItemStack(Material.NETHERITE_INGOT, 32))
                .addGuaranteedDrop(new ItemStack(Material.DIAMOND, 32));

        if (thornBit != null) {
            ItemStack s5 = thornBit.getItem().clone();
            s5.setAmount(20);
            tier5.addChanceDrop(s5, 40.0);
        }
        if (supNuggets != null) {
            ItemStack s5sup = supNuggets.getItem().clone();
            s5sup.setAmount(10);
            tier5.addChanceDrop(s5sup, 20.0);
        }
        tier5.register(plugin);
        // ================= TIER VI (Original 3x3) =================

// Usando nomes únicos (v6) para não conflitar com as variáveis das outras Tiers
        ItemStack[] qRecipeV6 = new ItemStack[] {
                new ItemStack(Material.BARRIER), new ItemStack(Material.NETHERITE_BLOCK), new ItemStack(Material.PISTON),
                new ItemStack(Material.NETHERITE_BLOCK), new ItemStack(Material.REINFORCED_DEEPSLATE), new ItemStack(Material.NETHERITE_BLOCK),
                new ItemStack(Material.PISTON), new ItemStack(Material.NETHERITE_BLOCK), new ItemStack(Material.PISTON)
        };

        WardenQuarry tier6 = new WardenQuarry(SourceFUNItemGroups.MACHINES,
                new SlimefunItemStack("SOURCE_WARDEN_QUARRY_T6", Material.REINFORCED_DEEPSLATE,
                        "§5§lSOURCE §6Warden Quarry", "", "§d§lMÁQUINA SUPREMA", "§8> §7Velocidade: §f20s", "§8> §e⚡ §7Consumo: §b760954 J/t"),
                RecipeType.ENHANCED_CRAFTING_TABLE, qRecipeV6, 760954, 40, 2596724);

        tier6.addGuaranteedDrop(new ItemStack(Material.COAL_BLOCK, 64))
                .addGuaranteedDrop(new ItemStack(Material.COPPER_BLOCK, 64))
                .addGuaranteedDrop(new ItemStack(Material.IRON_BLOCK, 64))
                .addGuaranteedDrop(new ItemStack(Material.QUARTZ_BLOCK, 64))
                .addGuaranteedDrop(new ItemStack(Material.GOLD_BLOCK, 64))
                .addGuaranteedDrop(new ItemStack(Material.LAPIS_BLOCK, 64))
                .addGuaranteedDrop(new ItemStack(Material.EMERALD_BLOCK, 64))
                .addGuaranteedDrop(new ItemStack(Material.NETHERITE_BLOCK, 64))
                .addGuaranteedDrop(new ItemStack(Material.DIAMOND_BLOCK, 64));

        if (thornBit != null) {
            ItemStack s6 = thornBit.getItem().clone();
            s6.setAmount(40);
            tier6.addChanceDrop(s6, 40.0);
        }
        if (supNuggets != null) {
            ItemStack s6sup = supNuggets.getItem().clone();
            s6sup.setAmount(20);
            tier6.addChanceDrop(s6sup, 40.0);
        }

        tier6.register(plugin);



        SlimefunItemStack titaniumPlate = new SlimefunItemStack(
                "SOURCE_TITANIUM_PLATE",
                Material.PAPER,
                "§x§5§4§D§A§F§4Titanium Plate",
                "");
        new SlimefunItem(
                SourceFUNItemGroups.RESOURCES,
                titaniumPlate,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]
                        { new ItemStack(Material.BARRIER), wardenEssence, wardenEssence,
                                wardenEssence, wardenEssence, wardenEssence,
                                wardenEssence, wardenEssence, wardenEssence }).register(plugin);


        SlimefunItemStack voidingWardenEssence = new SlimefunItemStack(
                "SOURCE_VOIDING_ESSENCE",
                Material.NETHERITE_INGOT,
                "§x§0§B§3§C§2§4Voiding Warden Essence",
                "",
                "§x§3§5§0§A§0§AA essência da morte em sua forma mais pura...");
        new SlimefunItem(
                SourceFUNItemGroups.RESOURCES,
                voidingWardenEssence,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]
                        { new ItemStack(Material.BARRIER), wardenEssence, wardenEssence,
                                wardenEssence, wardenEssence, wardenEssence,
                                wardenEssence, wardenEssence, wardenEssence }).register(plugin);

        SlimefunItemStack voidingWardenEssenceBlock = new SlimefunItemStack(
                "SOURCE_VOIDING_ESSENCE_BLOCK",
                Material.SCULK_SENSOR,
                "§x§0§B§3§C§2§4Voiding Warden Essence Block",
                "",
                "§x§A§0§0§0§0§0Bloco de essência vinda do vazio");
        new SlimefunItem(
                SourceFUNItemGroups.RESOURCES,
                voidingWardenEssenceBlock,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]
                        { new ItemStack(Material.BARRIER), wardenEssence, wardenEssence,
                                wardenEssence, wardenEssence, wardenEssence,
                                wardenEssence, wardenEssence, wardenEssence }).register(plugin);
        SlimefunItemStack voidingCetrusLumium = new SlimefunItemStack(
                "SOURCE_VOIDING_CETRUS_LUMIUM",
                Material.NETHER_STAR,
                "§x§F§F§6§7§0§0Voiding Cetrus Lumium",
                "",
                "§x§7§7§0§0§0§0Uma versão sombria de sua verdadeira forma...");
        new SlimefunItem(
                SourceFUNItemGroups.RESOURCES,
                voidingCetrusLumium,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]
                        { new ItemStack(Material.BARRIER), wardenEssence, wardenEssence,
                                wardenEssence, wardenEssence, wardenEssence,
                                wardenEssence, wardenEssence, wardenEssence }).register(plugin);


        SlimefunItemStack wardenHeart = new SlimefunItemStack(
                "SOURCE_WARDEN_HEART",
                Material.HEART_OF_THE_SEA,
                "§§x§0§0§5§3§1§DWarden Heart",
                "",
                """
                        §x§0§0§2§B§5§3Coração de uma criatura formidável
                         extraído das profundezas mais sombrias do mundo."""
                );
        new SlimefunItem(
                SourceFUNItemGroups.RESOURCES,
                wardenHeart,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]
                        { new ItemStack(Material.BARRIER), wardenEssence, wardenEssence,
                                wardenEssence, wardenEssence, wardenEssence,
                                wardenEssence, wardenEssence, wardenEssence }).register(plugin);

       
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

        SlimefunItemStack sourceniumX = new SlimefunItemStack(
                "SOURCENIUM_X",
                Material.NETHERITE_INGOT,
                "§x§F§D§0§0§0§0S§x§D§6§3§1§0§4o§x§B§0§6§2§0§8u§x§8§9§9§3§0§Br§x§6§3§C§4§0§Fc§x§3§C§F§5§1§3e§x§4§0§B§8§4§5n§x§4§4§7§B§7§7i§x§4§7§3§D§A§9u§x§4§B§0§0§D§Bm§x§4§B§0§0§D§B-§x§4§B§0§0§D§BX",
                "",
                "§x§F§F§0§0§0§AA divindade metálica absoluta e transcendental",
                "§x§F§F§0§0§0§A um soberano material cuja mera posse coroa o ápice da existência."
        );
        new SlimefunItem(
                SourceFUNItemGroups.RESOURCES,
                sourceniumX,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]
                        { new ItemStack(Material.BARRIER), wardenEssence, wardenEssence,
                                wardenEssence, wardenEssence, wardenEssence,
                                wardenEssence, wardenEssence, wardenEssence }).register(plugin);
        SlimefunItemStack sourceniumXblock = new SlimefunItemStack(
                "SOURCENIUM_X_BLOCK",
                Material.NETHERITE_BLOCK,
                "§x§5§7§0§D§9§8S§x§5§7§0§D§9§8o§x§5§7§0§D§9§8u§x§5§7§0§D§9§8r§x§5§E§2§4§8§9c§x§6§4§3§A§7§9e§x§6§B§5§1§6§An§x§7§1§6§7§5§Ai§x§7§8§7§E§4§Bu§x§9§5§7§6§6§4m§x§B§3§6§E§7§D-§x§D§0§6§5§9§5X §x§C§B§3§E§C§9B§x§A§9§1§F§E§4l§x§8§7§0§0§F§Fo§x§9§3§0§0§F§Fc§x§9§F§0§0§F§Fk",
                "",
                "§x§F§F§0§0§0§AA divindade metálica absoluta e transcendental em forma de bloco",
                "§x§F§F§0§0§0§A um soberano material cuja mera posse coroa o ápice da existência."
        );
        new SlimefunItem(
                SourceFUNItemGroups.RESOURCES,
                sourceniumXblock,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]
                        { new ItemStack(Material.BARRIER), wardenEssence, wardenEssence,
                                wardenEssence, wardenEssence, wardenEssence,
                                wardenEssence, wardenEssence, wardenEssence }).register(plugin);


        SlimefunItemStack bossSummoner = new SlimefunItemStack(
                "SOURCE_WARDEN_SUMMONER",
                Material.NETHER_STAR,
                "&d&lCoração Corrompido",
                "",
                "&7Clique no chão para invocar o",
                "&5&lCorrupted Warden",
                "",
                "&c&lCUIDADO: &7BIXO È CABULOSO"
        );


        SlimefunItem summonerItem = new SlimefunItem(
                SourceFUNItemGroups.BOSSES,
                bossSummoner,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        wardenEssence, new ItemStack(Material.BARRIER), wardenEssence,
                        new ItemStack(Material.NETHERITE_BLOCK), warderEssenceBlock, new ItemStack(Material.NETHERITE_BLOCK),
                        wardenEssence, new ItemStack(Material.NETHER_STAR), wardenEssence
                }
        );


        summonerItem.addItemHandler(new io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler() {
            @Override
            public void onRightClick(io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent e) {

                e.cancel();


                ItemStack item = e.getItem();
                item.setAmount(item.getAmount() - 1);


                me.JOTTA.SourceFUN.items.bosses.WardenBoss.spawn(plugin, e.getPlayer().getLocation());

                e.getPlayer().sendMessage("§5§lO ritual começou...");
            }
        });


        summonerItem.register(plugin);



        plugin.getLogger().info("§a[SourceFUN] Itens configurados com sucesso!");
    }
}