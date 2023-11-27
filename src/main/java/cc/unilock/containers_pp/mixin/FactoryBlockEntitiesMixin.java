package cc.unilock.containers_pp.mixin;

import cc.unilock.containers_pp.registry.CPPBlocks;
import eu.pb4.polyfactory.ModInit;
import eu.pb4.polyfactory.block.FactoryBlockEntities;
import eu.pb4.polymer.core.api.block.PolymerBlockUtils;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Objects;

@Mixin(FactoryBlockEntities.class)
public class FactoryBlockEntitiesMixin {
	@Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Leu/pb4/polyfactory/block/FactoryBlockEntities;register(Ljava/lang/String;Lnet/fabricmc/fabric/api/object/builder/v1/block/entity/FabricBlockEntityTypeBuilder;)Lnet/minecraft/block/entity/BlockEntityType;"/*, ordinal = 7*/))
	private static <T extends BlockEntity> BlockEntityType<T> register(String path, FabricBlockEntityTypeBuilder<T> item) {
		BlockEntityType<T> x;

		if (Objects.equals(path, "container")) {
			x = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(ModInit.ID, path), item.addBlocks(
				CPPBlocks.IRON_CONTAINER,
				CPPBlocks.GOLDEN_CONTAINER,
				CPPBlocks.DIAMOND_CONTAINER,
				CPPBlocks.OBSIDIAN_CONTAINER,
				CPPBlocks.NETHERITE_CONTAINER
			).build());
		} else {
			x = FactoryBlockEntities.register(path, item);
		}

		PolymerBlockUtils.registerBlockEntity(x);

		return x;
	}
}
