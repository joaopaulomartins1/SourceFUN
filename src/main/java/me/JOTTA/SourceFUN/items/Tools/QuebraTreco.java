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
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.HashSet;
import java.util.Set;

public class QuebraTreco extends SlimefunItem {

    // Lista de nomes de plugins (Addons) permitidos
    private final Set<String> addonsPermitidos = new HashSet<>();

    public QuebraTreco(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);

        // Adiciona o nome do plugin (como está no plugin.yml dele)
        addonsPermitidos.add("Networks");
        addonsPermitidos.add("InfinityExpansion2");
        addonsPermitidos.add("Supreme");
        // Podes adicionar o teu próprio addon também
        addonsPermitidos.add("SourceFUN");
        addonsPermitidos.add("Slimefun");
        addonsPermitidos.add("GeneticChickengineering");
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

            // --- A MÁGICA ACONTECE AQUI ---
            // Descobre qual plugin registou este item
            Plugin pluginDono = sfItem.getAddon().getJavaPlugin();
            String nomeDoAddon = pluginDono.getName();

            if (addonsPermitidos.contains(nomeDoAddon)) {

                // Verifica proteções de terreno
                if (!Slimefun.getProtectionManager().hasPermission(p, block, Interaction.BREAK_BLOCK)) {
                    p.sendMessage("§cCuidado com o ban em! Rs");
                    return;
                }

                // Dropa e remove
                ItemStack itemToDrop = sfItem.getItem().clone();
                block.getWorld().dropItemNaturally(block.getLocation(), itemToDrop);
                block.setType(Material.AIR);
                BlockStorage.clearBlockInfo(block);

                p.sendActionBar("§aItem do Addon " + nomeDoAddon + " removido!");
            }
        });
    }
}