package maple39.housingcommands.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import maple39.housingcommands.Listener;
import maple39.housingcommands.util.Chat;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.text.Text;

@Mixin(ChatHud.class)
public class MixinChatHud {
    @Inject(at = @At(value = "HEAD"), method = "Lnet/minecraft/client/gui/hud/ChatHud;addMessage(Lnet/minecraft/text/Text;I)V")
    public void addChatMessage(Text message, int messageId, CallbackInfo ci) {
        String m = Chat.stripColor(message.asString());

        m.replace("[VIP] ", "");
        m.replace("[VIP+] ", "");
        m.replace("[MVP] ", "");
        m.replace("[MVP+] ", "");
        m.replace("[MVP++] ", "");

        Listener.INSTANCE.onChatMessage(m);
    }
}
