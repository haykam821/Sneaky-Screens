package io.github.haykam821.sneakyscreens.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import io.github.haykam821.sneakyscreens.Main;
import net.minecraft.client.MinecraftClient;

@Pseudo
@Mixin(targets = "net.minecraft.class_315", remap = false)
public abstract class GameOptionsMixin {
	@Accessor("field_21332")
	protected abstract boolean getSneakToggled();

	@Inject(at = @At("RETURN"), method = "method_23487", cancellable = true, remap = false)
    private void load(CallbackInfoReturnable<Boolean> info) {
		info.setReturnValue(Main.toggleGetter(this.getSneakToggled(), MinecraftClient.getInstance()));
	}
}