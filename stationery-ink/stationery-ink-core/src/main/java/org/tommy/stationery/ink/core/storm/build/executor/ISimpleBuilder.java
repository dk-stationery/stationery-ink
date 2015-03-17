package org.tommy.stationery.ink.core.storm.build.executor;

import org.tommy.stationery.ink.domain.ResultStatement;
import org.tommy.stationery.ink.domain.BaseStatement;
import org.tommy.stationery.ink.exception.InkException;

/**
 * Created by kun7788 on 15. 2. 2..
 */
public interface ISimpleBuilder {
    public ISimpleBuilder execute(BaseStatement statement, boolean isLast) throws Exception;
    public void appendAST(ResultStatement statement) throws InkException;
    public ISimpleStatementExecutor build();
}

