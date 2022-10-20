package net.mamut.mamutmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;

public class ModSaplingBlock extends SaplingBlock {
    public ModSaplingBlock(AbstractTreeGrower abstractTreeGrower, Properties properties) {
        super(abstractTreeGrower, properties);
    }

    @Override
    protected boolean mayPlaceOn(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        //return blockState.is(ModBlocks.);
        return true;
    }
}
