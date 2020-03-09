package cn.davidma.aquaticexploration.common.progress;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class Progress extends ForgeRegistryEntry<Progress> {

	private int xPos;
	private int yPos;
	private ItemStack displayStack;
	private Set<Progress> parents;
	private Set<Progress> children;
	
	public Progress() {
		this.parents = new HashSet<>();
		this.children = new HashSet<>();
	}
	
	public Progress withPos(int x, int y) {
		this.xPos = x;
		this.yPos = y;
		
		return this;
	}
	
	public Progress withDisplay(ItemStack stack) {
		this.displayStack = stack;
		
		return this;
	}
	
	public Progress withParents(Set<Progress> parents) {
		this.parents = new HashSet<>(parents);
		
		return this;
	}
	
	public Progress withChildren(Set<Progress> parents) {
		this.children = new HashSet<>(parents);
		
		return this;
	}
	
	public int getX() {
		return this.xPos;
	}
	
	public int getY() {
		return this.yPos;
	}
	
	public ItemStack getDisplayStack() {
		return this.displayStack.copy();
	}
	
	public Set<Progress> getParents() {
		return this.parents;
	}
	
	public Set<Progress> getChildren() {
		return this.children;
	}
}
