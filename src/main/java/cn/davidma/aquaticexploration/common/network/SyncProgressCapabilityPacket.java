package cn.davidma.aquaticexploration.common.network;

import cn.davidma.aquaticexploration.common.capability.PlayerProgressCapability;
import cn.davidma.aquaticexploration.common.capability.PlayerProgressCapabilityProvider;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.common.capabilities.Capability;

public class SyncProgressCapabilityPacket {
	
	private PlayerProgressCapability cap;
	
	public SyncProgressCapabilityPacket(PlayerProgressCapability cap) {
		this.cap = cap;
	}
	
	public SyncProgressCapabilityPacket(PacketBuffer buf) {
		Capability<PlayerProgressCapability> progressCap = 
			PlayerProgressCapabilityProvider.progressCap;
		this.cap = progressCap.getDefaultInstance();
		progressCap.readNBT(this.cap, null, buf.readCompoundTag());
	}
	
	public void encode(PacketBuffer buf) {
		Capability<PlayerProgressCapability> progressCap = 
			PlayerProgressCapabilityProvider.progressCap;
		buf.writeCompoundTag((CompoundNBT) progressCap.writeNBT(cap, null));
	}
	
	public PlayerProgressCapability getCapability() {
		return this.cap;
	}
}
