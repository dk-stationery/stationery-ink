package org.tommy.stationery.ink.core.bus.event;

import org.tommy.stationery.ink.core.provider.SimpleMetaStoreProviderImp;
import org.tommy.stationery.ink.domain.BaseStatement;
import org.tommy.stationery.ink.enums.StatementTypeEnum;

/**
 * Created by kun7788 on 15. 6. 17..
 */
public class ValidateEvent {

    private boolean isValidate;
    private StatementTypeEnum.GroupTypeEnum statementGroupTypeEnum;
    private BaseStatement statement;
    private SimpleMetaStoreProviderImp simpleMetaStoreProviderImp;

    public ValidateEvent(StatementTypeEnum.GroupTypeEnum statementGroupTypeEnum, BaseStatement statement, SimpleMetaStoreProviderImp simpleMetaStoreProviderImp) {
        this.statementGroupTypeEnum = statementGroupTypeEnum;
        this.statement = statement;
        this.simpleMetaStoreProviderImp = simpleMetaStoreProviderImp;
    }

    public StatementTypeEnum.GroupTypeEnum getStatementGroupTypeEnum() {
        return statementGroupTypeEnum;
    }

    public void setStatementGroupTypeEnum(StatementTypeEnum.GroupTypeEnum statementGroupTypeEnum) {
        this.statementGroupTypeEnum = statementGroupTypeEnum;
    }

    public BaseStatement getStatement() {
        return statement;
    }

    public void setStatement(BaseStatement statement) {
        this.statement = statement;
    }

    public SimpleMetaStoreProviderImp getSimpleMetaStoreProviderImp() {
        return simpleMetaStoreProviderImp;
    }

    public void setSimpleMetaStoreProviderImp(SimpleMetaStoreProviderImp simpleMetaStoreProviderImp) {
        this.simpleMetaStoreProviderImp = simpleMetaStoreProviderImp;
    }

    public boolean isValidate() {
        return isValidate;
    }

    public void setValidate(boolean isValidate) {
        this.isValidate = isValidate;
    }
}
