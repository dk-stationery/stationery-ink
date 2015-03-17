package org.tommy.stationery.ink.mapper.metastore;

import org.springframework.stereotype.Repository;
import org.tommy.stationery.ink.domain.meta.Stream;

import java.util.List;

/**
 * Created by kun7788 on 15. 1. 28..
 */
@Repository(value="inkStreamMapper")
public interface InkStreamMapper {
    public void putInkStream(Stream inkStream);
    public void removeInkStream(Stream inkStream);
    public List<Stream> getInkStreamByName(Stream inkStream);
    public List<Stream> getInkStreams();
}
