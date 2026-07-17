package me.JOTTA.SourceFUN.quests;

import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class MissionCategoryMenu {

    public static void open(Player player, String category) {
        ChestMenu menu = new ChestMenu("§6Missões - " + category);

        for (int i = 0; i < 54; i++) {
            menu.addItem(i, ChestMenuUtils.getBackground(), ChestMenuUtils.getEmptyClickHandler());
        }

        // Slot 45 - voltar
        menu.addItem(45, new CustomItemStack(Material.BARRIER, "§cVoltar", "", "§7Clique para voltar"), (p, slot, item, action) -> {
            MissionsMenu.open(p);
            return false;
        });

        List<Mission> missions = MissionManager.getByCategory(category);
        PlayerMissionData data = MissionManager.getData(player);

        int slot = 0;
        for (Mission mission : missions) {
            if (slot >= 45) break; // não mexe na barra de baixo (voltar)

            MissionProgress progress = data.getProgress(mission.getId());

            // pula missões ocultas que ainda não foram concluídas
            if (mission.isHidden() && !progress.isCompleted()) {
                continue;
            }

            List<String> lore = new ArrayList<>(mission.getLore());
            lore.add("");

            Material icon;
            String status;

            if (progress.isRewardClaimed()) {
                icon = Material.LIME_STAINED_GLASS_PANE;
                status = "§a✔ Concluída (recompensa já resgatada)";
            } else if (progress.isCompleted()) {
                icon = Material.EMERALD;
                status = "§e★ Concluída! Clique para resgatar a recompensa";
            } else {
                icon = Material.PAPER;
                status = "§7Progresso: §f" + progress.getCurrent() + "/" + mission.getRequiredAmount();
            }
            lore.add(status);

            final Mission finalMission = mission;
            final MissionProgress finalProgress = progress;

            menu.addItem(slot, new CustomItemStack(icon, "§b" + mission.getName(), lore.toArray(new String[0])), (p, s, item, action) -> {
                if (finalProgress.isCompleted() && !finalProgress.isRewardClaimed()) {
                    giveRewards(p, finalMission);
                    finalProgress.setRewardClaimed(true);
                    MissionStorage.save(p.getUniqueId());
                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1f, 1f);
                    p.sendMessage("§a[MISSÕES] §fRecompensa de \"" + finalMission.getName() + "§f\" resgatada!");
                    open(p, category); // atualiza o menu
                }
                return false;
            });

            slot++;
        }

        menu.open(player);
    }

    private static void giveRewards(Player player, Mission mission) {
        for (ItemStack reward : mission.getRewards()) {
            var leftover = player.getInventory().addItem(reward.clone());
            // se o inventário estiver cheio, joga o item no chão perto do jogador
            for (ItemStack drop : leftover.values()) {
                player.getWorld().dropItemNaturally(player.getLocation(), drop);
            }
        }
    }
}