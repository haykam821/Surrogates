package io.github.haykam821.surrogates;

import java.util.stream.IntStream;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Direction;

public class SidedPlayerInventory implements SidedInventory {
	private static final int[] AVAILABLE_SLOTS = IntStream.rangeClosed(0, 35).toArray();

	public final PlayerInventory inventory;

	public SidedPlayerInventory(PlayerInventory inventory) {
		this.inventory = inventory;
	}
	
	@Override
	public int getInvSize() {
		return this.inventory.getInvSize();
	}

	@Override
	public boolean isInvEmpty() {
		return this.inventory.isInvEmpty();
	}

	@Override
	public ItemStack getInvStack(int index) {
		return this.inventory.getInvStack(index);
	}

	@Override
	public ItemStack takeInvStack(int index, int count) {
		return this.inventory.takeInvStack(index, count);
	}

	@Override
	public ItemStack removeInvStack(int index) {
		return this.inventory.removeInvStack(index);
	}

	@Override
	public void setInvStack(int index, ItemStack stack) {
		this.inventory.insertStack(index, stack);
	}

	@Override
	public void markDirty() {
		this.inventory.markDirty();
	}

	@Override
	public boolean canPlayerUseInv(PlayerEntity player) {
		return this.inventory.canPlayerUseInv(player);
	}

	@Override
	public void clear() {
		this.inventory.clear();
	}

	@Override
	public int[] getInvAvailableSlots(Direction direction) {
		return AVAILABLE_SLOTS;
	}

	@Override
	public boolean canInsertInvStack(int index, ItemStack stack, Direction direction) {
		if (this.inventory.getOccupiedSlotWithRoomForStack(stack) != -1) return true;
		return this.inventory.getEmptySlot() != -1;
	}

	@Override
	public boolean canExtractInvStack(int index, ItemStack stack, Direction direction) {
		return true;
	}

}