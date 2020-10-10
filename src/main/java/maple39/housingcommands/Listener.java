package maple39.housingcommands;

import java.util.ArrayList;
import java.util.Arrays;

import maple39.housingcommands.util.Chat;

/**
 * A class that listens for chat messages and handles them.
 */
public class Listener {
    /**
     * The globally usable instance of this class.
     */
    public static final Listener INSTANCE = new Listener();

    /**
     * Basic empty constructor.
     */
    public Listener() {
    }

    /**
     * Called when a chat message is recieved.
     * 
     * @param message The raw text of the message.
     */
    public void onChatMessage(String message) {
        System.out.println(message);

        // An array list of every word in the message.
        ArrayList<String> split = new ArrayList<String>(Arrays.asList(message.split(" ")));

        // For each command in the config file, check if it matches the command
        // just typed in chat
        for (String inConfigCommand : HousingCommandsConfig.INSTANCE.commands.keySet()) {
            // For each word in the message
            for (String word : split) {
                // If a word matches the command as set in the config:
                if (word.equals(inConfigCommand)) {
                    Chat.sendChatMessage("Testing");
                }
            }
        }
    }
}
