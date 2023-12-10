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

public class CopperPickaxe extends PickaxeItem {
    private static final TagKey<Block> blocks = BlockTags.MINEABLE_WITH_PICKAXE;
    private final static int attackDamage = 3;
    private final static float attackSpeed = 1.2f;
    private final static float baseSpeed = 4f;
    private static float speed = baseSpeed;
    private final static int maxDamage = Tiers.STONE.getUses();

    // COPPER Tiered PickaxeItem defaults to 2 Damage and 4 Speed
    public CopperPickaxe() {
        super(Tiers.STONE, attackDamage - 2, attackSpeed - 4f, new Item.Properties());
    }

    @Override
    public boolean mineBlock(@NotNull ItemStack p_40998_, @NotNull Level p_40999_,
                             @NotNull BlockState p_41000_, @NotNull BlockPos p_41001_, @NotNull LivingEntity p_41002_) {
        speed = getDynamicSpeed(p_40998_.getDamageValue());
        return super.mineBlock(p_40998_, p_40999_, p_41000_, p_41001_, p_41002_);
    }

    @Override
    public float getDestroySpeed(@NotNull ItemStack p_41004_, @NotNull BlockState p_41005_) {
        return p_41005_.is(blocks) ? speed : 1f;
    }

    private float getDynamicSpeed(float currentDamage) {
         return baseSpeed * (1 + currentDamage / maxDamage);
    }
}
