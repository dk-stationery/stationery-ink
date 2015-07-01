package org.tommy.stationery.ink.core.engine.utils;

import java.util.Map;

/**
 * Created by kun7788 on 15. 7. 1..
 */
public interface IEsperEventCallback {
    public void onEventReceive(String streamName, Map<String, Object> tuple);
}
