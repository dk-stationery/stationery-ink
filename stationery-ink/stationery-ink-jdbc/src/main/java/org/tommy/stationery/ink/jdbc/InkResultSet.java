package org.tommy.stationery.ink.jdbc;

import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tommy.stationery.ink.domain.SqlResults;
import org.tommy.stationery.ink.enums.SqlResultsHeaderEnum;
import org.tommy.stationery.ink.util.serde.JsonSerde;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;
import java.util.Map;

/**
 * Created by kun7788 on 15. 1. 30..
 */
public class InkResultSet implements ResultSet {

    private static final Logger logger = LoggerFactory.getLogger(InkResultSet.class);

    int _row = 0;
    boolean _closed = false;
    int curser = -1;
    String ret;
    SqlResults sqlResults;

    JsonSerde statementJsonSerde = new JsonSerde();

    InkResultSet(String ret) throws IOException {
        this.ret = ret;

        sqlResults = (SqlResults)statementJsonSerde.deserialize(ret, new TypeReference<SqlResults>() {
        });
    }

    public void clearWarnings(){
        // NO-OP
    }

    public void close(){
        _closed = true;
    }

    public boolean isClosed(){
        return _closed;
    }

    //  meta data

    public int getConcurrency(){
        return CONCUR_READ_ONLY;
    }

    public int getType(){
        return TYPE_FORWARD_ONLY;
    }

    public void setFetchDirection(int direction){
        if ( direction == getFetchDirection() )
            return;
        throw new UnsupportedOperationException("1");
    }

    public int getFetchDirection(){
        return 1;
    }

    public String getCursorName(){
        return "InkResultSet";
    }

    public ResultSetMetaData getMetaData(){
        return new ResultSetMetaData() {
            @Override
            public <T> T unwrap(Class<T> aClass) throws SQLException {
                return (T)this;
            }

            @Override
            public boolean isWrapperFor(Class<?> aClass) throws SQLException {
                return  aClass.isInstance(this);
            }

            @Override
            public int getColumnCount() throws SQLException {
                return SqlResultsHeaderEnum.values().length;
            }

            @Override
            public boolean isAutoIncrement(int i) throws SQLException {
                return false;
            }

            @Override
            public boolean isCaseSensitive(int i) throws SQLException {
                return false;
            }

            @Override
            public boolean isSearchable(int i) throws SQLException {
                return false;
            }

            @Override
            public boolean isCurrency(int i) throws SQLException {
                return false;
            }

            @Override
            public int isNullable(int i) throws SQLException {
                return 0;
            }

            @Override
            public boolean isSigned(int i) throws SQLException {
                return false;
            }

            @Override
            public int getColumnDisplaySize(int i) throws SQLException {
                return  100;
            }

            @Override
            public String getColumnLabel(int i) throws SQLException {
                String[] lables = {"ID", "TYPE", "ERROR", "RESULT", "RESULT"};
                return lables[i-1];
            }

            @Override
            public String getColumnName(int i) throws SQLException {
                String[] lables = {"ID", "TYPE", "ERROR", "RESULT", "RESULT"};
                return lables[i-1];
            }

            @Override
            public String getSchemaName(int i) throws SQLException {
                return "";
            }

            @Override
            public int getPrecision(int i) throws SQLException {
                return 0;
            }

            @Override
            public int getScale(int i) throws SQLException {
                return 0;
            }

            @Override
            public String getTableName(int i) throws SQLException {
                logger.info("##############################");
                return "cluster";
            }

            @Override
            public String getCatalogName(int i) throws SQLException {
                return "";
            }

            @Override
            public int getColumnType(int i) throws SQLException {
                return 12;
            }

            @Override
            public String getColumnTypeName(int i) throws SQLException {
                return "VARCHAR";
            }

            @Override
            public boolean isReadOnly(int i) throws SQLException {
                return false;
            }

            @Override
            public boolean isWritable(int i) throws SQLException {
                return false;
            }

            @Override
            public boolean isDefinitelyWritable(int i) throws SQLException {
                return false;
            }

            @Override
            public String getColumnClassName(int i) throws SQLException {
                logger.info(" == getColumnClassName " + String.class.getName());
                return String.class.getName();
            }
        };
        //throw new UnsupportedOperationException("2");
    }

