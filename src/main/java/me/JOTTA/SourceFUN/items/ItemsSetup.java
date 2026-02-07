package me.JOTTA.SourceFUN.items;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.JOTTA.SourceFUN.SourceFUN;
import me.JOTTA.SourceFUN.items.groups.SourceFUNItemGroups;
import me.JOTTA.SourceFUN.items.machines.AdvancedPusher;
import me.JOTTA.SourceFUN.items.machines.WardenEssenceMiner;
import me.JOTTA.SourceFUN.items.machines.Wardenassembly;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;

public class ItemsSetup {

    public static void setup(SourceFUN plugin) {
        // advanced pusher
        new AdvancedPusher(
                SourceFUNItemGroups.MACHINES,
                new SlimefunItemStack("SOURCE_ADVANCED_PUSHER", Material.RED_STAINED_GLASS, "§6Advanced Pusher", "", "§7Pusher padrão com mais slots"),
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        new ItemStack(Material.BARRIER), new ItemStack(Material.GOLD_INGOT), new ItemStack(Material.PISTON),
                        new ItemStack(Material.GOLD_INGOT), new ItemStack(Material.REDSTONE_BLOCK), new ItemStack(Material.GOLD_INGOT),
                        new ItemStack(Material.PISTON), new ItemStack(Material.GOLD_INGOT), new ItemStack(Material.PISTON)
                }
        ).register(plugin);
// warden assembly
        new Wardenassembly(
                SourceFUNItemGroups.MACHINES,
                new SlimefunItemStack("SOURCE_WARDEN_ASSEMBLER", Material.SCULK_CATALYST,
                        "§5Warden Assembler", "",
                        "§x§9§2§0§0§0§0End-Game Machine",
                        "§8⇨ §e⚡ §7Consumo: 4096 J/t",
                        "§8⇨ §b❄ §7Capacidade: 8192 J"),
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        new ItemStack(Material.SCULK_CATALYST), null, null, null, null, null, null, null, null
                }).register(plugin);

        // --- WARDEN ESSENCE ---
        SlimefunItemStack wardenEssence = new SlimefunItemStack(
                "WARDEN_ESSENCE",
                Material.ECHO_SHARD,
                "&x&5&4&D&A&F&4Warden Essence",
                "",
                "§7Essência vinda de tempos antigos"
        );

        new SlimefunItem(
                SourceFUNItemGroups.RESOURCES,
                wardenEssence,
                RecipeType.NULL,
                new ItemStack[] { null, null, null, null, new ItemStack(Material.WARDEN_SPAWN_EGG), null, null, null, null }
        ).register(plugin);

        // --- WARDEN BLOCK ---
        SlimefunItemStack warderEssenceBlock = new SlimefunItemStack(
                "SOURCE_WARDEN_ESSENCE_BLOCK",
                Material.SCULK,
                "&x&5&4&D&A&F&4Warden Essence Block",
                "",
                "§7Bloco de warden essence"
        );

        new SlimefunItem(
                SourceFUNItemGroups.RESOURCES,
                warderEssenceBlock,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        wardenEssence, wardenEssence, wardenEssence,
                        wardenEssence, wardenEssence, wardenEssence,
                        wardenEssence, wardenEssence, wardenEssence
                }
        ).register(plugin);

        // --- ESPADA INDESTRUTÍVEL ---
        SlimefunItemStack unbreakableSword = new SlimefunItemStack(
                "SOURCE_UNBREAKING_SWORD",
                Material.IRON_SWORD,
                "&x&5&4&D&A&F&4Espada indestrutível ",
                "",
                "&7Lâmina indestrutível",
                "&8(Indestrutível)"
        );

        ItemMeta swordMeta = unbreakableSword.getItemMeta();
        if (swordMeta != null) {
            swordMeta.setUnbreakable(true);
            swordMeta.addEnchant(Enchantment.DURABILITY, 1, true);
            swordMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ENCHANTS);
            unbreakableSword.setItemMeta(swordMeta);
        }

        new SlimefunItem(
                SourceFUNItemGroups.TOOLS,
                unbreakableSword,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        null, wardenEssence, null,
                        null, wardenEssence, null,
                        null, new ItemStack(Material.STICK), null
                }
        ).register(plugin);

        //  VARA DE PESCA INDESTRUTÍVEL
        SlimefunItemStack unbreakingfisher = new SlimefunItemStack(
                "SOURCE_UNBREAKING_FISHER",
                Material.FISHING_ROD,
                "&x&5&4&D&A&F&4Vara de pesca indestrutível ",
                "",
                "&7Fio indestrutível",
                "&8(Indestrutível)"
        );

        ItemMeta fisherMeta = unbreakingfisher.getItemMeta();
        if (fisherMeta != null) {
            fisherMeta.setUnbreakable(true);
            fisherMeta.addEnchant(Enchantment.DURABILITY, 1, true);
            fisherMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ENCHANTS);
            unbreakingfisher.setItemMeta(fisherMeta);
        }

        new SlimefunItem(
                SourceFUNItemGroups.TOOLS,
                unbreakingfisher,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        null, null, wardenEssence,
                        null, new ItemStack(Material.STICK), new ItemStack(Material.STRING),
                        new ItemStack(Material.STICK), null, new ItemStack(Material.STRING)
                }
        ).register(plugin);
        // warden essence miner
        SlimefunItemStack minerStack = new SlimefunItemStack(
                "SOURCE_WARDEN_ESSENCE_MINER",
                Material.SCULK_CATALYST,
                "&5Warden Essence Miner",
                "",
                "§x§9§2§0§0§0§0End-Game Machine",
                "§8⇨ §e⚡ §7Consumo: 4096 J/t",
                "§8⇨ §b❄ §7Capacidade: 8024 J"
        );
        new WardenEssenceMiner(
                SourceFUNItemGroups.MACHINES,
                minerStack,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        new ItemStack(Material.BARRIER), wardenEssence, new ItemStack(Material.NETHERITE_BLOCK),
                        wardenEssence, new ItemStack(Material.NETHER_STAR), wardenEssence,
                        new ItemStack(Material.NETHERITE_BLOCK), wardenEssence, new ItemStack(Material.NETHERITE_BLOCK)
                }
        ).register(plugin);


        SlimefunItemStack maraging = new SlimefunItemStack(
                "SOURCE_MARAGING",
                Material.IRON_INGOT,
                "§x§5§4§D§A§F§4Maraging",
                ""
        );

        new SlimefunItem(
                SourceFUNItemGroups.RESOURCES,
                maraging,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        new ItemStack(Material.BARRIER), wardenEssence, wardenEssence,
                        wardenEssence, wardenEssence, wardenEssence,
                        wardenEssence, wardenEssence, wardenEssence
                }
        ).register(plugin);

        SlimefunItemStack maragingPlate = new SlimefunItemStack(
                "SOURCE_MARAGING_PLATE",
                Material.PAPER,
                "§x§5§4§D§A§F§4Maraging Plate",
                ""
        );

        new SlimefunItem(
                SourceFUNItemGroups.RESOURCES,
                maragingPlate,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        new ItemStack(Material.BARRIER), wardenEssence, wardenEssence,
                        wardenEssence, wardenEssence, wardenEssence,
                        wardenEssence, wardenEssence, wardenEssence
                }
        ).register(plugin);





        plugin.getLogger().info("§a[SourceFUN] Itens configurados com sucesso!");
    }
}