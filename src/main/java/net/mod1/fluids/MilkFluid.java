package net.mod1.fluids;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.BaseFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.IWorld;
import net.minecraft.world.WorldView;
import net.mod1.Mod1;
import net.mod1.blocks.Mod1Blocks;

public abstract class MilkFluid extends BaseFluid {

    @Override
    public Fluid getFlowing() {
        return Mod1Fluids.FLOWING_MILK;
    }

    @Override
    public Fluid getStill() {
        return Mod1Fluids.MILK;
    }

    @Override
    public Item getBucketItem() {
        return Mod1.MILK_BUCKET;
    }
    
    @Override
    protected boolean isInfinite() {
        return false;
    }

    @Override
    protected void beforeBreakingBlock(IWorld world, BlockPos pos, BlockState state) {
        BlockEntity blockEntity = state.getBlock().hasBlockEntity() ? world.getBlockEntity(pos) : null;
        Block.dropStacks(state, world.getWorld(), pos, blockEntity);
    }

    @Override
    protected int method_15733(WorldView worldView) {
        return 3;
    }

    @Override
    protected int getLevelDecreasePerBlock(WorldView worldView) {
        return 1;
    }

    @Override
    protected boolean method_15777(FluidState fluidState, BlockView blockView, BlockPos blockPos, Fluid fluid, Direction direction) {
        return direction == Direction.DOWN && !fluid.matches(FluidTags.WATER);
    }

    @Override
    public int getTickRate(WorldView worldView) {
        return 5;
    }

    @Override
    protected float getBlastResistance() {
        return 100;
    }

    @Override
    protected BlockState toBlockState(FluidState fluidState) {
        return Mod1Blocks.MILK_FLUID.getDefaultState().with(FluidBlock.LEVEL, method_15741(fluidState));
    }

    @Override
	protected ParticleEffect getParticle() {
		return ParticleTypes.DRIPPING_WATER;
	}

    @Override
    public boolean matchesType(Fluid fluid) {
        return fluid == Mod1Fluids.MILK || fluid == Mod1Fluids.FLOWING_MILK;
    }

    public static class Flowing extends MilkFluid {

        @Override
        protected void appendProperties(Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getLevel(FluidState fluidState) {
            return fluidState.get(LEVEL);
        }

        @Override
        public boolean isStill(FluidState fluidState) {
            return false;
        }
    }

    public static class Still extends MilkFluid {

        @Override
        public int getLevel(FluidState fluidState) {
            return 8;
        }

        @Override
        public boolean isStill(FluidState fluidState) {
            return true;
        }
    }

}