package com.github.poopertools.util;

import com.github.poopertools.PooperTools;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static TagKey<Block> NEEDS_COPPER_TOOL = BlockTags.create(new ResourceLocation(PooperTools.MODID, "needs_copper_tool"));
    }
}
