package maple39.housingcommands;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import rocks.rdil.simpleconfig.Option;

/**
 * A class for the configuration.
 */
public class HousingCommandsConfig {
    public static final HousingCommandsConfig INSTANCE = new HousingCommandsConfig();

    /**
     * The commands map.
     */
    @Option
    public Map<String, String> commands = new ConcurrentHashMap<>();
}
