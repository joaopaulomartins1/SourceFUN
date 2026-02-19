package me.JOTTA.SourceFUN.items.ItensSetup;

import me.JOTTA.SourceFUN.SourceFUN;

public class ItemsSetup {
    public static void setup(SourceFUN plugin) {
        // A ordem de execução é CRÍTICA aqui:
        ResourceSetup.setup(plugin); // Carrega os ingredientes primeiro
        MachineSetup.setup(plugin);  // Carrega as máquinas
        me.JOTTA.SourceFUN.items.setup.ToolSetup.setup(plugin);     // Carrega as ferramentas
        BossSetup.setup(plugin);     // Carrega os itens de Boss

        plugin.getLogger().info("§a[SourceFUN] Todos os sistemas modulares foram carregados!");
    }
}