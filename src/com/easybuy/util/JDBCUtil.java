package com.easybuy.util;

import com.easybuy.entity.Result;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JDBCUtil {


    private static String dirverClass;
    private static String url;
    private static String name;
    private static String pwd;

    static {
        InputStream is =
                JDBCUtil.class.getClassLoader ().getResourceAsStream ("database.properties");
        try {
            Properties properties = new Properties ();
            properties.load (is);
            dirverClass = properties.getProperty ("driver");
            url = properties.getProperty ("url");
            name = properties.getProperty ("name");
            pwd = properties.getProperty ("password");
            Class.forName (dirverClass);
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }


    public static Connection getConnection() throws Exception {
        Connection connection = DriverManager.getConnection (url, name, pwd);
        return connection;
    }


    /**
     * 通过的update,delete,insert
     *
     * @param sql
     * @param params
     * @return
     */
    public static int update(String sql, Object[] params) {
        try {
            Connection connection = getConnection ();
            PreparedStatement preparedStatement = connection.prepareStatement (sql);
            if (params != null) {
                for (int i = 1; i <= params.length; i++) {
                    preparedStatement.setObject (i, params[i - 1]);
                }
            }
            return preparedStatement.executeUpdate ();
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return 0;
    }

    public static ResultSet query(String sql, Object[] params) {
        Connection connection = null;
        try {
            connection = getConnection ();
            PreparedStatement preparedStatement = connection.prepareStatement (sql);
            if (params != null) {
                for (int i = 1; i <= params.length; i++) {
                    preparedStatement.setObject (i, params[i - 1]);
                }
            }
            ResultSet resultSet = preparedStatement.executeQuery ();
            return resultSet;
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return null;
    }

}
