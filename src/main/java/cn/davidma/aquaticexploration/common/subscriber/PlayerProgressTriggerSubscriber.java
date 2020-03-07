package cn.davidma.aquaticexploration.common.subscriber;

import cn.davidma.aquaticexploration.common.AquaticExploration;
import cn.davidma.aquaticexploration.common.capability.PlayerProgressCapabilityProvider;
import cn.davidma.aquaticexploration.common.network.DisplayInfoMessagePacket;
import cn.davidma.aquaticexploration.common.network.PacketManager;
import cn.davidma.aquaticexploration.common.progress.AquaticProgresses;
import cn.davidma.aquaticexploration.common.progress.Progress;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.network.PacketDistributor;

@EventBusSubscriber(modid = AquaticExploration.MOD_ID)
public class PlayerProgressTriggerSubscriber {
	
	@SubscribeEvent
	public static void onPlayerTick(final PlayerTickEvent event) {
		if (event.player.world.isRemote) return;
		
		PlayerEntity player = event.player;
		if (player.world.getFluidState(player.getPosition()).getFluid() == Fluids.WATER) {
			tryTriggerProgress(player, AquaticProgresses.SHELL_PICKUP.get());
		}
	}
	
	public static void tryTriggerProgress(final PlayerEntity player, final Progress progress) {
		player.getCapability(PlayerProgressCapabilityProvider.progressCap).ifPresent(cap -> {
			if (!cap.hasProgress(progress)) {
				cap.addProgress(progress);
				PacketManager.INSTANCE.send(
					PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) player),
					new DisplayInfoMessagePacket(new StringTextComponent("Shell pickup"))
				);
			}
		});
	}
}
