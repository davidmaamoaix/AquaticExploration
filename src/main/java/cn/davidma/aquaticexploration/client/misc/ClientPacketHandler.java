package cn.davidma.aquaticexploration.client.misc;

import java.util.function.Supplier;

import cn.davidma.aquaticexploration.common.capability.PlayerProgressCapabilityProvider;
import cn.davidma.aquaticexploration.common.network.DisplayInfoMessagePacket;
import cn.davidma.aquaticexploration.common.network.SyncProgressCapabilityPacket;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.network.NetworkEvent;

public class ClientPacketHandler {
	
	public static void onDisplayInfoMessagePacket(
		DisplayInfoMessagePacket packet, Supplier<NetworkEvent.Context> ctx) {
		
		ctx.get().enqueueWork(() -> {
			OverlayHelper.displayChatMessage(packet.getText());
		});
		ctx.get().setPacketHandled(true);
	}
	
	public static void onSyncProgressCapabilityPacket(
		SyncProgressCapabilityPacket packet, Supplier<NetworkEvent.Context> ctx) {
		
		ctx.get().enqueueWork(() -> {
			Minecraft.getInstance().player.getCapability(PlayerProgressCapabilityProvider.progressCap)
			.ifPresent(cap -> {
				cap.copyFrom(packet.getCapability());
			});
		});
		ctx.get().setPacketHandled(true);
	}
}
