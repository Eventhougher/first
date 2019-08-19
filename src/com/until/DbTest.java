package com.until;

import com.dao.DbHelper;
import com.entity.GoodsInfo;
import com.entity.User;
import com.servlet.OperateServlet;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class DbTest {
    public static void main(String[] args) throws SQLException {
        testQuery();
        OperateServlet op = new OperateServlet();

    }

    private static void testQuery() throws SQLException {
        Object[] params = {"admin"};
        List<User> tbUsers = DbHelper.getRunner().query("SELECT * FROM user WHERE username=?", new BeanListHandler<>(User.class),params);
        tbUsers.forEach(tbUser -> {
            System.out.println(tbUser);
        });
        List<GoodsInfo> goodsInfos = DbHelper.getRunner().query("SELECT * FROM goodsinfo", new BeanListHandler<>(GoodsInfo.class));
        goodsInfos.forEach(goodsInfo -> {
            System.out.println(goodsInfo);
        });
//        sf.append("UPDATE goodsInfo set");
//        sf.append("    id=?");
//        sf.append("    goodsInfoName=?");
//        sf.append("    goodsInfoPic=?");
//        sf.append("    goodsInfoPrice=?");
//        sf.append("    goodsInfoDescription=?");
//        sf.append("    goodsInfoStock=?");
//        sf.append("    flag=?");
//        sf.append("    created=?");
//        sf.append("    createdDate=?");

    }
}