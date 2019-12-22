package net.mod1;

import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.fluid.Fluid;
import net.minecraft.tag.Tag;

public class Mod1Tags {

    public static final Tag<Fluid> MILK = registerFluid("liquid_milk");

    private Mod1Tags() {}

    private static Tag<Fluid> registerFluid(String name) {
	    return TagRegistry.fluid(Mod1.id(name));
    }

    public static void init() {}

}