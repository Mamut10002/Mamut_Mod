package net.mamut.mamutmod.entity;

import net.mamut.mamutmod.MamutMod;
import net.mamut.mamutmod.entity.custom.GreatGolemEntity;
import net.mamut.mamutmod.entity.custom.MamutiniumGolemEntity;
import net.mamut.mamutmod.entity.custom.RangedGolemEntity;
import net.mamut.mamutmod.entity.custom.RedGolemEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>>Entity_Types =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MamutMod.MOD_ID);

    public static final RegistryObject<EntityType<RedGolemEntity>> Red_Golem =
            Entity_Types.register("red_golem",
                    () -> EntityType.Builder.of(RedGolemEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.43f)
                            .build(new ResourceLocation(MamutMod.MOD_ID, "redgolem").toString()));

    public static final RegistryObject<EntityType<MamutiniumGolemEntity>> MamutiniumGolem =
            Entity_Types.register("mamutiniumgolem",
                    () -> EntityType.Builder.of(MamutiniumGolemEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.43f)
                            .build(new ResourceLocation(MamutMod.MOD_ID, "mamutiniumgolem").toString()));
     
    public static final RegistryObject<EntityType<GreatGolemEntity>> GreatGolem =
            Entity_Types.register("greatgolem",
                    () -> EntityType.Builder.of(GreatGolemEntity::new, MobCategory.MONSTER)
                            .sized(0.5f, 2.1f)
                            .build(new ResourceLocation(MamutMod.MOD_ID, "greatolem").toString()));

    public static final RegistryObject<EntityType<RangedGolemEntity>> RANGEDGOLEM =
            Entity_Types.register("rangedgolem",
                    () -> EntityType.Builder.of(RangedGolemEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.43f)
                            .build(new ResourceLocation(MamutMod.MOD_ID, "rangedgolem").toString()));
    
    public static void register(IEventBus eventBus){
        Entity_Types.register(eventBus);
    }
}
