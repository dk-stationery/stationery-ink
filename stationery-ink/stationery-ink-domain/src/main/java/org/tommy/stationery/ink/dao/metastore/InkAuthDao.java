package org.tommy.stationery.ink.dao.metastore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tommy.stationery.ink.domain.meta.Auth;
import org.tommy.stationery.ink.mapper.metastore.InkAuthMapper;

import java.util.List;

/**
 * Created by kun7788 on 15. 6. 18..
 */
@Component
public class InkAuthDao implements InkAuthMapper {

    @Autowired
    InkAuthMapper mapper;

    @Override
    public Auth getInkAuth(Auth inkAuth) {
        return mapper.getInkAuth(inkAuth);
    }
}