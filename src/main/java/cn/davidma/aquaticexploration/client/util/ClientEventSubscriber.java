package cn.davidma.aquaticexploration.client.util;

import cn.davidma.aquaticexploration.client.render.entity.FancyItemEntityRenderer;
import cn.davidma.aquaticexploration.common.entity.FancyItemEntity;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(bus = Bus.MOD)
public class ClientEventSubscriber {
	
	@SubscribeEvent
	public static void clientSetup(final FMLClientSetupEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(
			FancyItemEntity.class, FancyItemEntityRenderer::new);
	}
}
