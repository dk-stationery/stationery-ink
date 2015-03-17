package org.tommy.stationery.ink.domain;

import java.io.Serializable;

/**
 * Created by kun7788 on 15. 1. 27..
 */
public class ResultStatement implements Serializable {

    private static final long serialVersionUID = -3113172704091424396L;
    private BaseStatement statement;
    private String serializedResults;
    private String errorMsg = null;

    public BaseStatement getStatement() {
        return statement;
    }

    public void setStatement(BaseStatement statement) {
        this.statement = statement;
    }

    public String getSerializedResults() {
        return serializedResults;
    }

    public void setSerializedResults(String serializedResults) {
        this.serializedResults = serializedResults;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
