<%--
  Created by IntelliJ IDEA.
  User: inymtern
  Date: 2021/4/8
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script>
        $(function () {
            $("#subBtn").click(function () {
                var patt = /^\w{2,12}$/;
                var unametext = $("#unametext").val();
                var upwdtext = $("#upwdtext").val();
                var rupwdtext = $("#rupwdtext").val();
                if(!patt.test(unametext)) {
                    $("#errorMsg").text("用户名必须在2~12字符！");
                    return false;
                }
                if(!patt.test(upwdtext)) {
                    $("#errorMsg").text("密码必须在2~12字符！");
                    return false;
                }
                if(upwdtext !== rupwdtext) {
                    $("#errorMsg").text("确认密码不匹配!");
                    return false;
                }

            });
        });
    </script>
    <style>
        .errorMsg{
            color: red;
        }
    </style>
</head>
<body>
    <h1>用户注册</h1>
    <span id="errorMsg" class="errorMsg">${empty sessionScope.rerrorMsg?"":sessionScope.rerrorMsg}</span>
    <form action="register" method="get">
        <label>用户名称:</label><input type="text" name="username" id="unametext"
                                   value="${empty sessionScope.rerrorUser?"":sessionScope.rerrorUser.username}"><br>
        <label>用户密码:</label><input type="password" name="password" id="upwdtext"
                                    value="${empty sessionScope.rerrorUser?"":sessionScope.rerrorUser.password}"><br>
        <label>确认密码:</label><input type="password"  id="rupwdtext"><br>
        <input type="submit" value="注册" id="subBtn">
    </form>
    <a href="back">返回主页</a><br>
    <a href="enterLogin">登录</a>
</body>
</html>
