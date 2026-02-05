package me.JOTTA.SourceFUN.items.groups;

import me.JOTTA.SourceFUN.SourceFUN;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;

// Importe as classes que VOCÊ CRIOU
import me.JOTTA.SourceFUN.groups.MainFlexGroup;


public class SourceFUNItemGroups {

    // Declara os grupos públicos
    public static MainFlexGroup MAIN;
    public static DummyItemGroup MACHINES;
    public static DummyItemGroup WEAPONS;
    public static DummyItemGroup TOOLS;
    public static DummyItemGroup ARMOR;
    public static DummyItemGroup OTHER;

    public static void setup() {
        SourceFUN plugin = SourceFUN.getInstance();

        if (plugin == null) {
            throw new IllegalStateException("Plugin SourceFUN não foi inicializado!");
        }

        // 1. Cria o grupo principal (com menu customizado)
        MAIN = new MainFlexGroup(
                new NamespacedKey(plugin, "sourcefun_main"),
                new CustomItemStack(Material.NETHER_STAR, "§6§lSourceFUN")
        );

        // 2. Cria as subcategorias (usando DummyItemGroup)
        MACHINES = new DummyItemGroup(
                new NamespacedKey(plugin, "sourcefun_machines"),
                new CustomItemStack(Material.FURNACE, "§eMáquinas SourceFUN")
        );

        WEAPONS = new DummyItemGroup(
                new NamespacedKey(plugin, "sourcefun_weapons"),
                new CustomItemStack(Material.DIAMOND_SWORD, "§cArmas SourceFUN")
        );

        TOOLS = new DummyItemGroup(
                new NamespacedKey(plugin, "sourcefun_tools"),
                new CustomItemStack(Material.DIAMOND_PICKAXE, "§bFerramentas SourceFUN")
        );

        ARMOR = new DummyItemGroup(
                new NamespacedKey(plugin, "sourcefun_armor"),
                new CustomItemStack(Material.NETHERITE_CHESTPLATE, "§6Armaduras SourceFUN")
        );

        OTHER = new DummyItemGroup(
                new NamespacedKey(plugin, "sourcefun_other"),
                new CustomItemStack(Material.CHEST, "§dOutros Itens")
        );

        // 3. REGISTRA todos os grupos no Slimefun
        MAIN.register(plugin);
        MACHINES.register(plugin);
        WEAPONS.register(plugin);
        TOOLS.register(plugin);
        ARMOR.register(plugin);
        OTHER.register(plugin);

        plugin.getLogger().info("§a✅ Todos os grupos do SourceFUN foram registrados!");
    }
}