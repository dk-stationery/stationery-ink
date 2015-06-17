package org.tommy.stationery.ink.core.bus.subscriber;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;
import org.tommy.stationery.ink.core.bus.event.BuilderStatementEvent;
import org.tommy.stationery.ink.core.storm.build.executor.ISimpleBuilder;

/**
 * Created by kun7788 on 15. 6. 16..
 */
public class BuilderStatementEventHandler {

    @Subscribe
    @AllowConcurrentEvents
    public void onBuild(BuilderStatementEvent event) throws Exception {
        ISimpleBuilder builder = event.getProcessedBuilder().execute(event.getStatement(), event.isLast());
        event.setProcessedBuilder(builder);
    }
}
