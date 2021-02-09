package com.zairous.tutorial.registry;

import com.zairous.tutorial.Tutorial;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.List;

public class ModBlocks{


    public static final Block RUBY_BLOCK = new Block(FabricBlockSettings
            .of(Material.METAL)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(3f, 4f)
            .sounds(BlockSoundGroup.METAL)
            .luminance(5));

    public static void register(){
        Registry.register(Registry.BLOCK, new Identifier(Tutorial.MOD_ID, "ruby_block"), RUBY_BLOCK);
    }
}
