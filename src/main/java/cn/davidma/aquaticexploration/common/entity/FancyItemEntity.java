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
		this(AquaticEntities.FANCY_ITEM.get(), world);
	}
	
	public FancyItemEntity(World world, double x, double y, double z, ItemStack stack) {
		this(AquaticEntities.FANCY_ITEM.get(), world);
		this.setItem(stack);
		this.rotationYaw = this.rand.nextFloat() * 360.0F;
		this.setMotion(this.rand.nextDouble() * 0.2 - 0.1, 0.2, this.rand.nextDouble() * 0.2 - 0.1);
		this.lifespan = (stack.getItem() == null ? 6000 : stack.getEntityLifespan(world));
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
