package com.witchica.panes.neoforge;

import com.witchica.panes.common.HorizontalGlassPanes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(HorizontalGlassPanes.MOD_ID)
public class HorizontalGlassPanesNeoForge {
    public HorizontalGlassPanesNeoForge(IEventBus bus) {
        HorizontalGlassPanes.onInitialize();
    }
}