    public SQLWarning getWarnings(){
        //logger.info(" getWarnings :: ");
        //throw new UnsupportedOperationException("3");
        return null;
    }

    public void setFetchSize(int rows){
        throw new UnsupportedOperationException("4");
    }

    public int getFetchSize(){
        throw new UnsupportedOperationException("5");
    }


    public Statement getStatement(){
        throw new UnsupportedOperationException("6");
    }

    public int getHoldability(){
        return ResultSet.HOLD_CURSORS_OVER_COMMIT;
    }

    // cursor moving methods

    public boolean absolute(int row){
        throw new UnsupportedOperationException("7");
    }

    public void afterLast(){
        throw new UnsupportedOperationException("8");
    }

    public void beforeFirst(){
        throw new UnsupportedOperationException("9");
    }

    public boolean first(){
        throw new UnsupportedOperationException("10");
    }

    public int getRow(){
        return _row;
    }

    public boolean isAfterLast(){
        throw new UnsupportedOperationException("11");
    }

    public boolean isBeforeFirst(){
        throw new UnsupportedOperationException("12");
    }
    public boolean isFirst(){
        throw new UnsupportedOperationException("13");
    }
    public boolean isLast(){
        throw new UnsupportedOperationException("14");
    }
    public boolean last(){
        throw new UnsupportedOperationException("15");
    }
    public void moveToCurrentRow(){
        throw new UnsupportedOperationException("16");
    }
    public void moveToInsertRow(){
        throw new UnsupportedOperationException("17");
    }
    public boolean previous(){
        throw new UnsupportedOperationException("18");
    }
    public void refreshRow(){
        throw new UnsupportedOperationException("19");
    }
    public boolean relative(int rows){
        throw new UnsupportedOperationException("20");
    }
    public boolean rowDeleted(){
        throw new UnsupportedOperationException("21");
    }
    public boolean rowInserted(){
        throw new UnsupportedOperationException("22");
    }
    public boolean rowUpdated(){
        throw new UnsupportedOperationException("23");
    }

    // modifications

    public void insertRow(){
        throw new UnsupportedOperationException("24");
    }

    public void cancelRowUpdates(){
        throw new UnsupportedOperationException("25");
    }

    public void deleteRow(){
        throw new UnsupportedOperationException("26");
    }

    public void updateRow(){
        throw new UnsupportedOperationException("27");
    }

    // field updates

    public void updateArray(int columnIndex, Array x){
        throw new UnsupportedOperationException("28"); }
    public void updateArray(String columnName, Array x){
        throw new UnsupportedOperationException("29"); }

    public void updateAsciiStream(int columnIndex, InputStream x, int length){
        throw new UnsupportedOperationException("30"); }
    public void updateAsciiStream(String columnName, InputStream x, int length){
        throw new UnsupportedOperationException("31"); }
    public void updateAsciiStream(int columnIndex, InputStream x, long length){
        throw new UnsupportedOperationException("32"); }
    public void updateAsciiStream(String columnName, InputStream x, long length){
        throw new UnsupportedOperationException("33"); }
    public void updateAsciiStream(int columnIndex, InputStream x ){
        throw new UnsupportedOperationException("34"); }
    public void updateAsciiStream(String columnName, InputStream x ){
        throw new UnsupportedOperationException("35"); }

    public void updateBigDecimal(int columnIndex, BigDecimal x){
        throw new UnsupportedOperationException("36"); }
    public void updateBigDecimal(String columnName, BigDecimal x){
        throw new UnsupportedOperationException("37"); }

