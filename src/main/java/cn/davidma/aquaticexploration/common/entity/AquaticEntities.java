package cn.davidma.aquaticexploration.common.entity;

import cn.davidma.aquaticexploration.common.AquaticExploration;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AquaticEntities {
	
	private static final DeferredRegister<EntityType<?>> ENTITIES = 
		new DeferredRegister<>(ForgeRegistries.ENTITIES, AquaticExploration.MOD_ID);
	public static final RegistryObject<EntityType<FancyItemEntity>> FANCY_ITEM = 
		ENTITIES.register("fancy_item", () -> 
			EntityType.Builder.<FancyItemEntity>create(FancyItemEntity::new, EntityClassification.MISC)
			.setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(24)
			.setUpdateInterval(60)
			.setCustomClientFactory(FancyItemEntity::new)
			.build("fancy_item")
		);
	
	public static void init() {
		ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
}
