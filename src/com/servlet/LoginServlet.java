package com.servlet;

import com.dao.DbHelper;
import com.entity.User;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class LoginServlet extends HttpServlet {
    //获取用户对象
    private static final String SQL_GET_USER = "SELECT * FROM user WHERE username =?";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        User user = new User();
        // 获取请求参数

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //用户名是否为空
        if (username != null && !"".equals(username)) {
            //获取用户
            try {
                user = DbHelper.getRunner().query(SQL_GET_USER, new BeanHandler<>(User.class), username);

                //判断用户是否存在

                if (user != null) {


                    //判断密码是否正确
                    if (password.equals(user.getPassword())) {
                        //密码匹配跳转
                        HttpSession session = req.getSession();
                        session.setAttribute("username",username);
                        session.setAttribute("password",password);

                        req.getRequestDispatcher("good").forward(req,resp);
                        return;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        //用户名或密码错误
        resp.sendRedirect("/error.jsp");
    }
}
