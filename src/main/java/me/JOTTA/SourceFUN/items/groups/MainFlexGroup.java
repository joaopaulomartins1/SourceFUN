package me.JOTTA.SourceFUN.items.groups;

import io.github.thebusybiscuit.slimefun4.api.items.groups.FlexItemGroup;
import io.github.thebusybiscuit.slimefun4.api.player.PlayerProfile;
import io.github.thebusybiscuit.slimefun4.core.guide.SlimefunGuideMode;
import io.github.thebusybiscuit.slimefun4.core.guide.SlimefunGuide;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import javax.annotation.Nonnull;

public class MainFlexGroup extends FlexItemGroup {

    public MainFlexGroup(NamespacedKey key, CustomItemStack item) {
        super(key, item);
    }

    @Override
    public boolean isVisible(@Nonnull Player p, @Nonnull PlayerProfile profile, @Nonnull SlimefunGuideMode mode) {
        return true;
    }

    @Override
    public void open(@Nonnull Player player, @Nonnull PlayerProfile profile, @Nonnull SlimefunGuideMode mode) {
        ChestMenu menu = new ChestMenu("§6SourceFUN");

        for (int i = 0; i < 54; i++) {
            menu.addItem(i, ChestMenuUtils.getBackground(), ChestMenuUtils.getEmptyClickHandler());
        }

        // Slot 20 - MÁQUINAS
        menu.addItem(20, new CustomItemStack(Material.FURNACE, "§x§5§4§D§A§F§4M§x§5§4§C§8§E§Bá§x§5§4§B§7§E§2q§x§5§4§A§5§D§9u§x§5§4§9§3§D§1i§x§5§4§8§1§C§8n§x§5§4§7§0§B§Fa§x§5§4§5§E§B§6s"), (p, slot, item, action) -> {
            if (SourceFUNItemGroups.MACHINES != null) {
                profile.getGuideHistory().add(this, 1);
                SlimefunGuide.openItemGroup(profile, SourceFUNItemGroups.MACHINES, mode, 1);
            }
            return false;
        });

        // Slot 28 - RECURSOS
        menu.addItem(28, new CustomItemStack(Material.NETHER_BRICK, "§x§5§4§D§A§F§4R§x§5§4§C§B§E§Ce§x§5§4§B§B§E§5c§x§5§4§A§C§D§Du§x§5§4§9§C§D§5r§x§5§4§8§D§C§Ds§x§5§4§7§D§C§6o§x§5§4§6§E§B§Es"), (p, slot, item, action) -> {
            if (SourceFUNItemGroups.RESOURCES != null) {
                profile.getGuideHistory().add(this, 1);
                SlimefunGuide.openItemGroup(profile, SourceFUNItemGroups.RESOURCES, mode, 1);
            }
            return false;
        });

        // Slot 30 - FERRAMENTAS (CORRIGIDO)
        menu.addItem(30, new CustomItemStack(Material.DIAMOND_PICKAXE, "§x§5§4§D§A§F§4F§x§5§4§D§3§F§1e§x§5§4§C§C§E§Er§x§5§4§C§5§E§Ar§x§5§4§B§E§E§7a§x§5§4§B§7§E§3m§x§5§4§A§F§E§0e§x§5§4§A§8§D§Cn§x§5§4§A§1§D§9t§x§5§4§9§A§D§5a§x§5§4§9§3§D§2s"), (p, slot, item, action) -> {
            if (SourceFUNItemGroups.TOOLS != null) {
                profile.getGuideHistory().add(this, 1);
                SlimefunGuide.openItemGroup(profile, SourceFUNItemGroups.TOOLS, mode, 1);
            }
            return false;
        });
        menu.addItem(22, new CustomItemStack(Material.BLACK_CANDLE, "§x§3§B§0§4§0§4B§x§3§E§0§D§3§Bo§x§4§0§1§7§7§2s§x§4§3§2§0§A§9s§x§2§D§1§D§B§1e§x§1§6§1§A§B§8s"), (p, slot, item, action) -> {
            if (SourceFUNItemGroups.BOSSES != null) {
                profile.getGuideHistory().add(this, 1);
                SlimefunGuide.openItemGroup(profile, SourceFUNItemGroups.BOSSES, mode, 1);
            }
            return false;
        });

        // Slot 52 - DISCORD
        menu.addItem(52, new CustomItemStack(Material.BOOK, "§x§2§5§0§0§A§CDiscord", "§x§3§3§3§2§3§7Clique aqui para acessar nosso discord"), (p, slot, item, action) -> {
            String discordLink = "https://discord.sourcemc.com.br/";
            net.md_5.bungee.api.chat.TextComponent message = new net.md_5.bungee.api.chat.TextComponent(discordLink);
            message.setUnderlined(true);
            message.setClickEvent(new net.md_5.bungee.api.chat.ClickEvent(net.md_5.bungee.api.chat.ClickEvent.Action.OPEN_URL, discordLink));

            p.spigot().sendMessage(message);
            p.playSound(p.getLocation(), org.bukkit.Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.5f, 1f);
            return false;
        });

        // Slot 45 - VOLTAR AO SLIMEFUN
        menu.addItem(45, new CustomItemStack(Material.BARRIER, "§cVoltar ao Slimefun", "", "§7Clique para voltar ao guia principal"), (p, slot, item, action) -> {
            SlimefunGuide.openMainMenu(profile, mode, 1);
            return false;
        });

        // Slot 53 - INFORMAÇÃO (CORRIGIDO)
        menu.addItem(53, new CustomItemStack(Material.DIAMOND_AXE, "§x§2§5§0§0§A§CSo§x§4§0§1§1§B§Aur§x§5§A§2§2§C§8ce§x§5§3§1§8§D§0MC", "§x§3§3§3§2§3§7Em desenvolvimento, caso tenha ideias mande no nosso discord."),
                ChestMenuUtils.getEmptyClickHandler());

        menu.open(player);
    }
}