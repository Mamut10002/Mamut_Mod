package net.mamut.mamutmod.event;

import net.mamut.mamutmod.MamutMod;
import net.mamut.mamutmod.entity.ModEntityTypes;
import net.mamut.mamutmod.entity.custom.RedGolemEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MamutMod.MOD_ID)
public class ModEvents {
    @Mod.EventBusSubscriber(modid = MamutMod.MOD_ID)

    public static class ForgeEvents {
        
    }


    @Mod.EventBusSubscriber(modid = MamutMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents {
        @SubscribeEvent 
        public static void entityAttributeEvent(EntityAttributeCreationEvent event){
            event.put(ModEntityTypes.Red_Golem.get(), RedGolemEntity.setAttributes());
        }
    }

}
