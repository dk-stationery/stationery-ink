package org.tommy.stationery.ink.core.engine.storm.bolt.bucket.redis;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import redis.clients.jedis.JedisShardInfo;

import javax.script.*;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by kun7788 on 15. 7. 22..
 */
public class Test {
    public static List<JedisShardInfo> generateShardInfo(String hosts, String password, int timeout) {

        //http://172.26.32.54:9200/idx10/user/0 -d \'{\"uid\":\"0\",\"profile\":{\"gender\":\"M\",\"agegrp\":3},\"user_status\":{\"dia\":5},\"session\":[{\"date\":\"20150701\",\"count\":3,\"sum\":1000}],\"paid\":[{\"date\":\"20150703\",\"count\":3,\"sum\":1000},{\"date\":\"20150702\",\"count\":3,\"sum\":1000},{\"date\":\"20150701\",\"count\":3,\"sum\":1000}]}\'
        List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
        for (String hostname : hosts.split(",")) {
            int port = hostname.indexOf(":") == -1 ? 6379 : Integer.parseInt(hostname.split(":")[1]);
            String host = hostname.indexOf(":") == -1 ? hostname : hostname.split(":")[0];

            System.out.println(host + " : " + port);
            JedisShardInfo si = new JedisShardInfo(host, port);
            // si.setPassword(password);
            si.setTimeout(timeout);
            shards.add(si);
        }
        return shards;
    }

    public static void Display(String arg) {
        System.out.println("********" + arg);
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException, SQLException, ScriptException, NoSuchMethodException {

        /*ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        Class[] parameters = new Class[] { String.class, Integer.class };
        Method dealMethod = Utils.class.getMethod("deal", parameters);
        engine.put("deal", new FunctionObject("deal", dealMethod, scope));
*/

        String a = "test";
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        Bindings bindings = new SimpleBindings();
        bindings.put("a", a);
        engine.put("test", "test");
        engine.eval("print(test);");
        // engine.eval("var MyJavaClass = Java.type('org.tommy.stationery.ink.core.engine.storm.bolt.bucket.redis.Test');MyJavaClass.Display(a);", bindings);
        /*System.out.println(engine.eval("importPackage(org.tommy.stationery.ink.core.engine.storm.bolt.bucket.redis.Test);\n" +
                "Test.Display();", bindings));
*/

        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("org.postgresql.Driver");
        } catch (PropertyVetoException e) {
        }
        dataSource.setJdbcUrl("jdbc:postgresql://172.16.215.239:5432/gmp");
        dataSource.setUser("gmp");
        dataSource.setPassword("gmp!1");
        dataSource.setInitialPoolSize(1);
        dataSource.setMaxPoolSize(20);
        dataSource.setMinPoolSize(10);

        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from ink_auth where authuser = ?");
        preparedStatement.setString(1, "ADMIN");
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet != null) {
            while (resultSet.next()) {
                System.out.println(resultSet.getString("authuser"));
            }
            //String conditionValue = resultSet.getString("authuser");
            //System.out.println(conditionValue);
        }
    }
}
