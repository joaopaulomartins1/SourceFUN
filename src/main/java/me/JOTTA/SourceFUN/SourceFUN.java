package me.JOTTA.SourceFUN;

import me.JOTTA.SourceFUN.items.ItensSetup.ItemsSetup;
import me.JOTTA.SourceFUN.items.bosses.WardenBoss;
import me.JOTTA.SourceFUN.items.groups.SourceFUNItemGroups;
import me.JOTTA.SourceFUN.items.literners.WardenDropListener;
import me.JOTTA.SourceFUN.quests.MissionListerner;
import org.bukkit.plugin.java.JavaPlugin;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;

public class SourceFUN extends JavaPlugin implements SlimefunAddon {

    private static SourceFUN instance;

    @Override
    public void onEnable() {
        instance = this;

        try {
            SourceFUNItemGroups.setup(this);


            ItemsSetup.setup(this);

            // 3. Registro dos Listeners (Eventos)
            getServer().getPluginManager().registerEvents(new WardenBoss(), this);
            getServer().getPluginManager().registerEvents(new WardenDropListener(), this);
            getServer().getPluginManager().registerEvents(new MissionListerner(), this);
            me.JOTTA.SourceFUN.quests.QuestsSetup.setup();
            getServer().getPluginManager().registerEvents(new me.JOTTA.SourceFUN.items.literners.RadiationProtectionListener(), this);

            getLogger().info("§a[SourceFUN] Plugin habilitado com sucesso!");

        } catch (Exception e) {
            getLogger().severe("§c[SourceFUN] Erro no carregamento: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static SourceFUN getInstance() { return instance; }
    @Override public JavaPlugin getJavaPlugin() { return this; }
    @Override public String getBugTrackerURL() { return null; }
}