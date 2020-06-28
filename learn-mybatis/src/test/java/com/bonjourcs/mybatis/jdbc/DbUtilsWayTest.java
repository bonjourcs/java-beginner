package com.bonjourcs.mybatis.jdbc;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Data;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.junit.Before;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2020/6/28
 */
public class DbUtilsWayTest {

    private String url;

    private String userName;

    private String password;

    private String driver;

    @Before
    public void init() {
        url = "jdbc:mysql://ip:port/db_name?serverTimezone=GMT%2B8";
        userName = "";
        password = "";
        driver = "com.mysql.cj.jdbc.Driver";
    }

    @Test
    public void testDbUtils() throws SQLException {

        DataSource dataSource = getDataSource();
        QueryRunner queryRunner = new QueryRunner(dataSource);
        String sql = "select * from tb_goods";

        List<Good> goods = queryRunner.query(sql, new GoodHandler());
        goods.forEach(System.out::println);

    }

    class GoodHandler implements ResultSetHandler<List<Good>> {
        @Override
        public List<Good> handle(ResultSet resultSet) throws SQLException {

            List<Good> goods = new ArrayList<>();
            while (resultSet.next()) {
                Good good = new Good();
                good.setGid(resultSet.getInt("gid"));
                good.setName(resultSet.getString("gname"));
                goods.add(good);
            }
            return goods;
        }
    }

    @Data
    class Good {

        private int gid;

        private String name;

    }

    HikariDataSource getDataSource() {

        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(url);
        hikariConfig.setDriverClassName(driver);
        hikariConfig.setUsername(userName);
        hikariConfig.setPassword(password);

        return new HikariDataSource(hikariConfig);
    }

}
