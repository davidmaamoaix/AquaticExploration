package cn.davidma.aquaticexploration.common.capability;

import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;

public class PlayerProgressCapabilityProvider implements ICapabilityProvider {
	
	@CapabilityInject(PlayerProgressCapability.class)
	public static Capability<PlayerProgressCapability> progressCap = null;
	
	private LazyOptional<PlayerProgressCapability> cap = 
		LazyOptional.of(progressCap::getDefaultInstance);
	
	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction dir) {
		return cap == progressCap ? this.cap.cast() : LazyOptional.empty();
	}
}
