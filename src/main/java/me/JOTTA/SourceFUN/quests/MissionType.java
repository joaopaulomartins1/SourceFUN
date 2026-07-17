package me.JOTTA.SourceFUN.quests;

public enum MissionType {

    // Quebrar um bloco específico (opcionalmente exigindo uma ferramenta Slimefun específica)
    BLOCK_BREAK,

    // Craftar / pegar um item do Slimefun na bancada
    SLIMEFUN_CRAFT,

    // Matar um mob específico
    KILL_MOB,

    // Usar uma multiblock do Slimefun (1 uso = completa)
    MACHINE_USE,

    // Entregar uma quantidade de itens numa GUI (sugestão, lógica plugável depois)
    ITEM_DELIVER,

    // Usar uma máquina várias vezes (sugestão, pra missões mais longas)
    MACHINE_HARVEST
}