package io.github.haykam821.sneakyscreens.mixin;

import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
	@Inject(at = @At("RETURN"), method="setScreen")
    private void openScreen(Screen screen, CallbackInfo ci) {
		if (screen == null) {
			KeyBinding.updatePressedStates();
		}
	}
}