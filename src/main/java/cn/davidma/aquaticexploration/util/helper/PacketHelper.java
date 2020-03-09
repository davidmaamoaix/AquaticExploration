package cn.davidma.aquaticexploration.util.helper;

import cn.davidma.aquaticexploration.common.network.DisplayInfoMessagePacket;
import cn.davidma.aquaticexploration.common.network.PacketManager;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.fml.network.PacketDistributor;

/**
 * Shorthands for sending packets from server to client.
 * 
 * @author David Ma
 */
public class PacketHelper {
	
	public static void sendDisplayInfoMessage(ServerPlayerEntity player, ITextComponent text) {
		PacketManager.INSTANCE.send(
			PacketDistributor.PLAYER.with(() -> player),
			new DisplayInfoMessagePacket(text)
		);
	}
}
