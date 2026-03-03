package me.JOTTA.SourceFUN.items.ItensSetup;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.JOTTA.SourceFUN.SourceFUN;
import me.JOTTA.SourceFUN.items.ItensSetup.MachinesRecipes.StonecutterRecipes;
import me.JOTTA.SourceFUN.items.groups.SourceFUNItemGroups;
import me.JOTTA.SourceFUN.items.machines.*;
import org.bukkit.Material;
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
                2
        );
        StonecutterRecipes.registerAll(stonecutter);
        stonecutter.register(plugin);



        GenericMachine stoneCompressor = new GenericMachine(
                SourceFUNItemGroups.MACHINES,
                new SlimefunItemStack("SOURCE_COBBLE_PRESS_ADVANCED", Material.SMOOTH_STONE, "§x§F§F§2§C§3§DAdvanced §x§8§C§8§C§8§CCobble Press", "", "&7Comprime pedras automaticamente"),
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        new ItemStack(Material.BARRIER), new ItemStack(Material.BARRIER), new ItemStack(Material.BARRIER),
                        new ItemStack(Material.BARRIER), new ItemStack(Material.BARRIER), new ItemStack(Material.BARRIER),
                        new ItemStack(Material.BARRIER), new ItemStack(Material.BARRIER), new ItemStack(Material.BARRIER)
                },
                1748, // Energia (consumo)
                2048, // Capacidade
                1    // Velocidade
        );

// 1. Registro da primeira etapa (64 Cobblestone comum -> 8 Nível 1)
        SlimefunItem st1 = SlimefunItem.getById("IE_COMPRESSED_COBBLESTONE_1");
        if (st1 != null) {
            stoneCompressor.addRecipe(1,
                    new ItemStack(Material.COBBLESTONE, 64),
                    new CustomItemStack(st1.getItem(), 12)
            );
        }

// 2. Loop para os níveis seguintes (64 do anterior -> 8 do próximo)
// Vai do 1 até o 4, cobrindo as transições (1->2, 2->3, 3->4, 4->5)
        for (int i = 1; i <= 4; i++) {
            SlimefunItem atual = SlimefunItem.getById("IE_COMPRESSED_COBBLESTONE_" + i);
            SlimefunItem proximo = SlimefunItem.getById("IE_COMPRESSED_COBBLESTONE_" + (i + 1));

            if (atual != null && proximo != null) {
                stoneCompressor.addRecipe(1,
                        new CustomItemStack(atual.getItem(), 64),
                        new CustomItemStack(proximo.getItem(), 8)
                );
            }
        }

        stoneCompressor.register(plugin);




        SlimefunItemStack energyConnectorItem = new SlimefunItemStack(
                "SOURCE_ENERGY_CONNECTOR",
                Material.GREEN_WOOL,
                "&6Conector de Energia",
                "",
                "&7§x§8§3§8§3§8§3Range: §x§F§A§0§0§0§06 §x§F§1§F§F§0§0blocks",
                ""
        );


        ItemStack[] recipe = {
                new ItemStack(Material.IRON_INGOT), new ItemStack(Material.COPPER_INGOT), new ItemStack(Material.IRON_INGOT),
                new ItemStack(Material.COPPER_INGOT),new ItemStack(Material.COPPER_INGOT) , new ItemStack(Material.COPPER_INGOT),
                new ItemStack(Material.IRON_INGOT), new ItemStack(Material.COPPER_INGOT), new ItemStack(Material.IRON_INGOT)
        };


        EnergyConnector energyConnector = new EnergyConnector(
                SourceFUNItemGroups.MACHINES,
                energyConnectorItem,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                recipe,
                new ItemStack(Material.AIR) // Saída extra da receita (opcional)
        );

        energyConnector.register(plugin); // "this" refere-se à sua classe JavaPlugin/SlimefunAddon

    }


    ;


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