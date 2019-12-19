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
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class Separator extends Block implements BlockEntityProvider {

    public static final BooleanProperty HASMILK = BooleanProperty.of("hasmilk");

    public Separator() {
        super(FabricBlockSettings.of(Material.METAL).nonOpaque().breakByHand(true).breakByTool(FabricToolTags.PICKAXES, 0)
                .sounds(BlockSoundGroup.ANVIL).strength(4.0f, 35.0f).build());
            setDefaultState(getStateManager().getDefaultState().with(HASMILK, false));
    }

    @Override
    public BlockEntity createBlockEntity(BlockView blockView) {
       return new SeparatorEntity();
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(HASMILK);
    }

    @Override
    public boolean isTranslucent(BlockState state, BlockView view, BlockPos pos) {
        return true;
    }

    @Override
    public boolean isSimpleFullBlock(BlockState state, BlockView view, BlockPos pos) {
        return false;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if(blockEntity instanceof SeparatorEntity){
            SeparatorEntity separatorEntity = (SeparatorEntity)blockEntity;
            if(player.getStackInHand(hand).getItem() != null){
            if(player.getStackInHand(hand).getItem() == Items.MILK_BUCKET){
                if(separatorEntity.addMilk()){
                    player.setStackInHand(hand, new ItemStack(Items.BUCKET));
                    world.setBlockState(pos, Mod1.SEPARATOR.getDefaultState().with(HASMILK, true));
                    return ActionResult.SUCCESS;
                }
            }
            else if(player.getStackInHand(hand).getItem() == Items.BUCKET){
                if(separatorEntity.removeMilk()){
                    player.getStackInHand(hand).decrement(1);
                    player.giveItemStack(new ItemStack(Items.MILK_BUCKET));
                    world.setBlockState(pos, Mod1.SEPARATOR.getDefaultState().with(HASMILK, false));
                    return ActionResult.SUCCESS;
                }
                return ActionResult.FAIL;
            }
            }
        }
        return ActionResult.SUCCESS;
    }

}