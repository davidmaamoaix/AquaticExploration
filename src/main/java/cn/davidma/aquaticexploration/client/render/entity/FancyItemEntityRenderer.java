package cn.davidma.aquaticexploration.client.render.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.entity.item.ItemEntity;

public class FancyItemEntityRenderer extends ItemRenderer {

	public FancyItemEntityRenderer(EntityRendererManager renderManager) {
		super(renderManager, Minecraft.getInstance().getItemRenderer());
	}
	
	@Override
	public void doRender(ItemEntity entity, double x, double y, double z, float entityYaw, float partialTicks) {
		System.out.println("yay render");
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}
}
