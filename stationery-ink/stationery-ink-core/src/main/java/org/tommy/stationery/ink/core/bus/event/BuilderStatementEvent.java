package org.tommy.stationery.ink.core.bus.event;

import org.tommy.stationery.ink.core.storm.build.executor.ISimpleBuilder;
import org.tommy.stationery.ink.domain.BaseStatement;

/**
 * Created by kun7788 on 15. 6. 16..
 */
public class BuilderStatementEvent {

   private ISimpleBuilder processedBuilder;
   private BaseStatement statement;
   private boolean isLast;

   public BuilderStatementEvent(BaseStatement statement, ISimpleBuilder processedBuilder, boolean isLast) {
       this.processedBuilder = processedBuilder;
       this.statement = statement;
       this.isLast = isLast;
   }

    public BaseStatement getStatement() {
        return statement;
    }

    public void setStatement(BaseStatement statement) {
        this.statement = statement;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean isLast) {
        this.isLast = isLast;
    }

    public ISimpleBuilder getProcessedBuilder() {
        return processedBuilder;
    }

    public void setProcessedBuilder(ISimpleBuilder processedBuilder) {
        this.processedBuilder = processedBuilder;
    }
}
