package net.mod1.mixins;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.mod1.Mod1;

@Mixin(CowEntity.class)
public abstract class CowEntityMixin extends AnimalEntity {
    
    protected CowEntityMixin(EntityType<? extends AnimalEntity> type, World world) {
		super(type, world);
	}

	public boolean interactMob(PlayerEntity player, Hand hand) {

		if (player.getStackInHand(hand).getItem() == Items.BUCKET && !player.abilities.creativeMode && !this.isBaby()) {
			player.playSound(SoundEvents.ENTITY_COW_MILK, 1.0F, 1.0F);
			player.getStackInHand(hand).decrement(1);
			if (player.getStackInHand(hand).isEmpty()) {
				player.setStackInHand(hand, new ItemStack(Mod1.MILK_BUCKET));
            } 
            else if (!player.inventory.insertStack(new ItemStack(Mod1.MILK_BUCKET))) {
				player.dropItem(new ItemStack(Items.MILK_BUCKET), false);
			}
			return true;
        } 
        else {
			return super.interactMob(player, hand);
		}
    }
    
}