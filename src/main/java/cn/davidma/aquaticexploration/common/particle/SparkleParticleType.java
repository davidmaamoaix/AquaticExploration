package cn.davidma.aquaticexploration.common.particle;

import cn.davidma.aquaticexploration.client.particle.SparkleParticle;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.Particle;
import net.minecraft.particles.ParticleType;
import net.minecraft.world.World;

public class SparkleParticleType extends ParticleType<SparkleParticleData> {

	public SparkleParticleType() {
		super(false, SparkleParticleData.DESERIALIZER);
	}
	
	public static class ParticleFactory implements IParticleFactory<SparkleParticleData> {

		@Override
		public Particle makeParticle(SparkleParticleData data,
			World world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			
			return new SparkleParticle(world, x, y, z, xSpeed, ySpeed, zSpeed,
				data.getSize(), data.getR(), data.getG(), data.getB());
		}
	}
}
