package org.tommy.stationery.ink.core.storm.bolt.stream;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kun7788 on 15. 1. 28..
 */
public class TupleTypeDescriptor  implements Serializable
{
    private final Map<String, String> fieldTypes;

    public TupleTypeDescriptor(Map<String, String> fieldTypes)
    {
        this.fieldTypes = new HashMap<String, String>(fieldTypes);
    }

    public String getFieldType(String fieldName)
    {
        return fieldTypes.get(fieldName);
    }
}
