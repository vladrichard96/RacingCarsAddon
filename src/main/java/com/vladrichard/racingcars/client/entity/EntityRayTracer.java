package com.vladrichard.racingcars.client.entity;

/**
 * Created by Влад on 08.01.2021.
 */
public class EntityRayTracer {
    private static void registerEntitiesStatic() {
        List<com.mrcrayfish.vehicle.client.EntityRaytracer.MatrixTransformation> formulaCarTransformGlobal = new ArrayList();
        createBodyTransforms(formulaCarTransformGlobal, EntityFormulaCar.class);
        HashMap<com.mrcrayfish.vehicle.client.EntityRaytracer.RayTracePart, List<com.mrcrayfish.vehicle.client.EntityRaytracer.MatrixTransformation» formulaCarParts = Maps.newHashMap();
        createTransformListForPart((SpecialModels)SpecialModels.FORMULA_CAR_BODY, formulaCarParts, formulaCarTransformGlobal);
        createTransformListForPart((SpecialModels)SpecialModels.FORMULA_CAR_STEERING_WHEEL, formulaCarParts, formulaCarTransformGlobal, com.mrcrayfish.vehicle.client.EntityRaytracer.MatrixTransformation.createRotation(-90.0D, 1.0D, 0.0D, 0.0D), com.mrcrayfish.vehicle.client.EntityRaytracer.MatrixTransformation.createTranslation(0.0D, -0.02D, 0.0D), com.mrcrayfish.vehicle.client.EntityRaytracer.MatrixTransformation.createScale(0.9D));
        createFuelablePartTransforms((SpecialModels)SpecialModels.FUEL_PORT_CLOSED, EntityFormulaCar.class, formulaCarParts, formulaCarTransformGlobal);
        registerEntityStatic(EntityFormulaCar.class, formulaCarParts);
    }
}
