package me.JOTTA.SourceFUN.quests;

import me.JOTTA.SourceFUN.quests.iniciante.InicialQuests;

/**
 * Ponto único de entrada pra registrar todas as categorias de missões.
 * Chame QuestsSetup.setup() uma vez no onEnable() do SourceFUN.java.
 */
public class QuestsSetup {

    public static void setup() {
        InicialQuests.setup();

        // conforme for criando novas categorias, registra aqui também:
        // IntermediariaQuests.setup();
        // EspecificaQuests.setup();
    }
}