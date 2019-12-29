package net.mod1.items;

import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;

public class HoeBase extends HoeItem {

    public HoeBase(ToolMaterial material) {
        super(material, 0F, Mod1Items.newSettings());
    }
    
}