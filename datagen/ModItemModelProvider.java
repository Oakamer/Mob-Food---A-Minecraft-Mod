package net.oakamer.cropcraft.datagen;

import net.oakamer.cropcraft.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.oakamer.cropcraft.CropCraftMod;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CropCraftMod.MOD_ID, existingFileHelper);
    }
    protected void registerModels() {

        simpleItem(ModItems.GOLDDEW_SEEDS);
        simpleItem(ModItems.GOLDDEW_CORE);
        simpleItem(ModItems.GOLDDEW_STEAK);
        simpleItem(ModItems.FLUTE_CONCIERTO_RECORD);
        simpleItem(ModItems.PURIFIED_ZOMBIE_FLESH);
        simpleItem(ModItems.CREEPER_COOKIE);

        //Mob Food------------------------------------------------------
        simpleItem(ModItems.PURIFIED_ZOMBIE_FLESH);
        simpleItem(ModItems.CREEPER_COOKIE);
        simpleItem(ModItems.ENDER_BISCUIT);
        //Mob Food------------------------------------------------------
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(CropCraftMod.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(CropCraftMod.MOD_ID, "item/" + item.getId().getPath()));
    }
    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(CropCraftMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}
