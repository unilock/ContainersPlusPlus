package cc.unilock.containers_pp.registry;

import cc.unilock.containers_pp.ContainersPP;
import eu.pb4.polymer.core.api.item.PolymerItemGroupUtils;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.text.Text;

public class CPPItemGroup {
	public static final ItemGroup DEFAULT = FabricItemGroup.builder()
		.displayName(Text.translatable("itemgroup.containers_pp"))
		.icon(CPPBlocks.DIAMOND_CONTAINER.asItem()::getDefaultStack)
		.entries((displayContext, entries) -> {
			entries.add(CPPBlocks.IRON_CONTAINER);
			entries.add(CPPBlocks.GOLDEN_CONTAINER);
			entries.add(CPPBlocks.DIAMOND_CONTAINER);
			entries.add(CPPBlocks.OBSIDIAN_CONTAINER);
			entries.add(CPPBlocks.NETHERITE_CONTAINER);
		})
		.build();

	public static void init() {
		PolymerItemGroupUtils.registerPolymerItemGroup(ContainersPP.id("default"), DEFAULT);
	}
}
