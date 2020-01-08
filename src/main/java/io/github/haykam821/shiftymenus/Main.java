package io.github.haykam821.shiftymenus;

import net.minecraft.client.MinecraftClient;

public class Main {
	public static boolean toggleGetter(boolean sneakToggled, MinecraftClient client) {
		boolean screenVisible = client.currentScreen != null;
		return sneakToggled || screenVisible;
	}
}