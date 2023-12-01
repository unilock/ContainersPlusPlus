package cc.unilock.containers_pp.mixin;

import cc.unilock.containers_pp.block.BigContainerBlock;
import eu.pb4.polyfactory.block.other.ContainerBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ContainerBlockEntity.class)
public abstract class ContainerBlockEntityMixin extends BlockEntity {
	public ContainerBlockEntityMixin(BlockEntityType<?> type, BlockPos pos, BlockState state) {
		super(type, pos, state);
	}

	@Inject(method = "getMaxCount", at = @At("RETURN"), cancellable = true)
	private void getMaxCount(ItemStack stack, CallbackInfoReturnable<Integer> cir) {
		if (this.getWorld() != null && !this.getWorld().isClient()) {
			if (this.getWorld().getBlockState(pos).getBlock() instanceof BigContainerBlock bcb) {
				cir.setReturnValue(bcb.getSlots() * stack.getMaxCount());
			}
		}
	}
}
