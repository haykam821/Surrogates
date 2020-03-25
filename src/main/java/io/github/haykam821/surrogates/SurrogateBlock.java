package io.github.haykam821.surrogates;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.InventoryProvider;
import net.minecraft.container.Container;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class SurrogateBlock extends Block implements InventoryProvider {
	public SurrogateBlock(Settings settings) {
		super(settings);
	}

	@Override
	public SidedInventory getInventory(BlockState state, IWorld world, BlockPos pos) {
		Box box = new Box(pos).offset(0, 1, 0).contract(0.5);
		List<PlayerEntity> players = world.getNonSpectatingEntities(PlayerEntity.class, box);

		if (players.size() == 0) {
			return null;
		}

		PlayerEntity player = players.get(0);
		return new SidedPlayerInventory(player.inventory);
	}
}