package net.mod1.client;

import java.util.Arrays;
import java.util.Collection;

import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandler;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.resource.ResourceReloadListenerKeys;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.mod1.Mod1;
import net.mod1.fluids.Mod1Fluids;

public class FluidResourceLoader implements SimpleSynchronousResourceReloadListener {

    @Override
    public Identifier getFabricId() {
        return Mod1.id("fluid_resource_loader");
    }

    @Override
    public Collection<Identifier> getFabricDependencies() {
        return Arrays.asList(ResourceReloadListenerKeys.MODELS, ResourceReloadListenerKeys.TEXTURES);
    }

    @Override
    public void apply(ResourceManager manager) {
        FluidRenderHandler milkRenderHandler = (blockRenderView, blockPos, fluidState) ->
            new Sprite[]{
                MinecraftClient.getInstance().getSpriteAtlas(SpriteAtlasTexture.BLOCK_ATLAS_TEX).apply(Mod1.id("block/milk_still")),
                MinecraftClient.getInstance().getSpriteAtlas(SpriteAtlasTexture.BLOCK_ATLAS_TEX).apply(Mod1.id("block/milk_flow"))
            };

        FluidRenderHandlerRegistry.INSTANCE.register(Mod1Fluids.MILK, milkRenderHandler);
        FluidRenderHandlerRegistry.INSTANCE.register(Mod1Fluids.FLOWING_MILK, milkRenderHandler);

    }
    
}