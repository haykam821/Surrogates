package io.github.haykam821.surrogates;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Main implements ModInitializer {
	private static final Identifier ENDER_SURROGATE_ID = new Identifier("surrogates", "ender_surrogate");

	public static final Block ENDER_SURROGATE = new SurrogateBlock(FabricBlockSettings.copy(Blocks.END_STONE));
	public static final Item ENDER_SURROGATE_ITEM = new BlockItem(ENDER_SURROGATE, new Item.Settings().group(ItemGroup.REDSTONE));

	@Override
	public void onInitialize() {
		Registry.register(Registry.BLOCK, ENDER_SURROGATE_ID, ENDER_SURROGATE);
		Registry.register(Registry.ITEM, ENDER_SURROGATE_ID, ENDER_SURROGATE_ITEM);
	}
}