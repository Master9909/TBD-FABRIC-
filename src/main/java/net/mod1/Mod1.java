package net.mod1;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Mod1 implements ModInitializer {

    public static final ItemGroup MOD1 = FabricItemGroupBuilder.build(new Identifier("mod1", "mod1"), () -> new ItemStack(Items.MILK_BUCKET));

    public static final Block RUBYORE = new RubyOre();
    public static final Block SAPPHIREORE = new SapphireOre();
    public static final Block SEPARATOR = new Separator();

    public static BlockEntityType<SeparatorEntity> SEPARATORENTITY;

    public static final Item RUBY = new Item(new Item.Settings().group(ItemGroup.MATERIALS).group(Mod1.MOD1));
    public static final Item SAPPHIRE = new Item(new Item.Settings().group(ItemGroup.MATERIALS).group(Mod1.MOD1));

    @Override
    public void onInitialize(){
        Registry.register(Registry.BLOCK, new Identifier("mod1", "rubyore"), RUBYORE);
        Registry.register(Registry.BLOCK, new Identifier("mod1", "sapphireore"), SAPPHIREORE);
        Registry.register(Registry.BLOCK, new Identifier("mod1", "separator"), SEPARATOR);

        SEPARATORENTITY = Registry.register(Registry.BLOCK_ENTITY, "mod1:separatorentity", BlockEntityType.Builder.create(SeparatorEntity::new, SEPARATOR).build(null));

        Registry.register(Registry.ITEM, new Identifier("mod1", "rubyore"), new BlockItem(RUBYORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS).group(Mod1.MOD1)));
        Registry.register(Registry.ITEM, new Identifier("mod1", "sapphireore"), new BlockItem(SAPPHIREORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS).group(Mod1.MOD1)));
        Registry.register(Registry.ITEM, new Identifier("mod1", "separator"), new BlockItem(SEPARATOR, new Item.Settings().group(ItemGroup.FOOD).group(Mod1.MOD1)));

        Registry.register(Registry.ITEM, new Identifier("mod1", "ruby"), RUBY);
        Registry.register(Registry.ITEM, new Identifier("mod1", "sapphire"), SAPPHIRE);

        Registry.BIOME.forEach(OreGen::handleBiome);
        RegistryEntryAddedCallback.event(Registry.BIOME).register((i, identifier, biome) -> OreGen.handleBiome(biome));
    }
}