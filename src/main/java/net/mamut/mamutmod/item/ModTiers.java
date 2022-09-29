package net.mamut.mamutmod.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static final ForgeTier Mamutinium = new ForgeTier(5, 2561, 15f,
            0f, 22, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.Mamutinium.get()));
    public static final ForgeTier Mamutininium = new ForgeTier(6, 5000, 18f,
            0f, 30, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.Mamutininium.get()));
}