    public void updateBinaryStream(int columnIndex, InputStream x, int length){
        throw new UnsupportedOperationException("38"); }
    public void updateBinaryStream(String columnName, InputStream x, int length){
        throw new UnsupportedOperationException("39"); }
    public void updateBinaryStream(int columnIndex, InputStream x, long length){
        throw new UnsupportedOperationException("40"); }
    public void updateBinaryStream(String columnName, InputStream x, long length){
        throw new UnsupportedOperationException("41"); }
    public void updateBinaryStream(int columnIndex, InputStream x ){
        throw new UnsupportedOperationException("42"); }
    public void updateBinaryStream(String columnName, InputStream x ){
        throw new UnsupportedOperationException("43"); }

    public void updateBlob(int columnIndex, Blob x){
        throw new UnsupportedOperationException("44"); }
    public void updateBlob(String columnName, Blob x){
        throw new UnsupportedOperationException("45"); }
    public void updateBlob(int columnIndex, InputStream x){
        throw new UnsupportedOperationException("46"); }
    public void updateBlob(String columnName, InputStream x){
        throw new UnsupportedOperationException("47"); }
    public void updateBlob(int columnIndex, InputStream x, long l){
        throw new UnsupportedOperationException("48"); }
    public void updateBlob(String columnName, InputStream x, long l){
        throw new UnsupportedOperationException("49"); }

    public void updateBoolean(int columnIndex, boolean x){
        throw new UnsupportedOperationException("50"); }
    public void updateBoolean(String columnName, boolean x){
        throw new UnsupportedOperationException("51"); }

    public void updateByte(int columnIndex, byte x){
        throw new UnsupportedOperationException("52"); }
    public void updateByte(String columnName, byte x){
        throw new UnsupportedOperationException("53"); }

    public void updateBytes(int columnIndex, byte[] x){
        throw new UnsupportedOperationException("54"); }
    public void updateBytes(String columnName, byte[] x){
        throw new UnsupportedOperationException("55"); }

    public void updateCharacterStream(int columnIndex, Reader x, int length){
        throw new UnsupportedOperationException("56"); }
    public void updateCharacterStream(String columnName, Reader reader, int length){
        throw new UnsupportedOperationException("57"); }
    public void updateCharacterStream(int columnIndex, Reader x, long  length){
        throw new UnsupportedOperationException("58"); }
    public void updateCharacterStream(String columnName, Reader reader, long length){
        throw new UnsupportedOperationException("59"); }
    public void updateCharacterStream(int columnIndex, Reader x ){
        throw new UnsupportedOperationException("60"); }
    public void updateCharacterStream(String columnName, Reader reader ){
        throw new UnsupportedOperationException("61"); }

    public void updateClob(int columnIndex, Clob x){
        throw new UnsupportedOperationException(); }
    public void updateClob(String columnName, Clob x){
        throw new UnsupportedOperationException(); }
    public void updateClob(int columnIndex, Reader x){
        throw new UnsupportedOperationException(); }
    public void updateClob(String columnName, Reader x){
        throw new UnsupportedOperationException(); }
    public void updateClob(int columnIndex, Reader x, long l ){
        throw new UnsupportedOperationException(); }
    public void updateClob(String columnName, Reader x, long l ){
        throw new UnsupportedOperationException(); }

    public void updateDate(int columnIndex, Date x){
        throw new UnsupportedOperationException(); }
    public void updateDate(String columnName, Date x){
        throw new UnsupportedOperationException(); }

    public void updateDouble(int columnIndex, double x){
        throw new UnsupportedOperationException(); }
    public void updateDouble(String columnName, double x){
        throw new UnsupportedOperationException(); }

    public void updateFloat(int columnIndex, float x){
        throw new UnsupportedOperationException(); }
    public void updateFloat(String columnName, float x){
        throw new UnsupportedOperationException(); }

    public void updateInt(int columnIndex, int x){
        throw new UnsupportedOperationException(); }
    public void updateInt(String columnName, int x){
        throw new UnsupportedOperationException(); }

    public void updateLong(int columnIndex, long x){
        throw new UnsupportedOperationException(); }
    public void updateLong(String columnName, long x){
        throw new UnsupportedOperationException(); }

