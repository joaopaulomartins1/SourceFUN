package me.JOTTA.SourceFUN.items.ItensSetup;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import me.JOTTA.SourceFUN.SourceFUN;
import me.JOTTA.SourceFUN.items.SMG.SimpleMaterialClass;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import static me.JOTTA.SourceFUN.items.groups.SourceFUNItemGroups.SMG;

public class SMGsetup {

    public static void setup(SourceFUN plugin) {

        // ==========================================
        // 1. GERADORES QUEBRADOS (BASES)
        // ==========================================
        SlimefunItemStack brokenCobbleItem = new SlimefunItemStack("SOURCE_BROKEN_COBBLESTONE_GENERATOR", Material.GRAVEL, "&8&lGerador de Pedregulho &c(Quebrado)", "", "&c&oGerador quebrado", "&7Este dispositivo parece estar", "&7completamente inutilizável.", "&7As engrenagens estão enferrujadas.", "", "&4⚠ Não produz nada.");
        new SlimefunItem(SMG, brokenCobbleItem, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.SMOOTH_STONE), new ItemStack(Material.SMOOTH_STONE), new ItemStack(Material.SMOOTH_STONE),
                new ItemStack(Material.LAVA_BUCKET), new ItemStack(Material.IRON_PICKAXE), new ItemStack(Material.WATER_BUCKET),
                new ItemStack(Material.SMOOTH_STONE), new ItemStack(Material.SMOOTH_STONE), new ItemStack(Material.SMOOTH_STONE)
        }).register(plugin);

        SlimefunItemStack brokenSandItem = new SlimefunItemStack("SOURCE_BROKEN_SAND_GENERATOR", Material.SAND, "&8&lGerador de Areia &c(Quebrado)", "", "&c&oGerador quebrado", "&7Este dispositivo parece estar", "&7completamente inutilizável.", "&7As engrenagens estão enferrujadas.", "", "&4⚠ Não produz nada.");
        new SlimefunItem(SMG, brokenSandItem, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.IRON_PICKAXE), new ItemStack(Material.COBBLESTONE), new ItemStack(Material.IRON_PICKAXE),
                new ItemStack(Material.COBBLESTONE), new ItemStack(Material.SANDSTONE), new ItemStack(Material.COBBLESTONE),
                new ItemStack(Material.IRON_PICKAXE), new ItemStack(Material.COBBLESTONE), new ItemStack(Material.IRON_PICKAXE)
        }).register(plugin);

        // ==========================================
        // 2. GERADORES BÁSICOS (NÍVEL 1)
        // ==========================================
        SlimefunItemStack cobbleItem = new SlimefunItemStack("SOURCE_COBBLESTONE_GENERATOR", Material.COBBLESTONE, "&7&lGerador de Pedregulhos", "", "&fGera pedregulhos automaticamente", "", "&b⚡ Velocidade: &fNormal (1s)", "&6⚡ Produção: &f1 Pedregulho");
        new SimpleMaterialClass(SMG, cobbleItem, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.SMOOTH_STONE), sfItem("SOURCE_BROKEN_COBBLESTONE_GENERATOR"), new ItemStack(Material.WATER_BUCKET),
                sfItem("SOURCE_BROKEN_COBBLESTONE_GENERATOR"), new ItemStack(Material.IRON_PICKAXE), sfItem("SOURCE_BROKEN_COBBLESTONE_GENERATOR"),
                new ItemStack(Material.LAVA_BUCKET), sfItem("SOURCE_BROKEN_COBBLESTONE_GENERATOR"), new ItemStack(Material.SMOOTH_STONE)
        }, 2, new ItemStack(Material.COBBLESTONE)).register(plugin);

        SlimefunItemStack stoneItem = new SlimefunItemStack("SOURCE_STONE_GENERATOR", Material.STONE, "&7&lGerador de Pedras", "", "&fGera Pedras automaticamente", "", "&b⚡ Velocidade: &fNormal (2s)", "&6⚡ Produção: &f1 Pedra");
        new SimpleMaterialClass(SMG, stoneItem, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                sfItem("SILVER_INGOT"), sfItem("SOURCE_COBBLESTONE_GENERATOR"), sfItem("SILVER_INGOT"),
                new ItemStack(Material.LAVA_BUCKET), new ItemStack(Material.STONE), new ItemStack(Material.LAVA_BUCKET),
                sfItem("SILVER_INGOT"), sfItem("SOURCE_COBBLESTONE_GENERATOR"), sfItem("SILVER_INGOT")
        }, 4, new ItemStack(Material.STONE)).register(plugin);

        SlimefunItemStack gravelItem = new SlimefunItemStack("SOURCE_GRAVEL_GENERATOR", Material.GRAVEL, "&7&lGerador de Cascalho", "", "&fGera Cascalhos automaticamente", "", "&b⚡ Velocidade: &fNormal (3s)", "&6⚡ Produção: &f1 Cascalho");
        new SimpleMaterialClass(SMG, gravelItem, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.GRAVEL), new ItemStack(Material.IRON_PICKAXE), new ItemStack(Material.GRAVEL),
                sfItem("BRONZE_INGOT"), sfItem("SOURCE_COBBLESTONE_GENERATOR"), sfItem("BILLON_INGOT"),
                new ItemStack(Material.GRAVEL), new ItemStack(Material.IRON_PICKAXE), new ItemStack(Material.GRAVEL)
        }, 6, new ItemStack(Material.GRAVEL)).register(plugin);

        SlimefunItemStack sandItem = new SlimefunItemStack("SOURCE_SAND_GENERATOR", Material.SANDSTONE, "&7&lGerador de Areia", "", "&fGera Areias automaticamente", "", "&b⚡ Velocidade: &fNormal (2s)", "&6⚡ Produção: &f1 Areia");
        new SimpleMaterialClass(SMG, sandItem, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                sfItem("SOURCE_COBBLESTONE_GENERATOR"), sfItem("SOURCE_BROKEN_SAND_GENERATOR"), new ItemStack(Material.SAND),
                sfItem("SOURCE_BROKEN_SAND_GENERATOR"), sfItem("SOURCE_GRAVEL_GENERATOR"), sfItem("SOURCE_BROKEN_SAND_GENERATOR"),
                new ItemStack(Material.SAND), sfItem("SOURCE_BROKEN_SAND_GENERATOR"), sfItem("SOURCE_COBBLESTONE_GENERATOR")
        }, 4, new ItemStack(Material.SAND)).register(plugin);

        SlimefunItemStack smoothStoneItem = new SlimefunItemStack("SOURCE_SMOOTH_STONE_GENERATOR", Material.SMOOTH_STONE, "&7&lGerador de Pedra Lisa", "", "&fGera Pedras Lisas automaticamente", "", "&b⚡ Velocidade: &fNormal (4s)", "&6⚡ Produção: &f1 Pedra Lisa");
        new SimpleMaterialClass(SMG, smoothStoneItem, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                sfItem("SOURCE_STONE_GENERATOR"), new ItemStack(Material.FLINT_AND_STEEL), sfItem("DURALUMIN_INGOT"),
                new ItemStack(Material.FLINT_AND_STEEL), new ItemStack(Material.SMOOTH_STONE), new ItemStack(Material.FLINT_AND_STEEL),
                sfItem("DURALUMIN_INGOT"), new ItemStack(Material.FLINT_AND_STEEL), sfItem("SOURCE_COBBLESTONE_GENERATOR")
        }, 8, new ItemStack(Material.SMOOTH_STONE)).register(plugin);

        // ==========================================
        // 3. GERADORES DE BLOCOS NATURAIS
        // ==========================================
        SlimefunItemStack glassItem = new SlimefunItemStack("SOURCE_GLASS_GENERATOR", Material.GLASS, "&7&lGerador de Vidro", "", "&fGera Vidros automaticamente", "", "&b⚡ Velocidade: &fNormal (6s)", "&6⚡ Produção: &f1 Vidros");
        new SimpleMaterialClass(SMG, glassItem, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                sfItem("LEAD_INGOT"), new ItemStack(Material.SAND), sfItem("LEAD_INGOT"),
                new ItemStack(Material.LAVA_BUCKET), sfItem("SOURCE_SAND_GENERATOR"), new ItemStack(Material.LAVA_BUCKET),
                sfItem("LEAD_INGOT"), new ItemStack(Material.SAND), sfItem("LEAD_INGOT")
        }, 12, new ItemStack(Material.GLASS)).register(plugin);

        SlimefunItemStack netherrackItem = new SlimefunItemStack("SOURCE_NETHERRACK_GENERATOR", Material.NETHERRACK, "&7&lGerador de Netherrack", "", "&fGera Netherracks automaticamente", "", "&b⚡ Velocidade: &fNormal (6s)", "&6⚡ Produção: &f1 Netherrack");
        new SimpleMaterialClass(SMG, netherrackItem, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.LAVA_BUCKET), sfItem("SOURCE_SMOOTH_STONE_GENERATOR"), new ItemStack(Material.LAVA_BUCKET),
                sfItem("SOURCE_STONE_GENERATOR"), new ItemStack(Material.LAVA_BUCKET), sfItem("SOURCE_COBBLESTONE_GENERATOR"),
                new ItemStack(Material.LAVA_BUCKET), sfItem("LEAD_INGOT"), new ItemStack(Material.LAVA_BUCKET)
        }, 12, new ItemStack(Material.NETHERRACK)).register(plugin);

        SlimefunItemStack soulSandItem = new SlimefunItemStack("SOURCE_SOUL_SAND_GENERATOR", Material.SOUL_SAND, "&7&lGerador de Areia das Almas", "", "&fGera Areia das Almas automaticamente", "", "&b⚡ Velocidade: &fNormal (12s)", "&6⚡ Produção: &f1 Areia das almas");
        new SimpleMaterialClass(SMG, soulSandItem, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.SOUL_SOIL), sfItem("SOURCE_SAND_GENERATOR"), new ItemStack(Material.SOUL_SAND),
                sfItem("SOURCE_SAND_GENERATOR"), new ItemStack(Material.LAVA_BUCKET), sfItem("SOURCE_SAND_GENERATOR"),
                new ItemStack(Material.SOUL_SAND), sfItem("SOURCE_SAND_GENERATOR"), new ItemStack(Material.SOUL_SOIL)
        }, 24, new ItemStack(Material.SOUL_SAND)).register(plugin);

        SlimefunItemStack quartzItem = new SlimefunItemStack("SOURCE_QUARTZ_GENERATOR", Material.QUARTZ_BLOCK, "&7&lGerador de Quartzo", "", "&fGera Quartzo automaticamente", "", "&b⚡ Velocidade: &fNormal (20s)", "&6⚡ Produção: &f1 Quartzo");
        new SimpleMaterialClass(SMG, quartzItem, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                sfItem("SOURCE_NETHERRACK_GENERATOR"), new ItemStack(Material.IRON_PICKAXE), sfItem("SOURCE_NETHERRACK_GENERATOR"),
                new ItemStack(Material.IRON_PICKAXE), new ItemStack(Material.SOUL_SAND), new ItemStack(Material.IRON_PICKAXE),
                sfItem("SOURCE_NETHERRACK_GENERATOR"), sfItem("NETHER_GOLD_PAN"), sfItem("SOURCE_NETHERRACK_GENERATOR")
        }, 40, new ItemStack(Material.QUARTZ)).register(plugin);

        SlimefunItemStack endstoneItem = new SlimefunItemStack("SOURCE_ENDSTONE_GENERATOR", Material.END_STONE_BRICKS, "&7&lGerador de Pedra do End", "", "&fGera Pedras do End automaticamente", "", "&b⚡ Velocidade: &fNormal (20s)", "&6⚡ Produção: &f1 Pedra do End");
        new SimpleMaterialClass(SMG, endstoneItem, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.OBSIDIAN), new ItemStack(Material.END_STONE), new ItemStack(Material.OBSIDIAN),
                sfItem("SOURCE_NETHERRACK_GENERATOR"), new ItemStack(Material.END_CRYSTAL), sfItem("SOURCE_STONE_GENERATOR"),
                new ItemStack(Material.OBSIDIAN), new ItemStack(Material.CRYING_OBSIDIAN), new ItemStack(Material.OBSIDIAN)
        }, 40, new ItemStack(Material.END_STONE)).register(plugin);

        SlimefunItemStack obsidianItem = new SlimefunItemStack("SOURCE_OBSIDIAN_GENERATOR", Material.OBSIDIAN, "&7&lGerador de Obsidiana", "", "&fGera Obsidianas automaticamente", "", "&b⚡ Velocidade: &fNormal (20s)", "&6⚡ Produção: &f1 Obsidiana");
        new SimpleMaterialClass(SMG, obsidianItem, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.OBSIDIAN), sfItem("SOURCE_STONE_GENERATOR"), new ItemStack(Material.OBSIDIAN),
                new ItemStack(Material.WATER_BUCKET), new ItemStack(Material.WATER_BUCKET), new ItemStack(Material.LAVA_BUCKET),
                new ItemStack(Material.OBSIDIAN), sfItem("SOURCE_COBBLESTONE_GENERATOR"), new ItemStack(Material.OBSIDIAN)
        }, 40, new ItemStack(Material.OBSIDIAN)).register(plugin);

        SlimefunItemStack clayItem = new SlimefunItemStack("SOURCE_CLAY_GENERATOR", Material.CLAY, "&7&lGerador de Argila", "", "&fGera Argilas automaticamente", "", "&b⚡ Velocidade: &fNormal (25s)", "&6⚡ Produção: &f1 Argila");
        new SimpleMaterialClass(SMG, clayItem, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.MUD), new ItemStack(Material.WATER_BUCKET), new ItemStack(Material.MUD),
                new ItemStack(Material.WATER_BUCKET), new ItemStack(Material.DIRT), new ItemStack(Material.WATER_BUCKET),
                new ItemStack(Material.MUD), new ItemStack(Material.WATER_BUCKET), new ItemStack(Material.MUD)
        }, 50, new ItemStack(Material.CLAY)).register(plugin);

        // ==========================================
        // 4. GERADORES DE MINÉRIOS E PEDRAS PRECIOSAS
        // ==========================================
        SlimefunItemStack coalItem = new SlimefunItemStack("SOURCE_COAL_GENERATOR", Material.COAL_BLOCK, "&7&lGerador de Carvão", "", "&fGera Carvões automaticamente", "", "&b⚡ Velocidade: &fNormal (30s)", "&6⚡ Produção: &f1 Carvão");
        new SimpleMaterialClass(SMG, coalItem, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.CHARCOAL), new ItemStack(Material.OAK_LOG), new ItemStack(Material.CHARCOAL),
                new ItemStack(Material.OAK_LOG), new ItemStack(Material.CHARCOAL), new ItemStack(Material.OAK_LOG),
                new ItemStack(Material.LAVA_BUCKET), new ItemStack(Material.OAK_LOG), new ItemStack(Material.LAVA_BUCKET)
        }, 60, new ItemStack(Material.COAL)).register(plugin);

        SlimefunItemStack ironItem = new SlimefunItemStack("SOURCE_IRON_GENERATOR", Material.IRON_BLOCK, "&7&lGerador de Ferro", "", "&fGera Ferros automaticamente", "", "&b⚡ Velocidade: &fNormal (35s)", "&6⚡ Produção: &f1 Ferro");
        new SimpleMaterialClass(SMG, ironItem, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.IRON_INGOT), new ItemStack(Material.RAW_IRON), new ItemStack(Material.RAW_IRON),
                new ItemStack(Material.RAW_IRON), new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT),
                new ItemStack(Material.RAW_IRON_BLOCK), new ItemStack(Material.CARVED_PUMPKIN), new ItemStack(Material.IRON_BLOCK)
        }, 70, new ItemStack(Material.IRON_INGOT)).register(plugin);

        SlimefunItemStack goldItem = new SlimefunItemStack("SOURCE_GOLD_GENERATOR", Material.GOLD_BLOCK, "&7&lGerador de Ouro", "", "&fGera Ouros automaticamente", "", "&b⚡ Velocidade: &fNormal (35s)", "&6⚡ Produção: &f1 Ouro");
        new SimpleMaterialClass(SMG, goldItem, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                sfItem("SOURCE_SAND_GENERATOR"), sfItem("SOURCE_SAND_GENERATOR"), sfItem("SOURCE_SAND_GENERATOR"),
                sfItem("SOURCE_SAND_GENERATOR"), new ItemStack(Material.WATER_BUCKET), sfItem("SOURCE_SAND_GENERATOR"),
                new ItemStack(Material.RAW_GOLD_BLOCK), sfItem("GOLD_PAN"), new ItemStack(Material.GOLD_BLOCK)
        }, 70, new ItemStack(Material.GOLD_INGOT)).register(plugin);

        SlimefunItemStack redstoneItem = new SlimefunItemStack("SOURCE_REDSTONE_GENERATOR", Material.REDSTONE_BLOCK, "&7&lGerador de Redstone", "", "&fGera Redstones automaticamente", "", "&b⚡ Velocidade: &fNormal (35s)", "&6⚡ Produção: &f1 Redstone");
        new SimpleMaterialClass(SMG, redstoneItem, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.REDSTONE), new ItemStack(Material.OBSERVER), new ItemStack(Material.REDSTONE),
                new ItemStack(Material.REDSTONE), new ItemStack(Material.REDSTONE_BLOCK), new ItemStack(Material.REDSTONE),
                new ItemStack(Material.REDSTONE_BLOCK), new ItemStack(Material.REDSTONE_LAMP), new ItemStack(Material.REDSTONE_BLOCK)
        }, 70, new ItemStack(Material.REDSTONE)).register(plugin);

        SlimefunItemStack lapisItem = new SlimefunItemStack("SOURCE_LAPIS_LAZULI_GENERATOR", Material.LAPIS_BLOCK, "&7&lGerador de Lápis-Lazulí", "", "&fGera Lápis-Lazulís automaticamente", "", "&b⚡ Velocidade: &fNormal (35s)", "&6⚡ Produção: &f1 Lápis-Lazulí");
        new SimpleMaterialClass(SMG, lapisItem, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.LAPIS_LAZULI), new ItemStack(Material.CHISELED_BOOKSHELF), new ItemStack(Material.LAPIS_LAZULI),
                new ItemStack(Material.LAPIS_LAZULI), new ItemStack(Material.LAPIS_BLOCK), new ItemStack(Material.LAPIS_LAZULI),
                new ItemStack(Material.LAPIS_BLOCK), new ItemStack(Material.BOOKSHELF), new ItemStack(Material.LAPIS_BLOCK)
        }, 70, new ItemStack(Material.LAPIS_LAZULI)).register(plugin);

        SlimefunItemStack emeraldItem = new SlimefunItemStack("SOURCE_EMERALD_GENERATOR", Material.EMERALD_BLOCK, "&7&lGerador de Esmeralda", "", "&fGera Esmeraldas automaticamente", "", "&b⚡ Velocidade: &fNormal (60s)", "&6⚡ Produção: &f1 Esmeralda");
        new SimpleMaterialClass(SMG, emeraldItem, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.EMERALD), new ItemStack(Material.EMERALD_BLOCK), new ItemStack(Material.EMERALD),
                new ItemStack(Material.EMERALD), new ItemStack(Material.LECTERN), new ItemStack(Material.EMERALD),
                new ItemStack(Material.EMERALD_BLOCK), new ItemStack(Material.RED_BED), new ItemStack(Material.EMERALD_BLOCK)
        }, 120, new ItemStack(Material.EMERALD)).register(plugin);

        SlimefunItemStack diamondItem = new SlimefunItemStack("SOURCE_DIAMOND_GENERATOR", Material.DIAMOND_BLOCK, "&7&lGerador de Diamante", "", "&fGera Diamantes automaticamente", "", "&b⚡ Velocidade: &fNormal (60s)", "&6⚡ Produção: &f1 Diamante");
        new SimpleMaterialClass(SMG, diamondItem, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.PISTON), new ItemStack(Material.LAVA_BUCKET), new ItemStack(Material.PISTON),
                sfItem("SOURCE_EMERALD_GENERATOR"), new ItemStack(Material.DIAMOND), sfItem("SOURCE_GOLD_GENERATOR"),
                new ItemStack(Material.PISTON), new ItemStack(Material.LAVA_BUCKET), new ItemStack(Material.PISTON)
        }, 120, new ItemStack(Material.DIAMOND)).register(plugin);

        // ==========================================
        // 5. COMPRESSORES (ANDESITO E DIORITO)
        // ==========================================
        SlimefunItemStack andesiteItem = new SlimefunItemStack("SOURCE_ANDESITE_GENERATOR", Material.ANDESITE, "&7&lGerador de Andesito", "", "&fGera Andesitos automaticamente", "", "&b⚡ Velocidade: &fNormal (12s)", "&6⚡ Produção: &f1 Andesitos");
        new SimpleMaterialClass(SMG, andesiteItem, RecipeType.COMPRESSOR, new ItemStack[] {
                new ItemStack(Material.COBBLESTONE, 8), null, null,
                null, null, null,
                null, null, null
        }, 24, new ItemStack(Material.ANDESITE)).register(plugin);

        SlimefunItemStack dioriteItem = new SlimefunItemStack("SOURCE_DIORITE_GENERATOR", Material.POLISHED_DIORITE, "&7&lGerador de Diorito", "", "&fGera Dioritos automaticamente", "", "&b⚡ Velocidade: &fNormal (12s)", "&6⚡ Produção: &f1 Dioritos");
        new SimpleMaterialClass(SMG, dioriteItem, RecipeType.COMPRESSOR, new ItemStack[] {
                new ItemStack(Material.ANDESITE, 8), null, null,
                null, null, null,
                null, null, null
        }, 24, new ItemStack(Material.DIORITE)).register(plugin);

    }

    // Método auxiliar para buscar os itens customizados sem poluir o código
    private static ItemStack sfItem(String id) {
        SlimefunItem item = SlimefunItem.getById(id);
        return item != null ? item.getItem() : new ItemStack(Material.BARRIER);
    }
}