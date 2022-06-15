package io.github.haykam821.sneakyscreens;

import net.minecraft.client.MinecraftClient;

public class Main {
	public static boolean toggleGetter(boolean sneakToggled, MinecraftClient client) {
		boolean screenVisible = client.currentScreen != null;
		boolean sneakInContainer = screenVisible && client.player != null && client.player.isPushedByFluids();

		return sneakToggled || sneakInContainer;
	}
}