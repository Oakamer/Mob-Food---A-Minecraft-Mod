package net.oakamer.cropcraft.datagen;

import net.oakamer.cropcraft.CropCraftMod;
import net.oakamer.cropcraft.block.ModBlocks;
import net.oakamer.cropcraft.block.custom.oakamerCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CropCraftMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        makeCrop(((oakamerCropBlock) ModBlocks.GOLDDEW_CROP.get()), "golddew_stage", "golddew_stage");
    }

    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((oakamerCropBlock) block).getAgeProperty()),
                new ResourceLocation(CropCraftMod.MOD_ID, "block/" + textureName + state.getValue(((oakamerCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }



    private void blockItem(RegistryObject<Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("tutorialmod:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("tutorialmod:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}