package cn.davidma.aquaticexploration.common.capability;

import cn.davidma.aquaticexploration.common.AquaticExploration;
import cn.davidma.aquaticexploration.util.StringHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = AquaticExploration.MOD_ID)
public class CapabilityAttacher {
	
	@SubscribeEvent
	public static void attachCapabilities(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof PlayerEntity) {
			event.addCapability(
				StringHelper.loc("player_progress"), new PlayerProgressCapabilityProvider());
		}
	}
}
