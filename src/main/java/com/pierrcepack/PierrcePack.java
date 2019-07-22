package com.pierrcepack;

import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

import org.apache.logging.log4j.Logger;
import com.pierrcepack.init.PierrcePackItems;

@Mod(modid = References.MODID, name = References.NAME, version = References.VERSION)
public class PierrcePack
{
	@Instance
	public static PierrcePack instance;
	
	@EventHandler
	public void serverLoad(FMLServerStartingEvent event) {
		event.registerServerCommand(new Commands());
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		PierrcePackItems.init();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new MobDropHandler());
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {}
}
