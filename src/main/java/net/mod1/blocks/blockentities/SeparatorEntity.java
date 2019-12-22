package net.mod1.blocks.blockentities;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.CompoundTag;
import net.mod1.Mod1;

public class SeparatorEntity extends BlockEntity {

    private int mBucketMilk = 0;

    public boolean addMilk(){
        if (mBucketMilk == 0){
            mBucketMilk += 1000;
            return true;
        }
        return false;
    }

    public boolean removeMilk(){
        if(mBucketMilk == 1000){
            mBucketMilk -= 1000;
            return true;
        }
        return false;
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