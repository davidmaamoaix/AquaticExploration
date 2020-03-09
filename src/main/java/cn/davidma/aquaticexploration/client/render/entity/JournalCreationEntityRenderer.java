package cn.davidma.aquaticexploration.client.render.entity;

import com.mojang.blaze3d.platform.GlStateManager;

import cn.davidma.aquaticexploration.common.entity.JournalCreationEntity;
import cn.davidma.aquaticexploration.common.item.AquaticItems;
import cn.davidma.aquaticexploration.common.particle.SparkleParticleData;
import cn.davidma.aquaticexploration.util.struct.LazyValue;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

@SuppressWarnings("deprecation")
public class JournalCreationEntityRenderer extends EntityRenderer<JournalCreationEntity> {
	
	private static final LazyValue<ItemStack> SHELL_STACK = 
		LazyValue.of(() -> new ItemStack(AquaticItems.ANCIENT_SHELL.get()));
	private static final LazyValue<ItemRenderer> ITEM_RENDERER = 
		LazyValue.of(Minecraft.getInstance()::getItemRenderer);
	
	public JournalCreationEntityRenderer(EntityRendererManager renderManager) {
		super(renderManager);
	}

	@Override
	protected ResourceLocation getEntityTexture(JournalCreationEntity entity) {
		return null;
	}
	
	@Override
	public void doRender(JournalCreationEntity entity,
		double x, double y, double z, float entityYaw, float partialTicks) {
		
		GlStateManager.pushMatrix();
		GlStateManager.translated(x, y + 0.5, z);
		GlStateManager.scaled(0.65, 0.65, 0.65);
		GlStateManager.rotated(entity.ticksExisted * entity.ticksExisted / 20, 0, 1, 0);
		ITEM_RENDERER.get().renderItem(SHELL_STACK.get(), TransformType.FIXED);
		GlStateManager.popMatrix();
		
		((ClientWorld) entity.world).addParticle(new SparkleParticleData(1, 1, 1, 1), true, entity.posX, entity.posY, entity.posZ, 0, 0.01, 0);
	}
}
