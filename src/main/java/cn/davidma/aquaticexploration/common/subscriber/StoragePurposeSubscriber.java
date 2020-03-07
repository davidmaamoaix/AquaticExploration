package cn.davidma.aquaticexploration.common.subscriber;

import cn.davidma.aquaticexploration.common.AquaticExploration;
import cn.davidma.aquaticexploration.util.StringHelper;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = AquaticExploration.MOD_ID)
public class StoragePurposeSubscriber {
	
	@SubscribeEvent
	public static void onItemPickup(final EntityItemPickupEvent event) {
		if (event.getPlayer().world.isRemote) return;
		
		CompoundNBT tag = event.getItem().getItem().getOrCreateTag();
		if (tag.contains(StringHelper.STREAK_TAG)) {
			tag.remove(StringHelper.STREAK_TAG);
		}
	}
}
