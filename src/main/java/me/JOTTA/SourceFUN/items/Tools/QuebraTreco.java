package me.JOTTA.SourceFUN.items.Tools;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.libraries.dough.protection.Interaction;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.HashSet;
import java.util.Set;

public class QuebraTreco extends SlimefunItem {

    private final Set<String> addonsPermitidos = new HashSet<>();

    public QuebraTreco(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);

        addonsPermitidos.add("Networks");
        addonsPermitidos.add("InfinityExpansion2");
        addonsPermitidos.add("Supreme");
        addonsPermitidos.add("SourceFUN");
        addonsPermitidos.add("Slimefun");
        addonsPermitidos.add("GeneticChickengineering");
        addonsPermitidos.add("FluffyMachines");
        addonsPermitidos.add("SlimeTinker");
        addonsPermitidos.add("SimpleMaterialGenerators");
        addonsPermitidos.add("FNAmplifications");
        addonsPermitidos.add("FoxyMachines");
        addonsPermitidos.add("SlimeFrame");
    }

    @Override
    public void preRegister() {
        addItemHandler((ItemUseHandler) this::onUse);
    }

    private void onUse(PlayerRightClickEvent e) {
        e.cancel();

        e.getClickedBlock().ifPresent(block -> {
            Player p = e.getPlayer();
            SlimefunItem sfItem = BlockStorage.check(block);

            if (sfItem == null) return;

            Plugin pluginDono = sfItem.getAddon().getJavaPlugin();
            String nomeDoAddon = pluginDono.getName();

            if (addonsPermitidos.contains(nomeDoAddon)) {

                if (!Slimefun.getProtectionManager().hasPermission(p, block, Interaction.BREAK_BLOCK)) {
                    p.sendMessage("§cCuidado com o ban em! Rs");
                    return;
                }


                BlockBreakEvent breakEvent = new BlockBreakEvent(block, p);
                Bukkit.getPluginManager().callEvent(breakEvent);


                if (!breakEvent.isCancelled()) {
                    block.setType(Material.AIR);


                    BlockStorage.clearBlockInfo(block);
                }

                p.sendActionBar("§aItem do Addon " + nomeDoAddon + " removido com sucesso!");
            }
        });
    }
}