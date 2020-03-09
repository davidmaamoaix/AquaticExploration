package cn.davidma.aquaticexploration.common.particle;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.minecraft.network.PacketBuffer;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleType;

public class SparkleParticleData implements IParticleData {
	
	private final float size;
	private final float r;
	private final float g;
	private final float b;
	
	public SparkleParticleData(float size, float r, float g, float b) {
		this.size = size;
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	@Override
	public ParticleType<?> getType() {
		return AquaticParticles.SPARKLE.get();
	}

	@Override
	public void write(PacketBuffer buffer) {
		buffer.writeFloat(this.size);
		buffer.writeFloat(this.r);
		buffer.writeFloat(this.g);
		buffer.writeFloat(this.b);
	}
	
	@Override
	public String getParameters() {
		return String.format("%s %.2f %.2f %.2f %.2f",
			this.getType().getRegistryName(), this.size, this.r, this.g, this.b);
	}
	
	public float getSize() {
		return this.size;
	}
	
	public float getR() {
		return this.r;
	}
	
	public float getG() {
		return this.g;
	}
	
	public float getB() {
		return this.b;
	}
	
	public static final IDeserializer<SparkleParticleData> DESERIALIZER = 
		new IDeserializer<SparkleParticleData>() {

			@Override
			public SparkleParticleData deserialize(
				ParticleType<SparkleParticleData> type, StringReader reader) 
				throws CommandSyntaxException {
				
				reader.expect(' ');
				float size = reader.readFloat();
				reader.expect(' ');
				float r = reader.readFloat();
				reader.expect(' ');
				float g = reader.readFloat();
				reader.expect(' ');
				float b = reader.readFloat();
				
				return new SparkleParticleData(size, r, g, b);
			}

			@Override
			public SparkleParticleData read(
				ParticleType<SparkleParticleData> type, PacketBuffer buffer) {
				
				return new SparkleParticleData(
					buffer.readFloat(), buffer.readFloat(), buffer.readFloat(), buffer.readFloat());
			}
		
	};
}
