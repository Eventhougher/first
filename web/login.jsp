<%--
  Created by IntelliJ IDEA.
  User: 吴月波
  Date: 2019/8/12
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <style>
        .login_box{
            margin: auto;
            width: 500px;
            height: 300px;
            border: 1px solid black;
            margin-top: 150px;
        }
        .login_top{
            text-align: center;
            margin-bottom: 50px;
        }
        .login_height{
            height: 50px;
            margin-left: 20px;
        }
        .login_kuang{
            padding: 8px;
            width: 80%;
        }


    </style>

</head>
<body>
    <div class="login_box" >
        <form action="/login" method="post">
            <h1 class="login_top">账户登录</h1>
            <div class="login_height">
                账户:<input type="text" name="username" class="login_kuang" />
            </div>
            <div class="login_height">
                密码:<input type="password" name="password" class="login_kuang" />
            </div>
            <div class="login_height">
                <button type="submit">登录</button>
                <a href="index1.jsp">返回</a>
               <%-- <input type="button" onclick="history.back()" value=" 返回"/>--%>
            </div>


        </form>
    </div>


</body>
</html>
