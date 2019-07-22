package com.pierrcepack;

import com.pierrcepack.init.PierrcePackItems;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.monster.*;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MobDropHandler {

	@SubscribeEvent
	public void onEntityDeath(LivingDropsEvent event) {
		
		if(!(event.getSource().getTrueSource() instanceof EntityPlayer))
			return;
		
		ItemStack stack = null;
		EntityItem drop = new EntityItem(event.getEntity().world, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, stack);
		
		if(event.getEntityLiving().getClass().toString().contains("Zombie")) {
			stack = new ItemStack(PierrcePackItems.coinBronze, References.zombieCoinCount);
			event.getDrops().add(drop);
			return;
		}
		
		if(event.getEntityLiving().getClass().toString().contains("Skeleton")) {
			stack = new ItemStack(PierrcePackItems.coinBronze, References.skeletonCoinCount);
			event.getDrops().add(drop);
			return;
		}
		
		if(event.getEntityLiving().getClass().toString().contains("Spider")) {
			stack = new ItemStack(PierrcePackItems.coinBronze, References.spiderCoinCount);
			event.getDrops().add(drop);
			return;
		}
		
		if(event.getEntityLiving().getClass().toString().contains("Creeper")) {
			stack = new ItemStack(PierrcePackItems.coinBronze, References.creeperCoinCount);
			event.getDrops().add(drop);
			return;
		}
		
		if(event.getEntityLiving().getClass().toString().contains("Slime")) {
			stack = new ItemStack(PierrcePackItems.coinBronze, References.slimeCoinCount);
			event.getDrops().add(drop);
			return;
		}
		
		if(event.getEntityLiving().getClass().toString().contains("Blaze")) {
			stack = new ItemStack(PierrcePackItems.coinBronze, References.blazeCoinCount);
			event.getDrops().add(drop);
			return;
		}
		
		if(event.getEntityLiving().getClass().toString().contains("Witch")) {
			stack = new ItemStack(PierrcePackItems.coinBronze, References.witchCoinCount);
			event.getDrops().add(drop);
			return;
		}
		
		if(event.getEntityLiving().getClass().toString().contains("Jockey")) {
			stack = new ItemStack(PierrcePackItems.coinBronze, References.jockeyCoinCount);
			event.getDrops().add(drop);
			return;
		}
		
		if(event.getEntityLiving().getClass().toString().contains("Endermite")) {
			stack = new ItemStack(PierrcePackItems.coinBronze, References.endermiteCoinCount);
			event.getDrops().add(drop);
			return;
		}
		
		if(event.getEntityLiving().getClass().toString().contains("Enderman")) {
			stack = new ItemStack(PierrcePackItems.coinBronze, References.endermanCoinCount);
			event.getDrops().add(drop);
			return;
		}
		
		if(event.getEntityLiving().getClass().toString().contains("Silver")) {
			stack = new ItemStack(PierrcePackItems.coinBronze, References.silverfishCoinCount);
			event.getDrops().add(drop);
			return;
		}
		
		if(event.getEntityLiving().getClass().toString().contains("Magma")) {
			stack = new ItemStack(PierrcePackItems.coinBronze, References.magmaCubeCoinCount);
			event.getDrops().add(drop);
			return;
		}
		
		if(event.getEntityLiving().getClass().toString().contains("Wither")) {
			stack = new ItemStack(PierrcePackItems.coinSilver, References.skeletonCoinCount);
			event.getDrops().add(drop);
			return;
		}
		
		if(event.getEntityLiving().getClass().toString().contains("Ghast")) {
			stack = new ItemStack(PierrcePackItems.coinSilver, References.ghastCoinCount);
			event.getDrops().add(drop);
			return;
		}
		
		if(event.getEntityLiving().getClass().toString().contains("Dragon")) {
			stack = new ItemStack(PierrcePackItems.coinGold, References.enderdragonCoinCount);
			event.getDrops().add(drop);
			return;
		}
		
		if(event.getEntityLiving().getClass().toString().contains("Elder")) {
			stack = new ItemStack(PierrcePackItems.coinGold, References.elderCoinCount);
			event.getDrops().add(drop);
			return;
		}
	}
}
