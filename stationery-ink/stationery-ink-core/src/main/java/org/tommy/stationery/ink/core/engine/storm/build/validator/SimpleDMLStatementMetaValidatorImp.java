package org.tommy.stationery.ink.core.engine.storm.build.validator;

import org.tommy.stationery.ink.core.engine.build.validator.ISimpleStatementMetaValidator;
import org.tommy.stationery.ink.core.provider.SimpleMetaStoreProviderImp;
import org.tommy.stationery.ink.domain.BaseColumnDef;
import org.tommy.stationery.ink.domain.BaseStatement;
import org.tommy.stationery.ink.domain.BaseTableDef;
import org.tommy.stationery.ink.domain.meta.Auth;
import org.tommy.stationery.ink.domain.meta.Source;
import org.tommy.stationery.ink.domain.meta.Stream;
import org.tommy.stationery.ink.enums.MessageEnum;
import org.tommy.stationery.ink.enums.StatementTypeEnum;
import org.tommy.stationery.ink.exception.InkException;

import java.util.List;

/**
 * Created by kun7788 on 15. 2. 2..
 */

public class SimpleDMLStatementMetaValidatorImp implements ISimpleStatementMetaValidator {

    private static int ONLY_ONE = 1;

    private SimpleMetaStoreProviderImp simpleMetaStoreProviderImp;
    private Auth auth;

    public SimpleDMLStatementMetaValidatorImp(Auth auth, SimpleMetaStoreProviderImp simpleMetaStoreProviderImp) {
        this.simpleMetaStoreProviderImp = simpleMetaStoreProviderImp;
        this.auth = auth;
    }

    @Override
    public boolean validateBindTables(List<BaseTableDef> bindTables) throws InkException {
        if (bindTables == null) return false;

        for (BaseTableDef tableDef : bindTables) {

            Stream inkStream = new Stream();
            inkStream.setName(tableDef.getName());

            simpleMetaStoreProviderImp.isOnlyOneInkStreamByName(inkStream);

            if (validateSource(tableDef) == false) return false;
        }
        return true;
    }

    @Override
    public boolean validateSource(BaseTableDef tableDef) throws InkException {
        if (tableDef == null || tableDef.getSource() == null) return false;

        Source inkSource = new Source();
        inkSource.setName(tableDef.getSource());

        simpleMetaStoreProviderImp.isOnlyOneInkSourceByName(inkSource);

        return true;
    }

    @Override
    public boolean isValidate(BaseStatement statement) throws InkException {
        if (simpleMetaStoreProviderImp.isGrantAuth(auth, statement.getType().getGroupAuth()) == false) {
            throw new InkException(MessageEnum.NOT_ENOUGH_AUTH_GRANT);
        }

        if (statement.getType().getSubGroup().equals(StatementTypeEnum.SubGroupTypeEnum.LOOKUP)) {
            if (statement.getBindTables() == null || statement.getBindTables().size() != ONLY_ONE) {
                throw new InkException(MessageEnum.LOOKUP_STATEMENT_MUST_HAS_ONLY_ONE_STREAM);
            }
        }

        if (statement.getColumns() != null) {
            for (BaseColumnDef columnDef : statement.getColumns()) {
                if ("*".equals(columnDef.getName())) {
                    throw new InkException(MessageEnum.DONT_USE_ASTERISKS);
                }
            }
        } else {
            throw new InkException(MessageEnum.NOT_EXIST_COLUMNS);
        }
        return validateBindTables(statement.getBindTables());
    }
}
