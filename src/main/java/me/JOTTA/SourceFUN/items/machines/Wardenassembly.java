package me.JOTTA.SourceFUN.items.machines;

import javax.annotation.ParametersAreNonnullByDefault;

import io.github.thebusybiscuit.slimefun4.implementation.items.electric.machines.entities.AbstractEntityAssembler;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Warden;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;

import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;

public class Wardenassembly extends AbstractEntityAssembler<Warden> {

    @ParametersAreNonnullByDefault
    public Wardenassembly(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public int getCapacity() {
        return 8192;
    }

    @Override
    public int getEnergyConsumption() {
        return 4096;
    }

    @Override
    public ItemStack getHead() {
        return new ItemStack(Material.REINFORCED_DEEPSLATE, 2); // Cabeça do Warden
    }

    @Override
    public Material getHeadBorder() {
        return Material.BLACK_STAINED_GLASS_PANE;
    }

    @Override
    public ItemStack getBody() {
    return new ItemStack(Material.NETHER_STAR, 2); // Corpo do Warden
    }

    @Override
    public Material getBodyBorder() {
        return Material.CYAN_STAINED_GLASS_PANE;
    }

    @Override
    protected void constructMenu(BlockMenuPreset preset) {
        preset.addItem(1, new CustomItemStack(getHead(),
                        "&5Sculk Catalyst Slot",
                        "",
                        "&fThis Slot accepts Sculk Catalysts"),
                ChestMenuUtils.getEmptyClickHandler());

        preset.addItem(7, new CustomItemStack(getBody(),
                        "&5Sculk Block Slot",
                        "",
                        "&fThis Slot accepts Sculk Blocks"),
                ChestMenuUtils.getEmptyClickHandler());

        preset.addItem(13, new CustomItemStack(Material.CLOCK,
                        "&7Cooldown: &b60 Seconds",
                        "",
                        "&fThis Machine takes 1 Minute to assemble a Warden!",
                        "&cBe careful, it's dangerous!"),
                ChestMenuUtils.getEmptyClickHandler());
    }

    @Override
    public Warden spawnEntity(Location l) {
        // Som de Warden (usa som de Sculk)
        l.getWorld().playSound(l, org.bukkit.Sound.BLOCK_SCULK_SENSOR_CLICKING, SoundCategory.BLOCKS, 1.0f, 0.5f);

        // Spawn do Warden
        Warden warden = l.getWorld().spawn(l, Warden.class);

        // Dá alguns segundos de invulnerabilidade para não atacar imediatamente
        warden.setInvulnerable(true);

        // Agendador para remover invulnerabilidade após 3 segundos
        org.bukkit.Bukkit.getScheduler().runTaskLater(
                io.github.thebusybiscuit.slimefun4.implementation.Slimefun.instance(),
                () -> warden.setInvulnerable(false),
                60L // 3 segundos (20 ticks = 1 segundo)
        );

        return warden;
    }
}
