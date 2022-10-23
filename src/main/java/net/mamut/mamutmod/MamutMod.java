package net.mamut.mamutmod;

import com.mojang.logging.LogUtils;
import net.mamut.mamutmod.block.ModBlocks;
import net.mamut.mamutmod.entity.ModEntityTypes;
import net.mamut.mamutmod.entity.client.GreatGolemRenderer;
import net.mamut.mamutmod.entity.client.MamutiniumGolemRenderer;
import net.mamut.mamutmod.entity.client.RangedGolemRenderer;
import net.mamut.mamutmod.entity.client.RedGolemRenderer;
import net.mamut.mamutmod.item.ModItems;
import net.mamut.mamutmod.world.feature.ModConfiguredFeatures;
import net.mamut.mamutmod.world.feature.ModPlacedFeatures;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MamutMod.MOD_ID)
public class MamutMod
{

    public static final String MOD_ID = "mamutmod";

    private static final Logger LOGGER = LogUtils.getLogger();

    public MamutMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModConfiguredFeatures.register(modEventBus);
        ModPlacedFeatures.register(modEventBus);

        ModEntityTypes.register(modEventBus);



        GeckoLib.initialize();

        
        modEventBus.addListener(this::commonSetup);
        
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            SpawnPlacements.register(ModEntityTypes.Red_Golem.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules);

            SpawnPlacements.register(ModEntityTypes.MamutiniumGolem.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkAnyLightMonsterSpawnRules);

            SpawnPlacements.register(ModEntityTypes.GreatGolem.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules);

            SpawnPlacements.register(ModEntityTypes.RANGEDGOLEM.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules);

        });
       
    }


    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(final FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntityTypes.Red_Golem.get(), RedGolemRenderer::new);
            EntityRenderers.register(ModEntityTypes.MamutiniumGolem.get(), MamutiniumGolemRenderer::new);
            EntityRenderers.register(ModEntityTypes.GreatGolem.get(), GreatGolemRenderer::new);
            EntityRenderers.register(ModEntityTypes.RANGEDGOLEM.get(), RangedGolemRenderer::new);




        }
    }
}
