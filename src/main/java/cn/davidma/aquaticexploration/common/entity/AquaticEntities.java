package cn.davidma.aquaticexploration.common.entity;

import cn.davidma.aquaticexploration.common.AquaticExploration;
import cn.davidma.aquaticexploration.util.helper.StringHelper;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AquaticEntities {
	
	private static final DeferredRegister<EntityType<?>> ENTITIES = 
		new DeferredRegister<>(ForgeRegistries.ENTITIES, AquaticExploration.MOD_ID);
	
	public static final RegistryObject<EntityType<JournalCreationEntity>> JOURNAL_CREATION = 
		ENTITIES.register("journal_creation", () -> 
			EntityType.Builder
			.<JournalCreationEntity>create(JournalCreationEntity::new, EntityClassification.MISC)
			.size(1, 1)
			.setTrackingRange(16)
			.setUpdateInterval(20)
			.build(StringHelper.strLoc("journal_creation")));
	
	public static void init() {
		ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
}
