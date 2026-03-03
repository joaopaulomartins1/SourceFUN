package me.JOTTA.SourceFUN.backgrounds;

import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import org.bukkit.Material;

public class QuarryLayout {

    // Slots definidos no seu código original
    private static final int[] BACKGROUND_SLOTS = {
            0, 1, 2, 3, 5, 6, 7, 8,
            9, 10, 11, 12, 13, 14, 15, 16, 17,
            18, 26, 27, 35, 36, 44, 45, 53
    };

    private static final int ENERGY_STATUS_SLOT = 4;

    public static void apply(BlockMenuPreset preset) {
        // Preenche o fundo com vidro preto
        for (int slot : BACKGROUND_SLOTS) {
            preset.addItem(slot, new CustomItemStack(Material.BLACK_STAINED_GLASS_PANE, " "), ChestMenuUtils.getEmptyClickHandler());
        }

        // Adiciona o indicador de energia
        preset.addItem(ENERGY_STATUS_SLOT, new CustomItemStack(Material.GRAY_STAINED_GLASS_PANE, "§7Aguardando energia..."), ChestMenuUtils.getEmptyClickHandler());
    }
}