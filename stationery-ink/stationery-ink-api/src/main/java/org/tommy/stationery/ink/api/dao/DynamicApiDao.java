package org.tommy.stationery.ink.api.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tommy.stationery.ink.api.domain.DynamicQuery;
import org.tommy.stationery.ink.api.mapper.DynamicApiMapper;

import java.util.HashMap;
import java.util.List;

/**
 * Created by kun7788 on 15. 2. 9..
 */
@Component
public class DynamicApiDao implements DynamicApiMapper {

    @Autowired
    DynamicApiMapper dynamicApiMapper;

    @Override
    public List<HashMap<String, String>> getDynamicAPI(DynamicQuery dynamicQuery) {
        return dynamicApiMapper.getDynamicAPI(dynamicQuery);
    }
}
