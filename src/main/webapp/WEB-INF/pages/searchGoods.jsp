<%@ page import="com.cl.domain.Goods" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: inymtern
  Date: 2021/4/9
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询结果</title>
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


        .tl1,.tl2,.tl3,.tl4,.tl5{
            font-size: 20px;
            font-weight: bold;
            color: #ff0000;
        }
    </style>
</head>
<body>
        <h1>查询结果</h1>


        <!--查询-->
        <form action="searchGoods" method="get">
            <input type="text" name="searchText" value="${empty sessionScope.searchText?"":sessionScope.searchText}"><input type="submit" value="搜索">
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




    <%
        String errorMsg = (String)request.getAttribute("errorMsg");
        List<Goods> likeGoods = (List<Goods>)request.getAttribute("likeGoods");
        if(errorMsg != null) {
    %>
    <h3>${requestScope.errorMsg}</h3>
    <%} else {
    %>
        <table border="1px" id="goodsTable" width="50%" height="50%">
            <tr>
                <td><label class="tl1">编号</label></td>
                <td><label class="tl2">书名</label></td>
                <td><label class="tl3">价格</label></td>
                <td><label class="tl4">库存</label></td>
                <td><label class="tl5">操作</label></td>
            </tr>
            <%
                for (Goods goods:likeGoods) {
            %>
                    <tr>
                        <td><%=goods.getgId()%></td>
                        <td><%=goods.getgName()%></td>
                        <td><%=goods.getGprice()%></td>
                        <td><%=goods.getCount()%></td>
                        <td><a href="enterShopCarAdd?id=<%=goods.getgId()%>&name=<%=goods.getgName()%>&count=1&price=<%=goods.getGprice()%>"> ${empty sessionScope.sucUser?"":"添加到购物车"}</a></td>
                    </tr>
                <%}%>
        </table>
    <%}%>
</body>
</html>
