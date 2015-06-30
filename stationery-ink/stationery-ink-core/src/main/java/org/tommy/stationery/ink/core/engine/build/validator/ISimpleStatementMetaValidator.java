package org.tommy.stationery.ink.core.engine.build.validator;

import org.tommy.stationery.ink.domain.BaseStatement;
import org.tommy.stationery.ink.domain.BaseTableDef;
import org.tommy.stationery.ink.exception.InkException;

import java.util.List;

/**
 * Created by kun7788 on 15. 2. 2..
 */
public interface ISimpleStatementMetaValidator {
    public boolean validateBindTables(List<BaseTableDef> bindTables) throws InkException;
    public boolean validateSource(BaseTableDef tableDef) throws InkException;
    public boolean isValidate(BaseStatement statement) throws InkException;
}
