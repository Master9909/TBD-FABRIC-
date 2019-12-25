package net.mod1.blocks;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class CharcoalBlock extends Block {

    public CharcoalBlock() {
        super(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES, 0).sounds(BlockSoundGroup.STONE).strength(5.0f, 30.0f).build());
    }
    
}