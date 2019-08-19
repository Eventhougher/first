<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品详情</title>
    <style>
        .goods-table {
            margin: auto;
            width: 300px;
            height: 350px;
        }

        .goods-button {
            margin-left: 45%;
        }
    </style>
</head>
<body>

<table border="1" class="goods-table">
    <caption><h3>商品详情表</h3></caption>
    <tr>
        <th>id</th>
        <td>${goods.id}</td>
    <tr/>
    <tr>
        <th>商品名字</th>
        <td>${goods.goodsInfoName}</td>
    </tr>
    <tr>
        <th>商品图片</th>
        <td>
            <img src="/upload/${goods.goodsInfoPic}" width="50px" height="50px"/>
        </td>
    </tr>
    <tr>
        <th>商品价格</th>
        <td>${goods.goodsInfoPrice}</td>
    </tr>
    <tr>
        <th>商品简介</th>
        <td>${goods.goodsInfoDescription}</td>
    </tr>
    <tr>
        <th>商品库存</th>
        <td>${goods.goodsStock}</td>
    </tr>
    <tr>
        <th>状态值</th>
        <td>
            <c:if test="${goods.flag==1}">激活</c:if>
            <c:if test="${goods.flag==0}">禁止</c:if>
        </td>
    </tr>
    <tr>
        <th>创建人</th>
        <td>${goods.created}</td>
    </tr>
    <tr>
        <th>创建时间</th>
        <td>${goods.createdDate}</td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="button" value="返回" onclick="history.back()" class="goods-button"/>
        </td>
    </tr>


</table>
</body>
</html>
