package cc.unilock.containers_pp;

import cc.unilock.containers_pp.registry.CPPBlocks;
import cc.unilock.containers_pp.registry.CPPItemGroup;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class ContainersPP implements ModInitializer {
	public static final String MOD_ID = "containers_pp";
    //public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		CPPBlocks.init();
		CPPItemGroup.init();

		PolymerResourcePackUtils.addModAssets(MOD_ID);
		PolymerResourcePackUtils.markAsRequired();
	}

	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}
}
