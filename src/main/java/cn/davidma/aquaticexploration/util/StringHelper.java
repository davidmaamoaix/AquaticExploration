package cn.davidma.aquaticexploration.util;

import cn.davidma.aquaticexploration.common.AquaticExploration;
import net.minecraft.util.ResourceLocation;

public class StringHelper {
	
	public static ResourceLocation loc(String name) {
		return new ResourceLocation(AquaticExploration.MOD_ID, name);
	}
}
