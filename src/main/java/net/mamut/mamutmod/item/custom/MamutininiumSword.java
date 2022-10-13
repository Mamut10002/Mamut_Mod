package net.mamut.mamutmod.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class MamutininiumSword extends SwordItem {
    public MamutininiumSword(Tier tier, int p_43270_, float v, Properties properties) {
        super(tier, p_43270_, v, properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack itemStack, LivingEntity livingEntity, LivingEntity livingEntity1) {
        livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 400), livingEntity1);
        livingEntity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100), livingEntity1);
        return super.hurtEnemy(itemStack, livingEntity, livingEntity1);
    }
}
