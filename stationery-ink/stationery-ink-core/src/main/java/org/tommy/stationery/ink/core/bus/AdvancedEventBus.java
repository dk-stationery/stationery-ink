package org.tommy.stationery.ink.core.bus;

import com.google.common.eventbus.EventBus;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kun7788 on 15. 6. 17..
 */
public class AdvancedEventBus extends EventBus {

    private Map<String, Object> handlers = new HashMap<String, Object>();

    public void register(String name, Object object) {
        super.register(object);
        handlers.put(name, object);
    }

    public Object getHandler(String name) {
        return handlers.get(name);
    }

    public Object fireEvent(Object event) {
        super.post(event);
        return event;
    }
}
