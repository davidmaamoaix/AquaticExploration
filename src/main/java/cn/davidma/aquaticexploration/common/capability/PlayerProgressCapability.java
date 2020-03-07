package cn.davidma.aquaticexploration.common.capability;

import java.util.HashSet;
import java.util.Set;

import cn.davidma.aquaticexploration.common.progress.Progress;

public class PlayerProgressCapability {
	
	private Set<Progress> progressTracker;
	
	public PlayerProgressCapability() {
		this.progressTracker = new HashSet<>();
	}
	
	public boolean hasProgress(Progress progress) {
		return this.progressTracker.contains(progress);
	}
	
	public void addProgress(Progress progress) {
		if (progress == null) {
			throw new NullPointerException("The added progress cannot be null.");
		}
		this.progressTracker.add(progress);
	}
	
	public void removeProgress(Progress progress) {
		this.progressTracker.remove(progress);
	}
	
	public Set<Progress> getProgressTracker() {
		return this.progressTracker;
	}
}
