package net.mamut.mamutmod.entity.client;

import net.mamut.mamutmod.MamutMod;
import net.mamut.mamutmod.entity.custom.MamutiniumGolemEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MamutiniumGolemModel extends AnimatedGeoModel<MamutiniumGolemEntity> {
    @Override
    public ResourceLocation getModelResource(MamutiniumGolemEntity object) {
        return new ResourceLocation(MamutMod.MOD_ID, "geo/mamutiniumgolem.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MamutiniumGolemEntity object) {
        return new ResourceLocation(MamutMod.MOD_ID, "textures/entity/mamutiniumgolem.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MamutiniumGolemEntity animatable) {
        return new ResourceLocation(MamutMod.MOD_ID, "animations/mamutiniumgolem.animation.json");
    }
}
