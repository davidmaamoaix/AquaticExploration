package cn.davidma.aquaticexploration.client.util;

import java.util.function.Supplier;

import cn.davidma.aquaticexploration.common.network.DisplayInfoMessagePacket;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.fml.network.NetworkEvent;

public class ClientPacketHandler {
	
	public static void onDisplayInfoMessagePacket(
		DisplayInfoMessagePacket packet, Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> {
			OverlayHelper.displayChatMessage(new StringTextComponent(packet.getText()));
		});
		ctx.get().setPacketHandled(true);
	}
}
