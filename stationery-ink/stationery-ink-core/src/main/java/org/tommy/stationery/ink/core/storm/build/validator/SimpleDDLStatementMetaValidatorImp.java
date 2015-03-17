package org.tommy.stationery.ink.core.storm.build.validator;

import org.springframework.stereotype.Component;
import org.tommy.stationery.ink.domain.BaseStatement;
import org.tommy.stationery.ink.domain.BaseTableDef;
import org.tommy.stationery.ink.exception.InkException;

import java.util.List;

/**
 * Created by kun7788 on 15. 2. 2..
 */
@Component
public class SimpleDDLStatementMetaValidatorImp implements ISimpleStatementMetaValidator {

    @Override
    public boolean validateBindTables(List<BaseTableDef> bindTables) throws InkException {
        //DO NOT VALIDATION CHECK.
        return true;
    }

    @Override
    public boolean validateSource(BaseTableDef tableDef) throws InkException {
        //DO NOT VALIDATION CHECK.
        return true;
    }

    @Override
    public boolean isValidate(BaseStatement statement) throws InkException {
        //DO NOT VALIDATION CHECK.
        return true;
    }
}
