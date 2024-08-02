package net.oakamer.cropcraft.datagen.loot;


import net.oakamer.cropcraft.block.ModBlocks;
import net.oakamer.cropcraft.block.custom.oakamerCropBlock;
import net.oakamer.cropcraft.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        LootItemCondition.Builder lootitemcondition$builder1 = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.GOLDDEW_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(oakamerCropBlock.AGE, 6));
        this.add(ModBlocks.GOLDDEW_CROP.get(), this.createCropDrops(ModBlocks.GOLDDEW_CROP.get(),
                ModItems.GOLDDEW_CORE.get(), ModItems.GOLDDEW_SEEDS.get(), lootitemcondition$builder1));
    }

    protected Iterable<Block> getKnownBlocks()
    {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
