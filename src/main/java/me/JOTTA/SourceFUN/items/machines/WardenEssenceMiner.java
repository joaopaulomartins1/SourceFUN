package me.JOTTA.SourceFUN.items.machines;

import io.github.bakedlibs.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.EnergyNetComponent;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.mrCookieSlime.Slimefun.Objects.handlers.BlockTicker;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

public class WardenEssenceMiner extends SlimefunItem implements EnergyNetComponent {

    // --- CONFIGURAÇÕES DA MÁQUINA ---
    private static final int STATUS_SLOT = 4;
    private static final int[] OUTPUT_SLOTS = { 29, 30, 31, 32, 33, 38, 39, 40, 41, 42 };
    private static final int REQUIRED_PROGRESS = 30;
    private final int energyConsumption = 4096;
    private final int capacity = 8024;

    // --- OTIMIZAÇÃO DE MEMÓRIA (CACHE DE UI) ---
    // Instanciamos esses itens apenas UMA VEZ ao ligar o servidor, poupando a RAM (Garbage Collector).
    private static final ItemStack UI_NO_ENERGY = new CustomItemStack(Material.RED_STAINED_GLASS_PANE, "&cEnergia Insuficiente!", "&7Precisa de: &e4096 J/t");
    private static final ItemStack UI_FULL = new CustomItemStack(Material.ORANGE_STAINED_GLASS_PANE, "&6Inventário Cheio!", "&7A máquina parou.");
    private static final ItemStack UI_LOADING = new CustomItemStack(Material.BLACK_STAINED_GLASS_PANE, "&8Carregando...");

    // Variável para o Lazy Loading da Essência
    private ItemStack cachedOutputItem;

    public WardenEssenceMiner(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
        setupMenu(); // Separamos a criação do menu para manter o construtor limpo
    }

    private void setupMenu() {
        new BlockMenuPreset(getId(), getItemName()) {
            @Override
            public void init() {
                int[] background = {0,1,2,3,5,6,7,8,9,10,11,12,13,14,15,16,17,18,26,27,35,36,44,45,53};
                for (int i : background) {
                    addItem(i, ChestMenuUtils.getBackground());
                    addMenuClickHandler(i, ChestMenuUtils.getEmptyClickHandler());
                }
                addItem(STATUS_SLOT, UI_LOADING);
                addMenuClickHandler(STATUS_SLOT, ChestMenuUtils.getEmptyClickHandler());
            }

            @Override
            public int[] getSlotsAccessedByItemTransport(ItemTransportFlow flow) {
                return flow == ItemTransportFlow.WITHDRAW ? OUTPUT_SLOTS : new int[0];
            }

            @Override
            public boolean canOpen(@Nonnull Block b, @Nonnull org.bukkit.entity.Player p) {
                return true;
            }
        };
    }

    @Override
    public void preRegister() {
        addItemHandler(new BlockTicker() {
            @SuppressWarnings("deprecation") // A única forma correta de silenciar a interface nativa
            @Override
            public void tick(Block b, SlimefunItem item, me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config data) {
                processMachineTick(b); // Delega a função para manter o Ticker extremamente enxuto
            }

            @Override
            public boolean isSynchronized() {
                return true;
            }
        });
    }

    // --- LÓGICA DE NEGÓCIO (O Cérebro da Máquina) ---

    /**
     * Lazy Loading: Só busca o item no Slimefun na primeira vez que a máquina rodar.
     * Evita problemas de "NullPointerException" se a máquina carregar antes do item.
     */
    private ItemStack getOutputItem() {
        if (cachedOutputItem == null) {
            SlimefunItem essence = SlimefunItem.getById("WARDEN_ESSENCE");
            cachedOutputItem = (essence != null) ? essence.getItem().clone() : new ItemStack(Material.SCULK);
        }
        return cachedOutputItem;
    }

    private void processMachineTick(Block b) {
        BlockMenu inv = BlockStorage.getInventory(b);
        if (inv == null) return;

        ItemStack output = getOutputItem();

        // 1. Verificação de Espaço
        if (!inv.fits(output, OUTPUT_SLOTS)) {
            updateVisualStatus(inv, UI_FULL);
            return;
        }

        // 2. Verificação de Energia
        if (getCharge(b.getLocation()) < energyConsumption) {
            updateVisualStatus(inv, UI_NO_ENERGY);
            return;
        }

        // 3. Processamento
        removeCharge(b.getLocation(), energyConsumption);
        int progress = getProgress(b);
        progress++;

        if (progress >= REQUIRED_PROGRESS) {
            inv.pushItem(output.clone(), OUTPUT_SLOTS);
            progress = 0;
        }

        saveProgress(b, progress);

        // 4. UI Dinâmica (Criamos o vidro verde animado apenas se alguém estiver olhando o baú)
        if (inv.hasViewer()) {
            ItemStack progressItem = new CustomItemStack(Material.LIME_STAINED_GLASS_PANE,
                    "&aMinerando...",
                    "&7Progresso: &f" + progress + "/" + REQUIRED_PROGRESS,
                    "&7Energia: &e" + energyConsumption + " J/t");
            inv.replaceExistingItem(STATUS_SLOT, progressItem);
        }
    }

    // --- MÉTODOS AUXILIARES ---

    private void updateVisualStatus(BlockMenu inv, ItemStack statusItem) {
        // Só atualiza o menu se tiver player vendo (Economiza TPS de envio de pacotes ao cliente)
        if (inv.hasViewer()) {
            inv.replaceExistingItem(STATUS_SLOT, statusItem);
        }
    }

    private int getProgress(Block b) {
        String saved = BlockStorage.getLocationInfo(b.getLocation(), "progress");
        if (saved == null) return 0;
        try {
            return Integer.parseInt(saved);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private void saveProgress(Block b, int progress) {
        BlockStorage.addBlockInfo(b, "progress", String.valueOf(progress));
    }

    @Nonnull
    @Override
    public EnergyNetComponentType getEnergyComponentType() {
        return EnergyNetComponentType.CONSUMER;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }
}