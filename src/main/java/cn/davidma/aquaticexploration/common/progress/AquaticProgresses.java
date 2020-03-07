package cn.davidma.aquaticexploration.common.progress;

import cn.davidma.aquaticexploration.common.AquaticExploration;
import cn.davidma.aquaticexploration.util.helper.StringHelper;
import cn.davidma.aquaticexploration.util.struct.LazyValue;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@EventBusSubscriber(modid = AquaticExploration.MOD_ID, bus = Bus.MOD)
public class AquaticProgresses {
	
	public static final LazyValue<IForgeRegistry<Progress>> PROGRESS_REGISTRY = 
		LazyValue.of(() -> GameRegistry.findRegistry(Progress.class));
	
	@ObjectHolder(AquaticExploration.MOD_ID + ":shell_pickup")
	public static final Progress SHELL_PICKUP = null;
	
	@SubscribeEvent
	public static void registerProgresses(final RegistryEvent.Register<Progress> event) {
		event.getRegistry().registerAll(
			new Progress().withPos(0, 0).setRegistryName(StringHelper.loc("shell_pickup"))
		);
	}
}
