package net.mod1.blocks;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;
import net.mod1.Mod1;
import net.mod1.fluids.MilkFluidBlock;
import net.mod1.fluids.Mod1Fluids;
import net.mod1.items.Mod1Items;

public class Mod1Blocks {

    public static final Block RUBYORE = register("rubyore", new RubyOre(), new Item.Settings().group(Mod1.MOD1));
    public static final Block SAPPHIREORE = register("sapphireore", new SapphireOre(), new Item.Settings().group(Mod1.MOD1));
	public static final Block SEPARATOR = register("separator", new Separator(), new Item.Settings().group(Mod1.MOD1));
	public static final Block CHARCOALBLOCK = register("charcoalblock", new CharcoalBlock(), new Item.Settings().group(Mod1.MOD1));

    public static final Block MILK_FLUID = register("milk", new MilkFluidBlock(Mod1Fluids.MILK, FabricBlockSettings.of(Material.WATER).noCollision().strength(100.0F, 100f).dropsNothing().build()), (BlockItem) null);

    static <T extends Block> T register(String name, T block, Item.Settings settings) {
		return register(name, block, new BlockItem(block, settings));
	}

    static <T extends Block> T register(String name, T block) {
		return register(name, block, new Item.Settings().group(Mod1.MOD1));
	}

    static <T extends Block> T register(String name, T block, BlockItem item) {
		T holder = Registry.register(Registry.BLOCK, Mod1.id(name), block);
		if (item != null) {
			Mod1Items.register(name, item);
			Item.BLOCK_ITEMS.put(item.getBlock(), item);
		}
		return holder;
	}

	private Mod1Blocks() {}
    
    public static void init() {}

}