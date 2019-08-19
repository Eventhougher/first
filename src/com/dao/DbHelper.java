package com.dao;


import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * jdbc工具类
 *
 * */
public class DbHelper {


      //mySQL驱动
    private static final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";

    //地址url
    private static final String URL = "jdbc:mysql://localhost:3306/my1905?characterEncoding=utf8&useSSL=false&serverTimezone=CST";

    //用户名
    private static final String USERNAME = "root";

    //密码
    private static final String PASSWORD = "03180072";

    //数据源
    private static BasicDataSource dataSource = new BasicDataSource();

    static {
        //初始化数据源
        dataSource.setDriverClassName(DRIVER_CLASS_NAME);
        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);

    }

    //获取数据库连接池
    public static DataSource getDataSource(){
        return dataSource;
    }

    //获取数据库连接对象

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    //获取DbUtils Runner 对象  操作数据库
    public static QueryRunner getRunner(){
        return new QueryRunner(getDataSource());
    }

}
