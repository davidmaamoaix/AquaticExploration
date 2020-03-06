package cn.davidma.aquaticexploration.common.network;

import cn.davidma.aquaticexploration.client.util.ClientPacketHandler;
import cn.davidma.aquaticexploration.util.StringHelper;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class PacketManager {
	
	private static final String PROTOCOL_VERSION = "1";
	public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
		StringHelper.loc("channel"),
		() -> PROTOCOL_VERSION,
		PROTOCOL_VERSION::equals,
		PROTOCOL_VERSION::equals
	);
	
	private static int index;
	
	public static void init() {
		INSTANCE.registerMessage(
			index++,
			DisplayInfoMessagePacket.class,
			DisplayInfoMessagePacket::encode,
			DisplayInfoMessagePacket::new,
			ClientPacketHandler::onDisplayInfoMessagePacket
		);
	}
}
