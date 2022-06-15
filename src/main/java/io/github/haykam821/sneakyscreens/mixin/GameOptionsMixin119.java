package io.github.haykam821.sneakyscreens.mixin;

import java.util.function.BooleanSupplier;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import io.github.haykam821.sneakyscreens.Main;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;

@Mixin(GameOptions.class)
public class GameOptionsMixin119 {
	@Unique
	private static final String SNEAK_KEY_ID = "key.sneak";

	@Shadow
	@Final
	private MinecraftClient client;

	@ModifyArg(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/option/StickyKeyBinding;<init>(Ljava/lang/String;ILjava/lang/String;Ljava/util/function/BooleanSupplier;)V"), index = 3)
	private BooleanSupplier modifyToggleGetter(String id, int code, String category, BooleanSupplier toggleGetter) {
		if (SNEAK_KEY_ID.equals(id)) {
			return () -> Main.toggleGetter(toggleGetter.getAsBoolean(), this.client);
		} else {
			return toggleGetter;
		}
	}
}