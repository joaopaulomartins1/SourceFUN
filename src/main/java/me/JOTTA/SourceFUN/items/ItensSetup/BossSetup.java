package me.JOTTA.SourceFUN.items.ItensSetup;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import me.JOTTA.SourceFUN.SourceFUN;
import me.JOTTA.SourceFUN.items.groups.SourceFUNItemGroups;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class BossSetup {



    public static void setup(SourceFUN plugin) {
        // Item de Invocação
        SlimefunItemStack bossSummoner = new SlimefunItemStack("SOURCE_WARDEN_SUMMONER", Material.NETHER_STAR, "&d&lCoração Corrompido", "", "&7Invoque o &5&lCorrupted Warden");
        SlimefunItem summonerItem = new SlimefunItem(SourceFUNItemGroups.BOSSES, bossSummoner, RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] { ResourceSetup.wardenEssence, null, ResourceSetup.wardenEssence, null, ResourceSetup.warderEssenceBlock, null, null, null, null });

        summonerItem.addItemHandler((ItemUseHandler) e -> {
            e.cancel();
            e.getItem().setAmount(e.getItem().getAmount() - 1);
            me.JOTTA.SourceFUN.items.bosses.WardenBoss.spawn(plugin, e.getPlayer().getLocation());
            e.getPlayer().sendMessage("§5§lO ritual começou...");
        });
        summonerItem.register(plugin);
    }
}