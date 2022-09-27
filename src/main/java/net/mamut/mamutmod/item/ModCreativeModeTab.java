package net.mamut.mamutmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab MAMUT_TAB = new CreativeModeTab("mamuttab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.Mamutinium.get());
        }
    };
}
