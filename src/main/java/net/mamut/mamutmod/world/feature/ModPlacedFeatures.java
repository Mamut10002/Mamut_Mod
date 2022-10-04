package net.mamut.mamutmod.world.feature;

import net.mamut.mamutmod.MamutMod;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {

    public static final DeferredRegister<PlacedFeature> Placed_Feature =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, MamutMod.MOD_ID);



    public static final RegistryObject<PlacedFeature> ZIRCON_ORE_PLACED = Placed_Feature.register("mamutinium_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.Mamutinium_ore.getHolder().get(),
                    commonOrePlacement(3, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-50)))));
    

    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    public static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }

    public static void register(IEventBus eventBus){
        Placed_Feature.register(eventBus);
    }

}
