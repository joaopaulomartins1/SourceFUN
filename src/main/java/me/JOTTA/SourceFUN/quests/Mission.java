package me.JOTTA.SourceFUN.quests;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Representa uma missão (quest) do SourceFUN.
 * Use Mission.builder(...) pra criar uma nova.
 */
public class Mission {

    private final String id;
    private final String name;
    private final List<String> lore;
    private final boolean hidden;
    private final String category;
    private final MissionType type;
    private final int requiredAmount;

    // BLOCK_BREAK
    private final Material blockMaterial;
    private final String requiredToolId; // id do item Slimefun exigido como ferramenta (null = qualquer)

    // SLIMEFUN_CRAFT / MACHINE_USE / MACHINE_HARVEST / ITEM_DELIVER
    private final String slimefunItemId;

    // KILL_MOB
    private final EntityType entityType;

    private final List<ItemStack> rewards;

    private Mission(Builder b) {
        this.id = b.id;
        this.name = b.name;
        this.lore = Collections.unmodifiableList(new ArrayList<>(b.lore));
        this.hidden = b.hidden;
        this.category = b.category;
        this.type = b.type;
        this.requiredAmount = b.requiredAmount;
        this.blockMaterial = b.blockMaterial;
        this.requiredToolId = b.requiredToolId;
        this.slimefunItemId = b.slimefunItemId;
        this.entityType = b.entityType;
        this.rewards = Collections.unmodifiableList(new ArrayList<>(b.rewards));
    }

    public static Builder builder(String id, MissionType type) {
        return new Builder(id, type);
    }

    // ---- getters ----
    public String getId() { return id; }
    public String getName() { return name; }
    public List<String> getLore() { return lore; }
    public boolean isHidden() { return hidden; }
    public String getCategory() { return category; }
    public MissionType getType() { return type; }
    public int getRequiredAmount() { return requiredAmount; }
    public Material getBlockMaterial() { return blockMaterial; }
    public String getRequiredToolId() { return requiredToolId; }
    public String getSlimefunItemId() { return slimefunItemId; }
    public EntityType getEntityType() { return entityType; }
    public List<ItemStack> getRewards() { return rewards; }

    public static class Builder {
        private final String id;
        private final MissionType type;
        private String name = "Missão sem nome";
        private final List<String> lore = new ArrayList<>();
        private boolean hidden = false;
        private String category = "geral";
        private int requiredAmount = 1;

        private Material blockMaterial;
        private String requiredToolId;
        private String slimefunItemId;
        private EntityType entityType;

        private final List<ItemStack> rewards = new ArrayList<>();

        private Builder(String id, MissionType type) {
            this.id = id;
            this.type = type;
        }

        /** Nome exibido da missão na GUI. */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /** Lore/descrição da missão (cada string = uma linha). */
        public Builder lore(String... lines) {
            Collections.addAll(this.lore, lines);
            return this;
        }

        public Builder lore(List<String> lines) {
            this.lore.addAll(lines);
            return this;
        }

        /** Se true, a missão fica oculta na GUI até ser desbloqueada/liberada manualmente. */
        public Builder hidden(boolean hidden) {
            this.hidden = hidden;
            return this;
        }

        /** Categoria/grupo da missão (ex: "iniciais", "intermediarias", "especificas"). Usada pra organizar a GUI. */
        public Builder category(String category) {
            this.category = category;
            return this;
        }

        /** Quantidade necessária (blocos quebrados, itens craftados, mobs mortos...). */
        public Builder amount(int amount) {
            this.requiredAmount = amount;
            return this;
        }

        /** Para BLOCK_BREAK: qual bloco deve ser quebrado. */
        public Builder block(Material material) {
            this.blockMaterial = material;
            return this;
        }

        /** Para BLOCK_BREAK: id do item Slimefun exigido como ferramenta (null = aceita qualquer ferramenta). */
        public Builder tool(String slimefunToolId) {
            this.requiredToolId = slimefunToolId;
            return this;
        }

        /** Para SLIMEFUN_CRAFT / MACHINE_USE / MACHINE_HARVEST / ITEM_DELIVER: id do item/máquina Slimefun. */
        public Builder slimefunId(String slimefunItemId) {
            this.slimefunItemId = slimefunItemId;
            return this;
        }

        /** Para KILL_MOB: tipo da entidade a ser morta. */
        public Builder mob(EntityType entityType) {
            this.entityType = entityType;
            return this;
        }

        /** Adiciona um item de recompensa. */
        public Builder reward(ItemStack item) {
            this.rewards.add(item);
            return this;
        }

        public Mission build() {
            return new Mission(this);
        }
    }
}