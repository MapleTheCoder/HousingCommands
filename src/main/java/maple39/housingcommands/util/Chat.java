package maple39.housingcommands.util;

import java.util.regex.Pattern;

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
}
