package cn.davidma.aquaticexploration.common.progress;

import cn.davidma.aquaticexploration.common.AquaticExploration;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;

public class AquaticProgresses {
	
	public static final IForgeRegistry<Progress> PROGRESS_REGISTRY = 
		GameRegistry.findRegistry(Progress.class);
	
	private static final DeferredRegister<Progress> PROGRESSES = 
		new DeferredRegister<>(GameRegistry.findRegistry(Progress.class), AquaticExploration.MOD_ID);
	
	public static final RegistryObject<Progress> SHELL_PICKUP = 
		PROGRESSES.register("shell_pickup", () -> new Progress().withPos(0, 0));
	
	public static void init() {
		PROGRESSES.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
}
