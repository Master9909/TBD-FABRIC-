package net.mod1.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.resource.ResourceType;
import net.mod1.Mod1;
import net.mod1.blocks.Mod1Blocks;
import net.mod1.fluids.Mod1Fluids;

public class Mod1Client implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        ResourceManagerHelper.get(ResourceType.CLIENT_RESOURCES).registerReloadListener(new FluidResourceLoader());

        BlockRenderLayerMap.INSTANCE.putBlock(Mod1Blocks.MILK_FLUID, RenderLayer.getSolid());
        BlockRenderLayerMap.INSTANCE.putFluid(Mod1Fluids.MILK, RenderLayer.getSolid());
        BlockRenderLayerMap.INSTANCE.putFluid(Mod1Fluids.FLOWING_MILK, RenderLayer.getSolid());

        BlockRenderLayerMap.INSTANCE.putBlock(Mod1Blocks.SEPARATOR, RenderLayer.getTranslucent());

        ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEX).register((texture, registry) -> {
            registry.register(Mod1.id("block/milk_still"));
        });

    }
    
}