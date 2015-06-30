package org.tommy.stationery.ink.core.engine.storm.bolt.stream;

import backtype.storm.tuple.Fields;

import java.io.Serializable;

/**
 * Created by kun7788 on 15. 1. 28..
 */
public final class EventTypeDescriptor implements Serializable
{
    private final String name;
    private final Fields fields;
    private final String streamId;

    EventTypeDescriptor(String name, String[] fields, String streamId)
    {
        this.name = name;
        this.fields = new Fields(fields);
        this.streamId = streamId;
    }

    public String getName()
    {
        return name;
    }

    public Fields getFields()
    {
        return fields;
    }

    public String getStreamId()
    {
        return streamId;
    }
}
