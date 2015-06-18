package org.tommy.stationery.ink.daemon.service.metastore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tommy.stationery.ink.core.provider.SimpleMetaStoreProviderImp;
import org.tommy.stationery.ink.domain.meta.Auth;
import org.tommy.stationery.ink.exception.InkException;

/**
 * Created by kun7788 on 15. 6. 18..
 */
@Service
public class AuthService {

    @Autowired
    SimpleMetaStoreProviderImp simpleMetaStoreProvider;

    public Auth getInkAuth(Auth auth) throws InkException {
        return simpleMetaStoreProvider.getInkAuth(auth);
    }
}
