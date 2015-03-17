package org.tommy.stationery.ink.api.service;

import org.apache.hadoop.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tommy.stationery.ink.api.annotation.CacheData;
import org.tommy.stationery.ink.api.dao.DynamicApiDao;
import org.tommy.stationery.ink.api.domain.Column;
import org.tommy.stationery.ink.api.domain.DynamicApiCallInfo;
import org.tommy.stationery.ink.api.domain.DynamicQuery;
import org.tommy.stationery.ink.api.parser.ApiCallParserUtil;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by kun7788 on 15. 2. 9..
 */
@Service
public class DynamicApiService {

    private static String TABLENAME = "tableName";
    private static String WHERE = "where";

    @Autowired
    DynamicApiDao dynamicApiDao;

    @Autowired
    DataSource dataSource;

    @CacheData
    public LinkedHashMap<String, Column> getPrimaryKeysFromTable(String tableName) throws SQLException {
        Connection connection = null;

        LinkedHashMap<String, Column> primaryColumns = new LinkedHashMap<String, Column>();
        try {
            connection = dataSource.getConnection();
            DatabaseMetaData dmd = connection.getMetaData();
            ResultSet rs = dmd.getPrimaryKeys(null, null, tableName);


            NavigableMap<String, Column> navigableMap = new TreeMap<String, Column>();
            while (rs.next()) {
                String kseq = rs.getString("KEY_SEQ");

                Column column = new Column();
                column.setName(rs.getString("COLUMN_NAME"));
                column.setPrimary(true);
                column.setType(rs.getString("TYPE_NAME"));

                navigableMap.put(kseq, column);
            }

            for (String key : navigableMap.keySet()) {
                Column _column = navigableMap.get(key);
                primaryColumns.put(_column.getName(), _column);
            }

        } catch(Exception ex) {

        } finally {
            if (connection != null)
                connection.close();
        }
        return primaryColumns;
    }

    public List<HashMap<String, String>> getDynamicTableData(LinkedHashMap<String, Column> primaryKeys, DynamicApiCallInfo info) throws Exception {
        LinkedHashMap<String, Column> columns = new LinkedHashMap<String, Column>();
        for (String columnName : info.getColumns()) {
            if (!primaryKeys.containsKey(columnName)) {
                throw new Exception("not primary columns[1]");
            } else {
                columns.put(columnName, primaryKeys.get(columnName));
            }
        }

        StringBuilder psb = new StringBuilder();
        for (String key : primaryKeys.keySet()) {
            psb.append(key);
        }
        String primaryKeyHashingString = psb.toString();


        StringBuilder sb = new StringBuilder();
        for (String columnName : info.getColumns()) {
            sb.append(columnName);
        }
        String inputKeyHashingString = sb.toString();

        int hashingIndex = primaryKeyHashingString.indexOf(inputKeyHashingString);
        if (hashingIndex != 0) {
            throw new Exception("not primary columns[2]");
        }

        //query gen
        DynamicQuery dynamicQuery = new DynamicQuery();
        dynamicQuery.setTableName(info.getTableName());
        dynamicQuery.setWhere(generateWhereQuery(columns, info));
        return dynamicApiDao.getDynamicAPI(dynamicQuery);
    }

    private String generateWhereQuery(LinkedHashMap<String, Column> columns, DynamicApiCallInfo info) throws Exception {
        List<String> params = new ArrayList<String>();
        for (Column column : columns.values()) {
            String val = info.getParams().get(column.getName());
            if (val == null) {
                throw new Exception("param value is null");
            }
            if ("VARCHAR".equals(column.getType())) {
                val = "'" + val + "'";
            }
            params.add(column.getName() + " = " + val);
        }

        return StringUtils.join(" AND ", params);
    }

    @CacheData
    public List<HashMap<String, String>> getDynamicApi(String apiName, HttpServletRequest request) throws Exception {
        DynamicApiCallInfo info = ApiCallParserUtil.parse(apiName, request);

        LinkedHashMap<String, Column> primaryKeys = getPrimaryKeysFromTable(info.getTableName());

        return getDynamicTableData(primaryKeys, info);
    }

}
