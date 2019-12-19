package net.mod1;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class Separator extends Block implements BlockEntityProvider {

  
    public Separator() {
        super(FabricBlockSettings.of(Material.METAL).breakByHand(true).breakByTool(FabricToolTags.PICKAXES, 0)
                .sounds(BlockSoundGroup.ANVIL).strength(4.0f, 35.0f).build());
    }

    @Override
    public BlockEntity createBlockEntity(BlockView blockView) {
       return new SeparatorEntity();
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if(blockEntity instanceof SeparatorEntity){
            SeparatorEntity separatorEntity = (SeparatorEntity) blockEntity;
            if(player.inventory.getCursorStack() != null){
            if(player.inventory.getCursorStack().getItem() == Items.MILK_BUCKET){
                if(separatorEntity.addMilk()){
                    player.inventory.setCursorStack(new ItemStack(Items.BUCKET));
                    return ActionResult.SUCCESS;
                }
            }
            if(player.inventory.getCursorStack().getItem() ==Items.BUCKET){
                separatorEntity.removeMilk();
                player.inventory.setCursorStack(new ItemStack(Items.MILK_BUCKET));
                return ActionResult.SUCCESS;
            }
            }
        }
        return ActionResult.SUCCESS;
    }

}