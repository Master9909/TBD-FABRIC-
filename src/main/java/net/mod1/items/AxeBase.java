package net.mod1.items;

import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;

public class AxeBase extends AxeItem {

    public AxeBase(ToolMaterial material) {
        super(material, 5.5F, -3.0F, Mod1Items.newSettings());
    }
    
}