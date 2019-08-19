package com.filter;



import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;



public class PowerFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {


        // 将请求与响应向下转换
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String path = req.getRequestURI();
        HttpSession session = req.getSession(true);

        //从session里取的用户名信息
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");
        if (path.equals("/login.jsp") || path.equals("/login") || path.equals("/register.jsp") || path.equals("/register") || path.equals("/index1.jsp")
                || path.equals("/error.jsp") || path.equals("/loginfailed.jsp") || path.equals("/loginsuccess.jsp") || path.equals("/equal.jsp")
        ) {
            chain.doFilter(request, response);
            return;
        } else if (username == null || "".equals(username) || password == null || "".equals(password)) {
            //跳转到登陆页面
            res.sendRedirect("/index1.jsp");
        } else {
            //已经登陆,继续此次请求
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        System.out.println("销毁资源");
    }
}
