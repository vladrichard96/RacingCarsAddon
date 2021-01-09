package com.vladrichard.racingcars.entity.vehicle;

import com.vladrichard.racingcars.client.EntityRaytracer.IEntityRaytraceable;
import com.mrcrayfish.vehicle.entity.EngineType;
import com.mrcrayfish.vehicle.entity.EntityLandVehicle;
import com.mrcrayfish.vehicle.init.ModSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityFormulaCar extends EntityLandVehicle implements IEntityRaytraceable{
    public EntityFormulaCar(World worldIn) {
            super(worldIn);
            this.setMaxSpeed(22.0F);
            this.setTurnSensitivity(12);
            this.func_70105_a(1.5F, 0.5F);
            this.field_70138_W = 0.625F;
            this.setFuelConsumption(0.75F);
    }

    public void func_70108_f(Entity entityIn) {
        if (entityIn instanceof EntityFormulaCar && this.func_184207_aI()) {
            this.applyBumperCollision((EntityFormulaCar)entityIn);
        }

    }

    private void applyBumperCollision(EntityFormulaCar entity) {
        entity.field_70159_w += (double)(this.vehicleMotionX * 1.5F);
        entity.field_70179_y += (double)(this.vehicleMotionZ * 1.5F);
        this.field_70170_p.func_184148_a((EntityPlayer)null, this.field_70165_t, this.field_70163_u, this.field_70161_v, ModSounds.BONK, SoundCategory.NEUTRAL, 1.0F, 0.6F + 0.1F * this.getNormalSpeed());
        this.currentSpeed *= 0.6F;
    }

    public SoundEvent getMovingSound() {
            return ModSounds.GO_KART_ENGINE_MONO;
    }

    public SoundEvent getRidingSound() {
            return ModSounds.GO_KART_ENGINE_STEREO;
    }

    public EngineType getEngineType() {
            return EngineType.LARGE_MOTOR;
    }

    public float getMinEnginePitch() {
            return 0.8F;
    }

    public float getMaxEnginePitch() {
            return 1.6F;
    }

    public boolean canBeColored() {
        return true;
    }

    public boolean shouldRenderEngine() {
        return false;
    }

    public boolean shouldRenderFuelPort() {
        return true;
    }

    public boolean isLockable() {
        return false;
    }
}
