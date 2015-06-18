package org.tommy.stationery.ink.mapper.metastore;

/**
 * Created by kun7788 on 15. 6. 18..
 */

import org.springframework.stereotype.Repository;
import org.tommy.stationery.ink.domain.meta.Auth;

@Repository(value="inkAuthMapper")
public interface InkAuthMapper {
    public Auth getInkAuth(Auth inkAuth);
}
