package org.tommy.stationery.ink.jdbc;

import org.tommy.stationery.ink.enums.MessageEnum;
import org.tommy.stationery.ink.jdbc.client.InkRestClient;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Created by kun7788 on 15. 1. 30..
 */
public class InkDriver implements Driver {

    static final String PREFIX = "jdbc:ink://";
    public static final String DATABASE_USER = "user";
    public static final String DATABASE_PASSWORD = "password";

    static {
        try {
            DriverManager.registerDriver(new InkDriver());
        }
        catch ( SQLException e ){
            throw new RuntimeException( e );
        }
    }

    public Logger getParentLogger()
            throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public Connection connect(String url, Properties info) throws SQLException {
        if ( url.startsWith( PREFIX ) ) {
            url = "http://" + url.substring(PREFIX.length());
        } else {
            throw new SQLException(MessageEnum.INVALID_INK_PROTOCOL.getMessage());
        }

        String user = info.getProperty(DATABASE_USER);
        String password = info.getProperty(DATABASE_PASSWORD);

        if ((user == null || password == null) || (user.length() <= 0 || password.length() <= 0)) {
            throw new SQLException(MessageEnum.INVALID_AUTH_INFO.getMessage());
        }

        InkRestClient inkRestClient = new InkRestClient(url);
        inkRestClient.setSessionId(InkRestClient.initializeSession());
        inkRestClient.setUser(user);
        inkRestClient.setPassword(password);

        //auth check.
        String ret = inkRestClient.getClient().authCheck(user, password);
        if (!"200".equals(ret)) {
            throw new SQLException(MessageEnum.INVALID_AUTH_INFO.getMessage());
        }

        return new InkConnection(inkRestClient);
    }

    @Override
    public boolean acceptsURL(String url) throws SQLException {
        return url.startsWith( PREFIX );
    }

    @Override
    public DriverPropertyInfo[] getPropertyInfo(String s, Properties properties) throws SQLException {
        return new DriverPropertyInfo[0];
    }

    @Override
    public int getMajorVersion() {
        return 0;
    }

    @Override
    public int getMinorVersion() {
        return 1;
    }

    @Override
    public boolean jdbcCompliant() {
        return false;
    }
}
