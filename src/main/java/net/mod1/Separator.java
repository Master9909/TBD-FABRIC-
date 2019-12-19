package net.mod1;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.world.BlockView;

public class Separator extends Block implements BlockEntityProvider {

  
    public Separator() {
        super(FabricBlockSettings.of(Material.METAL).breakByHand(true).breakByTool(FabricToolTags.PICKAXES, 0)
                .sounds(BlockSoundGroup.ANVIL).strength(4.0f, 35.0f).build());
    }

    @Override
    public BlockEntity createBlockEntity(BlockView blockView) {
       return new SeparatorEntity();
    }

}