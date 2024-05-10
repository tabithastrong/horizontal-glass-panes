package com.witchica.panes.fabric;

import com.witchica.panes.common.HorizontalGlassPanes;
import com.witchica.panes.common.block.HorizontalPaneBlock;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class HorizontalGlassPanesFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        HorizontalGlassPanes.onInitialize();
    }
}