    public void updateNull(int columnIndex){
        throw new UnsupportedOperationException(); }
    public void updateNull(String columnName){
        throw new UnsupportedOperationException(); }

    public void updateObject(int columnIndex, Object x){
        throw new UnsupportedOperationException(); }
    public void updateObject(int columnIndex, Object x, int scale){
        throw new UnsupportedOperationException(); }
    public void updateObject(String columnName, Object x){
        throw new UnsupportedOperationException(); }
    public void updateObject(String columnName, Object x, int scale){
        throw new UnsupportedOperationException(); }

    public void updateRef(int columnIndex, Ref x){
        throw new UnsupportedOperationException(); }
    public void updateRef(String columnName, Ref x){
        throw new UnsupportedOperationException(); }

    public void updateRowId(int columnIndex, RowId x){
        throw new UnsupportedOperationException(); }
    public void updateRowId(String columnName, RowId x){
        throw new UnsupportedOperationException(); }

    public void updateShort(int columnIndex, short x){
        throw new UnsupportedOperationException(); }
    public void updateShort(String columnName, short x){
        throw new UnsupportedOperationException(); }

    public void updateSQLXML(int columnIndex, SQLXML xmlObject){
        throw new UnsupportedOperationException(); }
    public void updateSQLXML(String columnName, SQLXML xmlObject){
        throw new UnsupportedOperationException(); }

    public void updateString(int columnIndex, String x){
        throw new UnsupportedOperationException(); }
    public void updateString(String columnName, String x){
        throw new UnsupportedOperationException(); }

    public void updateTime(int columnIndex, Time x){
        throw new UnsupportedOperationException(); }
    public void updateTime(String columnName, Time x){
        throw new UnsupportedOperationException(); }

    public void updateTimestamp(int columnIndex, Timestamp x){
        throw new UnsupportedOperationException(); }
    public void updateTimestamp(String columnName, Timestamp x){
        throw new UnsupportedOperationException(); }

    // accessors
    public Array getArray(int i){throw new UnsupportedOperationException("62");}
    public Array getArray(String colName){throw new UnsupportedOperationException("63");}
    public InputStream getAsciiStream(int columnIndex){throw new UnsupportedOperationException("64");}
    public InputStream getAsciiStream(String columnName){throw new UnsupportedOperationException("65");}
    public BigDecimal getBigDecimal(int columnIndex){throw new UnsupportedOperationException("66");}
    public BigDecimal getBigDecimal(int columnIndex, int scale){throw new UnsupportedOperationException("67");}
    public BigDecimal getBigDecimal(String columnName){
        throw new UnsupportedOperationException("68");
    }
    public BigDecimal getBigDecimal(String columnName, int scale){
        throw new UnsupportedOperationException("69");
    }
    public InputStream getBinaryStream(int columnIndex){throw new UnsupportedOperationException("70");}
    public InputStream getBinaryStream(String columnName){
        throw new UnsupportedOperationException("71");
    }
    public Blob getBlob(int i){ throw new UnsupportedOperationException("72");}
    public Blob getBlob(String colName){
        throw new UnsupportedOperationException("73");
    }
    public boolean getBoolean(int columnIndex){
        return getBoolean( _find( columnIndex ) );
    }
    public boolean getBoolean(String columnName){
        /*Object x = _cur.get( columnName );
        if ( x == null )
            return false;
        return (Boolean)x;*/
        return false;
    }

    public byte getByte(int columnIndex){
        throw new UnsupportedOperationException();
    }
    public byte getByte(String columnName){
        throw new UnsupportedOperationException();
    }

    public byte[] getBytes(int columnIndex){
        throw new UnsupportedOperationException();
    }
    public byte[] getBytes(String columnName){
        throw new UnsupportedOperationException();
    }

    public Reader getCharacterStream(int columnIndex){
        return getCharacterStream( _find( columnIndex ) );
    }
    public Reader getCharacterStream(String columnName){
        throw new UnsupportedOperationException();
    }

