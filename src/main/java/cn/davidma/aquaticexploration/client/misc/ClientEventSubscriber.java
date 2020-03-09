package cn.davidma.aquaticexploration.client.misc;

import cn.davidma.aquaticexploration.client.render.entity.FancyItemEntityRenderer;
import cn.davidma.aquaticexploration.client.render.entity.JournalCreationEntityRenderer;
import cn.davidma.aquaticexploration.common.AquaticExploration;
import cn.davidma.aquaticexploration.common.entity.JournalCreationEntity;
import cn.davidma.aquaticexploration.common.particle.AquaticParticles;
import cn.davidma.aquaticexploration.common.particle.SparkleParticleType;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.ItemEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = AquaticExploration.MOD_ID, value = {Dist.CLIENT}, bus = Bus.MOD)
public class ClientEventSubscriber {
	
	@SubscribeEvent
	public static void clientSetup(final FMLClientSetupEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(
			ItemEntity.class, FancyItemEntityRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(
			JournalCreationEntity.class, JournalCreationEntityRenderer::new);
	}
	
	@SubscribeEvent
	public static void registerParticleFactories(ParticleFactoryRegisterEvent event) {
		Minecraft.getInstance().particles.registerFactory(
			AquaticParticles.SPARKLE.get(), new SparkleParticleType.ParticleFactory());
	}
}
