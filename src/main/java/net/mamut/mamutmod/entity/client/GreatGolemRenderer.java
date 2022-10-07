package net.mamut.mamutmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mamut.mamutmod.MamutMod;
import net.mamut.mamutmod.entity.custom.GreatGolemEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class GreatGolemRenderer extends GeoEntityRenderer<GreatGolemEntity> {
    public GreatGolemRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GreatGolemModel());
        this.shadowRadius = 0.5f;
    }

    @Override
    public ResourceLocation getTextureLocation(GreatGolemEntity instance) {
        return new ResourceLocation(MamutMod.MOD_ID, "textures/entity/greatgolem.png");
    }

    @Override
    public RenderType getRenderType(GreatGolemEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {

        
        
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
