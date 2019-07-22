package com.pierrcepack;

import java.util.ArrayList;
import java.util.List;

import com.pierrcepack.init.PierrcePackItems;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class Commands extends CommandBase {

	private static final List<String> aliases = new ArrayList<String>(){{add("coins");}};
	
	@Override
	public String getName() {
		return "coins";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "coins <stack/unstack/repair>";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		
		if(args.length == 0) {
			sender.sendMessage(new TextComponentString("/coins <stack/unstack/repair>"));
			return;
		}
		
		if(!(sender instanceof EntityPlayer)) return;
		
		World world = sender.getEntityWorld();
		EntityPlayer player = (EntityPlayer)sender;
		InventoryPlayer inventory =  player.inventory;
		
		if(world.isRemote) return;
		
		switch(args[0]) {
		case "stack":
			sender.sendMessage(new TextComponentString(Stack(inventory)));
			return;
		case "unstack":
			sender.sendMessage(new TextComponentString(Unstack(inventory, world, player)));
			return;
		default :
			sender.sendMessage(new TextComponentString("Nothing Happened."));
			return;
		}
	}
	
	public String Stack(InventoryPlayer inventory) {
		
		int bronzeCount = inventory.clearMatchingItems(PierrcePackItems.coinBronze, -1, 0, null);
		int silverCount = inventory.clearMatchingItems(PierrcePackItems.coinSilver, -1, 0, null);
		int goldCount = inventory.clearMatchingItems(PierrcePackItems.coinGold, -1, 0, null);
		
		inventory.addItemStackToInventory(new ItemStack(PierrcePackItems.coinSilver, bronzeCount / References.coinStackSize));
		inventory.addItemStackToInventory(new ItemStack(PierrcePackItems.coinBronze, bronzeCount % References.coinStackSize));
		inventory.addItemStackToInventory(new ItemStack(PierrcePackItems.coinGold, silverCount / References.coinStackSize));
		inventory.addItemStackToInventory(new ItemStack(PierrcePackItems.coinSilver, silverCount % References.coinStackSize));
		inventory.addItemStackToInventory(new ItemStack(PierrcePackItems.coinPlatinum, goldCount / References.coinStackSize));
		inventory.addItemStackToInventory(new ItemStack(PierrcePackItems.coinGold, goldCount % References.coinStackSize));
		
		return "Coins have been stacked.";
	}
	
	public String Unstack(InventoryPlayer inventory, World world, EntityPlayer player) {
		
		int platinumCount = inventory.clearMatchingItems(PierrcePackItems.coinPlatinum, -1, 0, null);
		int silverCount = inventory.clearMatchingItems(PierrcePackItems.coinSilver, -1, 0, null);
		int goldCount = inventory.clearMatchingItems(PierrcePackItems.coinGold, -1, 0, null);
		
		if(platinumCount > 0)
			world.spawnEntity(new EntityItem(world, player.posX, player.posY, player.posZ, 
					new ItemStack(PierrcePackItems.coinGold, platinumCount * References.coinStackSize)));
		
		if(goldCount > 0)
			world.spawnEntity(new EntityItem(world, player.posX, player.posY, player.posZ, 
					new ItemStack(PierrcePackItems.coinSilver, goldCount * References.coinStackSize)));
		
		if(silverCount > 0)
			world.spawnEntity(new EntityItem(world, player.posX, player.posY, player.posZ, 
					new ItemStack(PierrcePackItems.coinBronze, silverCount * References.coinStackSize)));
		
		return "Coins have been unstacked.";
	}
}
