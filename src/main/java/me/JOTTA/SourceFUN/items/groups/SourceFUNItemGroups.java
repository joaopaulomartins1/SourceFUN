package me.JOTTA.SourceFUN.items.groups;

import me.JOTTA.SourceFUN.SourceFUN;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

public class SourceFUNItemGroups {
    public static MainFlexGroup MAIN;
    public static DummyItemGroup MACHINES;
    public static DummyItemGroup RESOURCES;
    public static DummyItemGroup TOOLS;

    public static void setup(SourceFUN plugin) {
        // Grupo Principal (Visível)
        MAIN = new MainFlexGroup(
                new NamespacedKey(plugin, "sf_main"),
                new CustomItemStack(Material.NETHER_STAR, "§6§lSourceFUN")
        );

        // Grupo de Máquinas (Instanciado, mas não registrado globalmente)
        MACHINES = new DummyItemGroup(
                new NamespacedKey(plugin, "sf_machines"),
                new CustomItemStack(Material.FURNACE, "&#54DAF4M&#54C8EBa&#54B7E2q&#54A5D9u&#5493D1i&#5481C8n&#5470BFa&#545EB6s")
        );

        RESOURCES = new DummyItemGroup(
                new NamespacedKey(plugin, "sf_resources"),
                new CustomItemStack(Material.NETHER_BRICK, "§x§5§4§D§A§F§4M§x§5§4§C§8§E§Ba§x§5§4§B§7§E§2q§x§5§4§A§5§D§9u§x§5§4§9§3§D§1i§x§5§4§8§1§C§8n§x§5§4§7§0§B§Fa§x§5§4§5§E§B§6s")
        );

        TOOLS = new DummyItemGroup(
                new NamespacedKey(plugin, "sf_tools"),
                new CustomItemStack(Material.DIAMOND_AXE,"§x§5§4§D§A§F§4F§x§5§4§D§3§F§1e§x§5§4§C§C§E§Er§x§5§4§C§5§E§Ar§x§5§4§B§E§E§7a§x§5§4§B§7§E§3m§x§5§4§A§F§E§0e§x§5§4§A§8§D§Cn§x§5§4§A§1§D§9t§x§5§4§9§A§D§5a§x§5§4§9§3§D§2s")
        );



        // APENAS o MAIN é registrado no Slimefun.
        // O MACHINES existe na memória para os itens, mas não no Menu.
        MAIN.register(plugin);
    }
}