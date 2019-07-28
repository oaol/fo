package com.fo.test.tdengine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import com.alibaba.fastjson.JSON;
import com.taosdata.jdbc.TSDBDriver;

/**
 * java use tdengine demo
 * 
 * @author bryce
 * @Date Jul 25, 2019
 */
public class Demo {

    public static Connection getConn() throws Exception {
        Class.forName("com.taosdata.jdbc.TSDBDriver");
        String jdbcUrl = "jdbc:TAOS://127.0.0.1:6020/test?user=root&password=";
        Properties connProps = new Properties();
        connProps.setProperty(TSDBDriver.PROPERTY_KEY_USER, "root");
        connProps.setProperty(TSDBDriver.PROPERTY_KEY_PASSWORD, "");
        connProps.setProperty(TSDBDriver.PROPERTY_KEY_CONFIG_DIR, "/etc/taos");
        connProps.setProperty(TSDBDriver.PROPERTY_KEY_CHARSET, "UTF-8");
        connProps.setProperty(TSDBDriver.PROPERTY_KEY_LOCALE, "en_US.UTF-8");
        Connection conn = DriverManager.getConnection(jdbcUrl, connProps);
        return conn;
    }

    public static void main(String[] args) throws Exception {
        Connection conn = getConn();
        Statement createStatement = conn.createStatement();
        createStatement.execute("insert into t values('2019-01-01 11:11:13', 3) ('2019-02-01 11:11:11', 4)");
        ResultSet result = createStatement.executeQuery("select * from t");
        while (result.next()) {
            System.out.println("result: " + result.getString("td") + "," + result.getInt("a"));
        }
        conn.close();
    }

}
