package me.futility.mactweaks.mixin;

import net.minecraft.text.TranslatableTextContent;
import net.minecraft.util.Language;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(TranslatableTextContent.class)
public class MixinTranslatableTextContent {
    @Redirect(method = "updateTranslations", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Language;get(Ljava/lang/String;)Ljava/lang/String;"))
    String getTranslation(Language lang, String key) {
        if (key.startsWith("key.keyboard.")) {
            return lang.get(key).replace("Alt", "Option").replace("Win", "Command");
        }
        return lang.get(key);
    }
}
