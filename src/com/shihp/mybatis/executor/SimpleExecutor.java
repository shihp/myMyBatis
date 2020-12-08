package com.shihp.mybatis.executor;

import com.shihp.mybatis.entity.User;

import java.sql.*;

/**
 * 封装jdbc 实现crud
 *
 * @author shihuipeng
 * @date 2020/12/8
 */
public class SimpleExecutor implements Executor {
    @Override
    public <T> T query(String sql, Object parameter) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        connection = getConnection();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, (Integer) parameter);
            ResultSet rs = preparedStatement.executeQuery();
            User user = new User();
            while (rs.next()) {
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setAge(rs.getInt(3));
            }
            return (T) user;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    private Connection getConnection() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "12345678";

        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
