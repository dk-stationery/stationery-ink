package org.tommy.stationery.ink.api.mapper;

import org.springframework.stereotype.Repository;
import org.tommy.stationery.ink.api.domain.DynamicQuery;

import java.util.HashMap;
import java.util.List;

/**
 * Created by kun7788 on 15. 2. 9..
 */
@Repository(value="dynamicApiMapper")
public interface DynamicApiMapper {
    public List<HashMap<String, String>> getDynamicAPI(DynamicQuery dynamicQuery);
}
