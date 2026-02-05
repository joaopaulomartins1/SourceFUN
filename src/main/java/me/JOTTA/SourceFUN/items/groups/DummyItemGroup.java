package me.JOTTA.SourceFUN.items.groups;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.NamespacedKey;

public class DummyItemGroup extends ItemGroup {

    public DummyItemGroup(NamespacedKey key, CustomItemStack item) {
        super(key, item, 3);
    }

    @Override
    public void register(io.github.thebusybiscuit.slimefun4.api.SlimefunAddon addon) {
    }
}