package maple39.housingcommands.mixins;

import java.util.ArrayList;
import java.util.Arrays;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.text.Text;

@Mixin(ChatHud.class)
public class MixinChatHud {
    @Inject(at = @At(value = "HEAD"), method = "Lnet/minecraft/client/gui/hud/ChatHud;addMessage(Lnet/minecraft/text/Text;I)V")
    public void addChatMessage(Text message, int messageId, CallbackInfo ci) {
        String m = message.asString();

        m.replace("[VIP] ", "");
        m.replace("[VIP+] ", "");
        m.replace("[MVP] ", "");
        m.replace("[MVP+] ", "");
        m.replace("[MVP++] ", "");

        System.out.println(m);

        ArrayList<String> split = (ArrayList<String>) Arrays.asList(m.split("!"));

        split.remove(0);
        if (split.size() == 0) {
            // message is just "!" with no command
            return;
        }
        String command = split.get(0);
        System.out.println(command);
    }
}
