package cn.davidma.aquaticexploration.util;

import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PlayerHelper {
	
	public static void givePlayerStackSafe(PlayerEntity player, ItemStack stack) {
		if (!player.inventory.addItemStackToInventory(stack)) {
			World world = player.world;
			ItemEntity entity = new ItemEntity(world, player.posX, player.posY, player.posZ, stack);
			world.addEntity(entity);
		}
	}
}
