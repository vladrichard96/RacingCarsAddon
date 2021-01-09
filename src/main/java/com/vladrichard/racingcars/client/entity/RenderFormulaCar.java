package com.vladrichard.racingcars.entity.vehicle;

import com.mrcrayfish.vehicle.client.render.RenderLandVehicle;
import com.mrcrayfish.vehicle.client.render.Wheel;
import com.mrcrayfish.vehicle.client.render.Wheel.Position;
import com.mrcrayfish.vehicle.client.render.Wheel.Side;
import com.mrcrayfish.vehicle.entity.EntityLandVehicle;
import com.mrcrayfish.vehicle.entity.EntityPoweredVehicle;
import com.vladrichard.racingcars.entity.EntityFormulaCar;
import com.vladrichard.racingcars.net.proxy.ClientProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

private static void registerEntitiesStatic() {
List<com.mrcrayfish.vehicle.client.EntityRaytracer.MatrixTransformation> formulaCarTransformGlobal = new ArrayList();
createBodyTransforms(formulaCarTransformGlobal, EntityFormulaCar.class);
HashMap<com.mrcrayfish.vehicle.client.EntityRaytracer.RayTracePart, List<com.mrcrayfish.vehicle.client.EntityRaytracer.MatrixTransformation» formulaCarParts = Maps.newHashMap();
createTransformListForPart((SpecialModels)SpecialModels.FORMULA_CAR_BODY, formulaCarParts, formulaCarTransformGlobal);
createTransformListForPart((SpecialModels)SpecialModels.FORMULA_CAR_STEERING_WHEEL, formulaCarParts, formulaCarTransformGlobal, com.mrcrayfish.vehicle.client.EntityRaytracer.MatrixTransformation.createRotation(-90.0D, 1.0D, 0.0D, 0.0D), com.mrcrayfish.vehicle.client.EntityRaytracer.MatrixTransformation.createTranslation(0.0D, -0.02D, 0.0D), com.mrcrayfish.vehicle.client.EntityRaytracer.MatrixTransformation.createScale(0.9D));
createFuelablePartTransforms((SpecialModels)SpecialModels.FUEL_PORT_CLOSED, EntityFormulaCar.class, formulaCarParts, formulaCarTransformGlobal);
registerEntityStatic(EntityFormulaCar.class, formulaCarParts);
}