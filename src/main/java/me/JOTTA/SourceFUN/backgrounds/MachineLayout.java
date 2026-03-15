package me.JOTTA.SourceFUN.backgrounds;

import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ClickAction;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class MachineLayout {

    public static final int[] INPUT_SLOTS = {19, 20, 28, 29, 37, 38};
    public static final int[] OUTPUT_SLOTS = {24, 25, 33, 34, 42, 43};

    private static final int[] RED_BORDER = {9, 10, 11, 12, 18, 21, 27, 30, 36, 39, 45, 46, 47, 48};
    private static final int[] BLUE_BORDER = {14, 15, 16, 17, 23, 26, 32, 35, 41, 44, 50, 51, 52, 53};
    private static final int[] BACKGROUND_SLOTS = {0, 1, 2, 3, 4, 5, 6, 7, 8, 13, 22, 40, 49};

    public static void applyGenericMachineLayout(BlockMenuPreset preset) {
        for (int i : BACKGROUND_SLOTS) {
            preset.addItem(i, new CustomItemStack(Material.GRAY_STAINED_GLASS_PANE, " "), ChestMenuUtils.getEmptyClickHandler());
        }

        for (int i : RED_BORDER) {
            preset.addItem(i, new CustomItemStack(Material.RED_STAINED_GLASS_PANE, "§cEntrada", "§7Coloque os itens nos slots vazios"), ChestMenuUtils.getEmptyClickHandler());
        }


        for (int i : BLUE_BORDER) {
            preset.addItem(i, new CustomItemStack(Material.BLUE_STAINED_GLASS_PANE, "§9Saída", "§7O resultado aparecerá aqui"), ChestMenuUtils.getEmptyClickHandler());
        }


        preset.addItem(31, new CustomItemStack(Material.LIME_STAINED_GLASS_PANE, "§aProgresso", "§7Aguardando processamento..."), ChestMenuUtils.getEmptyClickHandler());


        for (int i : OUTPUT_SLOTS) {
            preset.addMenuClickHandler(i, new ChestMenu.AdvancedMenuClickHandler() {
                @Override
                public boolean onClick(Player p, int slot, ItemStack cursor, ClickAction action) { return false; }
                @Override
                public boolean onClick(InventoryClickEvent e, Player p, int slot, ItemStack cursor, ClickAction action) {
                    return cursor == null || cursor.getType() == Material.AIR;
                }
            });
        }
    }
}