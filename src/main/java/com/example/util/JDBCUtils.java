package com.example.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


public class JDBCUtils {

    static DruidDataSource dataSource;
    private static ThreadLocal<Connection> connection = new ThreadLocal<Connection>();

    static {
        try {
            Properties properties = new Properties();
            InputStream inputStream = JDBCUtils.class.getResourceAsStream("/JDBC.properties");
            properties.load(inputStream);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection() {

        Connection conn = connection.get();
        if (conn == null) {
            try {
                conn = dataSource.getConnection();
                connection.set(conn);
                conn.setAutoCommit(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return conn;
//        Connection connection = null;
//        try{
//            connection = dataSource.getConnection();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return connection;
    }


    public static void commitAndClose(){
        Connection conn = connection.get();
        if (conn != null){
            try{
                conn.commit();
                
            }catch (Exception e){
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        connection.remove();
    }

    public static void rollbackAndClose(){
        Connection conn = connection.get();
        if (conn != null){
            try{
                conn.rollback();
            }catch (Exception e){
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        connection.remove();
    }

}
