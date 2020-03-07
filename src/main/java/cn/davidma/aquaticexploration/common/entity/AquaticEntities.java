package cn.davidma.aquaticexploration.common.entity;

import cn.davidma.aquaticexploration.common.AquaticExploration;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AquaticEntities {
	
	private static final DeferredRegister<EntityType<?>> ENTITIES = 
		new DeferredRegister<>(ForgeRegistries.ENTITIES, AquaticExploration.MOD_ID);
	
	public static final RegistryObject<EntityType<JournalCreationEntity>> JOURNAL_CREATION = null;
	
	public static void init() {
		ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
}
