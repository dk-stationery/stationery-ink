package org.tommy.stationery.ink.core.storm.ast;

import org.tommy.stationery.ink.domain.*;

import java.util.List;

/**
 * Created by kun7788 on 15. 1. 27..
 */
public class ASTDump {

    public static String toAST(List<ResultStatement> resultStatements) {
        StringBuilder sb = new StringBuilder();
        if (resultStatements == null) {return "";}

        int lineNumCnt = 0;
        for (ResultStatement resultStatement : resultStatements) {
            BaseStatement statement = resultStatement.getStatement();


            sb.append((char)27 + "[31m[" + statement.getType().getGroup()+ ":STAGE-" + (lineNumCnt++) + "]"+ (char)27 + "[37m");
            sb.append("\r\n{");
            sb.append("\r\nTABLE:=>");
            if (statement.getTable() == null) sb.append("{NAME=>EMPTY, SOURCE=>EMPTY}"); else sb.append("{NAME=>" + statement.getTable().getName() + ", SOURCE=>" + statement.getTable().getSource() + "}");
            sb.append("\r\nTYPE:=>");
            if (statement.getType() == null) sb.append("{NAME=>EMPTY, GROUP=>EMPTY, SUBGROUP=>EMPTY"); else sb.append("{NAME=>" + statement.getType().getName() + ", GROUP=>" + statement.getType().getGroup() + ", SUBGROUP=>" + statement.getType().getSubGroup()+ "}");
            sb.append("\r\nQUERY:=>");
            if (statement.getQuery() == null) sb.append("{QUERY=>EMPTY}"); else sb.append("{QUERY=>" + statement.getQuery() + "}");
            sb.append("\r\nCOLUMNS:=>{");
            if (statement.getColumns() == null) {
                sb.append("\r\n\t{NAME=>EMPTY, TYPE=>EMPTY, COMMENT=>EMPTY}");
            } else {
                for (BaseColumnDef columnDef : statement.getColumns()) {
                    sb.append("\r\n\t{NAME=>" + columnDef.getName() + ", TYPE=>" + (columnDef.getType() == null ? "EMPTY" : columnDef.getType().getName()) + ", COMMENT=>" + (columnDef.getComment() == null ? "EMPTY" : columnDef.getComment()) + "}");
                }
            }
            sb.append("\r\n}");

            sb.append("\r\nBIND_COLUMNS:=>{");
            if (statement.getBindColumns() == null) {
                sb.append("\r\n\t{NAME=>EMPTY}");
            } else {
                for (BaseBindColumnDef columnDef : statement.getBindColumns()) {
                    sb.append("\r\n\t{NAME=>" + columnDef.getName() + "}");
                }
            }
            sb.append("\r\n}");

            sb.append("\r\nBIND_TABLES:=>{");
            if (statement.getBindTables() == null) {
                sb.append("\r\n\t{NAME=>EMPTY, SOURCE=>EMPTY}");
            } else {
                for (BaseTableDef tableDef : statement.getBindTables()) {
                    sb.append("\r\n\t{NAME=>" + tableDef.getName() + ", SOURCE=>" + tableDef.getSource() + "}");
                }
            }
            sb.append("\r\n}");
            sb.append("\r\n}\r\n");
        }

        return sb.toString();
    }
}
