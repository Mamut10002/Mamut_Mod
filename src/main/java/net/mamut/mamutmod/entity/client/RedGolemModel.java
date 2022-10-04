package net.mamut.mamutmod.entity.client;

import net.mamut.mamutmod.MamutMod;
import net.mamut.mamutmod.entity.custom.RedGolemEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class RedGolemModel extends AnimatedGeoModel<RedGolemEntity> {
    @Override
    public ResourceLocation getModelResource(RedGolemEntity object) {
        return new ResourceLocation(MamutMod.MOD_ID, "geo/redgolem.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RedGolemEntity object) {
        return new ResourceLocation(MamutMod.MOD_ID, "textures/entity/redgolem_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(RedGolemEntity animatable) {
        return new ResourceLocation(MamutMod.MOD_ID, "animations/redgolem.animation.json");
    }
}
