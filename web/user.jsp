<%@ page import="com.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: 吴月波
  Date: 2019/8/12
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>

      <table border="1">
          <tr>
              <th>id</th>
              <td>${user.id}</td>
          <tr/>
          <tr>
              <th>用户名</th>
              <td>${user.username}</td>
          </tr>
          <tr>
              <th>密码</th>
              <td>${user.password}</td>
          </tr>
          <tr>
              <th>性别</th>
              <td>${user.sex}</td>
          </tr>
          <tr>
              <th>爱好</th>
              <td>${user.hobbys}</td>
          </tr>
          <tr>
              <th>手机号码</th>
              <td>${user.phone}</td>
          </tr>
          <tr>
              <th>电子邮箱</th>
              <td>${user.email}</td>
          </tr>
          <tr>
              <th>地址</th>
              <td>${user.addrs}</td>
          </tr>
          <tr>
              <th>状态值</th>
              <td>${user.flag}</td>
          </tr>




      </table>
</body>
</html>