    public Clob getClob(int i){
        throw new UnsupportedOperationException();
    }
    public Clob getClob(String colName){
        throw new UnsupportedOperationException();
    }

    public Date getDate(int columnIndex){
        throw new UnsupportedOperationException();
    }
    public Date getDate(int columnIndex, Calendar cal){
        throw new UnsupportedOperationException();
    }
    public Date getDate(String columnName){
        throw new UnsupportedOperationException();
    }
    public Date getDate(String columnName, Calendar cal){
        throw new UnsupportedOperationException();
    }

    public double getDouble(int columnIndex){
        return getDouble( _find( columnIndex ) );
    }
    public double getDouble(String columnName){
        return _getNumber( columnName ).doubleValue();
    }

    public float getFloat(int columnIndex){
        return getFloat( _find( columnIndex ) );
    }
    public float getFloat(String columnName){
        return _getNumber( columnName ).floatValue();
    }

    public int getInt(int columnIndex){
        return getInt( _find( columnIndex ) );
    }
    public int getInt(String columnName){
        return _getNumber( columnName ).intValue();
    }

    public long getLong(int columnIndex){
        return getLong( _find( columnIndex ) );
    }
    public long getLong(String columnName){
        return _getNumber( columnName ).longValue();
    }

    public short getShort(int columnIndex){
        throw new UnsupportedOperationException();
    }
    public short getShort(String columnName){
        throw new UnsupportedOperationException();
    }

    Number _getNumber( String n ){
        throw new UnsupportedOperationException();
    }

    public Object getObject(int columnIndex){
       throw new UnsupportedOperationException();
    }
    public Object getObject(int i, Map map){
        throw new UnsupportedOperationException();
    }
    public Object getObject(String columnName){
       throw new UnsupportedOperationException();
    }
    public Object getObject(String colName, Map map){
        throw new UnsupportedOperationException();
    }

    public Ref getRef(int i){
        return getRef( _find( i ) );
    }
    public Ref getRef(String colName){
        throw new UnsupportedOperationException();
    }

    public RowId getRowId( int i ){
        return getRowId( _find( i ) );
    }
    public RowId getRowId( String name ){
        throw new UnsupportedOperationException();
    }


    public SQLXML getSQLXML(int columnIndex){
        return getSQLXML( _find( columnIndex ) );
    }
    public SQLXML getSQLXML(String columnName){
        throw new UnsupportedOperationException();
    }

    public String getString(int columnIndex){

        logger.info("======== getString1 :: " + columnIndex);

        if (columnIndex - 1 >= 0) {
            columnIndex = columnIndex -1;
        }

        //DEBUG
        if (sqlResults.getListFromCursor().size() < columnIndex) {
            return "";
        }
        Object val = sqlResults.getListFromCursor().get(columnIndex).get(curser);
        if ( val == null )
            return "";

        String v = val.toString();

        v = v.replace("\\n", "\r\n");
        v = v.replace("\\t", "\t");

        return v;
    }

    public String getString(String columnName){

        logger.info(" getString2 :: " + columnName);

        if (sqlResults.getListFromCursor().size() < findColumn(columnName)) {
            return "";
        }

        Object val = sqlResults.getListFromCursor().get(findColumn(columnName)).get(curser);
        if ( val == null )
            return "";

        String v = val.toString();

        v = v.replace("\\n", "\r\n");
        v = v.replace("\\t", "\t");

        return v;
    }

    public Time getTime(int columnIndex){
        return getTime( _find( columnIndex ) );
    }
    public Time getTime(int columnIndex, Calendar cal){
        return getTime( _find( columnIndex ) , cal );
    }
    public Time getTime(String columnName){
        throw new UnsupportedOperationException();
    }
    public Time getTime(String columnName, Calendar cal){
        throw new UnsupportedOperationException();
    }

