package maple39.housingcommands;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;
import rocks.rdil.simpleconfig.ConfigurationSystem;

/**
 * The mod's main class.
 */
public class Mod implements ModInitializer {
    public static final Logger LOGGER = LogManager.getLogger("HousingCommands");
    public static final File configFile = new File("housingcommands.json");

    public ConfigurationSystem configSystem = new ConfigurationSystem(configFile);

    private static boolean initialized = false;

    @Override
    public void onInitialize() {
        LOGGER.info("Starting HousingCommands...");

        if (initialized) {
            throw new RuntimeException("onInitialized called twice for HousingCommands, this SHOULD NOT HAPPEN!!!");
        }

        initialized = true;

        LOGGER.info("Initializing configuration...");
        configSystem.register(HousingCommandsConfig.INSTANCE);        

        LOGGER.info("Loaded HousingCommands!");
    }
}
