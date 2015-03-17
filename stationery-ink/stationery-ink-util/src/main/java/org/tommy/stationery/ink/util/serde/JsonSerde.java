package org.tommy.stationery.ink.util.serde;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.type.TypeReference;
import org.tommy.stationery.ink.domain.BaseStatement;
import org.tommy.stationery.ink.domain.ResultStatement;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 * Created by kun7788 on 15. 1. 29..
 */
public class JsonSerde implements IInkSerde {

    private ObjectMapper objectMapper = new ObjectMapper();

    public JsonSerde() {
        objectMapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);
    }
    public String serialize(Object obj) throws IOException {
        String str = objectMapper.writeValueAsString(obj);
        return str;
    }

    public String serialize(List<ResultStatement> obj) throws IOException {
        String str = objectMapper.writeValueAsString(obj);
        return str;
    }

    public String serialize(String obj, TypeReference typeReference) throws IOException {
        String str = objectMapper.writeValueAsString(obj);
        return str;
    }

    public BaseStatement deserialize(String str) throws IOException {
        BaseStatement statement = objectMapper.readValue(str, new TypeReference<BaseStatement>() {
        });
        return statement;
    }

    @Override
    public String serialize(Serializable o) throws Exception {
        return serialize((Object)o);
    }

    public Object deserialize(String str, TypeReference typeReference) throws IOException {
        Object object = objectMapper.readValue(str, typeReference);
        return object;
    }
}
