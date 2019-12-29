package net.mod1.items;

import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class PickaxeBase extends PickaxeItem {

    public PickaxeBase(ToolMaterial material) {
        super(material, 1, -2.8F, Mod1Items.newSettings());
    }
    
}