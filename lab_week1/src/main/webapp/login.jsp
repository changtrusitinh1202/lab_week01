<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 23/09/2023
  Time: 10:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 class="center">Đăng nhập</h1>
<form method="post" action="Controll"  class="register-form">
    <label>Tên đăng nhập</label>
    <input type="text" name="username"> <br>
    <label>Mật khẩu</label>
    <input type="password" name="password"> <br>
    <button type="submit">Đăng nhập</button>
</form>
</body>
<script src="">
    const username = document.getElementsByName("username")[0].value;
    const password = document.getElementsByName("password")[0].value;
    localStorage.setItem("username", username);
    localStorage.setItem("password",password);
    window.location.href = "result.jsp";
</script>
</html>
