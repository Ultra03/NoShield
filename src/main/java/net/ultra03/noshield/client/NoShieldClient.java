package net.ultra03.noshield.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class NoShieldClient implements ClientModInitializer {
    public static boolean shouldRender = false;

    @Override
    public void onInitializeClient() {

    }
}
