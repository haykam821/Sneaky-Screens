package io.github.haykam821.sneakyscreens.mixin;

import net.minecraft.client.options.GameOptions;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.options.StickyKeyBinding;
import net.minecraft.client.MinecraftClient;
import java.io.File;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.github.haykam821.sneakyscreens.Main;

@Mixin(GameOptions.class)
public class GameOptionsMixin {
	@Shadow
	KeyBinding keySneak;
	boolean sneakToggled;

	@Inject(at = @At("RETURN"), method="<init>*")
    private void constructor(MinecraftClient client, File file, CallbackInfo info) {
		this.keySneak = new StickyKeyBinding("key.sneak", 340, "key.categories.movement", () -> {
			return Main.toggleGetter(this.sneakToggled, client);
      });
	}
}