package org.tommy.stationery.ink.core.parser;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.soda.*;
import org.tommy.stationery.ink.domain.BaseBindColumnDef;
import org.tommy.stationery.ink.domain.BaseColumnDef;
import org.tommy.stationery.ink.domain.BaseStatement;
import org.tommy.stationery.ink.domain.BaseTableDef;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kun7788 on 15. 1. 26..
 */
public class QueryParser {
    private EPStatementObjectModel statement;
    private String sql;

    public BaseStatement parse(String sql) {
        BaseStatement statement = new BaseStatement();
        statement.setBindColumns(parseBindColumns(sql));

        String dressedSql = dressQuery(sql);
        statement.setColumns(parseColumns(dressedSql));
        statement.setBindTables(parseBindTables(sql));
        statement.setDressQuery(dressedSql);
        return statement;
    }


    public BaseStatement parseWithoutEPL(String sql) {
        BaseStatement statement = new BaseStatement();
        String dressedSql = dressQuery(sql);
        statement.setBindColumns(parseBindColumns(sql));
        statement.setColumns(parseColumns(dressedSql.replace("lookup ", "select ").replaceAll("plugins(\\s*)\\((.+?)\\)", ""))); //FOR USING ESPER PARSER!!
        statement.setBindTables(parseBindTables(sql));
        statement.setDressQuery(dressedSql);
        return statement;
    }

    public BaseStatement parseWithoutInsertEPL(String sql) {
        BaseStatement statement = new BaseStatement();
        String dressedSql = dressQuery(sql);
        statement.setBindColumns(parseBindColumns(sql));
        statement.setColumns(new ArrayList<BaseColumnDef>());
        statement.setBindTables(parseBindTables(sql));
        statement.setDressQuery(dressedSql);
        return statement;
    }

    private String dressQuery(String sql) {
        String dressedSql = new String(sql);
        String colonMark = dressedSql.substring(dressedSql.length() - 1, dressedSql.length());
        if (";".equals(colonMark)) {
            dressedSql = dressedSql.substring(0, dressedSql.length() - 1);
        }

        dressedSql = dressedSql.replaceAll("\\[(.+?)\\:(.+?)\\]", "$1");
        return dressedSql;
    }

    private List<BaseBindColumnDef> parseBindColumns(String sql) {
        List<BaseBindColumnDef> bindColumns = new ArrayList<BaseBindColumnDef>();

        Pattern p = Pattern.compile("\\[\\:(.+?)\\]");

        Matcher m = p.matcher (sql);
        while (m.find())
        {
            String bindName = m.group(1);
            BaseBindColumnDef bindColumn = new BaseBindColumnDef();
            bindColumn.setName(bindName);
            bindColumns.add(bindColumn);
        }

        return bindColumns;
    }


    private List<BaseColumnDef> parseColumns(String sql) {
        Configuration config = new Configuration();
        EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider(config);
        statement = epService.getEPAdministrator().compileEPL(sql);

        StringWriter sw = null;
        List<BaseColumnDef> columns = new ArrayList<BaseColumnDef>();

        for (SelectClauseElement select : statement.getSelectClause().getSelectList()) {
            if (select instanceof SelectClauseExpression) {
                sw=new StringWriter();
                SelectClauseExpression expression=(SelectClauseExpression)select;

                String name = "";
                if (expression.getAsName() == null) {
                    expression.getExpression().toEPL(sw, ExpressionPrecedenceEnum.AND);
                    name = sw.toString();
                } else {
                    name = expression.getAsName();
                }

                BaseColumnDef column = new BaseColumnDef();
                column.setName(name);
                columns.add(column);
            }
        }
        return columns;
    }

    private List<BaseTableDef> parseBindTables(String sql) {
        List<BaseTableDef> bindTables = new ArrayList<BaseTableDef>();

        Pattern p = Pattern.compile("(\\[([\\d\\w]+)\\:([\\d\\w]+))+\\]");
        Matcher m = p.matcher (sql);

        while (m.find())
        {
            String bindName = m.group(2);
            String sourceName = m.group(3);
            BaseTableDef tableDef = new BaseTableDef();
            tableDef.setName(bindName);
            tableDef.setSource(sourceName);
            bindTables.add(tableDef);
        }

        return bindTables;
    }

    private List<BaseTableDef> parseBindTablesFromEPL(String sql) {
        Configuration config = new Configuration();
        EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider(config);
        statement = epService.getEPAdministrator().compileEPL(sql);

        StringWriter sw = null;
        List<BaseTableDef> bindTables = new ArrayList<BaseTableDef>();

        for (Stream stream : statement.getFromClause().getStreams()) {

            String name = "";
            if ( stream instanceof FilterStream ) {
                FilterStream fs = (FilterStream) stream;
                name = fs.getFilter().getEventTypeName();
            }
            else {
                name =  stream.getStreamName();
            }

            BaseTableDef tableDef = new BaseTableDef();
            tableDef.setName(name);
            bindTables.add(tableDef);
        }
        return bindTables;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
}

