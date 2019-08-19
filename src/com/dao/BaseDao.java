package com.dao;

import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.*;
import java.util.List;
import java.util.Map;


// 不涉及到任何的业务javabean的基类
public class BaseDao {
    private static final String DRIVER_CLASS="com.mysql.cj.jdbc.Driver";
    private static final String URL="jdbc:mysql://localhost:3306/my1905?characterEncoding=utf8&useSSL=false&serverTimezone=CST";
    private static final String USERNAME="root";
    private static final String PASSWORD="03180072";

    // 获得连接对象
    public Connection getConnection(){
        DbUtils.loadDriver(DRIVER_CLASS);
        try {
            return DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 关闭资源
    public void closeAll(Connection conn, Statement sta, ResultSet rs){
        DbUtils.closeQuietly(conn, sta, rs);
    }

    /**
     * 查询
     *   要求：属性名和列名一致
     * @param clazz         要返回的javabean的Class
     * @param sql           要执行的sql语句
     * @param paramObjs     占位符的值
     * @param <T>           要返回的泛型
     * @return
     */
    public <T> List<T> queryByConnection(Class clazz, String sql, Object[] paramObjs){
        // 1、获得连接对象
        Connection conn = this.getConnection();

        // 2、创建QueryRunner对象，用于执行sql操作
        QueryRunner queryRunner = new QueryRunner();

        try {
            // 3、执行sql
            if(paramObjs!=null && paramObjs.length>0){
                // 带占位符
                List<T> list = queryRunner.query(conn, sql, new BeanListHandler<T>(clazz), paramObjs);
                return list;
            }else{
                // 不带占位符
                List<T> list = queryRunner.query(conn, sql, new BeanListHandler<T>(clazz));
                return list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeAll(conn, null,null);
        }
        return null;
    }

    /**
     * 查询
     *   要求：属性名和列名不一致
     * @param clazz         要返回的javabean的Class
     * @param sql           要执行的sql语句
     * @param paramObjs     占位符的值
     * @param <T>           要返回的泛型
     * @param propertyMap   属性与列名的映射：key表示列名，value表示属性名
     * @return
     */
    public <T> List<T> query2ByConnection(Class clazz, String sql, Object[] paramObjs, Map<String,String> propertyMap){
        // 1、获得连接对象
        Connection conn = this.getConnection();

        // 2、创建QueryRunner对象，用于执行sql操作
        QueryRunner queryRunner = new QueryRunner();

        try {
            // 3、执行sql
            if(paramObjs!=null && paramObjs.length>0){
                // 带占位符
                List list = queryRunner.query(conn, sql, resultSet -> {
                    BeanProcessor beanProcessor = new BeanProcessor(propertyMap);
                    RowProcessor rowProcessor = new BasicRowProcessor(beanProcessor);
                    return rowProcessor.toBeanList(resultSet, clazz);
                },paramObjs);
                return list;
            }else{
                // 不带占位符
                List list = queryRunner.query(conn, sql, resultSet -> {
                    BeanProcessor beanProcessor = new BeanProcessor(propertyMap);
                    RowProcessor rowProcessor = new BasicRowProcessor(beanProcessor);
                    return rowProcessor.toBeanList(resultSet, clazz);
                });
                return list;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeAll(conn, null,null);
        }
        return null;
    }

    /**
     * 增删改功能
     * @param sql          要执行的sql语句
     * @param paramObjs
     * @return
     */
    public int update(String sql, Object[] paramObjs){
        // 1、获得连接对象
        Connection conn = this.getConnection();
        try {
            // 1、创建QueryRunner对象，进行sql操作
            QueryRunner query = new QueryRunner();

            // 2、执行sql语句并返回结果集（List）
            int rows = query.update(conn, sql, paramObjs);
            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return 0;
    }
}
