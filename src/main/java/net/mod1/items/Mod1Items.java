package net.mod1.items;

import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;
import net.mod1.Mod1;

public class Mod1Items {

    public static final Item RUBY = register("ruby", new Item(newSettings()));
	public static final Item SAPPHIRE = register("sapphire", new Item(newSettings()));

    static Item.Settings newSettings() {
		return new Item.Settings().group(Mod1.MOD1);
	}
	
	public static void init() {}
	
	public static <T extends Item> T register(String name, T item) {
		return Registry.register(Registry.ITEM, Mod1.id(name), item);
	}
}