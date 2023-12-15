package com.github.poopertools.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class CopperShovel extends ShovelItem {
    private static final TagKey<Block> blocks = BlockTags.MINEABLE_WITH_HOE;
    private static final int attackDamage = 3;
    private static final float attackSpeed = 1f;
    private static final float baseSpeed = 4f;
    private static float speed = baseSpeed;
    private final static int maxDamage = Tiers.STONE.getUses();

    public CopperShovel() {
        super(Tiers.STONE, attackDamage - 1.5f, attackSpeed - 4f, new Item.Properties());
    }

    @Override
    public boolean mineBlock(@NotNull ItemStack p_40998_, @NotNull Level p_40999_,
                             @NotNull BlockState p_41000_, @NotNull BlockPos p_41001_, @NotNull LivingEntity p_41002_) {
        boolean result = super.mineBlock(p_40998_, p_40999_, p_41000_, p_41001_, p_41002_);
        speed = getDynamicSpeed(p_40998_.getDamageValue());
        return result;
    }

    @Override
    public boolean hurtEnemy(ItemStack p_40994_, LivingEntity p_40995_, LivingEntity p_40996_) {
        boolean result = super.hurtEnemy(p_40994_, p_40995_, p_40996_);
        speed = getDynamicSpeed(p_40994_.getDamageValue());
        return result;
    }

    @Override
    public float getDestroySpeed(@NotNull ItemStack p_41004_, @NotNull BlockState p_41005_) {
        return p_41005_.is(blocks) ? speed : 1f;
    }

    private float getDynamicSpeed(float currentDamage) {
        return baseSpeed * (1 + currentDamage / maxDamage);
    }
}
