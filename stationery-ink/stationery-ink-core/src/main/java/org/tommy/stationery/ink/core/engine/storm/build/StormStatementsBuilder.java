package org.tommy.stationery.ink.core.engine.storm.build;

import org.tommy.stationery.ink.config.InkConfig;
import org.tommy.stationery.ink.core.engine.build.StatementsBuilder;
import org.tommy.stationery.ink.core.util.StormManager;

/**
 * Created by kun7788 on 15. 6. 16..
 */
public class StormStatementsBuilder extends StatementsBuilder {

    public void deploy(InkConfig inkConfig, Object topology) throws Exception {
        //storm depoly
        StormManager.depoly(inkConfig, topology);
    }
}