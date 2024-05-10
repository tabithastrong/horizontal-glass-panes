package com.witchica.panes.common;

import com.witchica.panes.common.block.HorizontalPaneBlock;
import dev.architectury.registry.CreativeTabOutput;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class HorizontalGlassPanes {
	public static final String MOD_ID = "horizontal_glass_panes";
	public static final Logger LOGGER = LoggerFactory.getLogger("horizontal_glass_panes");

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(MOD_ID, Registries.ITEM);
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(MOD_ID, Registries.BLOCK);
	public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(MOD_ID, Registries.CREATIVE_MODE_TAB);

	public static RegistrySupplier<Block> PANE_GLASS = BLOCKS.register("pane_glass", () -> new HorizontalPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE)));
	public static RegistrySupplier<Block> PANE_IRON = BLOCKS.register("pane_iron", () -> new HorizontalPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BARS)));

	public static RegistrySupplier<Block>[] COLORED_PANES = new RegistrySupplier[16];

	public static RegistrySupplier<CreativeModeTab> HORIZONTAL_TAB = TABS.register("generic", () ->
			CreativeTabRegistry.create(Component.translatable("itemGroup.horizontal_glass_panes.generic"), () -> new ItemStack(PANE_GLASS.get(), 1)));


	public static final Map<Integer, Block> HORIZONTAL_ID_TO_BLOCK = new HashMap<Integer, Block>();

	static {
		HORIZONTAL_ID_TO_BLOCK.put(0, Blocks.WHITE_STAINED_GLASS_PANE);
		HORIZONTAL_ID_TO_BLOCK.put(1, Blocks.ORANGE_STAINED_GLASS_PANE);
		HORIZONTAL_ID_TO_BLOCK.put(2, Blocks.MAGENTA_STAINED_GLASS_PANE);
		HORIZONTAL_ID_TO_BLOCK.put(3, Blocks.LIGHT_BLUE_STAINED_GLASS_PANE);
		HORIZONTAL_ID_TO_BLOCK.put(4, Blocks.YELLOW_STAINED_GLASS_PANE);
		HORIZONTAL_ID_TO_BLOCK.put(5, Blocks.LIME_STAINED_GLASS_PANE);
		HORIZONTAL_ID_TO_BLOCK.put(6, Blocks.PINK_STAINED_GLASS_PANE);
		HORIZONTAL_ID_TO_BLOCK.put(7, Blocks.GRAY_STAINED_GLASS_PANE);
		HORIZONTAL_ID_TO_BLOCK.put(8, Blocks.LIGHT_GRAY_STAINED_GLASS_PANE);
		HORIZONTAL_ID_TO_BLOCK.put(9, Blocks.CYAN_STAINED_GLASS_PANE);
		HORIZONTAL_ID_TO_BLOCK.put(10, Blocks.PURPLE_STAINED_GLASS_PANE);
		HORIZONTAL_ID_TO_BLOCK.put(11, Blocks.BLUE_STAINED_GLASS_PANE);
		HORIZONTAL_ID_TO_BLOCK.put(12, Blocks.BROWN_STAINED_GLASS_PANE);
		HORIZONTAL_ID_TO_BLOCK.put(13, Blocks.GREEN_STAINED_GLASS_PANE);
		HORIZONTAL_ID_TO_BLOCK.put(14, Blocks.RED_STAINED_GLASS_PANE);
		HORIZONTAL_ID_TO_BLOCK.put(15, Blocks.BLACK_STAINED_GLASS_PANE);

		ITEMS.register("pane_glass", () -> new BlockItem(PANE_GLASS.get(), new Item.Properties().arch$tab(HORIZONTAL_TAB)));
		ITEMS.register("pane_iron", () -> new BlockItem(PANE_IRON.get(), new Item.Properties().arch$tab(HORIZONTAL_TAB)));

		for(int i = 0; i < 16; i++) {
			String name = "pane_" + DyeColor.values()[i].name().toLowerCase();
			final int id = i;

			COLORED_PANES[i] = BLOCKS.register(name, () -> new HorizontalPaneBlock(BlockBehaviour.Properties.ofFullCopy(HORIZONTAL_ID_TO_BLOCK.get(id))));
			ITEMS.register(name, () -> new BlockItem(COLORED_PANES[id].get(), new Item.Properties().arch$tab(HORIZONTAL_TAB)));
		}
	}

	public static void onInitialize() {
		BLOCKS.register();
		ITEMS.register();
		TABS.register();
	}

	public static ResourceLocation makeResourceLocation(String name) {
		return new ResourceLocation(MOD_ID, name);
	}
}
