package me.JOTTA.SourceFUN.items.Tools;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemDropHandler;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.Collection;
import java.util.Optional;

public class RadiationRune extends SimpleSlimefunItem<ItemDropHandler> {

    private static final double RANGE = 3.0;
    public static final NamespacedKey RUNE_TAG = new NamespacedKey("sourcefun", "radiation_rune");

    public RadiationRune(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public ItemDropHandler getItemHandler() {
        return (event, player, item) -> {
            Item runeEntity = event.getItemDrop();
            Location loc = runeEntity.getLocation();

            Collection<Entity> nearby = loc.getWorld().getNearbyEntities(loc, RANGE, RANGE, RANGE, RadiationRune::isCompatibleArmor);
            Optional<Entity> optional = nearby.stream().findFirst();

            if (optional.isPresent()) {
                activate(player, runeEntity, (Item) optional.get());
            }

            return false;
        };
    }

    private static boolean isCompatibleArmor(Entity entity) {
        if (!(entity instanceof Item item) || !item.isValid()) return false;

        ItemStack stack = item.getItemStack();
        String type = stack.getType().name();
        boolean isArmor = type.endsWith("_HELMET") || type.endsWith("_CHESTPLATE")
                || type.endsWith("_LEGGINGS") || type.endsWith("_BOOTS");

        return isArmor && !hasRune(stack);
    }

    private static void activate(Player player, Item runeEntity, Item targetEntity) {
        Location loc = targetEntity.getLocation();

        Slimefun.runSync(() -> {
            if (!runeEntity.isValid() || !targetEntity.isValid()) return;

            ItemStack result = targetEntity.getItemStack().clone();
            applyRune(result);

            loc.getWorld().strikeLightningEffect(loc);
            loc.getWorld().playSound(loc, Sound.ENTITY_PLAYER_LEVELUP, SoundCategory.PLAYERS, 1f, 1f);

            runeEntity.remove();
            targetEntity.remove();
            loc.getWorld().dropItemNaturally(loc, result);
        }, 10L);
    }

    public static boolean hasRune(ItemStack item) {
        if (item == null) return false;
        ItemMeta meta = item.getItemMeta();
        if (meta == null) return false;
        return meta.getPersistentDataContainer().has(RUNE_TAG, PersistentDataType.BYTE);
    }

    public static void applyRune(ItemStack armorPiece) {
        ItemMeta meta = armorPiece.getItemMeta();
        if (meta == null) return;

        meta.getPersistentDataContainer().set(RUNE_TAG, PersistentDataType.BYTE, (byte) 1);

        var lore = meta.hasLore() ? new java.util.ArrayList<>(meta.getLore()) : new java.util.ArrayList<String>();
        lore.add("§d✦ Imune à Radiação (Ancient Rune)");
        meta.setLore(lore);

        armorPiece.setItemMeta(meta);
    }
}