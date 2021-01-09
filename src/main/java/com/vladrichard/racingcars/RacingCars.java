package com.vladrichard.racingcars;

import net.minecraft.init.Blocks;
import com.vladrichard.racingcars.entity.EntityRegister;
import com.vladrichard.racingcars.item.ItemRegister;
import com.vladrichard.racingcars.proxy.Proxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import org.apache.logging.log4j.Logger;


@Mod(modid = RacingCars.MODID, name = RacingCars.NAME, version = RacingCars.VERSION)
public class RacingCars
{
    @Instance
    public static RacingCars instance;
    @SidedProxy(
            clientSide = "com.vladrichard.racingcars.proxy.ClientProxy",
            serverSide = "com.vladrichard.racingcars.proxy.ServerProxy"
    )
    public static Proxy proxy;
    public int nextEntityId;
    public static final CreativeTabs CREATIVE_TAB = new 1("tabVehicle");

    @EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new CommonEvents());
        CustomDataSerializers.register();
        HeldVehicleDataHandler.register();
        this.registerVehicles();
        VehicleProperties.register();
        proxy.preInit();
    }

    @EventHandler
    public static void onInit(FMLInitializationEvent e) {
        proxy.init();
    }

    @EventHandler
    public static void onPostInit(FMLPostInitializationEvent e) {
        proxy.postInit();
    }

    private void registerVehicles() {
        this.registerVehicle("formula_car",EntityFormulaCar.class);
    }

    private void registerVehicle(String id, Class<? extends EntityVehicle> clazz) {
        EntityRegistry.registerModEntity(new ResourceLocation("vehicle", id), clazz, "vehicle." + id, this.nextEntityId++, this, 256, 1, true);
        BlockVehicleCrate.registerVehicle(id);
    }
}
