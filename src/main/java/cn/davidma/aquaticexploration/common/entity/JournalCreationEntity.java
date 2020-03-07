package cn.davidma.aquaticexploration.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class JournalCreationEntity extends Entity {

	public JournalCreationEntity(EntityType<?> type, World world) {
		super(type, world);
	}
	
	public JournalCreationEntity(World world, double x, double y, double z) {
		super(AquaticEntities.JOURNAL_CREATION.get(), world);
		this.setPosition(x, y, z);
	}

	@Override
	protected void registerData() {
		
	}

	@Override
	protected void readAdditional(CompoundNBT compound) {
		
	}

	@Override
	protected void writeAdditional(CompoundNBT compound) {
		
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
}
