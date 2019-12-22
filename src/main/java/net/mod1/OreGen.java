package net.mod1;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.RandomCountRangeDecorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.mod1.blocks.Mod1Blocks;

public class OreGen {
    public static void handleBiome(Biome biome) {
        if(biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND) {
            biome.addFeature(
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE,Mod1Blocks.RUBYORE.getDefaultState(),4))
                    .createDecoratedFeature(RandomCountRangeDecorator.COUNT_RANGE.configure(new RangeDecoratorConfig(2,0,0,24))));
            biome.addFeature(
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE,Mod1Blocks.SAPPHIREORE.getDefaultState(),4))
                    .createDecoratedFeature(RandomCountRangeDecorator.COUNT_RANGE.configure(new RangeDecoratorConfig(2,0,0,24))));                    
        }
    }
}