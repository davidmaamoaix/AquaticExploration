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
	
	private final String text;
	
	public DisplayInfoMessagePacket(String text) {
		this.text = text;
	}
	
	public DisplayInfoMessagePacket(ITextComponent text) {
		this(text.getFormattedText());
	}
	
	public DisplayInfoMessagePacket(PacketBuffer buf) {
		this(buf.readString());
	}
	
	public void encode(PacketBuffer buf) {
		buf.writeString(this.text);
	}
	
	public String getText() {
		return this.text;
	}
}
