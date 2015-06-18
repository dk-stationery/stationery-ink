package org.tommy.stationery.ink.core.storm.build.validator;

import org.tommy.stationery.ink.core.provider.SimpleMetaStoreProviderImp;
import org.tommy.stationery.ink.domain.BaseStatement;
import org.tommy.stationery.ink.domain.BaseTableDef;
import org.tommy.stationery.ink.domain.meta.Auth;
import org.tommy.stationery.ink.enums.MessageEnum;
import org.tommy.stationery.ink.enums.SettingEnum;
import org.tommy.stationery.ink.exception.InkException;

import java.util.List;

/**
 * Created by kun7788 on 15. 2. 13..
 */
public class SimpleSETTINGStatementMetaValidatorImp implements ISimpleStatementMetaValidator {

    private SimpleMetaStoreProviderImp simpleMetaStoreProviderImp;
    private Auth auth;

    public SimpleSETTINGStatementMetaValidatorImp(Auth auth, SimpleMetaStoreProviderImp simpleMetaStoreProviderImp) {
        this.simpleMetaStoreProviderImp = simpleMetaStoreProviderImp;
        this.auth = auth;
    }

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
        if (simpleMetaStoreProviderImp.isGrantAuth(auth, statement.getType().getGroupAuth()) == false) {
            throw new InkException(MessageEnum.NOT_ENOUGH_AUTH_GRANT);
        }

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
