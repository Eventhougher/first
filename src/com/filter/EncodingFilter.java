package com.filter;

import javax.servlet.*;
import java.io.IOException;

//过滤器在web服务器启动时创建实例
public class EncodingFilter implements Filter {
    private String econding;
    //初始化，只执行1次

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        econding = filterConfig.getInitParameter("encoding1");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //设置请求对象的编码
        servletRequest.setCharacterEncoding(econding);
        //设置响应对象的编码
        servletResponse.setCharacterEncoding(econding);
        servletResponse.setContentType("text/html;charset=utf-8");

        //继续执行请求的url
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("销毁资源");
    }

    
}
