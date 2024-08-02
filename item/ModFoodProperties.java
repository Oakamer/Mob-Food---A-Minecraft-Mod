package net.oakamer.cropcraft.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties GOLDDEW_STEAK = new FoodProperties.Builder().nutrition(5).saturationMod(0.25f)
            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 10), 0.1f).build();

    public static final FoodProperties PURIFIED_ZOMBIE_FLESH = new FoodProperties.Builder().nutrition(5).saturationMod(0.25f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 80, 4), 100f).build();

    public static final FoodProperties CREEPER_COOKIE = new FoodProperties.Builder().nutrition(5).saturationMod(0.25f)
            .effect(() -> new MobEffectInstance(MobEffects.DARKNESS, 80, 4), 100f).build();

    public static final FoodProperties ENDER_BISCUIT = new FoodProperties.Builder().nutrition(5).saturationMod(0.25f)
            .effect(() -> new MobEffectInstance(MobEffects.DARKNESS, 80, 4), 100f).build();
}
