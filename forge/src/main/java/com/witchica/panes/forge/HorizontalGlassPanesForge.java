package com.witchica.panes.forge;

import com.witchica.panes.common.HorizontalGlassPanes;
import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(com.witchica.panes.common.HorizontalGlassPanes.MOD_ID)
public class HorizontalGlassPanesForge {
    public HorizontalGlassPanesForge() {
        EventBuses.registerModEventBus(HorizontalGlassPanes.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());

        // Run our common setup.
        HorizontalGlassPanes.onInitialize();
    }
}
