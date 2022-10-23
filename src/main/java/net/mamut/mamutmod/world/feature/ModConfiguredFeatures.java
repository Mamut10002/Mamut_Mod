package net.mamut.mamutmod.world.feature;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import net.mamut.mamutmod.MamutMod;
import net.mamut.mamutmod.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;


public class ModConfiguredFeatures {

    public static final DeferredRegister<ConfiguredFeature<?, ?>> Configured_Features =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, MamutMod.MOD_ID);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> Overworld_mamutinium_ore = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.Mamutinium_Ore.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_Mamutinium_Ore.get().defaultBlockState())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> Mamutinium_ore = Configured_Features.register("mamutinium_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(Overworld_mamutinium_ore.get(), 3)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> RED_TREE =
            Configured_Features.register("red_maple", () ->
                    new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(ModBlocks.Red_Log.get()),
                            new StraightTrunkPlacer(5, 6, 3),
                            BlockStateProvider.simple(ModBlocks.Red_Leaves.get()),
                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                            new TwoLayersFeatureSize(1, 0, 2)).dirt(BlockStateProvider.simple(Blocks.END_STONE)).build()));

    public static final RegistryObject<ConfiguredFeature<?, ?>> RED_TREE_SPAWN =
            Configured_Features.register("red_tree_spawn", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
                            ModPlacedFeatures.RED_TREE_CHECKED.getHolder().get(),
                            0.5F)), ModPlacedFeatures.RED_TREE_CHECKED.getHolder().get())));

    public static void register(IEventBus eventBus){
        Configured_Features.register(eventBus);
    }

    
}
