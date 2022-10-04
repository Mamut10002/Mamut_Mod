package net.mamut.mamutmod.world.feature;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import net.mamut.mamutmod.MamutMod;
import net.mamut.mamutmod.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
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



    public static void register(IEventBus eventBus){
        Configured_Features.register(eventBus);
    }

    
}
