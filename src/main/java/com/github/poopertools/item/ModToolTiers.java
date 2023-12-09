package com.github.poopertools.item;

import com.github.poopertools.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final int COPPER_LEVEL = 1;
    public static final int COPPER_DURABILITY = 131;
    public static final float COPPER_SPEED = 0f;
    public static final float COPPER_DAMAGE = 0f;
    public static final int COPPER_ENCHANTMENT = 5;

    public static final Tier COPPER = TierSortingRegistry.registerTier(
            new ForgeTier(Tiers.STONE.getLevel(), Tiers.STONE.getUses(), Tiers.STONE.getSpeed(), Tiers.
                    STONE.getAttackDamageBonus(), Tiers.STONE.getEnchantmentValue(),
                    BlockTags.NEEDS_STONE_TOOL, () -> Ingredient.of(Items.COPPER_INGOT)),
            new ResourceLocation("minecraft", "copper_ingot"), List.of(Tiers.STONE), List.of()
    );
}
