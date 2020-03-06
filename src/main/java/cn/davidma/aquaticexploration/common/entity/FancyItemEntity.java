package cn.davidma.aquaticexploration.common.entity;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;

public class FancyItemEntity extends ItemEntity {
	
	private Set<DamageSource> invulnerableSources = new HashSet<>();
	private boolean shouldEmitStreaks;
	
	public FancyItemEntity(EntityType<FancyItemEntity> type, World world) {
		super(type, world);
	}
	
	public FancyItemEntity(FMLPlayMessages.SpawnEntity packet, World world) {
		super(AquaticEntities.FANCY_ITEM.get(), world);
	}
	
	public FancyItemEntity(World world, double x, double y, double z, ItemStack stack) {
		super(world,  x, y, z, stack);
	}
	
	public FancyItemEntity setInvulnerable(DamageSource... sources) {
		for (DamageSource i: sources) {
			this.invulnerableSources.add(i);
		}
		
		return this;
	}
	
	public FancyItemEntity shouldEmitStreaks(boolean shouldEmitStreaks) {
		this.shouldEmitStreaks = shouldEmitStreaks;
		
		return this;
	}
	
	@Override
	public boolean isInvulnerableTo(DamageSource source) {
		if (source == DamageSource.OUT_OF_WORLD) {
			return false;
		}
		
		return this.invulnerableSources.contains(source);
	}
	
	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
}
