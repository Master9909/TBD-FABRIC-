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
	public static final Item RUBYHELMET = register("rubyhelmet", new ArmorItem(CustomArmorMaterial.RUBY, EquipmentSlot.HEAD, newSettings()));
	public static final Item RUBYCHESTPLATE = register("rubychestplate", new ArmorItem(CustomArmorMaterial.RUBY, EquipmentSlot.CHEST, newSettings()));
	public static final Item RUBYLEGGINGS = register("rubyleggings", new ArmorItem(CustomArmorMaterial.RUBY, EquipmentSlot.LEGS, newSettings()));
	public static final Item RUBYBOOTS = register("rubyboots", new ArmorItem(CustomArmorMaterial.RUBY, EquipmentSlot.FEET, newSettings()));
	public static final Item SAPPHIREHELMET = register("sapphirehelmet", new ArmorItem(CustomArmorMaterial.SAPPHIRE, EquipmentSlot.HEAD, newSettings()));
	public static final Item SAPPHIRECHESTPLATE = register("sapphirechestplate", new ArmorItem(CustomArmorMaterial.SAPPHIRE, EquipmentSlot.CHEST, newSettings()));
	public static final Item SAPPHIRELEGGINGS = register("sapphireleggings", new ArmorItem(CustomArmorMaterial.SAPPHIRE, EquipmentSlot.LEGS, newSettings()));
	public static final Item SAPPHIREBOOTS = register("sapphireboots", new ArmorItem(CustomArmorMaterial.SAPPHIRE, EquipmentSlot.FEET, newSettings()));
	public static final Item RUBYPICKAXE = register("rubypickaxe", new PickaxeBase(CustomToolMaterial.RUBY));
	public static final Item SAPPHIREPICKAXE = register("sapphirepickaxe", new PickaxeBase(CustomToolMaterial.SAPPHIRE));
	public static final Item RUBYAXE = register("rubyaxe", new AxeBase(CustomToolMaterial.RUBY));
	public static final Item SAPPHIREAXE = register("sapphireaxe", new AxeBase(CustomToolMaterial.SAPPHIRE));
	public static final Item RUBYSHOVEL = register("rubyshovel", new ShovelBase(CustomToolMaterial.RUBY));
	public static final Item SAPPHIRESHOVEL = register("sapphireshovel", new ShovelBase(CustomToolMaterial.SAPPHIRE));
	public static final Item RUBYHOE = register("rubyhoe", new HoeBase(CustomToolMaterial.RUBY));
	public static final Item SAPPHIREHOE = register("sapphirehoe", new HoeBase(CustomToolMaterial.SAPPHIRE));
	public static final Item RUBYSWORD = register("rubysword", new SwordBase(CustomToolMaterial.RUBY));
	public static final Item SAPPHIRESWORD = register("sapphiresword", new SwordBase(CustomToolMaterial.SAPPHIRE));

    static Item.Settings newSettings() {
		return new Item.Settings().group(Mod1.MOD1);
	}
	
	public static void init() {}
	
	public static <T extends Item> T register(String name, T item) {
		return Registry.register(Registry.ITEM, Mod1.id(name), item);
	}
}