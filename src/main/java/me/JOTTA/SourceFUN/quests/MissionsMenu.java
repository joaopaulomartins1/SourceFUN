package me.JOTTA.SourceFUN.quests;


import io.github.bakedlibs.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Menu principal de missões: lista as categorias existentes (inicial, intermediaria, etc)
 * e ao clicar abre a MissionCategoryMenu daquela categoria.
 */
public class MissionsMenu {

    public static void open(Player player) {
        ChestMenu menu = new ChestMenu("§6Missões");

        for (int i = 0; i < 27; i++) {
            menu.addItem(i, ChestMenuUtils.getBackground(), ChestMenuUtils.getEmptyClickHandler());
        }

        // pega todas as categorias registradas, sem repetir, na ordem de registro
        Set<String> categories = new LinkedHashSet<>();
        for (Mission mission : MissionManager.getAll()) {
            categories.add(mission.getCategory());
        }

        int slot = 10;
        for (String category : categories) {
            if (slot > 16) break;

            menu.addItem(slot, new CustomItemStack(Material.BOOK, "§e" + capitalize(category), "", "§7Clique para ver as missões", "§7dessa categoria"),
                    (p, s, item, action) -> {
                        MissionCategoryMenu.open(p, category);
                        return false;
                    });
            slot++;
        }

        menu.open(player);
    }

    private static String capitalize(String text) {
        if (text == null || text.isEmpty()) return text;
        return Character.toUpperCase(text.charAt(0)) + text.substring(1);
    }
}