package net.mamut.mamutmod.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.animal.allay.Allay;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class RedGolemEntity extends Monster implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);


    public RedGolemEntity(EntityType<? extends Monster> pEntityType, Level level) {
        super(pEntityType, level);
    }

    public static AttributeSupplier setAttributes() {
        return Monster.createMobAttributes()
                
                .add(Attributes.MAX_HEALTH, 60.0D)
                .add(Attributes.ATTACK_DAMAGE, 15.0f)
                .add(Attributes.ATTACK_SPEED, 1.0f)
                .add(Attributes.ARMOR, 50.0D)
                .add(Attributes.FOLLOW_RANGE, 40)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1)
                .add(Attributes.ATTACK_KNOCKBACK, 2)
                .add(Attributes.MOVEMENT_SPEED, 0.2f).build();
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2D, false));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));




        
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this).setAlertOthers());
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Creeper.class, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, PatrollingMonster.class, true));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, AgeableMob.class, true));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, WaterAnimal.class, true));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, AbstractGolem.class, true));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, Allay.class, true));
        //this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, Monster.class, true));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, Blaze.class, true));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, Spider.class, true));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, WitherBoss.class, true));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, Giant.class, true));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, Warden.class, true));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, Vex.class, true));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, Guardian.class, true));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, EnderMan.class, true));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, Endermite.class, true));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, AbstractPiglin.class, true));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, Zoglin.class, true));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, Zombie.class, true));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, AbstractSkeleton.class, true));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, Creeper.class, true));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, Silverfish.class, true));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, EnderDragon.class, true));
    }


    

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (source.getDirectEntity() instanceof AbstractArrow)
            return false;
        if (source == DamageSource.FALL)
            return false;
        if (source == DamageSource.CACTUS)
            return false;
        if (source == DamageSource.ON_FIRE)
            return false;
        if (source == DamageSource.IN_FIRE)
            return false;
        return super.hurt(source, amount);
    }


    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.redgolem.walk", true));
            return PlayState.CONTINUE;
        }
        

        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.redgolem.idle", true));
        return PlayState.CONTINUE;
    }   
    private PlayState attackPredicate(AnimationEvent event) {
        if (this.swinging && event.getController().getAnimationState().equals(AnimationState.Stopped)){
            event.getController().markNeedsReload();
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.redgolem.attack", false));
            this.swinging =false;
        }
        
        return PlayState.CONTINUE;
    }
    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));
        data.addAnimationController(new AnimationController(this, "attackController",
                0, this::attackPredicate));
    }



    @Override
    public AnimationFactory getFactory() {
        return factory;
    }



    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.IRON_GOLEM_STEP, 0.15F, 1.0F);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.IRON_GOLEM_REPAIR;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.IRON_GOLEM_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.IRON_GOLEM_DEATH;
    }

    protected float getSoundVolume() {
        return 0.3F;
    }

}
