package net.permutated.novillagerdm;

import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.network.FMLNetworkConstants;
import net.permutated.novillagerdm.filters.VillagerDeathMessageFilter;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(NoVillagerDeathMessages.MODID)
public class NoVillagerDeathMessages {

    public static final String MODID = "novillagerdm";

    public static final Logger LOGGER = LogManager.getLogger();

    @SuppressWarnings("java:S1118")
    public NoVillagerDeathMessages() {
        LOGGER.info("Registering mod: {}", MODID);

        ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.DISPLAYTEST,
            () -> Pair.of(() -> FMLNetworkConstants.IGNORESERVERONLY, (a, b) -> true));

        Logger rootLogger = LogManager.getRootLogger();
        if (rootLogger instanceof org.apache.logging.log4j.core.Logger) {
            ((org.apache.logging.log4j.core.Logger) rootLogger).addFilter(new VillagerDeathMessageFilter());
        } else {
            LOGGER.error("Registration failed with unexpected class: {}", rootLogger.getClass());
        }
    }
}
