package me.JOTTA.SourceFUN.items.bosses;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import me.JOTTA.SourceFUN.SourceFUN;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Warden;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.world.ChunkUnloadEvent;
import org.bukkit.scheduler.BukkitRunnable;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class WardenBoss implements Listener {

    public static final HashMap<UUID, Double> liveBosses = new HashMap<>();
    private static final HashMap<UUID, BossBar> bossBars = new HashMap<>();

    private static final double MAX_REAL_HEALTH = 70000.0;
    private static final double MAX_VANILLA_ALLOWED = 1024.0;
    private static final double VANILLA_TOTAL_HEALTH = 2000.0;

    public static void spawn(@Nonnull SourceFUN plugin, @Nonnull Location loc) {
        Chunk chunk = loc.getChunk();
        chunk.setForceLoaded(true);

        Warden boss = (Warden) loc.getWorld().spawnEntity(loc, EntityType.WARDEN);
        boss.setAI(false);
        boss.setTarget(null);

        boss.setCustomName("§d§lCorrupted Warden");
        boss.setCustomNameVisible(true);

        AttributeInstance healthAttr = boss.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        if (healthAttr != null) {

            healthAttr.setBaseValue(MAX_VANILLA_ALLOWED);
        }

        // Enche a vida base até o talo
        boss.setHealth(MAX_VANILLA_ALLOWED);

        // Injeta o que sobrou (2000 - 1024 = 976) como escudos de absorção puros
        double excessHealth = VANILLA_TOTAL_HEALTH - MAX_VANILLA_ALLOWED;
        if (excessHealth > 0) {
            boss.setAbsorptionAmount(excessHealth);
        }
        // ========================================================

        UUID id = boss.getUniqueId();
        liveBosses.put(id, MAX_REAL_HEALTH);

        BossBar bossBar = Bukkit.createBossBar("§5§lRitual de Invocação", BarColor.PURPLE, BarStyle.SEGMENTED_20);
        bossBars.put(id, bossBar);

        loc.getWorld().getNearbyEntities(loc, 50, 50, 50).forEach(e -> {
            if (e instanceof Player) bossBar.addPlayer((Player) e);
        });

        new BukkitRunnable() {
            int timer = 0;
            @Override
            public void run() {
                if (boss == null || !boss.isValid()) {
                    chunk.setForceLoaded(false);
                    cleanup(id);
                    this.cancel();
                    return;
                }

                timer++;
                boss.setInvulnerable(true);

                if (timer < 500) boss.setTarget(null);

                if (timer > 60 && timer < 500) {
                    boss.setAI(false);
                    boss.setGravity(false);
                    Location l = boss.getLocation();
                    l.add(0, 0.005, 0);
                    l.setYaw(l.getYaw() + 8.0f);
                    boss.teleport(l);

                    if (timer % 15 == 0) {
                        Location randLoc = boss.getLocation().clone().add(ThreadLocalRandom.current().nextDouble(-3, 3), 1, ThreadLocalRandom.current().nextDouble(-3, 3));
                        boss.getWorld().spawnParticle(Particle.EXPLOSION, randLoc, 1);
                        boss.getWorld().strikeLightningEffect(randLoc);
                    }
                }

                if (timer == 500) {
                    chunk.setForceLoaded(false);
                    Objects.requireNonNull(boss.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE)).setBaseValue(250.0);
                    Objects.requireNonNull(boss.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED)).setBaseValue(0.45);
                    boss.setAI(true);
                    boss.setGravity(true);
                    boss.setInvulnerable(false);
                    boss.getWorld().playSound(boss.getLocation(), Sound.ENTITY_WITHER_SPAWN, 3.0f, 0.5f);

                    updateBossBar(id, MAX_REAL_HEALTH);
                    bossBar.setColor(BarColor.PINK);
                    this.cancel();

                    startBossBarRadar(plugin, boss, id, bossBar);
                }
            }
        }.runTaskTimer(plugin, 0L, 1L);
    }

    private static void startBossBarRadar(SourceFUN plugin, Warden boss, UUID id, BossBar bossBar) {
        new BukkitRunnable() {
            @Override
            public void run() {
                if (!boss.isValid() || !liveBosses.containsKey(id)) {
                    this.cancel();
                    return;
                }

                Location bossLoc = boss.getLocation();
                for (Player p : Bukkit.getOnlinePlayers()) {
                    if (p.getWorld().equals(bossLoc.getWorld())) {
                        double distanceSquared = p.getLocation().distanceSquared(bossLoc);
                        if (distanceSquared <= 2500) {
                            if (!bossBar.getPlayers().contains(p)) bossBar.addPlayer(p);
                        } else {
                            if (bossBar.getPlayers().contains(p)) bossBar.removePlayer(p);
                        }
                    } else if (bossBar.getPlayers().contains(p)) {
                        bossBar.removePlayer(p);
                    }
                }
            }
        }.runTaskTimer(plugin, 0L, 10L);
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onDamage(EntityDamageByEntityEvent e) {
        if (!(e.getEntity() instanceof Warden)) return;
        UUID id = e.getEntity().getUniqueId();

        if (liveBosses.containsKey(id)) {
            double damage = e.getFinalDamage();
            double currentHP = liveBosses.get(id);
            double newHP = currentHP - damage;

            if (newHP <= 0) {
                liveBosses.put(id, 0.0);
                updateBossBar(id, 0);
                e.setCancelled(true);
                ((Warden) e.getEntity()).setHealth(0.0);
            } else {
                liveBosses.put(id, newHP);
                updateBossBar(id, newHP);

                double percentage = newHP / MAX_REAL_HEALTH;
                double syncHP = Math.max(1.0, VANILLA_TOTAL_HEALTH * percentage);

                // Re-calcula a gambiarra de absorção toda vez que o boss toma dano
                Warden w = (Warden) e.getEntity();
                if (syncHP > MAX_VANILLA_ALLOWED) {
                    w.setHealth(MAX_VANILLA_ALLOWED);
                    w.setAbsorptionAmount(syncHP - MAX_VANILLA_ALLOWED);
                } else {
                    w.setAbsorptionAmount(0);
                    w.setHealth(syncHP);
                }

                e.setDamage(0.001);
            }
        }
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onDeath(EntityDeathEvent e) {
        UUID id = e.getEntity().getUniqueId();
        if (liveBosses.containsKey(id)) {
            Location l = e.getEntity().getLocation();
            l.getWorld().playSound(l, Sound.ENTITY_WITHER_DEATH, 3f, 0.5f);

            // --- DROP DO ITEM SLIMEFUN ---
            SlimefunItem infectedHeart = SlimefunItem.getById("SOURCE_WARDEN_HEART_INFECTED");
            if (infectedHeart != null) {
                l.getWorld().dropItemNaturally(l, infectedHeart.getItem().clone());
                // Efeito visual de alma saindo do boss
                l.getWorld().spawnParticle(Particle.SOUL, l, 100, 0.5, 1, 0.5, 0.1);
            }

            new BukkitRunnable() {
                @Override
                public void run() {
                    cleanup(id);
                }
            }.runTaskLater(SourceFUN.getInstance(), 1L);
        }
    }

    private static void updateBossBar(UUID id, double currentHP) {
        BossBar bar = bossBars.get(id);
        if (bar != null) {
            bar.setProgress(Math.max(0, Math.min(1.0, currentHP / MAX_REAL_HEALTH)));
            bar.setTitle("§d§lCorrupted Warden §e" + (int)currentHP + " HP");
        }
    }

    private static void cleanup(UUID id) {
        liveBosses.remove(id);
        if (bossBars.containsKey(id)) {
            bossBars.get(id).removeAll();
            bossBars.remove(id);
        }
    }

    @EventHandler
    public void onChunkUnload(ChunkUnloadEvent event) {
        for (Entity entity : event.getChunk().getEntities()) {
            if (entity instanceof Warden && entity.getCustomName() != null && entity.getCustomName().contains("Corrupted Warden")) {
                cleanup(entity.getUniqueId());
                entity.remove();
            }
        }
    }
}