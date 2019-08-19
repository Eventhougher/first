
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加</title>
    <style>
        .insert-table{
            margin: auto;

        }

    </style>

</head>
<body>
<form action="operate?opr=insert" method="post" enctype="multipart/form-data">
    <%--<input type="hidden" name="opr" value="insert" />--%>
    <table border="1" id="table" class="insert-table" >
        <caption><h2>增加表</h2></caption>
        <%--<tr>
            <th>id</th>
            <td>
                <input type="text"  placeholder="id" name="id" />
            </td>
        <tr/>--%>
        <tr>
            <th>商品名字</th>
            <td>
                <input type="text"  placeholder="商品名字"  name="goodsInfoName"/>
            </td>
        </tr>
        <tr>
            <th>商品图片</th>
            <td>
                上传图片<input type="file"  name="goodsInfoPic"/>

            </td>
        </tr>
        <tr>
            <th>商品价格</th>
            <td>
                <input type="text" placeholder="商品价格" name="goodsInfoPrice" />
            </td>
        </tr>
        <tr>
            <th>商品简介</th>
            <td>
                <input type="text" placeholder="商品简介" name="goodsInfoDescription" />
            </td>
        </tr>
        <tr>
            <th>商品库存</th>
            <td>
                <input type="text" placeholder="商品库存" name="goodsStock" />
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
                <input type="text" placeholder="创建人" name="created" />
            </td>
        </tr>
        <%--<tr>
            <th>创建时间</th>
            <td>
                <input type="text" placeholder="创建时间" name="createdDate" />
            </td>
        </tr>--%>
        <tr>
            <td>
                <input type="submit" value="保存"   />
            </td>
            <td>
                <input type="button" value="返回" onclick="history.back()" />
            </td>
        </tr>




    </table>
</form>

</body>
</html>
