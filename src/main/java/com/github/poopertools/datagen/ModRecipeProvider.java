package com.github.poopertools.datagen;

import com.github.poopertools.PooperTools;
import com.github.poopertools.item.ModItems;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    private static final List<ItemLike> SMELTABLES = List.of(ModItems.COPPER_PICKAXE.get());

    public ModRecipeProvider(PackOutput p_248933_) {
        super(p_248933_);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput p_297267_) {

        oreSmelting(p_297267_, SMELTABLES, RecipeCategory.TOOLS, Items.COPPER_INGOT, 0.25f, 100, "copper");
        oreBlasting(p_297267_, SMELTABLES, RecipeCategory.TOOLS, Items.COPPER_INGOT, 0.25f, 50, "copper");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPER_PICKAXE.get())
                .pattern("CCC")
                .pattern(" S ")
                .pattern(" S ")
                .define('C', Items.COPPER_INGOT)
                .define('S', Items.STICK)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .save(p_297267_);
    }

    protected static void oreSmelting(@NotNull RecipeOutput p_297267_, List<ItemLike> pIngredients, @NotNull RecipeCategory pCategory,
                                      @NotNull ItemLike pResult, float pExperience, int pCookingTIme, @NotNull String pGroup) {
        oreCooking(p_297267_, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience,
                pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput p_297267_, List<ItemLike> pIngredients, RecipeCategory pCategory,
                                      ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(p_297267_, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience,
                pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(RecipeOutput p_297267_,
                                     RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer,
                                     List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                     float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(p_297267_,  PooperTools.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
