package com.vladrichard.racingcars.client.entity;

import com.mrcrayfish.vehicle.init.ModItems;
import com.mrcrayfish.vehicle.util.RenderUtil;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber(
        modid = "vehicle",
        value = {Side.CLIENT}
)
public class SpecialModels {
    FORMULA_CAR_BODY("f1car"),

    FORMULA_CAR_STEERING_WHEEL("f1steer");

    private static Item item;
    private ModelResourceLocation modelLocation;
    private boolean specialModel;
    @SideOnly(Side.CLIENT)
    private IBakedModel cachedModel;

    private SpecialModels(String modelName) {
        this(new ModelResourceLocation(new ResourceLocation("vehicle", modelName), (String) null), true);
    }

    private SpecialModels(ModelResourceLocation resourceLocation, boolean specialModel) {
        this.modelLocation = resourceLocation;
        this.specialModel = specialModel;
    }

    @SideOnly(Side.CLIENT)
    public IBakedModel getModel() {
        if (this.cachedModel == null) {
            ModelManager modelManager = RenderUtil.getModelManager();
            IBakedModel model = modelManager.func_174953_a(this.modelLocation);
            if (model == modelManager.func_174951_a()) {
                return model;
            }

            this.cachedModel = model;
        }

        return this.cachedModel;
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void register(ModelRegistryEvent event) {
        item = ModItems.MODELS;
        SpecialModels[] var1 = values();
        int var2 = var1.length;

        for (int var3 = 0; var3 < var2; ++var3) {
            SpecialModels model = var1[var3];
            if (model.specialModel) {
                ModelLoader.registerItemVariants(item, new ResourceLocation[]{model.modelLocation});
            }
        }

    }
}
