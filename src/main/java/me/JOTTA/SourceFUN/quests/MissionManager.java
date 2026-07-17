package me.JOTTA.SourceFUN.quests;

import org.bukkit.entity.Player;

import java.util.*;
import java.util.stream.Collectors;

public class MissionManager {

    private static final Map<String, Mission> missions = new LinkedHashMap<>();
    private static final Map<UUID, PlayerMissionData> playerData = new HashMap<>();

    private MissionManager() {}

    // ---- registro de missões (chamado pelos *Setup.java de cada categoria) ----
    public static void register(Mission mission) {
        missions.put(mission.getId(), mission);
    }

    public static Mission get(String id) {
        return missions.get(id);
    }

    public static Collection<Mission> getAll() {
        return missions.values();
    }

    public static List<Mission> getByCategory(String category) {
        return missions.values().stream()
                .filter(m -> m.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    // ---- dados do jogador ----
    public static PlayerMissionData getData(UUID uuid) {
        return playerData.computeIfAbsent(uuid, PlayerMissionData::new);
    }

    public static PlayerMissionData getData(Player player) {
        return getData(player.getUniqueId());
    }

    public static void unload(UUID uuid) {
        playerData.remove(uuid);
    }

    /**
     * Aplica progresso a todas as missões de um tipo que combinem com o alvo (targetKey),
     * pro jogador informado. Retorna a lista de missões que acabaram de ser completadas agora.
     * targetKey depende do tipo: Material.name(), EntityType.name() ou slimefunItemId.
     */
    public static List<Mission> progress(Player player, MissionType type, String targetKey, String toolId, int amount) {
        List<Mission> justCompleted = new ArrayList<>();
        PlayerMissionData data = getData(player);

        for (Mission mission : missions.values()) {
            if (mission.getType() != type) continue;
            if (!matchesTarget(mission, type, targetKey)) continue;
            if (type == MissionType.BLOCK_BREAK && mission.getRequiredToolId() != null
                    && !mission.getRequiredToolId().equalsIgnoreCase(toolId)) continue;

            MissionProgress progress = data.getProgress(mission.getId());
            if (progress.isCompleted()) continue;

            boolean completedNow = progress.addProgress(amount, mission.getRequiredAmount());
            if (completedNow) justCompleted.add(mission);
        }
        return justCompleted;
    }

    /** Overload pra missões que completam com 1 ação só (KILL_MOB, MACHINE_USE, SLIMEFUN_CRAFT com amount=1...). */
    public static List<Mission> progress(Player player, MissionType type, String targetKey) {
        return progress(player, type, targetKey, null, 1);
    }

    private static boolean matchesTarget(Mission mission, MissionType type, String targetKey) {
        switch (type) {
            case BLOCK_BREAK:
                return mission.getBlockMaterial() != null && mission.getBlockMaterial().name().equalsIgnoreCase(targetKey);
            case KILL_MOB:
                return mission.getEntityType() != null && mission.getEntityType().name().equalsIgnoreCase(targetKey);
            case SLIMEFUN_CRAFT:
            case MACHINE_USE:
            case MACHINE_HARVEST:
            case ITEM_DELIVER:
                return mission.getSlimefunItemId() != null && mission.getSlimefunItemId().equalsIgnoreCase(targetKey);
            default:
                return false;
        }
    }
}