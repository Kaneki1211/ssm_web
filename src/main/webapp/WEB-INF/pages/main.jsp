<%@ page import="com.cl.domain.Goods" %>
<%@ page import="java.util.List" %>
<%@ page import="com.cl.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: inymtern
  Date: 2021/4/8
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script src="https://unpkg.com/vue/dist/vue.js"></script>
    <!-- import JavaScript -->
    <script src="https://unpkg.com/element-ui/lib/index.js"></script>

    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
    <style>
        .l1{
            color: #559ea0;
        }
        .l2{
            font-size: 30px;
            color: red;
        }
        .l3{
            color: #559ea0;
        }
        .goodsTable{
            width: 50%;
            height: 50%;
            border: #559ea0;
        }
        .tl1,.tl2,.tl3,.tl4,.tl5{
            font-size: 20px;
            font-weight: bold;
            color: #ff0000;
        }
    </style>
</head>
<body>
    <h1>某宝商城</h1>


    <!--查询-->
    <form action="searchGoods" method="get">
        <input type="text" name="searchText"><input type="submit" value="搜索">
    </form>


    <!--用户-->
    <%
        if(request.getSession().getAttribute("sucUser") == null) {
    %>
        <a href="enterLogin" target="_blank">登录</a>&nbsp;&nbsp;&nbsp;<a href="enterRegister" target="_blank">注册</a>

    <%} else {%>
        <label class="l1">用户:</label>
        <label class="l2">${sessionScope.sucUser.username}</label>
        <label class="l3">已登录</label>
        &nbsp;&nbsp;
        <a href="quit">注销</a>
        <a href="enterShopCar">我的购物车</a>
    <%}%><br><br>





    <table class="goodsTable" border="1px">
        <tr>
            <td><label class="tl1">编号</label></td>
            <td><label class="tl2">书名</label></td>
            <td><label class="tl3">价格</label></td>
            <td><label class="tl4">库存</label></td>
            <td><label class="tl5">操作</label></td>
        </tr>
        <%
            List<Goods> goods = (List<Goods>)session.getAttribute("goods");
            User sucUser = (User)session.getAttribute("sucUser");

            if(goods!=null) {
                for (Goods good:goods) {

        %>
        <tr>
            <td><%=good.getgId()%></td>
            <td><%=good.getgName()%></td>
            <td><%=good.getGprice()%></td>
            <td><%=good.getCount()%></td>
            <td><a href="enterShopCarAdd?id=<%=good.getgId()%>&name=<%=good.getgName()%>&count=1&price=<%=good.getGprice()%>"> ${empty sessionScope.sucUser?"":"添加到购物车"}</a></td>
        </tr>
        <%}}%>
    </table>



</body>
</html>
