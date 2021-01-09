package com.vladrichard.racingcars.entity.vehicle;

import com.mrcrayfish.vehicle.VehicleConfig;
import com.mrcrayfish.vehicle.client.render.Wheel;
import com.mrcrayfish.vehicle.client.render.Wheel.Position;
import com.mrcrayfish.vehicle.client.render.Wheel.Side;
import com.mrcrayfish.vehicle.common.Seat;
import com.mrcrayfish.vehicle.common.entity.PartPosition;
import com.vladrichard.racingcars.entity.vehicle.EntityFormulaCar;
import javax.annotation.Nullable;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.common.Loader;

public class VehicleProperties {
    public static void register(){
        com.mrcrayfish.vehicle.entity.VehicleProperties properties = new com.mrcrayfish.vehicle.entity.VehicleProperties();
        properties.setAxleOffset(-0.5F);
        properties.setWheelOffset(4.45F);
        properties.setBodyPosition(new PartPosition(2.2D));
        properties.setFuelPortPosition(new PartPosition(-13.0D, 3.5D, -6.0D, 0.0D, -90.0D, 0.0D, 0.25D));
        properties.setHeldOffset(new Vec3d(1.5D, 2.5D, 0.0D));
        properties.setDisplayPosition(new PartPosition(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 1.25D));
        properties.addWheel(Side.LEFT, Position.FRONT, 9.0F, 16.0F, 1.75F, false, true);
        properties.addWheel(Side.RIGHT, Position.FRONT, 9.0F, 16.0F, 1.75F, false, true);
        properties.addWheel(Side.LEFT, Position.REAR, 9.0F, -12.5F, 1.75F, true, true);
        properties.addWheel(Side.RIGHT, Position.REAR, 9.0F, -12.5F, 1.75F, true, true);
        properties.setFrontAxelVec(0.0D, 16.0D);
        properties.setRearAxelVec(0.0D, -12.5D);
        properties.addSeat(new Seat(new Vec3d(5.5D, 5.0D, -6.0D), true));
        com.mrcrayfish.vehicle.entity.VehicleProperties.setProperties((EntityType) ModEntities.FORMULA_CAR.get(), properties);
}
