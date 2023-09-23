<%@ page import="services.AccountServices" %>
<%@ page import="java.util.List" %>
<%@ page import="models.Account" %>
<%@ page import="services.GrantAccessServices" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 23/09/2023
  Time: 11:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Đăng nhập thành công</h1>
    <%
        AccountServices accountServices = new AccountServices();
        GrantAccessServices grantAccessServices = new GrantAccessServices();
        String email = request.getParameter("username");
        String password = request.getParameter("password");
        Account account = accountServices.checkLogInService(email,password);
        if(!grantAccessServices.searchGrantAccessByAccountIdService(account.getId()).getRole().getId().equals("admin")){
            %>
        <h1>Quyền của bạn là user</h1>
            ID:         <span><%=account.getId()%></span> <br>
            Full name:  <span><%=account.getFullName()%></span> <br>
            Password:   <span><%=account.getEmail()%></span> <br>
            Email:      <span><%=account.getPassword()%></span> <br>
            Phone:      <span><%=account.getPhone()%></span> <br>
            Status:     <span><%=account.getStatus()%></span>
    <%
        }else {
        %>
            <h1>Quyền của bạn là admin</h1>
             <table cellpadding="10" border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Full name</th>
                <th>Password</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Status</th>
            </tr>
        </thead>
        <tbody>
    <%
        List<Account> listAcc = accountServices.getAccountsService();
        for (Account acc: listAcc) {
    %>
    <tr>
        <td><%= acc.getId() %> </td>
        <td><%= acc.getFullName() %></td>
        <td><%= acc.getEmail() %></td>
        <td><%= acc.getPassword() %></td>
        <td><%= acc.getPhone() %></td>
        <td><%= acc.getStatus() %></td>
    </tr>
    <%
        }
    %>
    </tbody>
    </table>
    <%
        }
    %>

    <script>
        const username = localStorage.getItem("username");
        const password = localStorage.getItem("password");
    </script>
</body>

</html>

