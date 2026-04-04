package me.JOTTA.SourceFUN.items.literners;

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

public class WardenDropListener implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onWardenDeath(EntityDeathEvent e) {
        if (!(e.getEntity() instanceof Warden)) return;

        Warden warden = (Warden) e.getEntity();
        UUID id = warden.getUniqueId();

        // 1. CHECA SE É O BOSS (Dropa 8 Corações)
        // Usamos liveBosses para identificar se é o seu Corrupted Warden
        if (WardenBoss.liveBosses.containsKey(id)) {
            if (ResourceSetup.wardenHeartInfected != null) {
                // Criamos o item de drop
                ItemStack dropHeart = ResourceSetup.wardenHeartInfected.clone();
                dropHeart.setAmount(8);

                // Adicionamos à lista de drops do evento
                e.getDrops().add(dropHeart);
            }
            // Importante: limpamos o Boss da lista após a morte aqui ou no Boss.java
            // para não vazar memória.
            return;
        }

        // 2. WARDEN COMUM (20% de vir Essência)
        // Dica: use nextDouble(100) < 20.0 para ser mais preciso
        if (ThreadLocalRandom.current().nextDouble(100.0) < 20.0) {
            if (ResourceSetup.wardenEssence != null) {
                ItemStack dropEssence = ResourceSetup.wardenEssence.clone();
                dropEssence.setAmount(1);
                e.getDrops().add(dropEssence);
            }
        }
    }
}