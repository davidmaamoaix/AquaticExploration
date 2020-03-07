package cn.davidma.aquaticexploration.common.subscriber;

import cn.davidma.aquaticexploration.common.AquaticExploration;
import cn.davidma.aquaticexploration.common.progress.Progress;
import cn.davidma.aquaticexploration.util.StringHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.RegistryBuilder;

@EventBusSubscriber(modid = AquaticExploration.MOD_ID, bus = Bus.MOD)
public class MiscSubscriber {
	
	@SubscribeEvent
	public static void registryRegistries(final RegistryEvent.NewRegistry event) {
		RegistryBuilder<Progress> progress = new RegistryBuilder<>();
		progress.setType(Progress.class);
		progress.setName(StringHelper.loc("progress"));
		progress.create();
	}
}
