package net.mod1.items;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;
import net.mod1.Mod1;

public class Mod1Items {

    public static final Item RUBY = register("ruby", new Item(newSettings()));
	public static final Item SAPPHIRE = register("sapphire", new Item(newSettings()));
	public static final Item COALCHUNKLET = register("coalchunklet", new Item(newSettings()));
	public static final Item CHARCOALCHUNKLET = register("charcoalchunklet", new Item(newSettings()));
	public static final Item RUBY_HELMET = register("rubyhelmet", new ArmorItem(CustomArmorMaterial.RUBY, EquipmentSlot.HEAD, newSettings()));
	public static final Item RUBY_CHESTPLATE = register("rubychestplate", new ArmorItem(CustomArmorMaterial.RUBY, EquipmentSlot.CHEST, newSettings()));
	public static final Item RUBY_LEGGINGS = register("rubyleggings", new ArmorItem(CustomArmorMaterial.RUBY, EquipmentSlot.LEGS, newSettings()));
	public static final Item RUBY_BOOTS = register("rubyboots", new ArmorItem(CustomArmorMaterial.RUBY, EquipmentSlot.FEET, newSettings()));
	public static final Item SAPPHIRE_HELMET = register("sapphirehelmet", new ArmorItem(CustomArmorMaterial.SAPPHIRE, EquipmentSlot.HEAD, newSettings()));
	public static final Item SAPPHIRE_CHESTPLATE = register("sapphirechestplate", new ArmorItem(CustomArmorMaterial.SAPPHIRE, EquipmentSlot.CHEST, newSettings()));
	public static final Item SAPPHIRE_LEGGINGS = register("sapphireleggings", new ArmorItem(CustomArmorMaterial.SAPPHIRE, EquipmentSlot.LEGS, newSettings()));
	public static final Item SAPPHIRE_BOOTS = register("sapphireboots", new ArmorItem(CustomArmorMaterial.SAPPHIRE, EquipmentSlot.FEET, newSettings()));

    static Item.Settings newSettings() {
		return new Item.Settings().group(Mod1.MOD1);
	}
	
	public static void init() {}
	
	public static <T extends Item> T register(String name, T item) {
		return Registry.register(Registry.ITEM, Mod1.id(name), item);
	}
}