package com.servlet;

import com.dao.DbHelper;
import com.dao.GoodsInfoDao;
import com.entity.GoodsInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取信息
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            //判断用户名是否为空
            if (username != null && !"".equals(username)) {
                //密码是否为空
                if (password != null && !"".equals(password)) {
                    //密码是否与用户名相等
                    if (username.equals(password)) {
                        //密码与用户名相同错误
                        resp.sendRedirect("/equal.jsp");
                        return;
                    }
                    //注册成功
                    Object[] params = {req.getParameter("username"), req.getParameter("password"), req.getParameter("sex"), req.getParameter("hobbys"), req.getParameter("phone"), req.getParameter("email"), req.getParameter("addrs"), req.getParameter("flag")};
                    DbHelper.getRunner().update("INSERT user VALUES (NULL,?,?,?,?,?,?,?,?)", params);

                    resp.sendRedirect("/loginsuccess.jsp");
                    return;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //用户名或密码为空
        resp.sendRedirect("/loginfailed.jsp");
    }
}
