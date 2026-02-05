package me.JOTTA.SourceFUN;

import me.JOTTA.SourceFUN.items.ItemsSetup;
import me.JOTTA.SourceFUN.items.groups.SourceFUNItemGroups;
import me.JOTTA.SourceFUN.items.literners.WardenDropListener;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;

public class SourceFUN extends JavaPlugin implements SlimefunAddon {

    private static SourceFUN instance;

    @Override
    public void onEnable() {
        instance = this;
        getLogger().info("§a[SourceFUN] Iniciando...");

        try {

            SourceFUNItemGroups.setup(this);


            ItemsSetup.setup(this);
            getServer().getPluginManager().registerEvents(new WardenDropListener(), this);

            getLogger().info("""
                    *******************************
                    -------------------------------
                    SOURCEFUN
                    -------------------------------
                    *******************************""");



        } catch (Exception e) {
            getLogger().severe("§c[SourceFUN] Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("§c[SourceFUN] Desativado.");
    }

    // IMPORTANTE: Só retorna instance DEPOIS de onEnable()
    public static SourceFUN getInstance() {
        return instance;  // Pode ser null se chamado ANTES de onEnable()
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

    @Override
    public String getBugTrackerURL() {
        return null;
    }
}