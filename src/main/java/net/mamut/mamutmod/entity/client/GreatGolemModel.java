package net.mamut.mamutmod.entity.client;

import net.mamut.mamutmod.MamutMod;
import net.mamut.mamutmod.entity.custom.GreatGolemEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GreatGolemModel extends AnimatedGeoModel<GreatGolemEntity> {
    @Override
    public ResourceLocation getModelResource(GreatGolemEntity object) {
        return new ResourceLocation(MamutMod.MOD_ID, "geo/greatgolem.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GreatGolemEntity object) {
        return new ResourceLocation(MamutMod.MOD_ID, "textures/entity/greatgolem.png");
    }
    
    @Override
    public ResourceLocation getAnimationResource(GreatGolemEntity animatable) {
        return new ResourceLocation(MamutMod.MOD_ID, "animations/greatgolem.animation.json");
    }
}
