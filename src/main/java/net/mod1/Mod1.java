package net.mod1;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.mod1.blocks.Mod1Blocks;
import net.mod1.blocks.blockentities.SeparatorEntity;
import net.mod1.fluids.Mod1Fluids;
import net.mod1.items.MilkBucket;
import net.mod1.items.Mod1Items;

public class Mod1 implements ModInitializer {

    public static final ItemGroup MOD1 = FabricItemGroupBuilder.build(new Identifier("mod1", "mod1"), () -> new ItemStack(Mod1Items.RUBY));

    public static final MilkBucket MILK_BUCKET = new MilkBucket(new Identifier("milk_bucket"), new Item.Settings().group(ItemGroup.MISC).recipeRemainder(Items.BUCKET).maxCount(1));

    public static BlockEntityType<SeparatorEntity> SEPARATORENTITY;

    public static Identifier id(String name) {
		return new Identifier("mod1", name);
    }

    protected static <T extends Item> T register(String name, T item) {
        return Registry.register(Registry.ITEM, Mod1.id(name), item);
    }
    
    @Override
    public void onInitialize(){

        Mod1Blocks.init();
        Mod1Items.init();
        Mod1Fluids.init();
        Mod1Tags.init();

        SEPARATORENTITY = Registry.register(Registry.BLOCK_ENTITY, "mod1:separatorentity", BlockEntityType.Builder.create(SeparatorEntity::new, Mod1Blocks.SEPARATOR).build(null));

        Registry.register(Registry.ITEM, Item.getRawId(Items.MILK_BUCKET), "milk_bucket", MILK_BUCKET);

        Registry.BIOME.forEach(OreGen::handleBiome);
        RegistryEntryAddedCallback.event(Registry.BIOME).register((i, identifier, biome) -> OreGen.handleBiome(biome));
    }

}