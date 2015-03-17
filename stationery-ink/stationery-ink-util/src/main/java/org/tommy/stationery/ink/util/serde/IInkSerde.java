package org.tommy.stationery.ink.util.serde;

import java.io.Serializable;

/**
 * Created by kun7788 on 15. 2. 6..
 */
public interface IInkSerde {
    public String serialize(Object obj) throws Exception;
    public Object deserialize(String str) throws Exception;
    public String serialize(Serializable o) throws Exception;
}
