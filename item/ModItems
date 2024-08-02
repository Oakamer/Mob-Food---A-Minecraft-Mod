package net.oakamer.cropcraft.item;


import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.RecordItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;
import net.oakamer.cropcraft.CropCraftMod;
import net.oakamer.cropcraft.CropCraftMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import net.oakamer.cropcraft.block.ModBlocks;
import net.oakamer.cropcraft.sound.ModSounds;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CropCraftMod.MOD_ID);

    public static final RegistryObject<Item> ZIRCON = ITEMS.register("zircon",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_ZIRCON = ITEMS.register("raw_zircon",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ZANTIUM_INGOT = ITEMS.register("zantium_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GOLDDEW_SEEDS = ITEMS.register("golddew_seeds",
            () -> new ItemNameBlockItem(ModBlocks.GOLDDEW_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> GOLDDEW_CORE = ITEMS.register("golddew_core",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GOLDDEW_STEAK = ITEMS.register("golddew_steak",
            () -> new Item(new Item.Properties().food(ModFoodProperties.GOLDDEW_STEAK)));

    public static final RegistryObject<Item> FLUTE_CONCIERTO_RECORD = ITEMS.register("flute_concierto_record",
            () -> new RecordItem(4, ModSounds.FLUTE_CONCIERTO, new Item.Properties().stacksTo(1), 3660));

    //Mob Food------------------------------------------------------
    public static final RegistryObject<Item> PURIFIED_ZOMBIE_FLESH = ITEMS.register("purified_zombie_flesh",
            () -> new Item(new Item.Properties().food(ModFoodProperties.PURIFIED_ZOMBIE_FLESH)));
    public static final RegistryObject<Item> CREEPER_COOKIE = ITEMS.register("creeper_cookie",
            () -> new Item(new Item.Properties().food(ModFoodProperties.CREEPER_COOKIE)));
    public static final RegistryObject<Item> ENDER_BISCUIT = ITEMS.register("ender_biscuit",
            () -> new Item(new Item.Properties().food(ModFoodProperties.ENDER_BISCUIT)));
    //Mob Food------------------------------------------------------

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
