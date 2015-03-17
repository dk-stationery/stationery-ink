package org.tommy.stationery.ink.core.storm.build.executor;

import org.tommy.stationery.ink.domain.ResultStatement;

import java.util.List;

/**
 * Created by kun7788 on 15. 2. 2..
 */
public interface ISimpleStatementExecutor {
    public String toAST();
    public List<ResultStatement> getResultStatement();
}
