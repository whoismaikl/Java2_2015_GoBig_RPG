<%--
  Created by IntelliJ IDEA.
  User: mike
  Date: 2016.01.26.
  Time: 23:37
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html >
  <head>
    <meta charset="UTF-8">
    <title>Send Password</title>
    <link rel='stylesheet prefetch' href='css/jquery-ui.css'>
    <link rel="stylesheet" href="css/style.css">
  </head>
  <body>
  <div class="login-card">
    <h1>Register</h1><br>
    <form action="/java2/retreivePassword" method="post">

      <input type="text" name="email" placeholder="email">

      <input type="submit" name="Send Password" class="login login-submit" value="retreivePassword">
    </form>
    <div class="login-help">
      <a href="/java2/index.jsp">Back</a>
    </div>
    <div class="login-help">
      <br><h1><%= request.getAttribute("model")%></h1>
    </div>
  </div>
  </body>
</html>
