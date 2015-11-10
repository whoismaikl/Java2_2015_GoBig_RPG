<%--
  Created by IntelliJ IDEA.
  User: AST
  Date: 2015.10.28.
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html >
<head>


  <meta charset="UTF-8">

  <title>Log-in</title>



  <link rel='stylesheet prefetch' href='css/jquery-ui.css'>

  <link rel="stylesheet" href="css/style.css">




</head>

<body>

<div class="login-card">
  <h1>Log-in</h1><br>
 <!-- <form method="post" action="/index.jsp"> -->
  <form action="/index" method="post">
    <input type="text" name="email" placeholder="email">
    <input type="password" name="password" placeholder="Password">
    <input type="submit" name="login" class="login login-submit" value="login">
  </form>

  <div class="login-help">
    <a href="/java2/register.jsp">Register</a> • <a href="#">Forgot Password</a>
  </div>
    <div class="login-help">
        <br><h1><%= request.getAttribute("model")%></h1>
    </div>
</div>


<script src='js/jquery.min.js'></script>
<script src='js/jquery-ui.min.js'></script>

  <!--skriplet -->
    <%
        int a = 1;
        int b = 3;
        int result = a+b;
    %>
    Result a+b = <font color="red"> <%= result %></font>



</body>
</html>
