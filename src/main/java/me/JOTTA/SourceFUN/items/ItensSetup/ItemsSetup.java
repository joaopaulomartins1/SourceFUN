package me.JOTTA.SourceFUN.items.ItensSetup;

import me.JOTTA.SourceFUN.SourceFUN;

public class ItemsSetup {
    public static void setup(SourceFUN plugin) {

        ResourceSetup.setup(plugin); // Carrega os ingredientes primeiro
        MachineSetup.setup(plugin);  // Carrega as máquinas
        ToolSetup.setup(plugin);     // Carrega as ferramentas
        BossSetup.setup(plugin);     // Carrega os itens de Boss

        plugin.getLogger().info("§a[SourceFUN] TODOS OS ITENS DESSA BAGAÇA FORAM CARREGADOS");
    }
}