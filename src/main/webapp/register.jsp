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
  <title>Register New User</title>



  <link rel='stylesheet prefetch' href='css/jquery-ui.css'>

  <link rel="stylesheet" href="css/style.css">




</head>

<body>

<div class="login-card">
  <h1>Register</h1><br>
  <form action="/register" method="post">
    <input type="text" name="username" placeholder="Username">
    <input type="text" name="email" placeholder="email">
    <input type="password" neme="password" placeholder="Password">
    <input type="password" name="password2" placeholder="Repeat Password">
    <input type="submit" name="login" class="login login-submit" value="register">
  </form>

  <div class="login-help">
    <a href="/java2/index.jsp">Back</a> • <a href="#">Forgot Password</a>
  </div>
</div>

<!-- <div id="error"><img src="https://dl.dropboxusercontent.com/u/23299152/Delete-icon.png" /> Your caps-lock is on.</div> -->
<script src='js/jquery.min.js'></script>
<script src='js/jquery-ui.min.js'></script>





</body>
</html>
