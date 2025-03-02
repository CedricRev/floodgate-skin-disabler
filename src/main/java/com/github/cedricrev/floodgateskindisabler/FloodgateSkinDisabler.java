package com.github.cedricrev.floodgateskindisabler;

import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.geysermc.floodgate.api.FloodgateApi;
import org.geysermc.floodgate.api.event.skin.SkinApplyEvent;

import java.util.function.Consumer;


public final class FloodgateSkinDisabler extends JavaPlugin implements Consumer<SkinApplyEvent> {

    @Override
    public void onEnable() {
        FloodgateApi.getInstance().getEventBus().subscribe(SkinApplyEvent.class, this);
    }

    @Override
    public void accept(SkinApplyEvent skinApplyEvent) {
        SkinApplyEvent.SkinData skin = new SkinApplyEvent.SkinData() {
            @Override
            public @NonNull String value() {
                return "";
            }

            @Override
            public @NonNull String signature() {
                return "";
            }
        };
        skinApplyEvent.newSkin(skin);
    }
}
