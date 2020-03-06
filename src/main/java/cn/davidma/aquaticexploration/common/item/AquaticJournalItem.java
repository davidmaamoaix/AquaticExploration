package cn.davidma.aquaticexploration.common.item;

import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class AquaticJournalItem extends Item {

	public AquaticJournalItem() {
		super(
			new Item.Properties()
			.group(AquaticItems.aquaticItemGroup)
			.rarity(Rarity.RARE)
			.maxStackSize(1)
		);
	}
	
	@Override
	public void addInformation(
		ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
		String key = I18n.format("tooltip.aquaticexploration.aquatic_journal");
		ITextComponent text = new StringTextComponent(key);
		text.applyTextStyle(TextFormatting.GRAY);
		tooltip.add(text);
	}
}
