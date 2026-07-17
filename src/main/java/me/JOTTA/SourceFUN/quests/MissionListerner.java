package me.JOTTA.SourceFUN.quests;

import io.github.thebusybiscuit.slimefun4.api.events.MultiBlockInteractEvent;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class MissionListerner implements Listener {

    // ---- carregar/salvar progresso ----

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        MissionStorage.load(e.getPlayer().getUniqueId());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        MissionStorage.save(e.getPlayer().getUniqueId());
        MissionManager.unload(e.getPlayer().getUniqueId());
    }

    // ---- BLOCK_BREAK ----

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onBlockBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();
        ItemStack handItem = player.getInventory().getItemInMainHand();
        String toolId = getSlimefunId(handItem); // null se não for ferramenta Slimefun

        List<Mission> completed = MissionManager.progress(
                player,
                MissionType.BLOCK_BREAK,
                e.getBlock().getType().name(),
                toolId,
                1
        );

        completeAndNotify(player, completed);
    }

    // ---- SLIMEFUN_CRAFT ----

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onCraft(CraftItemEvent e) {
        if (!(e.getWhoClicked() instanceof Player player)) return;

        ItemStack result = e.getInventory().getResult();
        String itemId = getSlimefunId(result);
        if (itemId == null) return;

        int amount = result != null ? result.getAmount() : 1;

        List<Mission> completed = MissionManager.progress(player, MissionType.SLIMEFUN_CRAFT, itemId, null, amount);
        completeAndNotify(player, completed);
    }

    // ---- KILL_MOB ----

    @EventHandler(priority = EventPriority.MONITOR)
    public void onEntityDeath(EntityDeathEvent e) {
        LivingEntity entity = e.getEntity();
        Player killer = entity.getKiller();
        if (killer == null) return;

        List<Mission> completed = MissionManager.progress(killer, MissionType.KILL_MOB, entity.getType().name());
        completeAndNotify(killer, completed);
    }

    // ---- MACHINE_USE (multiblock do Slimefun, 1 uso = completa) ----

    @EventHandler(priority = EventPriority.MONITOR)
    public void onMultiBlockUse(MultiBlockInteractEvent e) {
        Player player = e.getPlayer();
        String machineId = e.getMultiBlock().getSlimefunItem().getId();

        List<Mission> completed = MissionManager.progress(player, MissionType.MACHINE_USE, machineId);
        completeAndNotify(player, completed);
    }

    // ---- utilitários ----

    /** Retorna o id do SlimefunItem de um ItemStack, ou null se não for um item Slimefun. */
    private String getSlimefunId(ItemStack item) {
        if (item == null) return null;
        SlimefunItem sfItem = SlimefunItem.getByItem(item);
        return sfItem != null ? sfItem.getId() : null;
    }

    private void completeAndNotify(Player player, List<Mission> completedMissions) {
        for (Mission mission : completedMissions) {
            player.sendMessage("§a§l[MISSÃO CONCLUÍDA] §f" + mission.getName() + " §7- abra o menu de missões para reivindicar a recompensa!");
        }
    }
}