    public Timestamp getTimestamp(int columnIndex){
        return getTimestamp( _find( columnIndex ) );
    }
    public Timestamp getTimestamp(int columnIndex, Calendar cal){
        return getTimestamp( _find( columnIndex ) , cal );
    }
    public Timestamp getTimestamp(String columnName){
        throw new UnsupportedOperationException();
    }
    public Timestamp getTimestamp(String columnName, Calendar cal){
        throw new UnsupportedOperationException();
    }

    public InputStream getUnicodeStream(int columnIndex){
        return getUnicodeStream( _find( columnIndex ) );
    }
    public InputStream getUnicodeStream(String columnName){
        throw new UnsupportedOperationException();
    }

    public URL getURL(int columnIndex)
            throws SQLException {
        return getURL( _find( columnIndex ) );
    }
    public URL getURL(String columnName)
            throws SQLException {
        try {
            return new URL( getString( columnName ) );
        }
        catch ( java.net.MalformedURLException m ){
            throw new SQLException( "bad url [" + getString( columnName ) + "]" );
        }
    }

    // N stuff

    public String getNString(int columnIndex){
        return getNString( _find( columnIndex ) );
    }
    public String getNString(String columnName){
        throw new UnsupportedOperationException();
    }
    public NClob getNClob(int columnIndex){
        return getNClob( _find( columnIndex ) );
    }
    public NClob getNClob(String columnName){
        throw new UnsupportedOperationException();
    }
    public Reader getNCharacterStream(int columnIndex){
        return getNCharacterStream( _find( columnIndex ) );
    }
    public Reader getNCharacterStream(String columnName){
        throw new UnsupportedOperationException();
    }

    public void updateNCharacterStream(int columnIndex, Reader x){ throw new UnsupportedOperationException(); }
    public void updateNCharacterStream(int columnIndex, Reader x, long length){ throw new UnsupportedOperationException(); }
    public void updateNCharacterStream(String columnLabel, Reader reader){ throw new UnsupportedOperationException(); }
    public void updateNCharacterStream(String columnLabel, Reader reader, long length){ throw new UnsupportedOperationException(); }
    public void updateNClob(int columnIndex, NClob nClob){ throw new UnsupportedOperationException(); }
    public void updateNClob(int columnIndex, Reader reader){ throw new UnsupportedOperationException(); }
    public void updateNClob(int columnIndex, Reader reader, long length){ throw new UnsupportedOperationException(); }
    public void updateNClob(String columnLabel, NClob nClob){ throw new UnsupportedOperationException(); }
    public void updateNClob(String columnLabel, Reader reader){ throw new UnsupportedOperationException(); }

    public void updateNClob(String columnLabel, Reader reader, long length){ throw new UnsupportedOperationException(); }
    public void updateNString(int columnIndex, String nString){ throw new UnsupportedOperationException(); }
    public void updateNString(String columnLabel, String nString){ throw new UnsupportedOperationException(); }

    public boolean wasNull(){
        return false;
        //throw new UnsupportedOperationException();
    }

    // column <-> int mapping

    public int findColumn( String columnName ){
        return SqlResultsHeaderEnum.valueOf(columnName).getIndex()-1;
    }

    public String _find( int i ){
        String[] lables = {"ID", "TYPE", "ERROR", "RESULT"};
        return lables[i];
    }

    // random stuff

    public <T> T unwrap(Class<T> iface)
            throws SQLException {
        throw new UnsupportedOperationException("80");
    }

    public boolean isWrapperFor(Class<?> iface)
            throws SQLException {
        throw new UnsupportedOperationException("81");
    }

    // moving throgh cursor

    public boolean next(){
        if (sqlResults == null) return  false;
        if (sqlResults.getListFromCursor().get(0).size()-1 <= curser) {
            curser = -1;
            return false;
        }

        ++curser;
        return true;
    }

    public <T> T getObject(int columnIndex,
                           Class<T> type)
            throws SQLException {
        return null;
    }

    public <T> T getObject(String columnLabel,
                           Class<T> type)
            throws SQLException {
        return null;
    }
}
