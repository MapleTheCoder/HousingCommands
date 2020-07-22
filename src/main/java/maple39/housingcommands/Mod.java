package maple39.housingcommands;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;

public class Mod implements ModInitializer {
    private static final Logger LOGGER = LogManager.getLogger("HousingCommands");

    @Override
    public void onInitialize() {
        LOGGER.info("Loaded HousingCommands!");
    }
}
