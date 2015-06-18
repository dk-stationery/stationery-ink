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

    static final String PREFIX = "ink://";

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
        /*if ( info != null && info.size() > 0 )
            throw new UnsupportedOperationException( "properties not supported yet" );
        */

        if ( url.startsWith( PREFIX ) ) {
            url = "http://" + url.substring(PREFIX.length());
        } else {
            throw new SQLException(MessageEnum.INVALID_INK_PROTOCOL.getMessage());
        }

        InkRestClient inkRestClient = new InkRestClient(url);
        inkRestClient.setSessionId(InkRestClient.initializeSession());
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
