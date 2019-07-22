package com.pierrcepack.init;

import com.pierrcepack.*;
import com.pierrcepack.items.ItemRecordEden;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistryEntry;

@Mod.EventBusSubscriber(modid=References.MODID)
public class PierrcePackItems {
	
	public static ItemRecordEden recordEden;
	
	public static Item coinBronze;
	public static Item coinSilver;
	public static Item coinGold;
	public static Item coinPlatinum;
	
	public static void init() {
		recordEden = new ItemRecordEden("edenrecord").setCreativeTab(CreativeTabs.MISC).setMaxStackSize(1);
		coinBronze = new Item().setCreativeTab(CreativeTabs.MISC).setMaxStackSize(64).setUnlocalizedName("coinBronze").setRegistryName("coinBronze");
		coinSilver = new Item().setCreativeTab(CreativeTabs.MISC).setMaxStackSize(64).setUnlocalizedName("coinSilver").setRegistryName("coinSilver");
		coinGold = new Item().setCreativeTab(CreativeTabs.MISC).setMaxStackSize(64).setUnlocalizedName("coinGold").setRegistryName("coinGold");
		coinPlatinum = new Item().setCreativeTab(CreativeTabs.MISC).setMaxStackSize(64).setUnlocalizedName("coinPlatinum").setRegistryName("coinPlatinum");
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(recordEden, coinBronze, coinSilver, coinGold, coinPlatinum);
	}
	
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		registerRender(recordEden);
	}
	
	private static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
