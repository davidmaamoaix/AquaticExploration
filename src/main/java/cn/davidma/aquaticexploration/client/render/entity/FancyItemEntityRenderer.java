package cn.davidma.aquaticexploration.client.render.entity;

import java.util.Random;

import com.mojang.blaze3d.platform.GlStateManager;

import cn.davidma.aquaticexploration.util.helper.StringHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.item.ItemEntity;

public class FancyItemEntityRenderer extends ItemRenderer {

	public FancyItemEntityRenderer(EntityRendererManager renderManager) {
		super(renderManager, Minecraft.getInstance().getItemRenderer());
	}
	
	@Override
	public void doRender(ItemEntity entity, double x, double y, double z, float yaw, float ticks) {
		super.doRender(entity, x, y, z, yaw, ticks);
		
		if (entity.getItem().getOrCreateTag().getBoolean(StringHelper.STREAK_TAG)) {
			GlStateManager.pushMatrix();
			GlStateManager.translated(x, y + 0.35, z);
			renderStreaks(0.1F, 0.1F, 15, entity.ticksExisted, ticks);
			GlStateManager.popMatrix();
		}
	}
	
	public static void renderStreaks(
		float width, float length, int maxStreakAmount, float entityTicks, float partialTicks) {
		
		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder buffer = tessellator.getBuffer();
		RenderHelper.disableStandardItemLighting();
		float f = (entityTicks + partialTicks) / 200;
		float f1 = 0;
		
		Random random = new Random(432L);
		GlStateManager.disableTexture();
		GlStateManager.shadeModel(7425);
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE);
		GlStateManager.disableAlphaTest();
		GlStateManager.enableCull();
		GlStateManager.depthMask(false);
		GlStateManager.pushMatrix();
		
		for(int i = 0; i < Math.min((f + f * f) / 2.0F * 60, maxStreakAmount); ++i) {
			GlStateManager.rotatef(random.nextFloat() * 360, 1, 0, 0);
			GlStateManager.rotatef(random.nextFloat() * 360, 0, 1, 0);
			GlStateManager.rotatef(random.nextFloat() * 360, 0, 0, 1);
			GlStateManager.rotatef(random.nextFloat() * 360, 1, 0, 0);
			GlStateManager.rotatef(random.nextFloat() * 360, 0, 1, 0);
			GlStateManager.rotatef(random.nextFloat() * 360 + f * 90, 0, 0, 1);
			float f2 = random.nextFloat() * 20 + 5.0F + f1 * 10;
			float f3 = (random.nextFloat() * 2.0F + 1 + f1 * 2.0F) * width;
			buffer.begin(6, DefaultVertexFormats.POSITION_COLOR);
			buffer.pos(0, 0, 0).color(255, 255, 255, 175).endVertex();
			buffer.pos(-0.866D * f3, f2 * length, (-0.5F * f3)).color(255, 0, 255, 0).endVertex();
			buffer.pos(0.866D * f3, f2 * length, (-0.5F * f3)).color(255, 0, 255, 0).endVertex();
			buffer.pos(0, f2 * length, (1 * f3)).color(255, 0, 255, 0).endVertex();
			buffer.pos(-0.866D * f3, f2 * length, (-0.5F * f3)).color(255, 0, 255, 0).endVertex();
			tessellator.draw();
		}
		
		GlStateManager.popMatrix();
		GlStateManager.depthMask(true);
		GlStateManager.disableCull();
		GlStateManager.disableBlend();
		GlStateManager.shadeModel(7424);
		GlStateManager.color4f(1, 1, 1, 1);
		GlStateManager.enableTexture();
		GlStateManager.enableAlphaTest();
		RenderHelper.enableStandardItemLighting();
	}
}
