package cn.davidma.aquaticexploration.util.helper;

import cn.davidma.aquaticexploration.common.capability.PlayerProgressCapabilityProvider;
import cn.davidma.aquaticexploration.common.network.PacketManager;
import cn.davidma.aquaticexploration.common.network.SyncProgressCapabilityPacket;
import cn.davidma.aquaticexploration.common.progress.Progress;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.PacketDistributor;

public class PlayerHelper {
	
	public static void givePlayerStackSafe(PlayerEntity player, ItemStack stack) {
		if (!player.inventory.addItemStackToInventory(stack)) {
			World world = player.world;
			ItemEntity entity = new ItemEntity(world, player.posX, player.posY, player.posZ, stack);
			world.addEntity(entity);
		}
	}
	
	public static void obtainProgress(PlayerEntity player, Progress progress, Runnable callback) {
		player.getCapability(PlayerProgressCapabilityProvider.progressCap).ifPresent(cap -> {
			if (!cap.hasProgress(progress)) {
				if (callback != null) {
					callback.run();
				}
				cap.addProgress(progress);
				PacketManager.INSTANCE.send(
					PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) player),
					new SyncProgressCapabilityPacket(cap)
				);
			}
		});
	}
}
