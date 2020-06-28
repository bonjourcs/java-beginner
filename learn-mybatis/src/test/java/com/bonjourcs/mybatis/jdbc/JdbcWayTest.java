package com.bonjourcs.mybatis.jdbc;

import org.junit.Before;
import org.junit.Test;

import java.sql.*;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2020/6/28
 */
public class JdbcWayTest {

    private String driver;

    private String url;

    private String username;

    private String password;

    @Before
    public void init() {
        driver = "com.mysql.cj.jdbc.Driver";
        url = "jdbc:mysql://ip:port/db_name?characterEncoding=UTF-8&serverTimezone=GMT%2B8";
        username = "";
        password = "";
    }

    @Test
    public void testSelectBook() throws ClassNotFoundException, SQLException {

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, username, password);
        String sql = "select * from tb_goods";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();
        System.out.println("=======================");
        while (resultSet.next()) {
            System.out.println("|" + resultSet.getInt("gid") + "|" +
                    resultSet.getString("gname") + "|");
        }
        System.out.println("=======================");

    }
}
