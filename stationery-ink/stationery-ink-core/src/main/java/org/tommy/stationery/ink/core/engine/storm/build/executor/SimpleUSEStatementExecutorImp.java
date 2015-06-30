package org.tommy.stationery.ink.core.engine.storm.build.executor;

import org.tommy.stationery.ink.config.InkConfig;
import org.tommy.stationery.ink.core.engine.build.ISimpleBuilder;
import org.tommy.stationery.ink.core.engine.build.executor.ISimpleStatementExecutor;
import org.tommy.stationery.ink.core.util.ASTDump;
import org.tommy.stationery.ink.domain.BaseStatement;
import org.tommy.stationery.ink.domain.ResultStatement;
import org.tommy.stationery.ink.exception.InkException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kun7788 on 15. 3. 12..
 */
public class SimpleUSEStatementExecutorImp implements ISimpleStatementExecutor {

    private InkConfig inkConfig;
    private List<ResultStatement> resultStatement;

    public SimpleUSEStatementExecutorImp(Builder builder) {
        this.resultStatement = builder.resultStatement;
        this.inkConfig = builder.inkConfig;
    }

    @Override
    public String toAST() {
        return ASTDump.toAST(resultStatement);
    }

    @Override
    public List<ResultStatement> getResultStatement() {
        return resultStatement;
    }

    public static class Builder implements ISimpleBuilder {

        private List<ResultStatement> resultStatement = new ArrayList<ResultStatement>();
        private InkConfig inkConfig;

        public Builder() {
            inkConfig = new InkConfig();
        }

        @Override
        public ISimpleBuilder execute(BaseStatement statement, boolean isLast) throws Exception {

            ResultStatement _resultStatement = new ResultStatement();
            _resultStatement.setStatement(statement);

            appendAST(_resultStatement);
            return (ISimpleBuilder)this;
        }

        @Override
        public void appendAST(ResultStatement statement) throws InkException {
            resultStatement.add(statement);
        }

        @Override
        public ISimpleStatementExecutor build() {
            return new SimpleUSEStatementExecutorImp(this);
        }
    }
}
