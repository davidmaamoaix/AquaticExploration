package cn.davidma.aquaticexploration.util;

import cn.davidma.aquaticexploration.common.AquaticExploration;
import net.minecraft.util.ResourceLocation;

public class StringHelper {
	
	// ItemStack.
	public static final String STREAK_TAG = strLoc("streaks");
	
	// Cappability.
	public static final String PROGRESS_LIST_TAG = strLoc("progress_list");
		
	public static String strLoc(String name) {
		return AquaticExploration.MOD_ID + "." + name;
	}
	
	public static ResourceLocation loc(String name) {
		return new ResourceLocation(AquaticExploration.MOD_ID, name);
	}
}
