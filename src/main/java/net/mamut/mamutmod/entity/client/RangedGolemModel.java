package net.mamut.mamutmod.entity.client;

import net.mamut.mamutmod.MamutMod;
import net.mamut.mamutmod.entity.custom.RangedGolemEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class RangedGolemModel extends AnimatedGeoModel<RangedGolemEntity> {
    @Override
    public ResourceLocation getModelResource(RangedGolemEntity object) {
        return new ResourceLocation(MamutMod.MOD_ID, "geo/rangedgolem.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RangedGolemEntity object) {
        return new ResourceLocation(MamutMod.MOD_ID, "textures/entity/rangedgolem.png");
    }

    @Override
    public ResourceLocation getAnimationResource(RangedGolemEntity animatable) {
        return new ResourceLocation(MamutMod.MOD_ID, "animations/rangedgolem.animation.json");
    }
}
