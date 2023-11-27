package cc.unilock.containers_pp.registry;

import cc.unilock.containers_pp.ContainersPP;
import cc.unilock.containers_pp.block.BigContainerBlock;
import eu.pb4.polyfactory.item.FactoryItems;
import eu.pb4.polymer.core.api.block.PolymerBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class CPPBlocks {
	// NOTE: PolyFactory's Container has 36 slots (9 * 4)
	public static final BigContainerBlock IRON_CONTAINER = register("iron_container", new BigContainerBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).nonOpaque(), 9 * 6));
	public static final BigContainerBlock GOLDEN_CONTAINER = register("golden_container", new BigContainerBlock(AbstractBlock.Settings.copy(Blocks.GOLD_BLOCK).nonOpaque(), 9 * 9));
	public static final BigContainerBlock DIAMOND_CONTAINER = register("diamond_container", new BigContainerBlock(AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK).nonOpaque(), 9 * 14));
	public static final BigContainerBlock OBSIDIAN_CONTAINER = register("obsidian_container", new BigContainerBlock(AbstractBlock.Settings.copy(Blocks.OBSIDIAN).nonOpaque(), 9 * 14));
	public static final BigContainerBlock NETHERITE_CONTAINER = register("netherite_container", new BigContainerBlock(AbstractBlock.Settings.copy(Blocks.NETHERITE_BLOCK).nonOpaque(), 9 * 21));

	public static void init() {}

	private static <T extends Block & PolymerBlock> T register(String path, T block) {
		Registry.register(Registries.BLOCK, ContainersPP.id(path), block);
		FactoryItems.register(block);
		return block;
	}
}
