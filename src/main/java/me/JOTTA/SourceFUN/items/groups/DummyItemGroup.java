package me.JOTTA.SourceFUN.items.groups;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.NamespacedKey;

public class DummyItemGroup extends ItemGroup {

    public DummyItemGroup(NamespacedKey key, CustomItemStack item) {
        // Usamos um Tier negativo ou muito alto se necessário,
        // mas o truque principal está no registro.
        super(key, item, 3);
    }

    // Sobrescrevemos o registro para garantir que ele não entre na lista visual
    @Override
    public void register(io.github.thebusybiscuit.slimefun4.api.SlimefunAddon addon) {
        // Não chamamos o super.register(addon) aqui.
        // Isso impede que ele seja adicionado à lista global de visibilidade.
    }
}