package me.JOTTA.SourceFUN.items.ItensSetup;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.JOTTA.SourceFUN.SourceFUN;
import me.JOTTA.SourceFUN.items.groups.SourceFUNItemGroups;
import me.JOTTA.SourceFUN.items.machines.*;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;

public class MachineSetup {

    public static void setup(SourceFUN plugin) {
        // --- 1. MÁQUINAS UTILITÁRIAS E DE REDE ---

        new AdvancedPusher(SourceFUNItemGroups.MACHINES,
                new SlimefunItemStack("SOURCE_ADVANCED_PUSHER", Material.RED_STAINED_GLASS, "§6Advanced Pusher", "", "§7Pusher padrão com mais slots"),
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] { new ItemStack(Material.BARRIER), new ItemStack(Material.GOLD_INGOT), new ItemStack(Material.PISTON),
                        new ItemStack(Material.GOLD_INGOT), new ItemStack(Material.REDSTONE_BLOCK), new ItemStack(Material.GOLD_INGOT),
                        new ItemStack(Material.PISTON), new ItemStack(Material.GOLD_INGOT), new ItemStack(Material.PISTON) }).register(plugin);

        new NetworkGrabber(SourceFUNItemGroups.MACHINES,
                new SlimefunItemStack("SOURCE_GRABBER", Material.YELLOW_STAINED_GLASS, "§6Network Grabber", "", "§7Tira itens dos slots input das máquinas"),
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] { new ItemStack(Material.BARRIER), new ItemStack(Material.GOLD_INGOT), new ItemStack(Material.PISTON),
                        new ItemStack(Material.GOLD_INGOT), new ItemStack(Material.REDSTONE_BLOCK), new ItemStack(Material.GOLD_INGOT),
                        new ItemStack(Material.PISTON), new ItemStack(Material.GOLD_INGOT), new ItemStack(Material.PISTON) }).register(plugin);

        new Wardenassembly(SourceFUNItemGroups.MACHINES,
                new SlimefunItemStack("SOURCE_WARDEN_ASSEMBLER", Material.SCULK_CATALYST, "§5Warden Assembler", "", "§x§9§2§0§0§0§0End-Game Machine", "§8⇨ §e⚡ §7Consumo: 4096 J/t", "§8⇨ §b❄ §7Capacidade: 8192 J"),
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] { new ItemStack(Material.SCULK_CATALYST), null, null, null, null, null, null, null, null }).register(plugin);

        new WardenEssenceMiner(SourceFUNItemGroups.MACHINES,
                new SlimefunItemStack("SOURCE_WARDEN_ESSENCE_MINER", Material.SCULK_CATALYST, "&5Warden Essence Miner", "", "§x§9§2§0§0§0§0End-Game Machine", "§8⇨ §e⚡ §7Consumo: 4096 J/t", "§8⇨ §b❄ §7Capacidade: 8024 J"),
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] { new ItemStack(Material.BARRIER), ResourceSetup.wardenEssence, new ItemStack(Material.NETHERITE_BLOCK),
                        ResourceSetup.wardenEssence, new ItemStack(Material.NETHER_STAR), ResourceSetup.wardenEssence,
                        new ItemStack(Material.NETHERITE_BLOCK), ResourceSetup.wardenEssence, new ItemStack(Material.NETHERITE_BLOCK) }).register(plugin);


        // --- 2. CONFIGURAÇÃO DAS QUARRIES (TIER I - VI) ---

        ItemStack[] qRecipe = new ItemStack[] {
                new ItemStack(Material.BARRIER), new ItemStack(Material.GOLD_INGOT), new ItemStack(Material.PISTON),
                new ItemStack(Material.GOLD_INGOT), new ItemStack(Material.REDSTONE_BLOCK), new ItemStack(Material.GOLD_INGOT),
                new ItemStack(Material.PISTON), new ItemStack(Material.GOLD_INGOT), new ItemStack(Material.PISTON)
        };

        SlimefunItem thornBit = SlimefunItem.getById("SUPREME_THORNIUM_BIT");
        SlimefunItem supNuggets = SlimefunItem.getById("SUPREME_SUPREME_NUGGET");

        // TIER I
        WardenQuarry tier1 = new WardenQuarry(SourceFUNItemGroups.MACHINES,
                new SlimefunItemStack("SOURCE_WARDEN_QUARRY_T1", Material.QUARTZ_PILLAR, "§7Warden Quarry §fTier I", "", "§8> §7Velocidade: §f40s", "§8> §e⚡ §7Consumo: §b5246 J/t"),
                RecipeType.ENHANCED_CRAFTING_TABLE, qRecipe, 5246, 80, 10240);
        addBasicLoot(tier1, 2).register(plugin);

        // TIER II
        WardenQuarry tier2 = new WardenQuarry(SourceFUNItemGroups.MACHINES,
                new SlimefunItemStack("SOURCE_WARDEN_QUARRY_T2", Material.CHISELED_QUARTZ_BLOCK, "§fWarden Quarry §aTier II", "", "§8> §7Velocidade: §f40s", "§8> §e⚡ §7Consumo: §b8264 J/t"),
                RecipeType.ENHANCED_CRAFTING_TABLE, qRecipe, 8264, 80, 15654);
        addBasicLoot(tier2, 4).addGuaranteedDrop(new ItemStack(Material.REDSTONE, 4)).register(plugin);

        // TIER III
        WardenQuarry tier3 = new WardenQuarry(SourceFUNItemGroups.MACHINES,
                new SlimefunItemStack("SOURCE_WARDEN_QUARRY_T3", Material.CHISELED_NETHER_BRICKS, "§aWarden Quarry §bTier III", "", "§8> §7Velocidade: §f40s", "§8> §e⚡ §7Consumo: §b12972 J/t"),
                RecipeType.ENHANCED_CRAFTING_TABLE, qRecipe, 12972, 80, 20654);
        addBasicLoot(tier3, 8).addGuaranteedDrop(new ItemStack(Material.NETHERITE_INGOT, 4)).register(plugin);

        // TIER IV
        WardenQuarry tier4 = new WardenQuarry(SourceFUNItemGroups.MACHINES,
                new SlimefunItemStack("SOURCE_WARDEN_QUARRY_T4", Material.CHISELED_POLISHED_BLACKSTONE, "§bWarden Quarry §eTier IV", "", "§8> §7Velocidade: §f40s", "§8> §e⚡ §7Consumo: §b46750 J/t"),
                RecipeType.ENHANCED_CRAFTING_TABLE, qRecipe, 46750, 80, 78560);
        addBasicLoot(tier4, 16).addGuaranteedDrop(new ItemStack(Material.NETHERITE_INGOT, 16));
        if (thornBit != null) tier4.addChanceDrop(new CustomItemStack(thornBit.getItem(), 20), 20.0);
        tier4.register(plugin);

        // TIER V
        WardenQuarry tier5 = new WardenQuarry(SourceFUNItemGroups.MACHINES,
                new SlimefunItemStack("SOURCE_WARDEN_QUARRY_T5", Material.CHISELED_DEEPSLATE, "§eWarden Quarry §6Tier V", "", "§8> §7Velocidade: §f40s", "§8> §e⚡ §7Consumo: §b256839 J/t"),
                RecipeType.ENHANCED_CRAFTING_TABLE, qRecipe, 256839, 80, 259604);
        addBasicLoot(tier5, 32).addGuaranteedDrop(new ItemStack(Material.NETHERITE_INGOT, 32));
        if (thornBit != null) tier5.addChanceDrop(new CustomItemStack(thornBit.getItem(), 20), 40.0);
        if (supNuggets != null) tier5.addChanceDrop(new CustomItemStack(supNuggets.getItem(), 10), 20.0);
        tier5.register(plugin);

        // TIER VI (SUPREMA)
        ItemStack[] qRecipeV6 = new ItemStack[] {
                new ItemStack(Material.BARRIER), new ItemStack(Material.NETHERITE_BLOCK), new ItemStack(Material.PISTON),
                new ItemStack(Material.NETHERITE_BLOCK), new ItemStack(Material.REINFORCED_DEEPSLATE), new ItemStack(Material.NETHERITE_BLOCK),
                new ItemStack(Material.PISTON), new ItemStack(Material.NETHERITE_BLOCK), new ItemStack(Material.PISTON)
        };
        WardenQuarry tier6 = new WardenQuarry(SourceFUNItemGroups.MACHINES,
                new SlimefunItemStack("SOURCE_WARDEN_QUARRY_T6", Material.REINFORCED_DEEPSLATE, "§5§lSOURCE §6Warden Quarry", "", "§d§lMÁQUINA SUPREMA", "§8> §7Velocidade: §f20s", "§8> §e⚡ §7Consumo: §b760954 J/t"),
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

        if (thornBit != null) tier6.addChanceDrop(new CustomItemStack(thornBit.getItem(), 40), 40.0);
        if (supNuggets != null) tier6.addChanceDrop(new CustomItemStack(supNuggets.getItem(), 20), 40.0);
        tier6.register(plugin);
        IndustrialStonecutter stonecutter = new IndustrialStonecutter(
                SourceFUNItemGroups.MACHINES,
                new SlimefunItemStack("SOURCE_INDUSTRIAL_STONECUTTER", Material.STONECUTTER, "&6Industrial Stonecutter", "", "&7Cortador de pedras industrial", "&7Selecione a receita no menu"),
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {

                },
                1748,
                2048,
                4
        );

       // QUARTZ

        ItemStack qBlock = new ItemStack(Material.QUARTZ_BLOCK);

        stonecutter.addRecipe(qBlock, 1, new ItemStack(Material.QUARTZ_PILLAR), 1);
        stonecutter.addRecipe(qBlock, 1, new ItemStack(Material.CHISELED_QUARTZ_BLOCK), 1);
        stonecutter.addRecipe(qBlock, 1, new ItemStack(Material.QUARTZ_BRICKS), 1);
        stonecutter.addRecipe(qBlock, 1, new ItemStack(Material.SMOOTH_QUARTZ), 1);
        stonecutter.addRecipe(qBlock, 1, new ItemStack(Material.QUARTZ_STAIRS), 1);
        stonecutter.addRecipe(qBlock, 1, new ItemStack(Material.SMOOTH_QUARTZ_STAIRS), 1);
        stonecutter.addRecipe(qBlock, 1, new ItemStack(Material.QUARTZ_SLAB), 2);
        stonecutter.addRecipe(qBlock, 1, new ItemStack(Material.SMOOTH_QUARTZ_SLAB), 2);
        stonecutter.addRecipe(new ItemStack(Material.QUARTZ), 4, qBlock, 1);
        stonecutter.register(plugin);

        //SPRUCELOG

        ItemStack spruceBlock = new ItemStack(Material.SPRUCE_LOG);

        stonecutter.addRecipe(spruceBlock, 1, new ItemStack(Material.STRIPPED_SPRUCE_LOG), 1);
        stonecutter.addRecipe(spruceBlock, 1, new ItemStack(Material.STRIPPED_SPRUCE_WOOD), 1);
        stonecutter.addRecipe(spruceBlock, 1, new ItemStack(Material.SPRUCE_WOOD), 1);
        stonecutter.addRecipe(spruceBlock, 1, new ItemStack(Material.SPRUCE_PLANKS), 4);
        stonecutter.addRecipe(spruceBlock, 1, new ItemStack(Material.SPRUCE_STAIRS), 4);
        stonecutter.addRecipe(spruceBlock, 1, new ItemStack(Material.SPRUCE_SLAB), 8);
        stonecutter.addRecipe(spruceBlock, 1, new ItemStack(Material.SPRUCE_FENCE), 1);
        stonecutter.addRecipe(spruceBlock, 1, new ItemStack(Material.SPRUCE_TRAPDOOR), 1);
        stonecutter.addRecipe(spruceBlock, 1, new ItemStack(Material.SPRUCE_DOOR), 2);
        stonecutter.addRecipe(spruceBlock, 1, new ItemStack(Material.SPRUCE_FENCE_GATE), 2);
        stonecutter.addRecipe(spruceBlock, 1, new ItemStack(Material.SPRUCE_SIGN), 2);

        //OAK LOG

        ItemStack oakBlock = new ItemStack(Material.OAK_LOG);

        stonecutter.addRecipe(oakBlock, 1, new ItemStack(Material.STRIPPED_OAK_LOG), 1);
        stonecutter.addRecipe(oakBlock, 1, new ItemStack(Material.STRIPPED_OAK_WOOD), 1);
        stonecutter.addRecipe(oakBlock, 1, new ItemStack(Material.OAK_WOOD), 1);
        stonecutter.addRecipe(oakBlock, 1, new ItemStack(Material.OAK_PLANKS), 4);
        stonecutter.addRecipe(oakBlock, 1, new ItemStack(Material.OAK_STAIRS), 4);
        stonecutter.addRecipe(oakBlock, 1, new ItemStack(Material.OAK_SLAB), 8);
        stonecutter.addRecipe(oakBlock, 1, new ItemStack(Material.OAK_FENCE), 1);
        stonecutter.addRecipe(oakBlock, 1, new ItemStack(Material.OAK_TRAPDOOR), 1);
        stonecutter.addRecipe(oakBlock, 1, new ItemStack(Material.OAK_DOOR), 2);
        stonecutter.addRecipe(oakBlock, 1, new ItemStack(Material.OAK_FENCE_GATE), 2);
        stonecutter.addRecipe(oakBlock, 1, new ItemStack(Material.OAK_SIGN), 2);

        //BIRCHLOG

        ItemStack birchBlock = new ItemStack(Material.BIRCH_LOG);

        stonecutter.addRecipe(birchBlock, 1, new ItemStack(Material.STRIPPED_BIRCH_LOG), 1);
        stonecutter.addRecipe(birchBlock, 1, new ItemStack(Material.STRIPPED_BIRCH_WOOD), 1);
        stonecutter.addRecipe(birchBlock, 1, new ItemStack(Material.BIRCH_WOOD), 1);
        stonecutter.addRecipe(birchBlock, 1, new ItemStack(Material.BIRCH_PLANKS), 4);
        stonecutter.addRecipe(birchBlock, 1, new ItemStack(Material.BIRCH_STAIRS), 4);
        stonecutter.addRecipe(birchBlock, 1, new ItemStack(Material.BIRCH_SLAB), 8);
        stonecutter.addRecipe(birchBlock, 1, new ItemStack(Material.BIRCH_FENCE), 1);
        stonecutter.addRecipe(birchBlock, 1, new ItemStack(Material.BIRCH_TRAPDOOR), 1);
        stonecutter.addRecipe(birchBlock, 1, new ItemStack(Material.BIRCH_DOOR), 2);
        stonecutter.addRecipe(birchBlock, 1, new ItemStack(Material.BIRCH_FENCE_GATE), 2);
        stonecutter.addRecipe(birchBlock, 1, new ItemStack(Material.BIRCH_SIGN), 2);
    // JUNGLE
        ItemStack jungleBlock = new ItemStack(Material.JUNGLE_LOG);

        stonecutter.addRecipe(jungleBlock, 1, new ItemStack(Material.STRIPPED_JUNGLE_LOG), 1);
        stonecutter.addRecipe(jungleBlock, 1, new ItemStack(Material.STRIPPED_JUNGLE_WOOD), 1);
        stonecutter.addRecipe(jungleBlock, 1, new ItemStack(Material.JUNGLE_WOOD), 1);
        stonecutter.addRecipe(jungleBlock, 1, new ItemStack(Material.JUNGLE_PLANKS), 4);
        stonecutter.addRecipe(jungleBlock, 1, new ItemStack(Material.JUNGLE_STAIRS), 4);
        stonecutter.addRecipe(jungleBlock, 1, new ItemStack(Material.JUNGLE_SLAB), 8);
        stonecutter.addRecipe(jungleBlock, 1, new ItemStack(Material.JUNGLE_FENCE), 1);
        stonecutter.addRecipe(jungleBlock, 1, new ItemStack(Material.JUNGLE_TRAPDOOR), 1);
        stonecutter.addRecipe(jungleBlock, 1, new ItemStack(Material.JUNGLE_DOOR), 2);
        stonecutter.addRecipe(jungleBlock, 1, new ItemStack(Material.JUNGLE_FENCE_GATE), 2);
        stonecutter.addRecipe(jungleBlock, 1, new ItemStack(Material.JUNGLE_SIGN), 2);

        // ACACIA

        ItemStack acaciaBlock = new ItemStack(Material.ACACIA_LOG);

        stonecutter.addRecipe(acaciaBlock, 1, new ItemStack(Material.STRIPPED_ACACIA_LOG), 1);
        stonecutter.addRecipe(acaciaBlock, 1, new ItemStack(Material.STRIPPED_ACACIA_WOOD), 1);
        stonecutter.addRecipe(acaciaBlock, 1, new ItemStack(Material.ACACIA_WOOD), 1);
        stonecutter.addRecipe(acaciaBlock, 1, new ItemStack(Material.ACACIA_PLANKS), 4);
        stonecutter.addRecipe(acaciaBlock, 1, new ItemStack(Material.ACACIA_STAIRS), 4);
        stonecutter.addRecipe(acaciaBlock, 1, new ItemStack(Material.ACACIA_SLAB), 8);
        stonecutter.addRecipe(acaciaBlock, 1, new ItemStack(Material.ACACIA_FENCE), 1);
        stonecutter.addRecipe(acaciaBlock, 1, new ItemStack(Material.ACACIA_TRAPDOOR), 1);
        stonecutter.addRecipe(acaciaBlock, 1, new ItemStack(Material.ACACIA_DOOR), 2);
        stonecutter.addRecipe(acaciaBlock, 1, new ItemStack(Material.ACACIA_FENCE_GATE), 2);
        stonecutter.addRecipe(acaciaBlock, 1, new ItemStack(Material.ACACIA_SIGN), 2);

        //DAR OAK LOG

        ItemStack darkoakBlock = new ItemStack(Material.DARK_OAK_LOG);

        stonecutter.addRecipe(darkoakBlock, 1, new ItemStack(Material.STRIPPED_DARK_OAK_LOG), 1);
        stonecutter.addRecipe(darkoakBlock, 1, new ItemStack(Material.STRIPPED_DARK_OAK_WOOD), 1);
        stonecutter.addRecipe(darkoakBlock, 1, new ItemStack(Material.DARK_OAK_WOOD), 1);
        stonecutter.addRecipe(darkoakBlock, 1, new ItemStack(Material.DARK_OAK_PLANKS), 4);
        stonecutter.addRecipe(darkoakBlock, 1, new ItemStack(Material.DARK_OAK_STAIRS), 4);
        stonecutter.addRecipe(darkoakBlock, 1, new ItemStack(Material.DARK_OAK_SLAB), 8);
        stonecutter.addRecipe(darkoakBlock, 1, new ItemStack(Material.DARK_OAK_FENCE), 1);
        stonecutter.addRecipe(darkoakBlock, 1, new ItemStack(Material.DARK_OAK_TRAPDOOR), 1);
        stonecutter.addRecipe(darkoakBlock, 1, new ItemStack(Material.DARK_OAK_DOOR), 2);
        stonecutter.addRecipe(darkoakBlock, 1, new ItemStack(Material.DARK_OAK_FENCE_GATE), 2);
        stonecutter.addRecipe(darkoakBlock, 1, new ItemStack(Material.DARK_OAK_SIGN), 2);
    // MANGROVE LOG
        ItemStack mangroveBlock = new ItemStack(Material.MANGROVE_LOG);

        stonecutter.addRecipe(mangroveBlock, 1, new ItemStack(Material.STRIPPED_MANGROVE_LOG), 1);
        stonecutter.addRecipe(mangroveBlock, 1, new ItemStack(Material.STRIPPED_MANGROVE_WOOD), 1);
        stonecutter.addRecipe(mangroveBlock, 1, new ItemStack(Material.MANGROVE_WOOD), 1);
        stonecutter.addRecipe(mangroveBlock, 1, new ItemStack(Material.MANGROVE_PLANKS), 4);
        stonecutter.addRecipe(mangroveBlock, 1, new ItemStack(Material.MANGROVE_STAIRS), 4);
        stonecutter.addRecipe(mangroveBlock, 1, new ItemStack(Material.MANGROVE_SLAB), 8);
        stonecutter.addRecipe(mangroveBlock, 1, new ItemStack(Material.MANGROVE_FENCE), 1);
        stonecutter.addRecipe(mangroveBlock, 1, new ItemStack(Material.MANGROVE_TRAPDOOR), 1);
        stonecutter.addRecipe(mangroveBlock, 1, new ItemStack(Material.MANGROVE_DOOR), 2);
        stonecutter.addRecipe(mangroveBlock, 1, new ItemStack(Material.MANGROVE_FENCE_GATE), 2);
        stonecutter.addRecipe(mangroveBlock, 1, new ItemStack(Material.MANGROVE_SIGN), 2);

        //CHERRY LOG
        ItemStack cherryLog = new ItemStack(Material.CHERRY_LOG);
        stonecutter.addRecipe(cherryLog, 1, new ItemStack(Material.STRIPPED_CHERRY_LOG), 1);
        stonecutter.addRecipe(cherryLog, 1, new ItemStack(Material.STRIPPED_CHERRY_WOOD), 1);
        stonecutter.addRecipe(cherryLog, 1, new ItemStack(Material.CHERRY_WOOD), 1);
        stonecutter.addRecipe(cherryLog, 1, new ItemStack(Material.CHERRY_PLANKS), 4);
        stonecutter.addRecipe(cherryLog, 1, new ItemStack(Material.CHERRY_STAIRS), 4);
        stonecutter.addRecipe(cherryLog, 1, new ItemStack(Material.CHERRY_SLAB), 8);
        stonecutter.addRecipe(cherryLog, 1, new ItemStack(Material.CHERRY_FENCE), 1);
        stonecutter.addRecipe(cherryLog, 1, new ItemStack(Material.CHERRY_TRAPDOOR), 1);
        stonecutter.addRecipe(cherryLog, 1, new ItemStack(Material.CHERRY_DOOR), 2);
        stonecutter.addRecipe(cherryLog, 1, new ItemStack(Material.CHERRY_FENCE_GATE), 2);
        stonecutter.addRecipe(cherryLog, 1, new ItemStack(Material.CHERRY_SIGN), 2);
  //BAMBOO
        ItemStack bambooBlock = new ItemStack(Material.BAMBOO_BLOCK);
        ItemStack bambooPlanks = new ItemStack(Material.BAMBOO_PLANKS);
        ItemStack bambooMosaic = new ItemStack(Material.BAMBOO_MOSAIC);

        stonecutter.addRecipe(bambooBlock, 1, bambooPlanks, 2);
        stonecutter.addRecipe(bambooBlock, 1, new ItemStack(Material.STRIPPED_BAMBOO_BLOCK), 1);
        stonecutter.addRecipe(bambooPlanks, 1, new ItemStack(Material.BAMBOO_STAIRS), 1);
        stonecutter.addRecipe(bambooPlanks, 1, new ItemStack(Material.BAMBOO_SLAB), 2); // 1 Tábua = 2 Lajes
        stonecutter.addRecipe(bambooPlanks, 1, new ItemStack(Material.BAMBOO_FENCE), 1);
        stonecutter.addRecipe(bambooPlanks, 1, new ItemStack(Material.BAMBOO_FENCE_GATE), 1);
        stonecutter.addRecipe(bambooPlanks, 1, new ItemStack(Material.BAMBOO_DOOR), 1);
        stonecutter.addRecipe(bambooPlanks, 1, new ItemStack(Material.BAMBOO_TRAPDOOR), 1);
        stonecutter.addRecipe(bambooPlanks, 1, new ItemStack(Material.BAMBOO_PRESSURE_PLATE), 1);
        stonecutter.addRecipe(bambooPlanks, 1, new ItemStack(Material.BAMBOO_BUTTON), 1);
        stonecutter.addRecipe(bambooPlanks, 1, new ItemStack(Material.BAMBOO_SIGN), 1);
        stonecutter.addRecipe(bambooPlanks, 1, new ItemStack(Material.BAMBOO_HANGING_SIGN), 1);
        stonecutter.addRecipe(bambooPlanks, 1, bambooMosaic, 1);
        stonecutter.addRecipe(bambooMosaic, 1, new ItemStack(Material.BAMBOO_MOSAIC_STAIRS), 1);
        stonecutter.addRecipe(bambooMosaic, 1, new ItemStack(Material.BAMBOO_MOSAIC_SLAB), 2);

        //CRIMSOM STEM
        ItemStack crimsomStem = new ItemStack(Material.CRIMSON_STEM);

        stonecutter.addRecipe(crimsomStem, 1, new ItemStack(Material.STRIPPED_CRIMSON_HYPHAE), 1);
        stonecutter.addRecipe(crimsomStem, 1, new ItemStack(Material.STRIPPED_CRIMSON_STEM), 1);
        stonecutter.addRecipe(crimsomStem, 1, new ItemStack(Material.CRIMSON_HYPHAE), 1);
        stonecutter.addRecipe(crimsomStem, 1, new ItemStack(Material.CRIMSON_PLANKS), 4);
        stonecutter.addRecipe(crimsomStem, 1, new ItemStack(Material.CRIMSON_STAIRS), 4);
        stonecutter.addRecipe(crimsomStem, 1, new ItemStack(Material.CRIMSON_SLAB), 8);
        stonecutter.addRecipe(crimsomStem, 1, new ItemStack(Material.CRIMSON_FENCE), 1);
        stonecutter.addRecipe(crimsomStem, 1, new ItemStack(Material.CRIMSON_TRAPDOOR), 1);
        stonecutter.addRecipe(crimsomStem, 1, new ItemStack(Material.CRIMSON_DOOR), 2);
        stonecutter.addRecipe(crimsomStem, 1, new ItemStack(Material.CRIMSON_FENCE_GATE), 2);
        stonecutter.addRecipe(crimsomStem, 1, new ItemStack(Material.CRIMSON_SIGN), 2);

        //WARPED STEM
        ItemStack warpedStem = new ItemStack(Material.WARPED_STEM);
        stonecutter.addRecipe(warpedStem, 1, new ItemStack(Material.STRIPPED_WARPED_HYPHAE), 1);
        stonecutter.addRecipe(warpedStem, 1, new ItemStack(Material.STRIPPED_WARPED_STEM), 1);
        stonecutter.addRecipe(warpedStem, 1, new ItemStack(Material.WARPED_HYPHAE), 1);
        stonecutter.addRecipe(warpedStem, 1, new ItemStack(Material.WARPED_PLANKS), 4);
        stonecutter.addRecipe(warpedStem, 1, new ItemStack(Material.WARPED_STAIRS), 4);
        stonecutter.addRecipe(warpedStem, 1, new ItemStack(Material.WARPED_SLAB), 8);
        stonecutter.addRecipe(warpedStem, 1, new ItemStack(Material.WARPED_FENCE), 1);
        stonecutter.addRecipe(warpedStem, 1, new ItemStack(Material.WARPED_TRAPDOOR), 1);
        stonecutter.addRecipe(warpedStem, 1, new ItemStack(Material.WARPED_DOOR), 2);
        stonecutter.addRecipe(warpedStem, 1, new ItemStack(Material.WARPED_FENCE_GATE), 2);
        stonecutter.addRecipe(warpedStem, 1, new ItemStack(Material.WARPED_SIGN), 2);

        //COBBLESTONE
        ItemStack cobbleStone = new ItemStack(Material.COBBLESTONE);
        stonecutter.addRecipe(cobbleStone, 1, new ItemStack(Material.STONE), 1);
        stonecutter.addRecipe(cobbleStone, 1, new ItemStack(Material.SMOOTH_STONE), 1);
        stonecutter.addRecipe(cobbleStone, 1, new ItemStack(Material.MOSSY_COBBLESTONE), 1);
        stonecutter.addRecipe(cobbleStone, 1, new ItemStack(Material.MOSSY_STONE_BRICKS), 1);
        stonecutter.addRecipe(cobbleStone, 1, new ItemStack(Material.CHISELED_STONE_BRICKS), 1);
        stonecutter.addRecipe(cobbleStone, 1, new ItemStack(Material.CRACKED_STONE_BRICKS), 1);
        stonecutter.addRecipe(cobbleStone, 1, new ItemStack(Material.COBBLESTONE_STAIRS), 1);
        stonecutter.addRecipe(cobbleStone, 1, new ItemStack(Material.STONE_STAIRS), 1);
        stonecutter.addRecipe(cobbleStone, 1, new ItemStack(Material.MOSSY_COBBLESTONE_STAIRS), 1);
        stonecutter.addRecipe(cobbleStone, 1, new ItemStack(Material.STONE_BRICK_STAIRS), 1);
        stonecutter.addRecipe(cobbleStone, 1, new ItemStack(Material.MOSSY_STONE_BRICK_STAIRS), 1);
        stonecutter.addRecipe(cobbleStone, 1, new ItemStack(Material.COBBLESTONE_SLAB), 2);
        stonecutter.addRecipe(cobbleStone, 1, new ItemStack(Material.MOSSY_COBBLESTONE_SLAB), 2);
        stonecutter.addRecipe(cobbleStone, 1, new ItemStack(Material.MOSSY_STONE_BRICK_SLAB), 2);
        stonecutter.addRecipe(cobbleStone, 1, new ItemStack(Material.STONE_SLAB), 2);
        stonecutter.addRecipe(cobbleStone, 1, new ItemStack(Material.SMOOTH_STONE_SLAB), 2);
        stonecutter.addRecipe(cobbleStone, 1, new ItemStack(Material.STONE_BRICK_SLAB), 2);
        stonecutter.addRecipe(cobbleStone, 1, new ItemStack(Material.COBBLESTONE_WALL), 1);
        stonecutter.addRecipe(cobbleStone, 1, new ItemStack(Material.MOSSY_COBBLESTONE_WALL), 1);
        stonecutter.addRecipe(cobbleStone, 1, new ItemStack(Material.STONE_BRICK_WALL), 1);
        stonecutter.addRecipe(cobbleStone, 1, new ItemStack(Material.MOSSY_STONE_BRICK_WALL), 1);

        //ANDESITE
        ItemStack andesite = new ItemStack(Material.ANDESITE);
        stonecutter.addRecipe(andesite, 1, new ItemStack(Material.POLISHED_ANDESITE), 1);
        stonecutter.addRecipe(andesite, 1, new ItemStack(Material.POLISHED_ANDESITE_STAIRS), 1);
        stonecutter.addRecipe(andesite, 1, new ItemStack(Material.ANDESITE_STAIRS), 1);
        stonecutter.addRecipe(andesite, 1, new ItemStack(Material.POLISHED_ANDESITE_SLAB), 2);
        stonecutter.addRecipe(andesite, 1, new ItemStack(Material.ANDESITE_SLAB), 2);
        stonecutter.addRecipe(andesite, 1, new ItemStack(Material.ANDESITE_WALL), 1);

        //DIORITE
        ItemStack diorite = new ItemStack(Material.DIORITE);
        stonecutter.addRecipe(diorite, 1, new ItemStack(Material.POLISHED_DIORITE), 1);
        stonecutter.addRecipe(diorite, 1, new ItemStack(Material.POLISHED_DIORITE_STAIRS), 1);
        stonecutter.addRecipe(diorite, 1, new ItemStack(Material.DIORITE_STAIRS), 1);
        stonecutter.addRecipe(diorite, 1, new ItemStack(Material.POLISHED_DIORITE_SLAB), 2);
        stonecutter.addRecipe(diorite, 1, new ItemStack(Material.DIORITE_SLAB), 2);
        stonecutter.addRecipe(diorite, 1, new ItemStack(Material.DIORITE_WALL), 1);
        //ANDESITE
        ItemStack grannite = new ItemStack(Material.GRANITE);
        stonecutter.addRecipe(grannite, 1, new ItemStack(Material.POLISHED_GRANITE), 1);
        stonecutter.addRecipe(grannite, 1, new ItemStack(Material.POLISHED_GRANITE_STAIRS), 1);
        stonecutter.addRecipe(grannite, 1, new ItemStack(Material.GRANITE_STAIRS), 1);
        stonecutter.addRecipe(grannite, 1, new ItemStack(Material.POLISHED_GRANITE_SLAB), 2);
        stonecutter.addRecipe(grannite, 1, new ItemStack(Material.GRANITE_SLAB), 2);
        stonecutter.addRecipe(grannite, 1, new ItemStack(Material.GRANITE_WALL), 1);

        // --- SETUP DO DEEPSLATE (Ardósia) ---

        ItemStack deepslate = new ItemStack(Material.DEEPSLATE);

        // 1. Cobbled Deepslate (Ardósia Pedregulho)
        stonecutter.addRecipe(deepslate, 1, new ItemStack(Material.COBBLED_DEEPSLATE), 1);
        stonecutter.addRecipe(deepslate, 1, new ItemStack(Material.COBBLED_DEEPSLATE_STAIRS), 1);
        stonecutter.addRecipe(deepslate, 1, new ItemStack(Material.COBBLED_DEEPSLATE_SLAB), 2);
        stonecutter.addRecipe(deepslate, 1, new ItemStack(Material.COBBLED_DEEPSLATE_WALL), 1);

        // 2. Polished Deepslate (Ardósia Polida)
        stonecutter.addRecipe(deepslate, 1, new ItemStack(Material.POLISHED_DEEPSLATE), 1);
        stonecutter.addRecipe(deepslate, 1, new ItemStack(Material.POLISHED_DEEPSLATE_STAIRS), 1);
        stonecutter.addRecipe(deepslate, 1, new ItemStack(Material.POLISHED_DEEPSLATE_SLAB), 2);
        stonecutter.addRecipe(deepslate, 1, new ItemStack(Material.POLISHED_DEEPSLATE_WALL), 1);

        // 3. Deepslate Bricks (Tijolos de Ardósia)
        stonecutter.addRecipe(deepslate, 1, new ItemStack(Material.DEEPSLATE_BRICKS), 1);
        stonecutter.addRecipe(deepslate, 1, new ItemStack(Material.DEEPSLATE_BRICK_STAIRS), 1);
        stonecutter.addRecipe(deepslate, 1, new ItemStack(Material.DEEPSLATE_BRICK_SLAB), 2);
        stonecutter.addRecipe(deepslate, 1, new ItemStack(Material.DEEPSLATE_BRICK_WALL), 1);

        // 4. Deepslate Tiles (Azulejos de Ardósia)
        stonecutter.addRecipe(deepslate, 1, new ItemStack(Material.DEEPSLATE_TILES), 1);
        stonecutter.addRecipe(deepslate, 1, new ItemStack(Material.DEEPSLATE_TILE_STAIRS), 1);
        stonecutter.addRecipe(deepslate, 1, new ItemStack(Material.DEEPSLATE_TILE_SLAB), 2);
        stonecutter.addRecipe(deepslate, 1, new ItemStack(Material.DEEPSLATE_TILE_WALL), 1);

        // 5. Chiseled (Talhado)
        stonecutter.addRecipe(deepslate, 1, new ItemStack(Material.CHISELED_DEEPSLATE), 1);
        stonecutter.addRecipe(deepslate, 1, new ItemStack(Material.TUFF), 1);

        //BRICKS
        ItemStack brick = new ItemStack(Material.BRICK);
        ItemStack bricks = new ItemStack(Material.BRICKS);


        stonecutter.addRecipe(brick, 4, new ItemStack(Material.BRICKS), 1);
        stonecutter.addRecipe(bricks, 1, new ItemStack(Material.BRICK_STAIRS), 1);
        stonecutter.addRecipe(bricks, 1, new ItemStack(Material.BRICK_SLAB), 2);
        stonecutter.addRecipe(bricks, 1, new ItemStack(Material.BRICK_WALL), 1);

        // --- SETUP DE SAND (Areia) ---
        // Custo: 4 Areias = 1 Bloco de Arenito (qualquer variação)

        ItemStack sand = new ItemStack(Material.SAND);

        // 1. Sandstone (Arenito Padrão)
        stonecutter.addRecipe(sand, 4, new ItemStack(Material.SANDSTONE), 1);
        stonecutter.addRecipe(sand, 4, new ItemStack(Material.SANDSTONE_STAIRS), 1);
        stonecutter.addRecipe(sand, 4, new ItemStack(Material.SANDSTONE_SLAB), 2);
        stonecutter.addRecipe(sand, 4, new ItemStack(Material.SANDSTONE_WALL), 1);

        // 2. Cut Sandstone (Arenito Cortado)
        stonecutter.addRecipe(sand, 4, new ItemStack(Material.CUT_SANDSTONE), 1);
        stonecutter.addRecipe(sand, 4, new ItemStack(Material.CUT_SANDSTONE_SLAB), 2);

        // 3. Smooth Sandstone (Arenito Liso - que normalmente exige fornalha)
        stonecutter.addRecipe(sand, 4, new ItemStack(Material.SMOOTH_SANDSTONE), 1);
        stonecutter.addRecipe(sand, 4, new ItemStack(Material.SMOOTH_SANDSTONE_STAIRS), 1);
        stonecutter.addRecipe(sand, 4, new ItemStack(Material.SMOOTH_SANDSTONE_SLAB), 2);

        // 4. Chiseled (Talhado)
        stonecutter.addRecipe(sand, 4, new ItemStack(Material.CHISELED_SANDSTONE), 1);


        // --- SETUP DE RED SAND (Areia Vermelha) ---
        // Custo: 4 Areias Vermelhas = 1 Bloco de Arenito Vermelho

        ItemStack redSand = new ItemStack(Material.RED_SAND);

        // 1. Red Sandstone (Arenito Vermelho Padrão)
        stonecutter.addRecipe(redSand, 4, new ItemStack(Material.RED_SANDSTONE), 1);
        stonecutter.addRecipe(redSand, 4, new ItemStack(Material.RED_SANDSTONE_STAIRS), 1);
        stonecutter.addRecipe(redSand, 4, new ItemStack(Material.RED_SANDSTONE_SLAB), 2);
        stonecutter.addRecipe(redSand, 4, new ItemStack(Material.RED_SANDSTONE_WALL), 1);

        // 2. Cut Red Sandstone (Arenito Vermelho Cortado)
        stonecutter.addRecipe(redSand, 4, new ItemStack(Material.CUT_RED_SANDSTONE), 1);
        stonecutter.addRecipe(redSand, 4, new ItemStack(Material.CUT_RED_SANDSTONE_SLAB), 2);

        // 3. Smooth Red Sandstone (Arenito Vermelho Liso)
        stonecutter.addRecipe(redSand, 4, new ItemStack(Material.SMOOTH_RED_SANDSTONE), 1);
        stonecutter.addRecipe(redSand, 4, new ItemStack(Material.SMOOTH_RED_SANDSTONE_STAIRS), 1);
        stonecutter.addRecipe(redSand, 4, new ItemStack(Material.SMOOTH_RED_SANDSTONE_SLAB), 2);

        // 4. Chiseled Red (Talhado Vermelho)
        stonecutter.addRecipe(redSand, 4, new ItemStack(Material.CHISELED_RED_SANDSTONE), 1);
        // --- SETUP DO PRISMARINE (Oceano) ---
        // Regra: 4 Shards = 1 Bloco de qualquer variação (Prismarine, Bricks, Dark)
        // Isso é um buff industrial, já que Dark Prismarine normalmente precisaria de tinta.

        ItemStack shard = new ItemStack(Material.PRISMARINE_SHARD);
        ItemStack crystals = new ItemStack(Material.PRISMARINE_CRYSTALS);

        // 1. Prismarine Padrão
        stonecutter.addRecipe(shard, 4, new ItemStack(Material.PRISMARINE), 1);
        stonecutter.addRecipe(shard, 4, new ItemStack(Material.PRISMARINE_STAIRS), 1);
        stonecutter.addRecipe(shard, 4, new ItemStack(Material.PRISMARINE_SLAB), 2);
        stonecutter.addRecipe(shard, 4, new ItemStack(Material.PRISMARINE_WALL), 1);

        // 2. Prismarine Bricks (Tijolos)
        stonecutter.addRecipe(shard, 4, new ItemStack(Material.PRISMARINE_BRICKS), 1);
        stonecutter.addRecipe(shard, 4, new ItemStack(Material.PRISMARINE_BRICK_STAIRS), 1);
        stonecutter.addRecipe(shard, 4, new ItemStack(Material.PRISMARINE_BRICK_SLAB), 2);


        stonecutter.addRecipe(shard, 4, new ItemStack(Material.DARK_PRISMARINE), 1);
        stonecutter.addRecipe(shard, 4, new ItemStack(Material.DARK_PRISMARINE_STAIRS), 1);
        stonecutter.addRecipe(shard, 4, new ItemStack(Material.DARK_PRISMARINE_SLAB), 2);


        stonecutter.addRecipe(crystals, 4, new ItemStack(Material.SEA_LANTERN), 1);


        ItemStack netherrack = new ItemStack(Material.NETHERRACK);
        stonecutter.addRecipe(netherrack, 1, new ItemStack(Material.NETHER_BRICK), 1);
        stonecutter.addRecipe(netherrack, 4, new ItemStack(Material.NETHER_BRICKS), 1);
        stonecutter.addRecipe(netherrack, 4, new ItemStack(Material.NETHER_BRICK_STAIRS), 1);
        stonecutter.addRecipe(netherrack, 4, new ItemStack(Material.NETHER_BRICK_SLAB), 2); // 1 Bloco rende 2 Lajes
        stonecutter.addRecipe(netherrack, 4, new ItemStack(Material.NETHER_BRICK_WALL), 1);
        stonecutter.addRecipe(netherrack, 4, new ItemStack(Material.NETHER_BRICK_FENCE), 1);
        stonecutter.addRecipe(netherrack, 4, new ItemStack(Material.CHISELED_NETHER_BRICKS), 1);
        stonecutter.addRecipe(netherrack, 4, new ItemStack(Material.CRACKED_NETHER_BRICKS), 1);

        stonecutter.addRecipe(netherrack, 4, new ItemStack(Material.RED_NETHER_BRICKS), 1);
        stonecutter.addRecipe(netherrack, 4, new ItemStack(Material.RED_NETHER_BRICK_STAIRS), 1);
        stonecutter.addRecipe(netherrack, 4, new ItemStack(Material.RED_NETHER_BRICK_SLAB), 2);
        stonecutter.addRecipe(netherrack, 4, new ItemStack(Material.RED_NETHER_BRICK_WALL), 1);

        ItemStack basalt = new ItemStack(Material.BASALT);

        stonecutter.addRecipe(basalt, 1, new ItemStack(Material.POLISHED_BASALT), 1);
        stonecutter.addRecipe(basalt, 1, new ItemStack(Material.SMOOTH_BASALT), 1);
        ItemStack blackstone = new ItemStack(Material.BLACKSTONE);
        stonecutter.addRecipe(blackstone, 1, new ItemStack(Material.BLACKSTONE_STAIRS), 1);
        stonecutter.addRecipe(blackstone, 1, new ItemStack(Material.BLACKSTONE_SLAB), 2);
        stonecutter.addRecipe(blackstone, 1, new ItemStack(Material.BLACKSTONE_WALL), 1);

        // 2. Polished Blackstone (Pedra Negra Polida)
        stonecutter.addRecipe(blackstone, 1, new ItemStack(Material.POLISHED_BLACKSTONE), 1);
        stonecutter.addRecipe(blackstone, 1, new ItemStack(Material.POLISHED_BLACKSTONE_STAIRS), 1);
        stonecutter.addRecipe(blackstone, 1, new ItemStack(Material.POLISHED_BLACKSTONE_SLAB), 2);
        stonecutter.addRecipe(blackstone, 1, new ItemStack(Material.POLISHED_BLACKSTONE_WALL), 1);
        stonecutter.addRecipe(blackstone, 1, new ItemStack(Material.POLISHED_BLACKSTONE_BUTTON), 1);
        stonecutter.addRecipe(blackstone, 1, new ItemStack(Material.POLISHED_BLACKSTONE_PRESSURE_PLATE), 1);

        stonecutter.addRecipe(blackstone, 1, new ItemStack(Material.POLISHED_BLACKSTONE_BRICKS), 1);
        stonecutter.addRecipe(blackstone, 1, new ItemStack(Material.POLISHED_BLACKSTONE_BRICK_STAIRS), 1);
        stonecutter.addRecipe(blackstone, 1, new ItemStack(Material.POLISHED_BLACKSTONE_BRICK_SLAB), 2);
        stonecutter.addRecipe(blackstone, 1, new ItemStack(Material.POLISHED_BLACKSTONE_BRICK_WALL), 1);
        stonecutter.addRecipe(blackstone, 1, new ItemStack(Material.CHISELED_POLISHED_BLACKSTONE), 1);
        stonecutter.addRecipe(blackstone, 1, new ItemStack(Material.CRACKED_POLISHED_BLACKSTONE_BRICKS), 1);
// --- SETUP DO END (O Fim) ---

        // 1. End Stone Bricks (Tijolos de Pedra do Fim)

        ItemStack endStone = new ItemStack(Material.END_STONE);

        stonecutter.addRecipe(endStone, 1, new ItemStack(Material.END_STONE_BRICKS), 1);
        stonecutter.addRecipe(endStone, 1, new ItemStack(Material.END_STONE_BRICK_STAIRS), 1);
        stonecutter.addRecipe(endStone, 1, new ItemStack(Material.END_STONE_BRICK_SLAB), 2);
        stonecutter.addRecipe(endStone, 1, new ItemStack(Material.END_STONE_BRICK_WALL), 1);


        // 2. Purpur Blocks (Blocos de Púrpura)
        // Input: Fruta do Coro Queimada (Popped Chorus Fruit)
        // Vanilla: 4 Frutas = 4 Blocos. Aqui mantemos 1 Fruta = 1 Bloco para ser prático.
        ItemStack poppedChorus = new ItemStack(Material.POPPED_CHORUS_FRUIT);

        stonecutter.addRecipe(poppedChorus, 1, new ItemStack(Material.PURPUR_BLOCK), 1);
        stonecutter.addRecipe(poppedChorus, 1, new ItemStack(Material.PURPUR_PILLAR), 1);
        stonecutter.addRecipe(poppedChorus, 1, new ItemStack(Material.PURPUR_STAIRS), 1);
        stonecutter.addRecipe(poppedChorus, 1, new ItemStack(Material.PURPUR_SLAB), 2);
        // --- SETUP DO COPPER (Cobre) ---
        // Input: Barra de Cobre (Copper Ingot)
        // Regra Industrial: 4 Ingots = 1 Bloco (Economia de mais de 50% comparado ao craft manual de 9)
        // Bônus: Escolha o nível de oxidação NA HORA (Normal, Exposto, Intemperizado, Oxidado)

        ItemStack copperIngot = new ItemStack(Material.COPPER_INGOT);

        // --- ESTÁGIO 1: NORMAL (Laranja) ---
        stonecutter.addRecipe(copperIngot, 4, new ItemStack(Material.COPPER_BLOCK), 1);
        stonecutter.addRecipe(copperIngot, 4, new ItemStack(Material.CUT_COPPER), 1);
        stonecutter.addRecipe(copperIngot, 4, new ItemStack(Material.CUT_COPPER_STAIRS), 1);
        stonecutter.addRecipe(copperIngot, 4, new ItemStack(Material.CUT_COPPER_SLAB), 2);

        // --- ESTÁGIO 2: EXPOSED (Exposto) ---
        stonecutter.addRecipe(copperIngot, 4, new ItemStack(Material.EXPOSED_COPPER), 1);
        stonecutter.addRecipe(copperIngot, 4, new ItemStack(Material.EXPOSED_CUT_COPPER), 1);
        stonecutter.addRecipe(copperIngot, 4, new ItemStack(Material.EXPOSED_CUT_COPPER_STAIRS), 1);
        stonecutter.addRecipe(copperIngot, 4, new ItemStack(Material.EXPOSED_CUT_COPPER_SLAB), 2);

        // --- ESTÁGIO 3: WEATHERED (Intemperizado) ---
        stonecutter.addRecipe(copperIngot, 4, new ItemStack(Material.WEATHERED_COPPER), 1);
        stonecutter.addRecipe(copperIngot, 4, new ItemStack(Material.WEATHERED_CUT_COPPER), 1);
        stonecutter.addRecipe(copperIngot, 4, new ItemStack(Material.WEATHERED_CUT_COPPER_STAIRS), 1);
        stonecutter.addRecipe(copperIngot, 4, new ItemStack(Material.WEATHERED_CUT_COPPER_SLAB), 2);

        stonecutter.addRecipe(copperIngot, 4, new ItemStack(Material.OXIDIZED_COPPER), 1);
        stonecutter.addRecipe(copperIngot, 4, new ItemStack(Material.OXIDIZED_CUT_COPPER), 1);
        stonecutter.addRecipe(copperIngot, 4, new ItemStack(Material.OXIDIZED_CUT_COPPER_STAIRS), 1);
        stonecutter.addRecipe(copperIngot, 4, new ItemStack(Material.OXIDIZED_CUT_COPPER_SLAB), 2);


    }




    private static WardenQuarry addBasicLoot(WardenQuarry q, int amt) {
        return q.addGuaranteedDrop(new ItemStack(Material.COAL, amt))
                .addGuaranteedDrop(new ItemStack(Material.COPPER_INGOT, amt))
                .addGuaranteedDrop(new ItemStack(Material.IRON_INGOT, amt))
                .addGuaranteedDrop(new ItemStack(Material.QUARTZ, amt))
                .addGuaranteedDrop(new ItemStack(Material.GOLD_INGOT, amt))
                .addGuaranteedDrop(new ItemStack(Material.LAPIS_LAZULI, amt))
                .addGuaranteedDrop(new ItemStack(Material.EMERALD, amt))
                .addGuaranteedDrop(new ItemStack(Material.DIAMOND, amt));
    }
}