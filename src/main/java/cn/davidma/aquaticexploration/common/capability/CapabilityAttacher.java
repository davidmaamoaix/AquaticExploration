package cn.davidma.aquaticexploration.common.capability;

import cn.davidma.aquaticexploration.util.StringHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class CapabilityAttacher {
	
	public static void attachCapabilities(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof PlayerEntity) {
			event.addCapability(
				StringHelper.loc("playerProgress"), new PlayerProgressCapabilityProvider());
		}
	}
}
