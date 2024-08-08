package net.oakamer.cropcraft.datagen;

import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import net.oakamer.cropcraft.CropCraftMod;
import net.oakamer.cropcraft.item.ModItems;
import net.oakamer.cropcraft.loot.AddItemModifier;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output) {
        super(output, CropCraftMod.MOD_ID);
    }

    @Override
    protected void start() {
        add("hardened_spider_blood_from_spider", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("minecraft:entities/spider")).build()
        }, ModItems.HARDENED_SPIDER_BLOOD.get()));
    }
}
