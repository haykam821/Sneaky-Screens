package io.github.haykam821.shiftymenus.mixin;

import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
	@Inject(at = @At("RETURN"), method="openScreen")
    private void openScreen(Screen screen, CallbackInfo ci) {
		if (screen == null) {
			KeyBinding.updatePressedStates();
		}
	}
}