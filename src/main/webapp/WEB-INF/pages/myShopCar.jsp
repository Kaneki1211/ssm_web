<%@ page import="com.cl.domain.ShopCar" %>
<%@ page import="com.cl.domain.Items" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: inymtern
  Date: 2021/4/8
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script>

        $(function () {

        });


    </script>
</head>
<body>
    <h1>我的购物车</h1>
    <table border="1px">
        <tr>
            <td>编号</td>
            <td>书名</td>
            <td>数量</td>
            <td>价格</td>
            <td>操作</td>
        </tr>
        <%
            ShopCar shopCar = (ShopCar)session.getAttribute("shopCar");
            if(!(shopCar == null)) {
                for (Items item:shopCar.getGoodsList()) {

        %>
                <tr>
                <td><%=item.getId()%></td>
                <td><%=item.getName()%></td>
                    <td><a href="reduceCount?id=<%=item.getId()%>&name=<%=item.getName()%>&count=<%=item.getCount()%>&price=<%=item.getPrice()%>">&lt;-</a>
                        <label><%=item.getCount()%></label>
                        <a href="addCount?id=<%=item.getId()%>&name=<%=item.getName()%>&count=<%=item.getCount()%>&price=<%=item.getPrice()%>">-&gt;</a></td>
                <td><%=item.getPrice()%></td>
                <td><a href="del?id=<%=item.getId()%>&name=<%=item.getName()%>&count=<%=item.getCount()%>&price=<%=item.getPrice()%>">移除</a></td>
                </tr>
            <%}}else {%>
                <a href="enterGoods">快去浏览商品吧</a>
            <%}%>

    </table>
    总价:${empty sessionScope.shopCar.price?"0":sessionScope.shopCar.price} 元
    <a href="clear">清空购物车</a>
    <a href="enterGoods">返回主页</a>
</body>
</html>
