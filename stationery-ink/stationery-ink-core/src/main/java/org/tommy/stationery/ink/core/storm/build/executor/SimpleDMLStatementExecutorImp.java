package org.tommy.stationery.ink.core.storm.build.executor;

import org.tommy.stationery.ink.core.config.InkConfig;
import org.tommy.stationery.ink.core.provider.SimpleMetaStoreProviderImp;
import org.tommy.stationery.ink.core.storm.ast.ASTDump;
import org.tommy.stationery.ink.core.storm.build.storm.BoltBuilder;
import org.tommy.stationery.ink.core.storm.build.storm.StormTopologyBuilder;
import org.tommy.stationery.ink.domain.BaseStatement;
import org.tommy.stationery.ink.domain.ResultStatement;
import org.tommy.stationery.ink.exception.InkException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kun7788 on 15. 1. 27..
 */
public class SimpleDMLStatementExecutorImp implements ISimpleStatementExecutor {

    private InkConfig inkConfig;
    private List<ResultStatement> resultStatement;
    private StormTopologyBuilder stormTopologyBuilder;

    public SimpleDMLStatementExecutorImp(Builder builder, StormTopologyBuilder stormTopologyBuilder) {
        this.resultStatement = builder.resultStatement;
        this.stormTopologyBuilder = stormTopologyBuilder;
    }

    public String toAST() {
        return ASTDump.toAST(resultStatement);
    }

    public List<ResultStatement> getResultStatement() {
        return resultStatement;
    }

    public StormTopologyBuilder getStormTopologyBuilder() {
        return stormTopologyBuilder;
    }

    public static class Builder implements ISimpleBuilder {

        private List<ResultStatement> resultStatement = new ArrayList<ResultStatement>();
        private InkConfig inkConfig;
        private StormTopologyBuilder stormTopologyBuilder = new StormTopologyBuilder();
        private SimpleMetaStoreProviderImp simpleMetaStoreProvider;
        private BoltBuilder boltBuilder = new BoltBuilder();

        public Builder(InkConfig inkConfig, SimpleMetaStoreProviderImp simpleMetaStoreProvider) {
            this.inkConfig = inkConfig;
            this.simpleMetaStoreProvider = simpleMetaStoreProvider;
        }

        @Override
        public ISimpleStatementExecutor build() {
            return new SimpleDMLStatementExecutorImp(this, stormTopologyBuilder);
        }

        @Override
        public ISimpleBuilder execute(BaseStatement statement, boolean isLast) throws Exception {

            stormTopologyBuilder = boltBuilder.addInstance(stormTopologyBuilder, simpleMetaStoreProvider, statement, inkConfig, isLast);

            ResultStatement _resultStatement = new ResultStatement();
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
