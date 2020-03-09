package cn.davidma.aquaticexploration.common.particle;

import cn.davidma.aquaticexploration.common.AquaticExploration;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AquaticParticles {
	
	private static final DeferredRegister<ParticleType<?>> PARTICLES = 
		new DeferredRegister<>(ForgeRegistries.PARTICLE_TYPES, AquaticExploration.MOD_ID);
	
	public static final RegistryObject<SparkleParticleType> SPARKLE = 
		PARTICLES.register("sparkle", () -> new SparkleParticleType());
	
	public static void init() {
		PARTICLES.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
}
