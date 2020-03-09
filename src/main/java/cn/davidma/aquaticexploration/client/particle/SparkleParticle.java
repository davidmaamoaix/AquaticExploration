package cn.davidma.aquaticexploration.client.particle;

import org.lwjgl.opengl.GL11;

import com.mojang.blaze3d.platform.GlStateManager;

import cn.davidma.aquaticexploration.client.misc.Resources;
import cn.davidma.aquaticexploration.util.helper.MathHelper;
import cn.davidma.aquaticexploration.util.helper.StringHelper;
import net.minecraft.client.particle.IParticleRenderType;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class SparkleParticle extends Particle {
	
	private static final ResourceLocation SPARKLE_PARTICLE = 
		StringHelper.loc(Resources.SPARKLE_PARTICLE);
	private static final float DEFAULT_SIZE = 0.1F;
	
	private float scale;
	
	public SparkleParticle(World world, double x, double y, double z,
		double xSpeed, double ySpeed, double zSpeed, float size, float r, float g, float b) {
		
		super(world, x, y, z, xSpeed, ySpeed, zSpeed);
		
		this.particleRed = r;
		this.particleGreen = g;
		this.particleBlue = b;
		this.setSize(DEFAULT_SIZE, DEFAULT_SIZE);
		this.scale = size * MathHelper.randomFloat(this.rand, 1, 2);
		this.setMaxAge(500);
	}

	@Override
	public void renderParticle(
		BufferBuilder buffer, ActiveRenderInfo info, float partialTicks,
		float rotationX, float rotationZ, float rotationYZ, float rotationXY, float rotationXZ) {
		
		float texMin = this.age % 16 / 16F;
		float texMax = texMin + 1 / 16F;
		
		double x = this.prevPosX + (this.posX - this.prevPosX) * partialTicks - interpPosX;
		double y = this.prevPosY + (this.posY - this.prevPosY) * partialTicks - interpPosY;
		double z = this.prevPosZ + (this.posZ - this.prevPosZ) * partialTicks - interpPosZ;
		double size = DEFAULT_SIZE * this.scale * (this.maxAge - this.age + 1) / this.maxAge;
		
		/*buffer.pos(
			x - rotationX * size - rotationXY * size,
			y - rotationZ * size,
			z - rotationYZ * size - rotationXZ * size
		).tex(1, texMax).color(1, 1, 1, 1).endVertex();;
		buffer.pos(
			x - rotationX * size + rotationXY * size,
			y + rotationZ * size,
			z - rotationYZ * size + rotationXZ * size
		).tex(1, texMin).color(1, 1, 1, 1).endVertex();;
		buffer.pos(
			x + rotationX * size + rotationXY * size,
			y + rotationZ * size,
			z + rotationYZ * size + rotationXZ * size
		).tex(0, texMin).color(1, 1, 1, 1).endVertex();;
		buffer.pos(
			x + rotationX * size - rotationXY * size,
			y - rotationZ * size,
			z + rotationYZ * size - rotationXZ * size
		).tex(0, texMax).color(1, 1, 1, 1).endVertex();*/
		buffer.pos(x, y, z).color(1, 1, 1, 1).endVertex();
		buffer.pos(x, y, z + 10).color(1, 1, 1, 1).endVertex();
		buffer.pos(x + 10, y, z + 10).color(1, 1, 1, 1).endVertex();
		buffer.pos(x + 10, y, z).color(1, 1, 1, 1).endVertex();
	}

	@Override
	public IParticleRenderType getRenderType() {
		return SPARKLE_TYPE;
	}
	
	private static final IParticleRenderType SPARKLE_TYPE = new IParticleRenderType() {
		
		@Override
		public void beginRender(BufferBuilder buffer, TextureManager textureManager) {
			GlStateManager.enableBlend();
			GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
			GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
			GlStateManager.disableLighting();
			GlStateManager.depthMask(false);
			GlStateManager.color4f(1, 1, 1, 0.5F);
			textureManager.bindTexture(SPARKLE_PARTICLE);
			//buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX_COLOR);
			buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_COLOR);
		}
		
		@Override
		public void finishRender(Tessellator tessellator) {
			tessellator.draw();
			GlStateManager.depthMask(true);
			GlStateManager.disableBlend();
			GlStateManager.alphaFunc(GL11.GL_GREATER, 0.1F);
		}
	};
}
