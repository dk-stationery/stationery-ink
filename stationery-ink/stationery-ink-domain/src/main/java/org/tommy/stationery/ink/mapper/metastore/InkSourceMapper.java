package org.tommy.stationery.ink.mapper.metastore;

import org.springframework.stereotype.Repository;
import org.tommy.stationery.ink.domain.meta.Source;

import java.util.List;

/**
 * Created by kun7788 on 15. 1. 28..
 */
@Repository(value="inkSourceMapper")
public interface InkSourceMapper {
    public void putInkSource(Source inkSource);

    public void removeInkSource(Source inkSource);

    public List<Source> getInkSourceByNameAndCatalog(Source inkSource);

    public List<Source> getInkSourceByName(Source inkSource);

    public List<Source> getInkSources();
}
