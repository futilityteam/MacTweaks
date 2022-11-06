package me.futility.mactweaks.mixin;

import net.minecraft.client.Mouse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Mouse.class)
public class MixinMouse {
    @Redirect(method = "onMouseButton", at = @At(value = "FIELD", target = "Lnet/minecraft/client/MinecraftClient;IS_SYSTEM_MAC:Z"))
    private boolean enableControlRightClick() {
        return false;
    }

    // The code below is taken from https://github.com/nelson2tm/shift-scroll-fix
    // Doubles and longs are counted twice, index 5 is vertical in onMouseScroll.
    @ModifyVariable(method = "onMouseScroll", at = @At("HEAD"), index = 5, argsOnly = true)
    private double scrollFix(double vertical1, long window, double horizontal, double vertical2) {
        return vertical1 == 0 ? horizontal : vertical1;
    }
}
