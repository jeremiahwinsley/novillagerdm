package net.permutated.novillagerdm;

import net.neoforged.fml.common.Mod;
import net.permutated.novillagerdm.filters.VillagerDeathMessageFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(NoVillagerDeathMessages.MODID)
public class NoVillagerDeathMessages {

    public static final String MODID = "novillagerdm";

    public static final Logger LOGGER = LogManager.getLogger();

    @SuppressWarnings("java:S1118")
    public NoVillagerDeathMessages() {
        LOGGER.info("Registering mod: {}", MODID);

        var logger = LogManager.getRootLogger();
        if (logger instanceof org.apache.logging.log4j.core.Logger rootLogger) {
            rootLogger.addFilter(new VillagerDeathMessageFilter());
        } else {
            LOGGER.error("Registration failed with unexpected class: {}", logger.getClass());
        }
    }
}
