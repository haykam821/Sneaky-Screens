package io.github.haykam821.sneakyscreens.mixin;

import net.minecraft.client.options.GameOptions;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.MinecraftClient;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import io.github.haykam821.sneakyscreens.Main;

@Mixin(GameOptions.class)
public class GameOptionsMixin {
	@Shadow KeyBinding keySneak;
	@Shadow boolean sneakToggled;

	@Inject(at = @At("RETURN"), method = "method_23487", cancellable = true)
    private void load(CallbackInfoReturnable<Boolean> info) {
		info.setReturnValue(Main.toggleGetter(this.sneakToggled, MinecraftClient.getInstance()));
	}
}