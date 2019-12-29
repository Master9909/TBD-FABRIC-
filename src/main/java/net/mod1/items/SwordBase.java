package net.mod1.items;

import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class SwordBase extends SwordItem {

    public SwordBase(ToolMaterial material) {
        super(material, 3, -2.4F, Mod1Items.newSettings());
    }
    
}