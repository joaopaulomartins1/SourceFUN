package me.JOTTA.SourceFUN.quests;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerMissionData {

    private final UUID uuid;
    private final Map<String, MissionProgress> progressByMissionId = new HashMap<>();

    public PlayerMissionData(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuid() { return uuid; }

    public MissionProgress getProgress(String missionId) {
        return progressByMissionId.computeIfAbsent(missionId, id -> new MissionProgress());
    }

    public Map<String, MissionProgress> getAll() {
        return progressByMissionId;
    }

    /** Usado pelo MissionStorage ao carregar do disco. */
    public void setProgress(String missionId, MissionProgress progress) {
        progressByMissionId.put(missionId, progress);
    }
}