package net.mamut.mamutmod.procedures;

import net.mamut.mamutmod.entity.ModEntityTypes;
import net.mamut.mamutmod.entity.custom.RangedGolemEntity;
import net.mamut.mamutmod.entity.custom.RedGolemEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;

public class GreatGolemEntitySpawnProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (world instanceof ServerLevel _level) {
            Entity entityToSpawn = new RedGolemEntity(ModEntityTypes.Red_Golem.get(), _level);
            entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
            if (entityToSpawn instanceof Mob _mobToSpawn)
                _mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
            world.addFreshEntity(entityToSpawn);
        }
        if (world instanceof ServerLevel _level) {
            Entity entityToSpawn = new RedGolemEntity(ModEntityTypes.Red_Golem.get(), _level);
            entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
            if (entityToSpawn instanceof Mob _mobToSpawn)
                _mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
            world.addFreshEntity(entityToSpawn);
        }
        if (world instanceof ServerLevel _level) {
            Entity entityToSpawn = new RedGolemEntity(ModEntityTypes.Red_Golem.get(), _level);
            entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
            if (entityToSpawn instanceof Mob _mobToSpawn)
                _mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
            world.addFreshEntity(entityToSpawn);
        }
        if (world instanceof ServerLevel _level) {
            Entity entityToSpawn = new RangedGolemEntity(ModEntityTypes.RANGEDGOLEM.get(), _level);
            entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
            if (entityToSpawn instanceof Mob _mobToSpawn)
                _mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
            world.addFreshEntity(entityToSpawn);
        }


    }

}
