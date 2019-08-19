package com.servlet;

import com.dao.DbHelper;
import com.entity.GoodsInfo;
import com.until.StringUntil;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("/good_list.jsp").forward(req,resp);
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //查询主页
        try {

            GoodsInfo goodsInfos = new GoodsInfo();
            List<GoodsInfo> list = DbHelper.getRunner().query("SELECT id, goodsInfoName,goodsInfoPic,goodsInfoPrice FROM goodsinfo", new BeanListHandler<>(GoodsInfo.class));
            list.forEach(goodsInfo -> {
//                System.out.println(goodsInfo);
            });

            req.setAttribute("list", list);
            req.getRequestDispatcher("/good_list.jsp").forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}


