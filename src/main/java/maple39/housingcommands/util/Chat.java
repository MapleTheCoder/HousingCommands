package maple39.housingcommands.util;

import java.util.regex.Pattern;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.network.packet.c2s.play.ChatMessageC2SPacket;

public class Chat {
    public static final char COLOR_CHAR = '\u00A7';

    public static String stripColor(final String input) {
        if (input == null) {
            return null;
        }

        return Pattern
            .compile("(?i)" + COLOR_CHAR + "[0-9A-FK-OR]")
            .matcher(input)
            .replaceAll("");
    }

    public static void sendChatMessage(final String message) {
        final ChatMessageC2SPacket chatPacket = new ChatMessageC2SPacket(message);

        final ClientPlayerInteractionManager c = MinecraftClient.getInstance().interactionManager;
        
        ClientPlayNetworkHandler h = (ClientPlayNetworkHandler) JvmReflectionUtil
                .getPrivateFieldValue(ClientPlayerInteractionManager.class, c, "networkHandler");
        
        h.sendPacket(chatPacket);
    }
}
