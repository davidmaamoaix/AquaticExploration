package cn.davidma.aquaticexploration.client.util;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ITextComponent;

public class OverlayHelper {
	
	private static final int AQUATIC_CHAT_ID = 666;
	
	/**
	 * Displays a message in chat. Collapse previous messages created by this.
	 */
	public static void displayChatMessage(ITextComponent text) {
		Minecraft mc = Minecraft.getInstance();
		mc.ingameGUI.getChatGUI().printChatMessageWithOptionalDeletion(text, AQUATIC_CHAT_ID);
	}
}
