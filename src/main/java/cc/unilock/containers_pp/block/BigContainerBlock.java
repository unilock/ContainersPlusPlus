package cc.unilock.containers_pp.block;

import eu.pb4.polyfactory.block.other.ContainerBlock;

public class BigContainerBlock extends ContainerBlock {
	private final int slots;

	public BigContainerBlock(Settings settings, int slots) {
		super(settings);
		this.slots = slots;
	}

	public int getSlots() {
		return this.slots;
	}
}
