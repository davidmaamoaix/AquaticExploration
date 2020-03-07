package cn.davidma.aquaticexploration.util.helper;

import net.minecraft.entity.item.ItemEntity;

public class EntityHelper {
	
	public static void addStreaks(ItemEntity entity) {
		entity.getItem().getOrCreateTag().putBoolean(StringHelper.STREAK_TAG, true);
	}
}
