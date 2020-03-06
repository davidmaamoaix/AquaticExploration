package cn.davidma.aquaticexploration.common;

import cn.davidma.aquaticexploration.common.entity.AquaticEntities;
import cn.davidma.aquaticexploration.common.item.AquaticItems;
import cn.davidma.aquaticexploration.common.network.PacketManager;
import net.minecraftforge.fml.common.Mod;

@Mod(AquaticExploration.MOD_ID)
public class AquaticExploration {
	
	public static final String MOD_ID = "aquaticexploration";
	
	private static AquaticExploration instance;
		
	public AquaticExploration() {
		instance = this;
		
		AquaticItems.init();
		AquaticEntities.init();
		
		PacketManager.init();
	}
	
	public static AquaticExploration get() {
		return instance;
	}
}
