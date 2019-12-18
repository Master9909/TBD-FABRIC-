package net.mod1;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class Separator extends Block {

    public Separator() {
        super(FabricBlockSettings.of(Material.METAL).breakByHand(true).breakByTool(FabricToolTags.PICKAXES, 0).sounds(BlockSoundGroup.ANVIL).strength(4.0f, 35.0f).build());
    }
    
}