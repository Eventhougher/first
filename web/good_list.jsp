
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品信息表</title>
    <script type="text/javascript">
        function onDelete1(id) {
            if(confirm('确定删除吗')){
                location.href="good?opr=delete&id="+id;
            }
        }
    </script>
    <style>
        .good-table{
            margin: auto;
            width: 500px;
        }
        .good-add{
            margin-left: 45%;
            font-size: 20px;
        }

    </style>
</head>
<body>
   <form>
       <table border="1" class="good-table">
           <caption><h1>商品信息表</h1></caption>
          <tr>
              <th>id</th>
              <th>商品名字</th>
              <th>商品图片</th>
              <th>商品价格</th>
              <th>操作</th>
          </tr>

           <c:if test="${list!=null}">
               <c:forEach items="${list}" var="good" varStatus="g">
                   <tr>
                       <td>${good.id}</td>
                       <td>${good.goodsInfoName}</td>
                       <td><img src="/upload/${good.goodsInfoPic}"  width="50px" height="50px"/></td>
                       <td>${good.goodsInfoPrice}</td>

                       <td>
                           <a href="operate?opr=update1&id=${good.id}">修改</a>

                           <a href="operate?opr=delete&id=${good.id}" onclick="return confirm('确认删除吗')">删除</a>
                           <a href="operate?opr=view&id=${good.id}">详情</a>
                       </td>
                   </tr>

               </c:forEach>

           </c:if>
           <tr >
               <td colspan="5" >
                   <a href="goods_insert.jsp" class="good-add">增加</a>
               </td>
           </tr>
       </table>


   </form>
</body>
</html>
