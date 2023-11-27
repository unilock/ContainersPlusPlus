package cc.unilock.containers_pp.block;

import eu.pb4.polyfactory.block.other.ContainerBlock;
import eu.pb4.polyfactory.block.other.ContainerBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class BigContainerBlock extends ContainerBlock {
	private final int slots;

	public BigContainerBlock(Settings settings, int slots) {
		super(settings);
		this.slots = slots;
	}

	@Override
	public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		return new ContainerBlockEntity(pos, state) {
			@Override
			public int getMaxCount(ItemStack stack) {
				return slots * stack.getMaxCount();
			}
		};
	}
}
