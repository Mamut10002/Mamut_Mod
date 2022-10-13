package net.mamut.mamutmod.block;

import net.mamut.mamutmod.MamutMod;
import net.mamut.mamutmod.block.custom.ModFlammableRotatedPillarBlock;
import net.mamut.mamutmod.block.custom.RedwheatCropBlock;
import net.mamut.mamutmod.item.ModCreativeModeTab;
import net.mamut.mamutmod.item.ModItems;
import net.mamut.mamutmod.world.feature.tree.RedTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
        DeferredRegister.create(ForgeRegistries.BLOCKS, MamutMod.MOD_ID);

    public static final RegistryObject<Block> Mamutinium_Block = registryBlock("mamutinium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.MAMUT_TAB);

    public static final RegistryObject<Block> Red_Log = registryBlock("red_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG))
            , ModCreativeModeTab.MAMUT_TAB);

    public static final RegistryObject<Block> Red_PLANKS = registryBlock("red_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }
            }, ModCreativeModeTab.MAMUT_TAB);
    public static final RegistryObject<Block> Red_Leaves = registryBlock("red_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 30;
                }
            }, ModCreativeModeTab.MAMUT_TAB);

    public static final RegistryObject<Block> Red_Sapling = registryBlock("red_sapling",
            () -> new SaplingBlock(new RedTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModeTab.MAMUT_TAB);

    public static final RegistryObject<Block> Mamutinium_Ore = registryBlock("mamutinium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(5, 10)), ModCreativeModeTab.MAMUT_TAB);
    public static final RegistryObject<Block> DEEPSLATE_Mamutinium_Ore = registryBlock("deepslate_mamutinium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(7f).requiresCorrectToolForDrops(),
                    UniformInt.of(5, 10)), ModCreativeModeTab.MAMUT_TAB);

    public static final RegistryObject<Block> RedWheat_Crop = BLOCKS.register("redwheat_crop",
            () -> new RedwheatCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));
    
    
    private static <T extends Block>RegistryObject<T> registryBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registryBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registryBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab){
         return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }


}
