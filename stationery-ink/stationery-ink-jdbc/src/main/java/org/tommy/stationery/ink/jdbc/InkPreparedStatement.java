package org.tommy.stationery.ink.jdbc;

import org.tommy.stationery.ink.jdbc.client.InkRestClient;
import org.tommy.stationery.ink.jdbc.exception.InkSQLException;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by kun7788 on 15. 1. 30..
 */
public class InkPreparedStatement extends InkStatement implements PreparedStatement {

    final String sql;
    List _params = new ArrayList();
    InkRestClient inkRestClient;

    InkPreparedStatement( InkConnection conn , int type, int concurrency, int holdability , String sql )
            throws InkSQLException, Exception {
        super( conn , type , concurrency , holdability );
        this.sql = sql;

        inkRestClient = conn.getInkRestClient();
        inkRestClient.setSql(sql);
        //inkRestClient.parse(sql);
    }

    public void addBatch(){
        throw new UnsupportedOperationException( "batch stuff not supported" );
    }

    // --- metadata ---

    public ResultSetMetaData getMetaData(){
        throw new UnsupportedOperationException();
    }
    public ParameterMetaData getParameterMetaData(){
        throw new UnsupportedOperationException();
    }

    public void clearParameters(){
        throw new UnsupportedOperationException();
    }

    // ----- actually do

    public boolean execute(){
        String ret = inkRestClient.send();
        InkResultSet inkResultSet = null;
        try {
            inkResultSet = new InkResultSet(ret);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
       return true;
    }

    public ResultSet executeQuery(){
        String ret = inkRestClient.send();
        InkResultSet inkResultSet = null;
        try {
            inkResultSet = new InkResultSet(ret);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inkResultSet;
    }

    public int executeUpdate()
            throws InkSQLException {
        throw new RuntimeException( "executeUpdate not done" );
    }

    // ---- setters -----

    public void setArray(int idx, Array x){ _setnotdone(); }
    public void setAsciiStream(int idx, InputStream x){ _setnotdone(); }
    public void setAsciiStream(int idx, InputStream x, int length){ _setnotdone(); }
    public void setAsciiStream(int idx, InputStream x, long length){ _setnotdone(); }
    public void setBigDecimal(int idx, BigDecimal x){ _setnotdone(); }
    public void setBinaryStream(int idx, InputStream x){ _setnotdone(); }
    public void setBinaryStream(int idx, InputStream x, int length){ _setnotdone(); }
    public void setBinaryStream(int idx, InputStream x, long length){ _setnotdone(); }
    public void setBlob(int idx, Blob x){ _setnotdone(); }
    public void setBlob(int idx, InputStream inputStream){ _setnotdone(); }
    public void setBlob(int idx, InputStream inputStream, long length){ _setnotdone(); }
    public void setBoolean(int idx, boolean x){ _setnotdone(); }
    public void setByte(int idx, byte x){ _setnotdone(); }
    public void setBytes(int idx, byte[] x){ _setnotdone(); }
    public void setCharacterStream(int idx, Reader reader){ _setnotdone(); }
    public void setCharacterStream(int idx, Reader reader, int length){ _setnotdone(); }
    public void setCharacterStream(int idx, Reader reader, long length){ _setnotdone(); }
    public void setClob(int idx, Clob x){ _setnotdone(); }


    public void setClob(int idx, Reader reader){ _setnotdone(); }
    public void setClob(int idx, Reader reader, long length){ _setnotdone(); }
    public void setDate(int idx, Date x){ _setnotdone(); }
    public void setDate(int idx, Date x, Calendar cal){ _setnotdone(); }
    public void setDouble(int idx, double x){ _setnotdone(); }
    public void setFloat(int idx, float x){ _setnotdone(); }
    public void setInt(int idx, int x){ _set( idx , x ); }
    public void setLong(int idx, long x){ _set( idx , x ); }
    public void setNCharacterStream(int idx, Reader value){ _setnotdone(); }
    public void setNCharacterStream(int idx, Reader value, long length){ _setnotdone(); }
    public void setNClob(int idx, NClob value){ _setnotdone(); }
    public void setNClob(int idx, Reader reader){ _setnotdone(); }
    public void setNClob(int idx, Reader reader, long length){ _setnotdone(); }
    public void setNString(int idx, String value){ _setnotdone(); }
    public void setNull(int idx, int sqlType){ _setnotdone(); }
    public void setNull(int idx, int sqlType, String typeName){ _setnotdone(); }
    public void setObject(int idx, Object x){ _set( idx , x ); }
    public void setObject(int idx, Object x, int targetSqlType){ _setnotdone(); }
    public void setObject(int idx, Object x, int targetSqlType, int scaleOrLength){ _setnotdone(); }
    public void setRef(int idx, Ref x){ _setnotdone(); }
    public void setRowId(int idx, RowId x){ _setnotdone(); }
    public void setShort(int idx, short x){ _set( idx , x ); }
    public void setSQLXML(int idx, SQLXML xmlObject){ _setnotdone(); }
    public void setString(int idx, String x){ _set( idx , x ); }
    public void setTime(int idx, Time x){ _setnotdone(); }
    public void setTime(int idx, Time x, Calendar cal){ _setnotdone(); }
    public void setTimestamp(int idx, Timestamp x){ _setnotdone(); }
    public void setTimestamp(int idx, Timestamp x, Calendar cal){ _setnotdone(); }
    public void setUnicodeStream(int idx, InputStream x, int length){ _setnotdone(); }
    public void setURL(int idx, URL x){ _setnotdone(); }

    void _setnotdone(){
        throw new UnsupportedOperationException( "setter not done" );
    }

    void _set( int idx , Object o ){
        while ( _params.size() <= idx )
            _params.add( null );
        _params.set( idx , o );
    }

    public boolean isCloseOnCompletion()
            throws SQLException {
        return false;
    }

    public void closeOnCompletion()
            throws SQLException {

    }

    public <T> T getObject(int parameterIndex,
                           Class<T> type)
            throws SQLException {
        return null;
    }

    public <T> T getObject(String parameterName,
                           Class<T> type)
            throws SQLException {
        return null;
    }
}
