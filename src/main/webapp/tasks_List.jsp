<%--
  Created by IntelliJ IDEA.
  User: AST
  Date: 2015.11.13.
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<jsp:useBean id="userTask" class="lv.javaguru.java2.domain.UserTask" scope="session"/>
<head>
    <title></title>
</head>
<body>
<form action="/java2/task" method="post">
<table class="tablesorter" cellspacing="0">
  <thead>
  <tr>
    <th>Delete</th>
    <th>Task Description</th>
    <th>Category</th>
    <th>Value</th>
    <th>Is Task Accomplished ?</th>
  </tr>
  </thead>
  <tbody>

  <c:forEach var="userTask" items="${userTasks}">

  <tr>
    <td><input type="submit" name="${userTask.id}" class="login login-submit" value="Delete"></td>
    <td>${userTask.statDescription}</td>
    <td>${userTask.statType}</td>
    <td>${userTask.statValue}</td>
    <td>
      <input type="submit" value="Yes" name="yes" +${userTask.id}" class="alt_btn">
      <input type="submit" value="No" name="no" +${userTask.id}"class="alt_btn">
    </td>
  </tr>

</c:forEach>

</tbody>
</table>
  </form>
</body>
</html>
