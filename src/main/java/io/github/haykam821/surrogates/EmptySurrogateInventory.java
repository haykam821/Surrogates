package io.github.haykam821.surrogates;

import net.minecraft.inventory.BasicInventory;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Direction;

public class EmptySurrogateInventory extends BasicInventory implements SidedInventory {
	public EmptySurrogateInventory() {
		super(0);
	}

	public int[] getInvAvailableSlots(Direction direction) {
		return new int[0];
	}

	public boolean canInsertInvStack(int index, ItemStack stack, Direction direction) {
		return false;
	}

	public boolean canExtractInvStack(int index, ItemStack stack, Direction direction) {
		return false;
	}

}