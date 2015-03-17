package org.tommy.stationery.ink.jdbc.exception;

import java.sql.SQLException;

/**
 * Created by kun7788 on 15. 1. 30..
 */
public class InkSQLException extends SQLException {

    public InkSQLException(String msg) {
        super(msg);
    }

    public static class BadSQL extends InkSQLException {
        BadSQL( String sql ){
            super( "bad sql: " + sql );
        }
    }
}
