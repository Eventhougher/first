
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改</title>
    <style>
        .update-table{
            margin: auto;
            height: 200px;
            width: 280px;
        }
    </style>

</head>
<body>
<form action="operate?opr=update" method="post" enctype="multipart/form-data" >
    <%--<input type="hidden" name="opr" value="update" />--%>
    <table border="1" class="update-table">
        <caption><h2>修改表格</h2></caption>
        <tr>
            <th>id</th>
            <td>
                <input type="text" value="${goods.id}"  name="id" />
            </td>
        <tr/>
        <tr>
            <th>商品名字</th>
            <td>
                <input type="text" value="${goods.goodsInfoName}" name="goodsInfoName" />
            </td>
        </tr>
        <tr>
            <th>商品图片</th>
            <td>
                <img src="/upload/${goods.goodsInfoPic}" width="50px" height="50px">
                上传图片<input type="file"  name="goodsInfoPic" />

            </td>
        </tr>
        <tr>
            <th>商品价格</th>
            <td>
                <input type="text" value="${goods.goodsInfoPrice}" name="goodsInfoPrice" />
            </td>
        </tr>
        <tr>
            <th>商品简介</th>
            <td>
                <input type="text" value="${goods.goodsInfoDescription}" name="goodsInfoDescription" />
            </td>
        </tr>
        <tr>
            <th>商品库存</th>
            <td>
                <input type="text" value="${goods.goodsStock}" name="goodsStock" />
            </td>
        </tr>
        <tr>
            <th>状态值</th>
            <td>
                激活<input type="radio" value="激活" name="flag" checked />
                禁止<input type="radio" value="禁止" name="flag" />
            </td>
        </tr>
        <tr>
            <th>创建人</th>
            <td>
                <input type="text" value="${goods.created}" name="created" />
            </td>
        </tr>
        <tr>
            <th>创建时间</th>
            <td>
                <input type="text" value="${goods.createdDate}" />
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="保存"  />
            </td>
            <td>
                <input type="button" value="返回" onclick="history.back()" />
            </td>
        </tr>




    </table>
</form>

</body>
</html>
