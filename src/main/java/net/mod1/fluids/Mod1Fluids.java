package net.mod1.fluids;

import net.minecraft.fluid.BaseFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.registry.Registry;
import net.mod1.Mod1;

public class Mod1Fluids {
    
    public static final BaseFluid MILK = (BaseFluid) register("milk", new MilkFluid.Still());
	public static final BaseFluid FLOWING_MILK = (BaseFluid) register("flowing_milk", new MilkFluid.Flowing());

	private static Fluid register(String name, Fluid fluid) {
		return Registry.register(Registry.FLUID, Mod1.id(name), fluid);
	}
	
	private Mod1Fluids() {}
    
    public static void init(){}
}