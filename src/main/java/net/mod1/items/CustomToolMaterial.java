package net.mod1.items;

import java.util.function.Supplier;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

public enum CustomToolMaterial implements ToolMaterial {
    RUBY(3, 1275, 7.0F, 2.5F, 13, () -> {return Ingredient.ofItems(Mod1Items.RUBY);}),
    SAPPHIRE(3, 1275, 7.0F, 2.5F, 13, () -> {return Ingredient.ofItems(Mod1Items.SAPPHIRE);});

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    private CustomToolMaterial(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantibility, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantibility;
        this.repairIngredient = new Lazy<Ingredient>(repairIngredient);
    }

    public int getDurability() {
        return this.itemDurability;
    }
  
     public float getMiningSpeed() {
        return this.miningSpeed;
    }
  
     public float getAttackDamage() {
        return this.attackDamage;
    }
  
     public int getMiningLevel() {
        return this.miningLevel;
    }
  
     public int getEnchantability() {
        return this.enchantability;
    }
  
     public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
    
}