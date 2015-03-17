package org.tommy.stationery.ink.dao.metastore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tommy.stationery.ink.domain.meta.Stream;
import org.tommy.stationery.ink.enums.MessageEnum;
import org.tommy.stationery.ink.exception.InkException;
import org.tommy.stationery.ink.mapper.metastore.InkStreamMapper;

import java.util.List;

/**
 * Created by kun7788 on 15. 1. 28..
 */
@Component
public class InkStreamDao implements InkStreamMapper {

    private static int ONLY_ONE = 1;

    @Autowired
    InkStreamMapper mapper;

    @Override
    public void putInkStream(Stream inkStream) {
        mapper.putInkStream(inkStream);
    }

    @Override
    public void removeInkStream(Stream inkStream) {
        mapper.removeInkStream(inkStream);
    }

    @Override
    public List<Stream> getInkStreamByName(Stream inkStream) {
        return mapper.getInkStreamByName(inkStream);
    }

    @Override
    public List<Stream> getInkStreams() {
        return mapper.getInkStreams();
    }

    public Stream getOnlyInkStreamByName(Stream inkStream) throws InkException {
        List<Stream> inkStreams = getInkStreamByName(inkStream);
        if (inkStreams == null || inkStreams.size() != ONLY_ONE) {
            throw new InkException(MessageEnum.STREAM_NOT_FOUND);
        }

        return inkStreams.get(0);
    }

    public boolean isOnlyOneInkStreamByName(Stream inkStream) throws InkException {
        getOnlyInkStreamByName(inkStream);
        return true;
    }
}
