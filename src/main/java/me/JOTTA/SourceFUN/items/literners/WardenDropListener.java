package me.JOTTA.SourceFUN.items.literners;

import me.JOTTA.SourceFUN.items.ItensSetup.BossSetup;
import me.JOTTA.SourceFUN.items.ItensSetup.ItemsSetup;
import me.JOTTA.SourceFUN.items.ItensSetup.ResourceSetup;
import me.JOTTA.SourceFUN.items.bosses.WardenBoss;
import org.bukkit.entity.Warden;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import java.util.concurrent.ThreadLocalRandom;
import java.util.UUID;

import static me.JOTTA.SourceFUN.items.ItensSetup.BossSetup.wardenHeartInfected;

public class WardenDropListener implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onWardenDeath(EntityDeathEvent e) {
        if (!(e.getEntity() instanceof Warden)) return;

        UUID id = e.getEntity().getUniqueId();

        // 1. CHECA SE É BOSS (Dropa 8)
        if (WardenBoss.liveBosses.containsKey(id)) {
            if (BossSetup.wardenHeartInfected != null) {
                ItemStack dropHeart = BossSetup.wardenHeartInfected.clone();
                dropHeart.setAmount(8);
                e.getDrops().add(dropHeart);
            }
            return; // Se é boss, não roda a chance de 20%
        }

        // 2. WARDEN COMUM (20% de vir Essência)
        if (ThreadLocalRandom.current().nextInt(100) < 20) {
            if (ResourceSetup.wardenEssence != null) {
                ItemStack dropEssence = ResourceSetup.wardenEssence.clone();
                dropEssence.setAmount(1);
                e.getDrops().add(dropEssence);


            }
        }
    }
}