package cn.davidma.aquaticexploration.common.subscriber;

import cn.davidma.aquaticexploration.common.AquaticExploration;
import cn.davidma.aquaticexploration.common.progress.AquaticProgresses;
import cn.davidma.aquaticexploration.common.progress.Progress;
import cn.davidma.aquaticexploration.util.helper.PlayerHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = AquaticExploration.MOD_ID)
public class PlayerProgressTriggerSubscriber {
	
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent event) {
		if (event.player.world.isRemote) return;
		
		PlayerEntity player = event.player;
		if (player.world.getFluidState(player.getPosition()).getFluid() == Fluids.WATER) {
			tryTriggerProgress(player, AquaticProgresses.SHELL_PICKUP);
		}
	}
	
	public static void tryTriggerProgress(PlayerEntity player, Progress progress) {
		PlayerHelper.obtainProgress(player, progress);
	}
}
