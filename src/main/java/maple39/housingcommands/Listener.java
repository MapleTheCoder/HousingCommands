package maple39.housingcommands;

import java.util.ArrayList;
import java.util.Arrays;

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

        ArrayList<String> split = new ArrayList<String>(Arrays.asList(message.split("!")));

        split.remove(0);
        if (split.size() == 0) {
            // message is just "!" with no command
            return;
        }
        
        String command = split.get(0);
        System.out.println(command);
    }
}
