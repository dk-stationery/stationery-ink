package org.tommy.stationery.ink.core.storm.bolt;

import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tommy.stationery.ink.core.cache.ConcurrentLRUCache;
import org.tommy.stationery.ink.core.config.InkConfig;
import org.tommy.stationery.ink.core.util.MetaFinderUtil;
import org.tommy.stationery.ink.domain.*;
import org.tommy.stationery.ink.domain.meta.Source;
import org.tommy.stationery.ink.domain.meta.Stream;
import org.tommy.stationery.ink.enums.MetaFieldEnum;
import org.tommy.stationery.ink.enums.SettingEnum;

import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kun7788 on 15. 2. 9..
 */
public class GenericBoltUtils {

    public static Logger logger = LoggerFactory.getLogger(GenericBoltUtils.class);

    private ConcurrentLRUCache<String, List<List<Object>>> concurrentLRUCache = new ConcurrentLRUCache<String, List<List<Object>>>(500000);

    public List<List<Object>> LOCAL_CACHE_GET(String key) {
        return concurrentLRUCache.get(key);
    }

    public void LOCAL_CACHE_PUT(String key, List<List<Object>> val) {
        concurrentLRUCache.put(key, val);
    }

    public Object getJDBCCommunication(InkConfig inkConfig, Source inkSource) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        BaseMetaDef driverMeta = MetaFinderUtil.findMeta(inkSource.getStatement().getMetas(), MetaFieldEnum.DRIVER);
        if (driverMeta != null) {
            dataSource.setDriverClass(driverMeta.getValue());
        }

        BaseMetaDef urlMeta = MetaFinderUtil.findMeta(inkSource.getStatement().getMetas(), MetaFieldEnum.URL);
        if (urlMeta != null) {
            dataSource.setJdbcUrl(urlMeta.getValue());
        }

        BaseMetaDef idMeta = MetaFinderUtil.findMeta(inkSource.getStatement().getMetas(), MetaFieldEnum.ID);
        if (idMeta != null) {
            dataSource.setUser(idMeta.getValue());
        }

        BaseMetaDef passwdMeta = MetaFinderUtil.findMeta(inkSource.getStatement().getMetas(), MetaFieldEnum.PW);
        if (passwdMeta != null) {
            dataSource.setPassword(passwdMeta.getValue());
        }

        BaseMetaDef initialPoolSizeMeta = MetaFinderUtil.findMeta(inkSource.getStatement().getMetas(), MetaFieldEnum.INITIALPOOLSIZE);
        if (initialPoolSizeMeta != null) {
            dataSource.setInitialPoolSize(Integer.valueOf(initialPoolSizeMeta.getValue()));
        } else {
            dataSource.setInitialPoolSize(Integer.valueOf(inkConfig.getInteger(SettingEnum.BUCKET_CONNECTION_INITIALPOOLSIZE)));
        }

        BaseMetaDef maxPoolSizeMeta = MetaFinderUtil.findMeta(inkSource.getStatement().getMetas(), MetaFieldEnum.MAXPOOLSIZE);
        if (maxPoolSizeMeta != null) {
            dataSource.setMaxPoolSize(Integer.valueOf(maxPoolSizeMeta.getValue()));
        } else {
            dataSource.setMaxPoolSize(Integer.valueOf(inkConfig.getInteger(SettingEnum.BUCKET_CONNECTION_MAXPOOLSIZE)));
        }

        BaseMetaDef minPoolSizeMeta = MetaFinderUtil.findMeta(inkSource.getStatement().getMetas(), MetaFieldEnum.MINPOOLSIZE);
        if (minPoolSizeMeta != null) {
            dataSource.setMinPoolSize(Integer.valueOf(minPoolSizeMeta.getValue()));
        } else {
            dataSource.setMinPoolSize(Integer.valueOf(inkConfig.getInteger(SettingEnum.BUCKET_CONNECTION_MINPOOLSIZE)));
        }
        return dataSource;
    }

    public List<List<Object>> valuesMapperFromJDBCResultColumns(BaseStatement baseStatement, ResultSet rs) throws SQLException {
        List<List<Object>> values = new ArrayList<List<Object>>();

        List<Object> value = new ArrayList<Object>();
        if (rs != null) {
            while (rs.next()) {
                for (BaseColumnDef columnDef : baseStatement.getColumns()) {
                    Object val = null;
                    try {
                        val = rs.getObject(columnDef.getName());
                    } catch (Exception e) {
                    }
                    value.add(val);
                }

                values.add(value);
            }
        }
        return values;
    }

    public Fields getDeclareOutputFields(List<String> previousEmitFileds, List<BaseColumnDef> baseColumnDefs) {
        List<String> columns = new ArrayList<String>();

        if (baseColumnDefs != null) {
            for (BaseColumnDef columnDef : baseColumnDefs) {
                columns.add(columnDef.getName());
            }
        }

        if (previousEmitFileds != null && previousEmitFileds.size() > 0) {
            columns.addAll(previousEmitFileds);
        }

        return new Fields(columns.toArray(new String[0]));
    }

    public String generatePreQueryForBindTable(String topic, BaseStatement baseStatement, Stream inkStream) {
        String query = baseStatement.getQuery();
        for (BaseTableDef tableDef : baseStatement.getBindTables()) {
            String bindTableTag = "[" + tableDef.getName() + ":" + tableDef.getSource() + "]";
            query = query.replace(bindTableTag, topic);
        }
        query = query.replace("lookup ", "select ").replace(";", "");
        return query;
    }

    public String generateQueryForBindColumns(String query, BaseStatement baseStatement, Tuple input) {

        if (input == null) return null;

        //bind column
        for (BaseBindColumnDef columnDef :  baseStatement.getBindColumns()) {
            Object bindVal = input.getValueByField(columnDef.getName());
            if (bindVal == null) return null;

            String bindColumnTag = "[:" + columnDef.getName() + "]";

            query = query.replace(bindColumnTag, bindVal.toString());
        }

        return query;
    }
}
