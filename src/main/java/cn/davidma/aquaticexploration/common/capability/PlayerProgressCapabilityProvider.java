package cn.davidma.aquaticexploration.common.capability;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class PlayerProgressCapabilityProvider implements ICapabilitySerializable<CompoundNBT> {
	
	@CapabilityInject(PlayerProgressCapability.class)
	public static Capability<PlayerProgressCapability> progressCap = null;
	
	private LazyOptional<PlayerProgressCapability> cap = 
		LazyOptional.of(progressCap::getDefaultInstance);
	
	// Cached value to circumvent enclosing scope (yea it sucks).
	private CompoundNBT cacheTag;
	
	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction dir) {
		return cap == progressCap ? this.cap.cast() : LazyOptional.empty();
	}

	@Override
	public CompoundNBT serializeNBT() {
		this.cacheTag  = new CompoundNBT();
		this.cap.ifPresent(instance -> {
			this.cacheTag = 
				(CompoundNBT) progressCap.getStorage().writeNBT(progressCap, instance, null);
		});
		return this.cacheTag;
	}

	@Override
	public void deserializeNBT(CompoundNBT tag) {
		this.cap.ifPresent(instance -> {
			progressCap.getStorage().readNBT(progressCap, instance, null, tag);
		});
	}
}
