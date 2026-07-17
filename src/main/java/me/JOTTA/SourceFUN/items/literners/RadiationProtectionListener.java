package me.JOTTA.SourceFUN.items.literners;

import io.github.thebusybiscuit.slimefun4.api.events.RadiationDamageEvent;
import me.JOTTA.SourceFUN.items.Tools.RadiationRune;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;

public class RadiationProtectionListener implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onRadiationDamage(RadiationDamageEvent e) {
        Player player = e.getPlayer();
        EntityEquipment equipment = player.getEquipment();
        if (equipment == null) return;

        ItemStack[] armor = {
                equipment.getHelmet(), equipment.getChestplate(),
                equipment.getLeggings(), equipment.getBoots()
        };

        for (ItemStack piece : armor) {
            if (RadiationRune.hasRune(piece)) {
                e.setCancelled(true);
                return;
            }
        }
    }
}