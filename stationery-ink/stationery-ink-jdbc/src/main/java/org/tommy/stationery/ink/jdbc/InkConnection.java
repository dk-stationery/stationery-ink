package org.tommy.stationery.ink.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tommy.stationery.ink.jdbc.client.InkRestClient;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * Created by kun7788 on 15. 1. 30..
 */
public class InkConnection implements Connection {

    private static final Logger logger = LoggerFactory.getLogger(InkConnection.class);

    InkRestClient inkRestClient;
    Properties clientInfo;

    public InkConnection( InkRestClient inkRestClient ){
        this.inkRestClient = inkRestClient;
    }

    public SQLWarning getWarnings(){
       // throw new RuntimeException( "should do get last error" );
        return null;
    }

    public void clearWarnings(){
        throw new RuntimeException( "should reset error" );
    }

    // ---- state -----

    public void close(){
        System.out.println("finalize close");
        inkRestClient.send("commit");
        inkRestClient.setSessionId(InkRestClient.initializeSession());

        if (isClosed() != true) {
            inkRestClient.close();
        }
    }

    public boolean isClosed(){
        return inkRestClient == null;
    }

    // --- commit ----

    public void commit(){
        // NO-OP
    }

    public boolean getAutoCommit(){
        return true;
    }

    public void rollback(){
        throw new RuntimeException( "can't rollback" );
    }

    public void rollback(Savepoint savepoint){
        throw new RuntimeException( "can't rollback" );
    }

    public void setAutoCommit(boolean autoCommit){
        if ( ! autoCommit )
            throw new RuntimeException( "autoCommit has to be on" );
    }

    public void releaseSavepoint(Savepoint savepoint){
        throw new RuntimeException( "no savepoints" );
    }

    public Savepoint setSavepoint(){
        throw new RuntimeException( "no savepoints" );
    }

    public Savepoint setSavepoint(String name){
        throw new RuntimeException( "no savepoints" );
    }

    public void setTransactionIsolation(int level){
       // throw new RuntimeException( "no TransactionIsolation" );
    }

    // --- create ----

    public Array createArrayOf(String typeName, Object[] elements){
        throw new RuntimeException( "no create*" );
    }
    public Struct createStruct(String typeName, Object[] attributes){
        throw new RuntimeException( "no create*" );
    }
    public Blob createBlob(){
        throw new RuntimeException( "no create*" );
    }
    public Clob createClob(){
        throw new RuntimeException( "no create*" );
    }
    public NClob createNClob(){
        throw new RuntimeException( "no create*" );
    }
    public SQLXML createSQLXML(){
        throw new RuntimeException( "no create*" );
    }

    // ------- meta data ----

    public String getCatalog(){
        return null;
    }
    public void setCatalog(String catalog){
        throw new RuntimeException( "can't set catalog" );
    }

    public Properties getClientInfo(){
        return clientInfo;
    }
    public String getClientInfo(String name){
        return (String)clientInfo.get( name );
    }

    public void setClientInfo(String name, String value){
        clientInfo.put( name , value );
    }
    public void setClientInfo(Properties properties){
        clientInfo = properties;
    }


    public int getHoldability(){
        return ResultSet.HOLD_CURSORS_OVER_COMMIT;
    }
    public void setHoldability(int holdability){
    }

    public int getTransactionIsolation(){
        return 1;
        //throw new RuntimeException( "not dont yet" );
    }

    public DatabaseMetaData getMetaData() throws SQLException {
       return new InkDatabaseMetaData(this);
    }

    public boolean isValid(int timeout){
        return inkRestClient != null;
    }

    public boolean isReadOnly(){
        return false;
    }

    public void setReadOnly(boolean readOnly){
        if ( readOnly )
            throw new RuntimeException( "no read only mode" );
    }


    public Map<String,Class<?>> getTypeMap(){
        throw new RuntimeException( "not done yet" );
    }
    public void setTypeMap(Map<String,Class<?>> map){
        throw new RuntimeException( "not done yet" );
    }

    // ---- Statement -----

    public Statement createStatement(){
        //throw new RuntimeException( "createStatement1" );
        return createStatement( 0 , 0 , 0 );
    }
    public Statement createStatement(int resultSetType, int resultSetConcurrency){
        //throw new RuntimeException( "createStatement2" );
        return createStatement( resultSetType , resultSetConcurrency, 0 );
    }
    public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability){
        //throw new RuntimeException( "createStatement3" );
        return new InkStatement( this , resultSetType , resultSetConcurrency , resultSetHoldability );
    }

    // --- CallableStatement


    public CallableStatement prepareCall(String sql){
        return prepareCall( sql , 0 , 0 , 0 );
    }
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency){
        return prepareCall( sql , resultSetType , resultSetConcurrency , 0 );
    }
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability){
        throw new RuntimeException( "CallableStatement not supported" );
    }

    // ---- PreparedStatement
    public PreparedStatement prepareStatement(String sql)
            throws SQLException {
        return prepareStatement( sql , 0 , 0 , 0 );
    }
    public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys){
        throw new RuntimeException( "no PreparedStatement yet" );
    }
    public PreparedStatement prepareStatement(String sql, int[] columnIndexes){
        throw new RuntimeException( "no PreparedStatement yet" );
    }
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency)
            throws SQLException {
        return prepareStatement( sql , resultSetType , resultSetConcurrency , 0 );
    }
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability)
            throws SQLException {
        try {
            return new InkPreparedStatement( this , resultSetType , resultSetConcurrency , resultSetHoldability , sql );
        } catch (Exception e) {
        }

        return null;
    }

    public PreparedStatement prepareStatement(String sql, String[] columnNames){
        throw new RuntimeException( "no PreparedStatement yet" );
    }


    // ---- random ----

    public String nativeSQL(String sql){
        return sql;
    }

    public <T> T unwrap(Class<T> iface)
            throws SQLException {
        throw new UnsupportedOperationException();
    }

    public boolean isWrapperFor(Class<?> iface)
            throws SQLException {
        throw new UnsupportedOperationException();
    }

    public int getNetworkTimeout()
            throws SQLException {
        return 0;
    }

    public void setNetworkTimeout(Executor executor,
                                  int milliseconds)
            throws SQLException {

    }

    public void abort(Executor executor)
            throws SQLException {

    }

    public String getSchema()
            throws SQLException {
        return null;
    }

    public void setSchema(String s)
            throws SQLException {

    }

    public InkRestClient getInkRestClient(){
        return inkRestClient;
    }
}
