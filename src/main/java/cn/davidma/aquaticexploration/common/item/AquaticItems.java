package cn.davidma.aquaticexploration.common.item;

import cn.davidma.aquaticexploration.common.AquaticExploration;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AquaticItems {
	
	private static final DeferredRegister<Item> ITEMS = 
		new DeferredRegister<>(ForgeRegistries.ITEMS, AquaticExploration.MOD_ID);
	
	public static final RegistryObject<Item> ANCIENT_SHELL = 
		ITEMS.register("ancient_shell", () -> new AncientShellItem());
	public static final RegistryObject<Item> AQUATIC_JOURNAL = 
		ITEMS.register("aquatic_journal", () -> new AquaticJournalItem());
	
	public static final ItemGroup aquaticItemGroup = new ItemGroup(AquaticExploration.MOD_ID) {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(ANCIENT_SHELL.get());
		}
	};
	
	public static void init() {
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
}
