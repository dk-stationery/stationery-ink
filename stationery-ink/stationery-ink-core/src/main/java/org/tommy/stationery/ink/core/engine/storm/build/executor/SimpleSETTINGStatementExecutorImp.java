package org.tommy.stationery.ink.core.engine.storm.build.executor;

import org.tommy.stationery.ink.config.InkConfig;
import org.tommy.stationery.ink.core.engine.build.ISimpleBuilder;
import org.tommy.stationery.ink.core.engine.build.executor.ISimpleStatementExecutor;
import org.tommy.stationery.ink.core.util.ASTDump;
import org.tommy.stationery.ink.domain.BaseStatement;
import org.tommy.stationery.ink.domain.ResultStatement;
import org.tommy.stationery.ink.enums.SettingEnum;
import org.tommy.stationery.ink.exception.InkException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kun7788 on 15. 2. 13..
 */
public class SimpleSETTINGStatementExecutorImp implements ISimpleStatementExecutor {

    private InkConfig inkConfig;
    private List<ResultStatement> resultStatement;

    public SimpleSETTINGStatementExecutorImp(Builder builder) {
        this.resultStatement = builder.resultStatement;
        this.inkConfig = builder.inkConfig;
    }

    public InkConfig getCustomInkConfig() {
        return inkConfig;
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

            inkConfig.put(SettingEnum.valueOf(statement.getSettingDef().getName()), statement.getSettingDef().getValue());

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
            return new SimpleSETTINGStatementExecutorImp(this);
        }
    }
}
