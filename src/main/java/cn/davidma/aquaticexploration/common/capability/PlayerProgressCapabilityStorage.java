package cn.davidma.aquaticexploration.common.capability;

import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

public class PlayerProgressCapabilityStorage implements Capability.IStorage<PlayerProgressCapability> {

	@Override
	public void readNBT(
			Capability<PlayerProgressCapability> cap, PlayerProgressCapability type, Direction dir, INBT arg3) {
		
	}

	@Override
	public INBT writeNBT(Capability<PlayerProgressCapability> cap, PlayerProgressCapability type, Direction dir) {
		return null;
	}
}
