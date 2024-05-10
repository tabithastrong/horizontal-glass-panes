package com.witchica.panes.fabric;

import com.witchica.panes.common.HorizontalGlassPanes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;

public class HorizontalGlassPanesFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(HorizontalGlassPanes.PANE_GLASS.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HorizontalGlassPanes.PANE_IRON.get(), RenderType.cutout());

        for(int i = 0; i < 16; i++) {
            BlockRenderLayerMap.INSTANCE.putBlock(HorizontalGlassPanes.COLORED_PANES[i].get(), RenderType.translucent());
        }
    }
}
