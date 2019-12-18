package net.mod1;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Mod1 implements ModInitializer {

    public static final Block RUBYORE = new RubyOre();
    public static final Block SAPPHIREORE = new SapphireOre();
    public static final Block SEPARATOR = new Separator();

    public static final Item RUBY = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
    public static final Item SAPPHIRE = new Item(new Item.Settings().group(ItemGroup.MATERIALS));

    @Override
    public void onInitialize(){
        Registry.register(Registry.BLOCK, new Identifier("mod1", "rubyore"), RUBYORE);
        Registry.register(Registry.BLOCK, new Identifier("mod1", "sapphireore"), SAPPHIREORE);
        Registry.register(Registry.BLOCK, new Identifier("mod1", "separator"), SEPARATOR);

        Registry.register(Registry.ITEM, new Identifier("mod1", "rubyore"), new BlockItem(RUBYORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("mod1", "sapphireore"), new BlockItem(SAPPHIREORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("mod1", "separator"), new BlockItem(SEPARATOR, new Item.Settings().group(ItemGroup.FOOD)));

        Registry.register(Registry.ITEM, new Identifier("mod1", "ruby"), RUBY);
        Registry.register(Registry.ITEM, new Identifier("mod1", "sapphire"), SAPPHIRE);

        Registry.BIOME.forEach(OreGen::handleBiome);
        RegistryEntryAddedCallback.event(Registry.BIOME).register((i, identifier, biome) -> OreGen.handleBiome(biome));
    }
}