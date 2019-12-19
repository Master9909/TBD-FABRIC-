package net.mod1;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;

public class SeparatorEntity extends BlockEntity {

    private int mBucketMilk = 0;

    public boolean addMilk(){
        if (mBucketMilk == 0){
            mBucketMilk = 1000;
            return true;
        }
        return false;
    }

    public void removeMilk(){
        if(mBucketMilk == 1000){
            world.spawnEntity(new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 1.0, pos.getZ() + 0.5, new ItemStack(Items.MILK_BUCKET)));
            mBucketMilk = 0;
        }
    }

    public SeparatorEntity() {
        super(Mod1.SEPARATORENTITY);
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);
        tag.putInt("MBucketMilk", this.mBucketMilk);

        return tag;
    }

    @Override
    public void fromTag(CompoundTag tag) {
        super.fromTag(tag);
        this.mBucketMilk = tag.getInt("MBucketMilk");
    }

}