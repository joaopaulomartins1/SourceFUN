package me.JOTTA.SourceFUN.quests.iniciante;


import me.JOTTA.SourceFUN.quests.Mission;
import me.JOTTA.SourceFUN.quests.MissionManager;
import me.JOTTA.SourceFUN.quests.MissionType;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

/**
 * Missões da categoria "inicial". Só registra no MissionManager, sem lógica própria.
 */
public class InicialQuests {

    public static void setup() {

        // Quebrar bloco
        MissionManager.register(
                Mission.builder("inicial_minerar_pedra", MissionType.BLOCK_BREAK)
                        .name("§7Primeiras Picadas")
                        .lore("§7Quebre §f32 Pedra")
                        .category("inicial")
                        .amount(32)
                        .block(Material.STONE)
                        .reward(new ItemStack(Material.IRON_INGOT, 5))
                        .build()
        );

        // Matar mob
        MissionManager.register(
                Mission.builder("inicial_matar_zumbi", MissionType.KILL_MOB)
                        .name("§7Caça aos Mortos-Vivos")
                        .lore("§7Mate §f10 Zumbis")
                        .category("inicial")
                        .amount(10)
                        .mob(EntityType.ZOMBIE)
                        .reward(new ItemStack(Material.GOLDEN_APPLE, 1))
                        .build()
        );

        // Craftar item do Slimefun (troca "REINFORCED_PICKAXE" pelo id real do seu item)
        MissionManager.register(
                Mission.builder("inicial_craftar_picareta", MissionType.SLIMEFUN_CRAFT)
                        .name("§7Ferramenta de Verdade")
                        .lore("§7Crafte §f1 Picareta Reforçada")
                        .category("inicial")
                        .amount(1)
                        .slimefunId("REINFORCED_PICKAXE")
                        .reward(new ItemStack(Material.DIAMOND, 2))
                        .build()
        );

        // Construir/usar a Enhanced Crafting Table
        MissionManager.register(
                Mission.builder("inicial_construir_enchanted_crafting_table", MissionType.MACHINE_USE)
                        .name("§7Bancada Encantada")
                        .lore("§7Construa e use uma §fEnhanced Crafting Table", "§7(usada pra craftar a maioria dos itens do Slimefun)")
                        .category("inicial")
                        .slimefunId("ENHANCED_CRAFTING_TABLE")
                        .reward(new ItemStack(Material.EXPERIENCE_BOTTLE, 10))
                        .build()
        );

// Construir/usar a Smeltery
        MissionManager.register(
                Mission.builder("inicial_construir_smeltery", MissionType.MACHINE_USE)
                        .name("§7Forjando Metais")
                        .lore("§7Construa e use uma §fSmeltery", "§7(converte pós em lingotes e cria ligas)")
                        .category("inicial")
                        .slimefunId("SMELTERY")
                        .reward(new ItemStack(Material.IRON_INGOT, 8))
                        .build()
        );

// Construir/usar a Grind Stone
        MissionManager.register(
                Mission.builder("inicial_construir_grind_stone", MissionType.MACHINE_USE)
                        .name("§7Pedra de Amolar")
                        .lore("§7Construa e use uma §fGrind Stone", "§7(tritura itens transformando em outros)")
                        .category("inicial")
                        .slimefunId("GRIND_STONE")
                        .reward(new ItemStack(Material.FLINT, 16))
                        .build()
        );

// Construir/usar o Ore Crusher
        MissionManager.register(
                Mission.builder("inicial_construir_ore_crusher", MissionType.MACHINE_USE)
                        .name("§7Triturador de Minérios")
                        .lore("§7Construa e use um §fOre Crusher", "§7(transforma minério em pó)")
                        .category("inicial")
                        .slimefunId("ORE_CRUSHER")
                        .reward(new ItemStack(Material.IRON_NUGGET, 16))
                        .build()
        );

// Construir/usar a Pressure Chamber
        MissionManager.register(
                Mission.builder("inicial_construir_pressure_chamber", MissionType.MACHINE_USE)
                        .name("§7Sob Pressão")
                        .lore("§7Construa e use uma §fPressure Chamber", "§7(comprime itens ainda mais)")
                        .category("inicial")
                        .slimefunId("PRESSURE_CHAMBER")
                        .reward(new ItemStack(Material.DIAMOND, 3))
                        .build()
        );
    }
}