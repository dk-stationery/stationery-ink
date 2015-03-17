package org.tommy.stationery.ink.core.provider;

import org.tommy.stationery.ink.domain.ResultStatement;
import org.tommy.stationery.ink.util.serde.JsonSerde;

import java.io.IOException;

/**
 * Created by kun7788 on 15. 2. 5..
 */
public abstract class AbstractSimpleMetaStoreProvider {
    protected JsonSerde statementJsonSerde = new JsonSerde();

    protected ResultStatement generateResultStatement(Object target) throws IOException {
        ResultStatement resultStatement = new ResultStatement();
        resultStatement.setSerializedResults(statementJsonSerde.serialize(target));
        return resultStatement;
    }
}
