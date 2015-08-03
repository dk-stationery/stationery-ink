package org.tommy.stationery.ink.daemon.service.metastore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tommy.stationery.ink.core.provider.SimpleMetaStoreProviderImp;
import org.tommy.stationery.ink.daemon.config.ParametersConfig;
import org.tommy.stationery.ink.domain.meta.Auth;
import org.tommy.stationery.ink.enums.StatementTypeEnum;
import org.tommy.stationery.ink.exception.InkException;

/**
 * Created by kun7788 on 15. 6. 18..
 */
@Service
public class AuthService {

    @Autowired
    ParametersConfig parametersConfig;

    @Autowired
    SimpleMetaStoreProviderImp simpleMetaStoreProvider;

    public Auth superGrantUserAuth() {
        Auth auth = new Auth();
        auth.setAuthgrant(StatementTypeEnum.GroupTypeAuthEnum.READ_WRITE_DEPLOY.getName());
        return auth;
    }

    public boolean isEnableAuth() {
        String isEnableAuth = ParametersConfig.StringValue(parametersConfig.getConfig().get("auth").get("enable"));
        if ("true".equals(isEnableAuth)) {
            return false;
        }
        return true;
    }

    public Auth getInkAuth(Auth auth) throws InkException {
        return simpleMetaStoreProvider.getInkAuth(auth);
    }
}
