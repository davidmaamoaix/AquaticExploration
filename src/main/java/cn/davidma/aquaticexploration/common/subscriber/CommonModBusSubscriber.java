package cn.davidma.aquaticexploration.common.subscriber;

import cn.davidma.aquaticexploration.common.AquaticExploration;
import cn.davidma.aquaticexploration.common.capability.PlayerProgressCapability;
import cn.davidma.aquaticexploration.common.capability.PlayerProgressCapabilityStorage;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@EventBusSubscriber(modid = AquaticExploration.MOD_ID, bus = Bus.MOD)
public class CommonModBusSubscriber {
	
	@SubscribeEvent
	public static void parallelModLoading(final FMLCommonSetupEvent event) {
		CapabilityManager.INSTANCE.register(
			PlayerProgressCapability.class,
			new PlayerProgressCapabilityStorage(),
			PlayerProgressCapability::new
		);
	}
}
