package cn.davidma.aquaticexploration.common.capability;

import cn.davidma.aquaticexploration.common.progress.AquaticProgresses;
import cn.davidma.aquaticexploration.common.progress.Progress;
import cn.davidma.aquaticexploration.util.helper.StringHelper;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.nbt.StringNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Constants;

public class PlayerProgressCapabilityStorage implements Capability.IStorage<PlayerProgressCapability> {
	
	@Override
	public void readNBT(
		Capability<PlayerProgressCapability> type,
		PlayerProgressCapability cap, Direction dir, INBT nbt) {
		
		if (nbt instanceof CompoundNBT) {
			CompoundNBT tag = (CompoundNBT) nbt;
			
			ListNBT progresses = tag.getList(StringHelper.PROGRESS_LIST_TAG, Constants.NBT.TAG_STRING);
			progresses.forEach(stringTag -> {
				ResourceLocation key = new ResourceLocation(stringTag.getString());
				Progress progress = AquaticProgresses.PROGRESS_REGISTRY.get().getValue(key);
				
				if (progress != null) {
					cap.addProgress(progress);
				}
			});
		}
	}

	@Override
	public INBT writeNBT(
		Capability<PlayerProgressCapability> type, PlayerProgressCapability cap, Direction dir) {
		
		CompoundNBT tag = new CompoundNBT();
		
		ListNBT progresses = new ListNBT();
		cap.getProgressTracker().forEach(progress -> {
			progresses.add(new StringNBT(progress.getRegistryName().toString()));
		});
		tag.put(StringHelper.PROGRESS_LIST_TAG, progresses);
		
		return tag;
	}
}
