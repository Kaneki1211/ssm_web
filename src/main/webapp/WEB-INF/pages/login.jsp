<%--
  Created by IntelliJ IDEA.
  User: inymtern
  Date: 2021/4/8
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <style>
        .errorMsg{
            color: red;
        }
    </style>
</head>
<body>
    <h2>${empty requestScope.sucRegister?"":requestScope.sucRegister}</h2>
    <h1>用户登录</h1>
    <span class="errorMsg" id="errorMsg">${empty requestScope.errorMsg?"":requestScope.errorMsg}</span>
    <form action="login" method="get">
        <label>用户名称:</label><input type="text" name="username"
                                   value="${empty requestScope.errorUser?"":requestScope.errorUser.username}"><br>
        <label>用户密码:</label><input type="password" name="password"
                                   value="${empty requestScope.errorUser?"":requestScope.errorUser.password}"><br>
        <input type="submit" value="登录">

    </form>
    <a href="back">返回主页</a><br>
    <a href="enterRegister">注册账号</a>
</body>
</html>
