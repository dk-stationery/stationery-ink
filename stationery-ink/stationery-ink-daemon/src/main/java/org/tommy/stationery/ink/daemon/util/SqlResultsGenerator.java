package org.tommy.stationery.ink.daemon.util;

import org.codehaus.jackson.type.TypeReference;
import org.tommy.stationery.ink.domain.ResultStatement;
import org.tommy.stationery.ink.domain.SqlResults;
import org.tommy.stationery.ink.util.serde.JsonSerde;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kun7788 on 15. 2. 2..
 */
public class SqlResultsGenerator {

    private static SqlResults genSqlResults(int id, SqlResults sqlResults, ResultStatement statement, Object result) throws Exception {
        JsonSerde jsonSerde = new JsonSerde();

        sqlResults.getRowIds().add("No." + id);
        sqlResults.getTypes().add(statement.getStatement().getType().getName());
        String errorMsg = "SUCCEED";
        if (statement.getErrorMsg() != null) {
            errorMsg = statement.getErrorMsg();
        }
        sqlResults.getErrors().add(errorMsg);
        if (result == null) {
            sqlResults.getResults().add(jsonSerde.serialize(statement.getStatement().getQuery()));
        } else {
            sqlResults.getResults().add(jsonSerde.serialize(result));
        }
        return sqlResults;
    }

    public static SqlResults FromResultStatements(List<ResultStatement> resultStatments) throws Exception {

        JsonSerde jsonSerde = new JsonSerde();

        SqlResults sqlResults = new SqlResults();

        int id = -1;
        for (ResultStatement statement : resultStatments) {
            id++;
            Object results = null;
            if (statement.getSerializedResults() != null) {
                results = jsonSerde.deserialize(statement.getSerializedResults(), new TypeReference<Object>() {});
            }
            if (results == null) {
                genSqlResults(id, sqlResults, statement, results);
            } else if (results instanceof ArrayList) {
                for (Object result : (List)results) {
                    genSqlResults(id, sqlResults, statement, result);
                }
            } else {
                genSqlResults(id, sqlResults, statement, results);
            }

        }
        return sqlResults;
    }
}
