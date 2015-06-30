package org.tommy.stationery.ink.core.engine.storm.build.executor;

import org.tommy.stationery.ink.config.InkConfig;
import org.tommy.stationery.ink.core.engine.build.ISimpleBuilder;
import org.tommy.stationery.ink.core.engine.build.executor.ISimpleStatementExecutor;
import org.tommy.stationery.ink.core.provider.SimpleMetaStoreProviderImp;
import org.tommy.stationery.ink.core.util.ASTDump;
import org.tommy.stationery.ink.domain.BaseStatement;
import org.tommy.stationery.ink.domain.ResultStatement;
import org.tommy.stationery.ink.exception.InkException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kun7788 on 15. 1. 27..
 */
public class SimpleDDLStatementExecutorImp implements ISimpleStatementExecutor {

    private InkConfig inkConfig;
    private List<ResultStatement> resultStatement;

    public SimpleDDLStatementExecutorImp(Builder builder) {
        resultStatement = builder.resultStatement;
    }

    public String toAST() {
        return ASTDump.toAST(resultStatement);
    }

    public List<ResultStatement> getResultStatement() {
        return resultStatement;
    }

    public static class Builder implements ISimpleBuilder {

        private List<ResultStatement> resultStatement = new ArrayList<ResultStatement>();
        private InkConfig inkConfig;
        private SimpleMetaStoreProviderImp simpleMetaStoreProvider;

        public Builder(InkConfig inkConfig, SimpleMetaStoreProviderImp simpleMetaStoreProvider) {
            this.inkConfig = inkConfig;
            this.simpleMetaStoreProvider = simpleMetaStoreProvider;
        }

        @Override
        public ISimpleStatementExecutor build() {
            return new SimpleDDLStatementExecutorImp(this);
        }


        @Override
        public ISimpleBuilder execute(BaseStatement statement, boolean isLast) throws Exception {

            //do execution.
            ResultStatement _resultStatement = simpleMetaStoreProvider.execute(inkConfig, statement);
            _resultStatement.setStatement(statement);

            appendAST(_resultStatement);
            return (ISimpleBuilder)this;
        }

        @Override
        public void appendAST(ResultStatement statement) throws InkException {
            resultStatement.add(statement);
        }
    }
}
