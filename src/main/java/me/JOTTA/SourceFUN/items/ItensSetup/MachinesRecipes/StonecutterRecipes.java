package me.JOTTA.SourceFUN.items.ItensSetup.MachinesRecipes;

import me.JOTTA.SourceFUN.items.machines.IndustrialMachine;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;


public class StonecutterRecipes {


    public static void registerAll(IndustrialMachine stonecutter) {

        // --- QUARTZ ---
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

        // --- SPRUCE LOG ---
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

        // --- OAK LOG ---
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

        // --- BIRCH LOG ---
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

        // --- JUNGLE LOG ---
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

        // --- ACACIA LOG ---
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

        // --- DARK OAK LOG ---
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

        // --- MANGROVE LOG ---
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

        // --- CHERRY LOG ---
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

        // --- BAMBOO ---
        ItemStack bambooBlock = new ItemStack(Material.BAMBOO_BLOCK);
        ItemStack bambooPlanks = new ItemStack(Material.BAMBOO_PLANKS);
        ItemStack bambooMosaic = new ItemStack(Material.BAMBOO_MOSAIC);

        stonecutter.addRecipe(bambooBlock, 1, bambooPlanks, 2);
        stonecutter.addRecipe(bambooBlock, 1, new ItemStack(Material.STRIPPED_BAMBOO_BLOCK), 1);
        stonecutter.addRecipe(bambooPlanks, 1, new ItemStack(Material.BAMBOO_STAIRS), 1);
        stonecutter.addRecipe(bambooPlanks, 1, new ItemStack(Material.BAMBOO_SLAB), 2);
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

        // --- CRIMSON STEM ---
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

        // --- WARPED STEM ---
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

        // --- COBBLESTONE ---
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

        // --- ANDESITE ---
        ItemStack andesite = new ItemStack(Material.ANDESITE);
        stonecutter.addRecipe(andesite, 1, new ItemStack(Material.POLISHED_ANDESITE), 1);
        stonecutter.addRecipe(andesite, 1, new ItemStack(Material.POLISHED_ANDESITE_STAIRS), 1);
        stonecutter.addRecipe(andesite, 1, new ItemStack(Material.ANDESITE_STAIRS), 1);
        stonecutter.addRecipe(andesite, 1, new ItemStack(Material.POLISHED_ANDESITE_SLAB), 2);
        stonecutter.addRecipe(andesite, 1, new ItemStack(Material.ANDESITE_SLAB), 2);
        stonecutter.addRecipe(andesite, 1, new ItemStack(Material.ANDESITE_WALL), 1);

        // --- DIORITE ---
        ItemStack diorite = new ItemStack(Material.DIORITE);
        stonecutter.addRecipe(diorite, 1, new ItemStack(Material.POLISHED_DIORITE), 1);
        stonecutter.addRecipe(diorite, 1, new ItemStack(Material.POLISHED_DIORITE_STAIRS), 1);
        stonecutter.addRecipe(diorite, 1, new ItemStack(Material.DIORITE_STAIRS), 1);
        stonecutter.addRecipe(diorite, 1, new ItemStack(Material.POLISHED_DIORITE_SLAB), 2);
        stonecutter.addRecipe(diorite, 1, new ItemStack(Material.DIORITE_SLAB), 2);
        stonecutter.addRecipe(diorite, 1, new ItemStack(Material.DIORITE_WALL), 1);

        // --- GRANITE ---
        ItemStack grannite = new ItemStack(Material.GRANITE);
        stonecutter.addRecipe(grannite, 1, new ItemStack(Material.POLISHED_GRANITE), 1);
        stonecutter.addRecipe(grannite, 1, new ItemStack(Material.POLISHED_GRANITE_STAIRS), 1);
        stonecutter.addRecipe(grannite, 1, new ItemStack(Material.GRANITE_STAIRS), 1);
        stonecutter.addRecipe(grannite, 1, new ItemStack(Material.POLISHED_GRANITE_SLAB), 2);
        stonecutter.addRecipe(grannite, 1, new ItemStack(Material.GRANITE_SLAB), 2);
        stonecutter.addRecipe(grannite, 1, new ItemStack(Material.GRANITE_WALL), 1);

        // --- DEEPSLATE ---
        ItemStack deepslate = new ItemStack(Material.DEEPSLATE);
        stonecutter.addRecipe(deepslate, 1, new ItemStack(Material.COBBLED_DEEPSLATE), 1);
        stonecutter.addRecipe(deepslate, 1, new ItemStack(Material.COBBLED_DEEPSLATE_STAIRS), 1);
        stonecutter.addRecipe(deepslate, 1, new ItemStack(Material.COBBLED_DEEPSLATE_SLAB), 2);
        stonecutter.addRecipe(deepslate, 1, new ItemStack(Material.COBBLED_DEEPSLATE_WALL), 1);
        stonecutter.addRecipe(deepslate, 1, new ItemStack(Material.POLISHED_DEEPSLATE), 1);
        stonecutter.addRecipe(deepslate, 1, new ItemStack(Material.POLISHED_DEEPSLATE_STAIRS), 1);
        stonecutter.addRecipe(deepslate, 1, new ItemStack(Material.POLISHED_DEEPSLATE_SLAB), 2);
        stonecutter.addRecipe(deepslate, 1, new ItemStack(Material.POLISHED_DEEPSLATE_WALL), 1);
        stonecutter.addRecipe(deepslate, 1, new ItemStack(Material.DEEPSLATE_BRICKS), 1);
        stonecutter.addRecipe(deepslate, 1, new ItemStack(Material.DEEPSLATE_BRICK_STAIRS), 1);
        stonecutter.addRecipe(deepslate, 1, new ItemStack(Material.DEEPSLATE_BRICK_SLAB), 2);
        stonecutter.addRecipe(deepslate, 1, new ItemStack(Material.DEEPSLATE_BRICK_WALL), 1);
        stonecutter.addRecipe(deepslate, 1, new ItemStack(Material.DEEPSLATE_TILES), 1);
        stonecutter.addRecipe(deepslate, 1, new ItemStack(Material.DEEPSLATE_TILE_STAIRS), 1);
        stonecutter.addRecipe(deepslate, 1, new ItemStack(Material.DEEPSLATE_TILE_SLAB), 2);
        stonecutter.addRecipe(deepslate, 1, new ItemStack(Material.DEEPSLATE_TILE_WALL), 1);
        stonecutter.addRecipe(deepslate, 1, new ItemStack(Material.CHISELED_DEEPSLATE), 1);
        stonecutter.addRecipe(deepslate, 1, new ItemStack(Material.TUFF), 1);

        // --- BRICKS ---
        ItemStack brick = new ItemStack(Material.BRICK);
        ItemStack bricks = new ItemStack(Material.BRICKS);
        stonecutter.addRecipe(brick, 4, new ItemStack(Material.BRICKS), 1);
        stonecutter.addRecipe(bricks, 1, new ItemStack(Material.BRICK_STAIRS), 1);
        stonecutter.addRecipe(bricks, 1, new ItemStack(Material.BRICK_SLAB), 2);
        stonecutter.addRecipe(bricks, 1, new ItemStack(Material.BRICK_WALL), 1);

        // --- SAND ---
        ItemStack sand = new ItemStack(Material.SAND);
        stonecutter.addRecipe(sand, 4, new ItemStack(Material.SANDSTONE), 1);
        stonecutter.addRecipe(sand, 4, new ItemStack(Material.SANDSTONE_STAIRS), 1);
        stonecutter.addRecipe(sand, 4, new ItemStack(Material.SANDSTONE_SLAB), 2);
        stonecutter.addRecipe(sand, 4, new ItemStack(Material.SANDSTONE_WALL), 1);
        stonecutter.addRecipe(sand, 4, new ItemStack(Material.CUT_SANDSTONE), 1);
        stonecutter.addRecipe(sand, 4, new ItemStack(Material.CUT_SANDSTONE_SLAB), 2);
        stonecutter.addRecipe(sand, 4, new ItemStack(Material.SMOOTH_SANDSTONE), 1);
        stonecutter.addRecipe(sand, 4, new ItemStack(Material.SMOOTH_SANDSTONE_STAIRS), 1);
        stonecutter.addRecipe(sand, 4, new ItemStack(Material.SMOOTH_SANDSTONE_SLAB), 2);
        stonecutter.addRecipe(sand, 4, new ItemStack(Material.CHISELED_SANDSTONE), 1);

        // --- RED SAND ---
        ItemStack redSand = new ItemStack(Material.RED_SAND);
        stonecutter.addRecipe(redSand, 4, new ItemStack(Material.RED_SANDSTONE), 1);
        stonecutter.addRecipe(redSand, 4, new ItemStack(Material.RED_SANDSTONE_STAIRS), 1);
        stonecutter.addRecipe(redSand, 4, new ItemStack(Material.RED_SANDSTONE_SLAB), 2);
        stonecutter.addRecipe(redSand, 4, new ItemStack(Material.RED_SANDSTONE_WALL), 1);
        stonecutter.addRecipe(redSand, 4, new ItemStack(Material.CUT_RED_SANDSTONE), 1);
        stonecutter.addRecipe(redSand, 4, new ItemStack(Material.CUT_RED_SANDSTONE_SLAB), 2);
        stonecutter.addRecipe(redSand, 4, new ItemStack(Material.SMOOTH_RED_SANDSTONE), 1);
        stonecutter.addRecipe(redSand, 4, new ItemStack(Material.SMOOTH_RED_SANDSTONE_STAIRS), 1);
        stonecutter.addRecipe(redSand, 4, new ItemStack(Material.SMOOTH_RED_SANDSTONE_SLAB), 2);
        stonecutter.addRecipe(redSand, 4, new ItemStack(Material.CHISELED_RED_SANDSTONE), 1);

        // --- PRISMARINE ---
        ItemStack shard = new ItemStack(Material.PRISMARINE_SHARD);
        ItemStack crystals = new ItemStack(Material.PRISMARINE_CRYSTALS);
        stonecutter.addRecipe(shard, 4, new ItemStack(Material.PRISMARINE), 1);
        stonecutter.addRecipe(shard, 4, new ItemStack(Material.PRISMARINE_STAIRS), 1);
        stonecutter.addRecipe(shard, 4, new ItemStack(Material.PRISMARINE_SLAB), 2);
        stonecutter.addRecipe(shard, 4, new ItemStack(Material.PRISMARINE_WALL), 1);
        stonecutter.addRecipe(shard, 4, new ItemStack(Material.PRISMARINE_BRICKS), 1);
        stonecutter.addRecipe(shard, 4, new ItemStack(Material.PRISMARINE_BRICK_STAIRS), 1);
        stonecutter.addRecipe(shard, 4, new ItemStack(Material.PRISMARINE_BRICK_SLAB), 2);
        stonecutter.addRecipe(shard, 4, new ItemStack(Material.DARK_PRISMARINE), 1);
        stonecutter.addRecipe(shard, 4, new ItemStack(Material.DARK_PRISMARINE_STAIRS), 1);
        stonecutter.addRecipe(shard, 4, new ItemStack(Material.DARK_PRISMARINE_SLAB), 2);
        stonecutter.addRecipe(crystals, 4, new ItemStack(Material.SEA_LANTERN), 1);

        // --- NETHERRACK ---
        ItemStack netherrack = new ItemStack(Material.NETHERRACK);
        stonecutter.addRecipe(netherrack, 1, new ItemStack(Material.NETHER_BRICK), 1);
        stonecutter.addRecipe(netherrack, 4, new ItemStack(Material.NETHER_BRICKS), 1);
        stonecutter.addRecipe(netherrack, 4, new ItemStack(Material.NETHER_BRICK_STAIRS), 1);
        stonecutter.addRecipe(netherrack, 4, new ItemStack(Material.NETHER_BRICK_SLAB), 2);
        stonecutter.addRecipe(netherrack, 4, new ItemStack(Material.NETHER_BRICK_WALL), 1);
        stonecutter.addRecipe(netherrack, 4, new ItemStack(Material.NETHER_BRICK_FENCE), 1);
        stonecutter.addRecipe(netherrack, 4, new ItemStack(Material.CHISELED_NETHER_BRICKS), 1);
        stonecutter.addRecipe(netherrack, 4, new ItemStack(Material.CRACKED_NETHER_BRICKS), 1);
        stonecutter.addRecipe(netherrack, 4, new ItemStack(Material.RED_NETHER_BRICKS), 1);
        stonecutter.addRecipe(netherrack, 4, new ItemStack(Material.RED_NETHER_BRICK_STAIRS), 1);
        stonecutter.addRecipe(netherrack, 4, new ItemStack(Material.RED_NETHER_BRICK_SLAB), 2);
        stonecutter.addRecipe(netherrack, 4, new ItemStack(Material.RED_NETHER_BRICK_WALL), 1);

        // --- BASALT ---
        ItemStack basalt = new ItemStack(Material.BASALT);
        stonecutter.addRecipe(basalt, 1, new ItemStack(Material.POLISHED_BASALT), 1);
        stonecutter.addRecipe(basalt, 1, new ItemStack(Material.SMOOTH_BASALT), 1);

        // --- BLACKSTONE ---
        ItemStack blackstone = new ItemStack(Material.BLACKSTONE);
        stonecutter.addRecipe(blackstone, 1, new ItemStack(Material.BLACKSTONE_STAIRS), 1);
        stonecutter.addRecipe(blackstone, 1, new ItemStack(Material.BLACKSTONE_SLAB), 2);
        stonecutter.addRecipe(blackstone, 1, new ItemStack(Material.BLACKSTONE_WALL), 1);
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

        // --- END STONE ---
        ItemStack endStone = new ItemStack(Material.END_STONE);
        stonecutter.addRecipe(endStone, 1, new ItemStack(Material.END_STONE_BRICKS), 1);
        stonecutter.addRecipe(endStone, 1, new ItemStack(Material.END_STONE_BRICK_STAIRS), 1);
        stonecutter.addRecipe(endStone, 1, new ItemStack(Material.END_STONE_BRICK_SLAB), 2);
        stonecutter.addRecipe(endStone, 1, new ItemStack(Material.END_STONE_BRICK_WALL), 1);

        // --- PURPUR ---
        ItemStack poppedChorus = new ItemStack(Material.POPPED_CHORUS_FRUIT);
        stonecutter.addRecipe(poppedChorus, 1, new ItemStack(Material.PURPUR_BLOCK), 1);
        stonecutter.addRecipe(poppedChorus, 1, new ItemStack(Material.PURPUR_PILLAR), 1);
        stonecutter.addRecipe(poppedChorus, 1, new ItemStack(Material.PURPUR_STAIRS), 1);
        stonecutter.addRecipe(poppedChorus, 1, new ItemStack(Material.PURPUR_SLAB), 2);

        // --- COPPER ---
        ItemStack copperIngot = new ItemStack(Material.COPPER_INGOT);
        // Estágio 1: Normal
        stonecutter.addRecipe(copperIngot, 9, new ItemStack(Material.COPPER_BLOCK), 1);
        stonecutter.addRecipe(copperIngot, 9, new ItemStack(Material.CUT_COPPER), 1);
        stonecutter.addRecipe(copperIngot, 9, new ItemStack(Material.CUT_COPPER_STAIRS), 1);
        stonecutter.addRecipe(copperIngot, 9, new ItemStack(Material.CUT_COPPER_SLAB), 2);
        // Estágio 2: Exposed
        stonecutter.addRecipe(copperIngot, 9, new ItemStack(Material.EXPOSED_COPPER), 1);
        stonecutter.addRecipe(copperIngot, 9, new ItemStack(Material.EXPOSED_CUT_COPPER), 1);
        stonecutter.addRecipe(copperIngot, 9, new ItemStack(Material.EXPOSED_CUT_COPPER_STAIRS), 1);
        stonecutter.addRecipe(copperIngot, 9, new ItemStack(Material.EXPOSED_CUT_COPPER_SLAB), 2);
        // Estágio 3: Weathered
        stonecutter.addRecipe(copperIngot, 9, new ItemStack(Material.WEATHERED_COPPER), 1);
        stonecutter.addRecipe(copperIngot, 9, new ItemStack(Material.WEATHERED_CUT_COPPER), 1);
        stonecutter.addRecipe(copperIngot, 9, new ItemStack(Material.WEATHERED_CUT_COPPER_STAIRS), 1);
        stonecutter.addRecipe(copperIngot, 9, new ItemStack(Material.WEATHERED_CUT_COPPER_SLAB), 2);
        // Estágio 4: Oxidized
        stonecutter.addRecipe(copperIngot, 9, new ItemStack(Material.OXIDIZED_COPPER), 1);
        stonecutter.addRecipe(copperIngot, 9, new ItemStack(Material.OXIDIZED_CUT_COPPER), 1);
        stonecutter.addRecipe(copperIngot, 9, new ItemStack(Material.OXIDIZED_CUT_COPPER_STAIRS), 1);
        stonecutter.addRecipe(copperIngot, 9, new ItemStack(Material.OXIDIZED_CUT_COPPER_SLAB), 2);
    }
}