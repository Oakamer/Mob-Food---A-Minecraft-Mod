package net.oakamer.cropcraft;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.oakamer.cropcraft.block.ModBlocks;
import net.oakamer.cropcraft.effect.ModEffects;
import net.oakamer.cropcraft.item.ModItems;
import net.oakamer.cropcraft.sound.ModSounds;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CropCraftMod.MOD_ID)
public class CropCraftMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "cropcraft";
    private static final Logger LOGGER = LogUtils.getLogger();


    public CropCraftMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModEffects.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModSounds.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS)
        {
            event.accept(ModItems.GOLDDEW_SEEDS);
            event.accept(ModItems.GOLDDEW_CORE);
            event.accept(ModItems.GOLDDEW_STEAK);
            event.accept(ModItems.FLUTE_CONCIERTO_RECORD);

            event.accept(ModItems.PURIFIED_ZOMBIE_FLESH);
            event.accept(ModItems.CREEPER_COOKIE);
            event.accept(ModItems.ENDER_BISCUIT);
            event.accept(ModItems.SPIDER_BLOOD_PURIFIED);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }

    }

}
