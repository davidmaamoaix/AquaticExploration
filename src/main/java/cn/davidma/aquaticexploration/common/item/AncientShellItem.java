package cn.davidma.aquaticexploration.common.item;

import java.util.List;

import cn.davidma.aquaticexploration.common.entity.FancyItemEntity;
import cn.davidma.aquaticexploration.common.network.DisplayInfoMessagePacket;
import cn.davidma.aquaticexploration.common.network.PacketManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.fml.network.PacketDistributor;

public class AncientShellItem extends Item {

	public AncientShellItem() {
		super(new Item.Properties().group(AquaticItems.aquaticItemGroup).rarity(Rarity.UNCOMMON));
	}
	
	@Override
	public ActionResultType onItemUse(ItemUseContext ctx) {
		if (!ctx.getWorld().isRemote) {
			BlockPos pos = ctx.getPos().offset(ctx.getFace());
			if (ctx.getWorld().getFluidState(pos).getFluid() != Fluids.WATER) {
				return ActionResultType.FAIL;
			}
			
			Biome biome = ctx.getWorld().getBiome(pos);
			PlayerEntity player = ctx.getPlayer();
			if (biome.getRegistryName().toString().contains("ocean") || biome == Biomes.BEACH) {
				ItemStack heldStack = player.inventory.getCurrentItem();
				heldStack.setCount(heldStack.getCount() - 1);
				
				FancyItemEntity entity = new FancyItemEntity(
					ctx.getWorld(),
					pos.getX() + 0.5,
					pos.getY() + 0.5,
					pos.getZ() + 0.5,
					new ItemStack(AquaticItems.AQUATIC_JOURNAL.get())
				);
				entity.setNoGravity(true);
				entity.setNoDespawn();
				entity.setMotion(0, 0, 0);
				entity.shouldEmitStreaks(true);
				ctx.getWorld().addEntity(entity);
			} else {
				ITextComponent text = new TranslationTextComponent("chat.aquaticexploration.not_ocean");
				text.applyTextStyle(TextFormatting.LIGHT_PURPLE);
				PacketManager.INSTANCE.send(
					PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) player),
					new DisplayInfoMessagePacket(text)
				);
				return ActionResultType.FAIL;
			}
		}
		
		return ActionResultType.PASS;
	}
	
	@Override
	public void addInformation(
			ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
		String key = I18n.format("tooltip.aquaticexploration.ancient_shell");
		ITextComponent text = new StringTextComponent(key);
		text.applyTextStyle(TextFormatting.LIGHT_PURPLE);
		tooltip.add(text);
	}
}
