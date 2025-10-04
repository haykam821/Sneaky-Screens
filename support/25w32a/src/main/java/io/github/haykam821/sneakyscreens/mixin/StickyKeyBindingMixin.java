package io.github.haykam821.sneakyscreens.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.github.haykam821.sneakyscreens.Main;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.option.StickyKeyBinding;

@Mixin(StickyKeyBinding.class)
public class StickyKeyBindingMixin extends KeyBinding {
	private StickyKeyBindingMixin(String id, int code, String category) {
		super(id, code, category);
	}

	@Inject(method = "reset", at = @At("HEAD"), cancellable = true)
	private void preventResettingSneak(CallbackInfo ci) {
		if (Main.SNEAK_KEY_ID.equals(this.getTranslationKey())) {
			ci.cancel();
		}
	}
}
