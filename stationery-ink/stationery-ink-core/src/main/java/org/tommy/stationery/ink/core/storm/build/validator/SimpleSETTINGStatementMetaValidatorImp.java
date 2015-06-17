package org.tommy.stationery.ink.core.storm.build.validator;

import org.tommy.stationery.ink.domain.BaseStatement;
import org.tommy.stationery.ink.domain.BaseTableDef;
import org.tommy.stationery.ink.enums.MessageEnum;
import org.tommy.stationery.ink.enums.SettingEnum;
import org.tommy.stationery.ink.exception.InkException;

import java.util.List;

/**
 * Created by kun7788 on 15. 2. 13..
 */
public class SimpleSETTINGStatementMetaValidatorImp implements ISimpleStatementMetaValidator {

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
        if (statement.getSettingDef() == null) {
            throw new InkException(MessageEnum.SETTING_IS_NULL);
        }

        if (statement.getSettingDef().getName() == null || statement.getSettingDef().getName().length() <= 0) {
            throw new InkException(MessageEnum.SETTING_NAME_IS_NULL);
        }

        if (statement.getSettingDef().getValue() == null || statement.getSettingDef().getValue().length() <= 0) {
            throw new InkException(MessageEnum.SETTING_VALUE_IS_NULL);
        }

        if (SettingEnum.valueOf(statement.getSettingDef().getName()) == null) {
            throw new InkException(MessageEnum.SETTING_IS_INVALID);
        }

        return true;
    }
}
