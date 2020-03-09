package cn.davidma.aquaticexploration.common.entity;

import cn.davidma.aquaticexploration.common.item.AquaticItems;
import cn.davidma.aquaticexploration.util.helper.EntityHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
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
	
	@Override
	public void tick() {
		this.posY += 0.01;
		if (!this.world.isRemote) {
			if (this.ticksExisted > 300) {
				ItemEntity entity = new ItemEntity(
					this.world,
					this.posX,
					this.posY,
					this.posZ,
					new ItemStack(AquaticItems.AQUATIC_JOURNAL.get())
				);
				entity.setNoGravity(true);
				entity.setNoDespawn();
				entity.setMotion(0, 0, 0);
				EntityHelper.addStreaks(entity);
				this.world.addEntity(entity);
				
				this.remove();
			}
		}
		super.tick();
	}
}
