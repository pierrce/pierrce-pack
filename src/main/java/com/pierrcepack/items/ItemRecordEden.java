package com.pierrcepack.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemRecord;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class ItemRecordEden extends ItemRecord {
	
	public ItemRecordEden(String name) {
		super(name, new SoundEvent(new ResourceLocation("pierrcepack:edenmusic")));
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
	}

	public ItemRecordEden setMaxStackSize(int maxStackSize)
    {
        return (ItemRecordEden)super.setMaxStackSize(maxStackSize);
    }
	
	public ItemRecordEden setCreativeTab(CreativeTabs tab)
    {
        return (ItemRecordEden)super.setCreativeTab(tab);
    }
}
