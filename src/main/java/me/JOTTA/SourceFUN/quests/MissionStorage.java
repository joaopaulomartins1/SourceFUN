package me.JOTTA.SourceFUN.quests;

import me.JOTTA.SourceFUN.SourceFUN;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class MissionStorage {

    private static File folder;

    private static File folder() {
        if (folder == null) {
            folder = new File(SourceFUN.getInstance().getDataFolder(), "missions");
            if (!folder.exists()) folder.mkdirs();
        }
        return folder;
    }

    public static void load(UUID uuid) {
        File file = new File(folder(), uuid + ".yml");
        PlayerMissionData data = MissionManager.getData(uuid);

        if (!file.exists()) return;

        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        ConfigurationSection section = cfg.getConfigurationSection("missions");
        if (section == null) return;

        for (String missionId : section.getKeys(false)) {
            int current = section.getInt(missionId + ".current", 0);
            boolean completed = section.getBoolean(missionId + ".completed", false);
            boolean claimed = section.getBoolean(missionId + ".claimed", false);
            data.setProgress(missionId, new MissionProgress(current, completed, claimed));
        }
    }

    public static void save(UUID uuid) {
        PlayerMissionData data = MissionManager.getData(uuid);
        File file = new File(folder(), uuid + ".yml");

        YamlConfiguration cfg = new YamlConfiguration();
        for (var entry : data.getAll().entrySet()) {
            String path = "missions." + entry.getKey();
            MissionProgress p = entry.getValue();
            cfg.set(path + ".current", p.getCurrent());
            cfg.set(path + ".completed", p.isCompleted());
            cfg.set(path + ".claimed", p.isRewardClaimed());
        }

        try {
            cfg.save(file);
        } catch (IOException e) {
            SourceFUN.getInstance().getLogger().severe("§c[SourceFUN] Erro ao salvar missões de " + uuid + ": " + e.getMessage());
        }
    }
}