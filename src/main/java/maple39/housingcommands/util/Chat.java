package maple39.housingcommands.util;

import java.util.regex.Pattern;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.network.packet.c2s.play.ChatMessageC2SPacket;

import maple39.housingcommands.mixin.IMixinClientPlayerInteractionManager;

/**
 * A utility for handling chat related tasks.
 */
public class Chat {
    /**
     * The character used for colors.
     */
    public static final char COLOR_CHAR = '\u00A7';

    /**
     * Removes the color codes from a {@link java.lang.String}.
     * 
     * @param input The original {@link java.lang.String}.
     * @return The {@link java.lang.String} without color codes.
     */
    public static String stripColor(final String input) {
        if (input == null) {
            return null;
        }

        return Pattern
            .compile("(?i)" + COLOR_CHAR + "[0-9A-FK-OR]")
            .matcher(input)
            .replaceAll("");
    }

    /**
     * Sends the specified chat message to the server.
     * 
     * @param message The message to send.
     */
    public static void sendChatMessage(final String message) {
        final ChatMessageC2SPacket chatPacket = new ChatMessageC2SPacket(message);

        final ClientPlayerInteractionManager c = MinecraftClient.getInstance().interactionManager;
        
        ClientPlayNetworkHandler h = ((IMixinClientPlayerInteractionManager) c).getNetworkHandler();
        
        h.sendPacket(chatPacket);
    }
}
