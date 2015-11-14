<%--
  Created by IntelliJ IDEA.
  User: AST
  Date: 2015.11.13.
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="/java2/main" method="post">
    <fieldset>
        <label>Task Description</label>
        <input type="text" name="statDescription" placeholder="Description" value="Description">
    </fieldset>
    <fieldset> <!-- to make two field float next to one another, adjust values accordingly -->
      <label>Category</label>
        <select name="statType" value="Health" style="width:92%;">
          <option>Health</option>
          <option>Intelligence</option>
          <option>Communication</option>
        </select>
      </fieldset>
      <fieldset>
        <label>Task Scores</label>
        <input type="number" name="statValue" placeholder="1" value="0">
      </fieldset>
      <fieldset>
          <input type="submit" name="newTask" class="login login-submit" value="Add New Task">
      </fieldset>
  </form>
</body>
</html>
