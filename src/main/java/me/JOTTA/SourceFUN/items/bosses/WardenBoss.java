package me.JOTTA.SourceFUN.items.bosses;

import me.JOTTA.SourceFUN.SourceFUN;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
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

    public static void spawn(@Nonnull SourceFUN plugin, @Nonnull Location loc) {
        // 1. Chunk Loader Ambulante para evitar bug de imortalidade
        Chunk chunk = loc.getChunk();
        chunk.setForceLoaded(true);

        Warden boss = (Warden) loc.getWorld().spawnEntity(loc, EntityType.WARDEN);
        boss.setAI(false);
        boss.setTarget(null);

        boss.setCustomName("§d§lCorrupted Warden");
        boss.setCustomNameVisible(true);

        // Vida base para o motor do Minecraft
        boss.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(2000.0);
        boss.setHealth(2000.0);

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
                    // Se o boss sumir antes do tempo, limpa o chunk loader
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
                        boss.getWorld().spawnParticle(Particle.EXPLOSION_LARGE, randLoc, 1);
                        boss.getWorld().strikeLightningEffect(randLoc);
                    }
                }

                if (timer == 500) {
                    // Ritual acabou: desativa chunk loader e libera o boss
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
                }
            }
        }.runTaskTimer(plugin, 0L, 1L);
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onDamage(EntityDamageByEntityEvent e) {
        if (!(e.getEntity() instanceof Warden)) return;
        UUID id = e.getEntity().getUniqueId();

        if (liveBosses.containsKey(id)) {
            double damage = e.getFinalDamage();
            double currentHP = liveBosses.get(id);
            double newHP = currentHP - damage;

            // Cancela dano real para manter os 70k
            e.setDamage(0);

            if (newHP <= 0) {
                liveBosses.put(id, 0.0);
                updateBossBar(id, 0);
                ((Warden) e.getEntity()).setHealth(0); // Dispara o EntityDeathEvent
            } else {
                liveBosses.put(id, newHP);
                updateBossBar(id, newHP);
                e.getEntity().playEffect(EntityEffect.HURT);
            }
        }
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onDeath(EntityDeathEvent e) {
        UUID id = e.getEntity().getUniqueId();
        if (liveBosses.containsKey(id)) {
            Location l = e.getEntity().getLocation();
            l.getWorld().playSound(l, Sound.ENTITY_WITHER_DEATH, 3f, 0.5f);

            // IMPORTANTE: Cleanup atrasado em 1 tick para permitir que
            // outros Listeners (Drops) reconheçam o ID do Boss antes dele sumir.
            new BukkitRunnable() {
                @Override
                public void run() {
                    cleanup(id);
                }
            }.runTaskLater(SourceFUN.getInstance(), 1L);
        }
    }

    @EventHandler
    public void onPlayerMove(org.bukkit.event.player.PlayerMoveEvent e) {
        Player player = e.getPlayer();
        for (UUID id : liveBosses.keySet()) {
            Entity entity = Bukkit.getEntity(id);
            if (entity != null && entity.getWorld().equals(player.getWorld())) {
                double distance = entity.getLocation().distance(player.getLocation());
                BossBar bar = bossBars.get(id);

                if (bar != null) {
                    if (distance <= 50.0 && !bar.getPlayers().contains(player)) {
                        bar.addPlayer(player);
                    } else if (distance > 60.0 && bar.getPlayers().contains(player)) {
                        bar.removePlayer(player);
                    }
                }
            }
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
                entity.remove();
            }
        }
    }
}