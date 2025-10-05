package io.github.haykam821.sneakyscreens.mixin;

import java.util.function.BooleanSupplier;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import io.github.haykam821.sneakyscreens.Main;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;

@Mixin(GameOptions.class)
public class GameOptionsMixin1219 {
	@Shadow
	@Final
	private MinecraftClient client;

	@ModifyArg(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/option/StickyKeyBinding;<init>(Ljava/lang/String;ILnet/minecraft/client/option/KeyBinding$Category;Ljava/util/function/BooleanSupplier;Z)V"), index = 3)
	private BooleanSupplier modifyToggleGetter(String id, int code, KeyBinding.Category category, BooleanSupplier toggleGetter, boolean restore) {
		if (Main.SNEAK_KEY_ID.equals(id)) {
			return () -> Main.toggleGetter(toggleGetter.getAsBoolean(), this.client);
		} else {
			return toggleGetter;
		}
	}
}
