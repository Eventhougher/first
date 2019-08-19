
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <style>
        .login_box {
            margin: auto;
            width: 500px;

            border: 1px solid black;
            margin-top: 150px;
        }

        .login_top {
            text-align: center;
            margin-bottom: 50px;
        }

        .login_height {
            height: 50px;
            margin-left: 20px;
        }

        .login_kuang {
            padding: 8px;
            width: 80%;
        }


    </style>
</head>
<body>
<div class="login_box">
    <form action="/register" method="post">
        <table border="1">
            <caption><h1 class="login_top">账户注册</h1></caption>

            <tr class="login_height">
                <th>账户</th>
                <td>
                    <input type="text" class="login_kuang" name="username"/>
                </td>
            </tr>
            <tr class="login_height">
                <th>密码</th>
                <td>
                    <input type="password" class="login_kuang" name="password"/>
                </td>
            </tr>
            <tr class="login_height">
                <th>性别</th>
                <td>
                    <select name="sex">
                        <option name="sex">男</option>
                        <option name="sex">女</option>
                    </select>
                </td>
            </tr>
            <tr class="login_height">
                <th>爱好</th>
                <td>
                    <input type="text" class="login_kuang" name="hobbys"/>
                </td>
            </tr>
            <tr class="login_height">
                <th>电话</th>
                <td>
                    <input type="text" class="login_kuang" name="phone"/>
                </td>
            </tr>
            <tr class="login_height">
                <th>邮箱</th>
                <td>
                    <input type="text" class="login_kuang" name="email"/>
                </td>
            </tr>
            <tr class="login_height">
                <th>地址</th>
                <td>
                    <input type="text" class="login_kuang" name="addrs"/>
                </td>
            </tr>
            
            <tr class="login_height">
                <th>状态</th>
                <td>
                    <input type="text" class="login_kuang" name="flag"/>
                </td>
            </tr>


            <div class="login_height">
                <button type="submit">注册</button>
                <a href="index1.jsp">返回</a>
                <%--<input type="button" onclick="history.back()" value=" 返回"/>--%>
            </div>

        </table>
    </form>
</div>
</body>
</html>
