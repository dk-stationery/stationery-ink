package org.tommy.stationery.ink.dao.metastore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tommy.stationery.ink.domain.meta.Source;
import org.tommy.stationery.ink.enums.MessageEnum;
import org.tommy.stationery.ink.exception.InkException;
import org.tommy.stationery.ink.mapper.metastore.InkSourceMapper;

import java.util.List;

/**
 * Created by kun7788 on 15. 1. 28..
 */
@Component
public class InkSourceDao implements InkSourceMapper {

    private static int ONLY_ONE = 1;

    @Autowired
    InkSourceMapper mapper;

    @Override
    public void putInkSource(Source inkSource) {
        mapper.putInkSource(inkSource);
    }

    @Override
    public void removeInkSource(Source inkSource) {
        mapper.removeInkSource(inkSource);
    }

    @Override
    public List<Source> getInkSourceByNameAndCatalog(Source inkSource) {
        return mapper.getInkSourceByNameAndCatalog(inkSource);
    }

    @Override
    public List<Source> getInkSourceByName(Source inkSource) {
        return mapper.getInkSourceByName(inkSource);
    }

    @Override
    public List<Source> getInkSources() {
        return mapper.getInkSources();
    }

    public Source getOnlyInkSourceByName(Source inkSource) throws InkException {
        List<Source> inkSources = getInkSourceByName(inkSource);
        if (inkSources == null || inkSources.size() != ONLY_ONE) {
            throw new InkException(MessageEnum.STREAM_NOT_FOUND);
        }
        return inkSources.get(0);
    }

    public boolean isOnlyOneInkSourceByName(Source inkSource) throws InkException {
        getOnlyInkSourceByName(inkSource);
        return true;
    }
}
