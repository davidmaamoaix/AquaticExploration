package cn.davidma.aquaticexploration.common.network;

import net.minecraft.network.PacketBuffer;
import net.minecraft.util.text.ITextComponent;

/**
 * Tells the client to display a message in chat (will be automatically localized).
 * Collapses the previous message displayed from this packet.
 * 
 * @author David Ma
 */
public class DisplayInfoMessagePacket {
	
	private final ITextComponent text;
	
	public DisplayInfoMessagePacket(ITextComponent text) {
		this.text = text;
	}
	
	public DisplayInfoMessagePacket(PacketBuffer buf) {
		this(buf.readTextComponent());
	}
	
	public void encode(PacketBuffer buf) {
		buf.writeTextComponent(this.text);
	}
	
	public ITextComponent getText() {
		return this.text;
	}
}
