package me.JOTTA.SourceFUN.items.literners;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import java.util.concurrent.ThreadLocalRandom;

public class WardenDropListener implements Listener {

    @EventHandler
    public void onWardenDeath(EntityDeathEvent e) {
        if (e.getEntityType() == EntityType.WARDEN) {

            // Lógica de Chance: 20% (0 a 100 < 20)
            if (ThreadLocalRandom.current().nextInt(100) < 20) {
                SlimefunItem sfItem = SlimefunItem.getById("WARDEN_ESSENCE");

                if (sfItem != null) {
                    ItemStack itemDrop = sfItem.getItem().clone();
                    e.getDrops().add(itemDrop);
                }
            }
        }
    }
}