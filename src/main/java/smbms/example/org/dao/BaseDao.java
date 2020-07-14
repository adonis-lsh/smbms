package smbms.example.org.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class BaseDao {
    static {
        init();
    }

    private static String driver;
    private static String url;
    private static String user;
    private static String password;

    public static void init() {
        Properties properties = new Properties();
        InputStream inputStream = BaseDao.class.getResourceAsStream("/db.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
        user = properties.getProperty("user");
        password = properties.getProperty("password");
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }



    public static ResultSet execute(Connection connection, String sql, Object[] params,ResultSetListener resultSetListener) {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
             preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i+1, params[i]);
            }
            resultSet = preparedStatement.executeQuery();
            if (resultSetListener != null) {
                resultSetListener.execResult(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResource(connection, preparedStatement, resultSet);
        }

        //关闭连接

        return resultSet;
    }

    public static boolean closeResource(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        boolean flag = true;
        try {
            if (null != connection) {
                connection.close();
                connection = null;
            }
            if (null != preparedStatement) {
                preparedStatement.close();
                preparedStatement = null;
            }
            if (null != resultSet) {
                resultSet.close();
                resultSet = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }


    public interface ResultSetListener {
        void execResult(ResultSet resultSet);
    }
}
