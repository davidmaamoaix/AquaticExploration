package cn.davidma.aquaticexploration.common.subscriber;

import cn.davidma.aquaticexploration.common.AquaticExploration;
import cn.davidma.aquaticexploration.common.item.AquaticItems;
import cn.davidma.aquaticexploration.common.progress.AquaticProgresses;
import cn.davidma.aquaticexploration.common.progress.Progress;
import cn.davidma.aquaticexploration.util.helper.PacketHelper;
import cn.davidma.aquaticexploration.util.helper.PlayerHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
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
			tryTriggerProgress(player, AquaticProgresses.SHELL_PICKUP, () -> {
				PlayerHelper.givePlayerStackSafe(
					player, new ItemStack(AquaticItems.ANCIENT_SHELL.get()));
				PacketHelper.sendDisplayInfoMessage(
					(ServerPlayerEntity) player,
					new TranslationTextComponent("chat.aquaticexploration.shell_pickup")
					.applyTextStyle(TextFormatting.LIGHT_PURPLE)
				);
			});
		}
	}
	
	public static void tryTriggerProgress(PlayerEntity player, Progress progress, Runnable callback) {
		PlayerHelper.obtainProgress(player, progress, callback);
	}
}
