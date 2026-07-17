package me.JOTTA.SourceFUN.items.SMG;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.Objects.handlers.BlockTicker;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.util.HashMap;

public class SimpleMaterialClass extends SlimefunItem {

    private final int ticksToGenerate;
    private final ItemStack outputItem;

    public SimpleMaterialClass(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, int ticks, ItemStack output) {
        super(itemGroup, item, recipeType, recipe);
        this.ticksToGenerate = ticks;
        this.outputItem = output;
    }

    @Override
    public void preRegister() {
        addItemHandler(new BlockTicker() {
            @Override
            public void tick(Block b, SlimefunItem item, Config data) {
                SimpleMaterialClass.this.tick(b);
            }

            @Override
            public boolean isSynchronized() {
                return true;
            }
        });
    }

    protected void tick(@Nonnull Block b) {
        Block targetBlock = b.getRelative(BlockFace.UP);
        BlockState state = targetBlock.getState();

        if (state instanceof InventoryHolder) {
            Inventory inv = ((InventoryHolder) state).getInventory();

            String data = BlockStorage.getLocationInfo(b.getLocation(), "progress");
            int progress = (data == null) ? 0 : Integer.parseInt(data);

            if (progress >= ticksToGenerate) {

                HashMap<Integer, ItemStack> sobra = inv.addItem(outputItem.clone());

                if (sobra.isEmpty()) {
                    BlockStorage.addBlockInfo(b, "progress", "0");
                }

            } else {
                BlockStorage.addBlockInfo(b, "progress", String.valueOf(progress + 1));
            }
        }
    }
}