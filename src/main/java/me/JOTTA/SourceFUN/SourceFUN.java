package me.JOTTA.SourceFUN;

import me.JOTTA.SourceFUN.items.ItemsSetup;
import me.JOTTA.SourceFUN.items.bosses.WardenBoss;
import me.JOTTA.SourceFUN.items.groups.SourceFUNItemGroups;
import me.JOTTA.SourceFUN.items.literners.WardenDropListener;
import org.bukkit.plugin.java.JavaPlugin;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;

public class SourceFUN extends JavaPlugin implements SlimefunAddon {

    private static SourceFUN instance;

    @Override
    public void onEnable() {
        instance = this;

        try {
            // 1. Grupos de Itens
            SourceFUNItemGroups.setup(this);

            // 2. Setup de Itens (Define os itens na memória)
            ItemsSetup.setup(this);

            // 3. Registro dos Listeners (Eventos)
            getServer().getPluginManager().registerEvents(new WardenBoss(), this);
            getServer().getPluginManager().registerEvents(new WardenDropListener(), this);

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