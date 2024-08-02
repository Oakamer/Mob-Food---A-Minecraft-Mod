package net.oakamer.cropcraft.datagen;

import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.oakamer.cropcraft.block.ModBlocks;
import net.oakamer.cropcraft.item.ModItems;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.FinishedRecipe;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput)
    {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GOLDDEW_CROP.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ZANTIUM_INGOT.get())
                .unlockedBy("has_zantium_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ZANTIUM_INGOT.get()).build()))
                .save(pWriter);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.GOLDDEW_STEAK.get(), 9)
                .requires(Items.COOKED_BEEF).requires(ModItems.GOLDDEW_CORE.get())
                .unlockedBy("has_cooked_beef", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.COOKED_BEEF).build()))
                .save(pWriter);
    }
}
