package net.permutated.novillagerdm.filters;

import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.Node;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.filter.AbstractFilter;
import org.apache.logging.log4j.message.Message;

@Plugin(name = "VillagerDeathMessageFilter", category = Node.CATEGORY, elementType = Filter.ELEMENT_TYPE)
public class VillagerDeathMessageFilter extends AbstractFilter {

    @Override
    public Filter.Result filter(LogEvent event) {
        Message message = event.getMessage();
        if (message.getFormat().equals("Villager {} died, message: '{}'")) {
            return Result.DENY;
        } else {
            return Result.NEUTRAL;
        }
    }
}
