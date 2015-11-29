<%--
  Created by IntelliJ IDEA.
  User: AST
  Date: 2015.11.04.
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">

<head>
  <meta email="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

  <meta charset="utf-8"/>
  <title>Dashboard I Admin Panel</title>
  <link rel="stylesheet" href="css/layout.css" type="text/css" media="screen" />
  <link rel="stylesheet" href="css/gobig.css" type="text/css" media="screen" />
  <link rel="stylesheet" href="css/ie.css" type="text/css" media="screen"/>
</head>
<%@ include file="includes/header.jsp" %>
<%@ include file="includes/menu.jsp" %>
<body>

<section id="main" class="column">
  <article class="module width_full">
    <header><h3 class="tabs_involved">Task Management</h3>
    </header>
    <div class="tab_container">
      <div id="tab1" class="tab_content" -->
        <html>
        <jsp:useBean id="userTask" class="lv.javaguru.java2.domain.Task" scope="session"/>
        <form action="/java2/task_management" method="post">
          <table class="tablesorter" cellspacing="0">
            <thead>
            <tr>
              <th></th>
              <th>Task Description</th>
              <th>Category</th>
              <th>Value</th>
              <th>Repeatable</th>
              <th>Repeat(Days)</th>
              <th>Edit</th>
              <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="userTask" items="${userTasks}">
              <tr>
                <td></td>
                <td>${userTask.statDescription}</td>
                <td>${userTask.statType}</td>
                <td>${userTask.statValue}</td>
                <td>${userTask.repeatableYN}</td>
                <td>${userTask.repeatFrequencyDays}</td>
                <td><input type="submit" name="edit__+${userTask.id}" class="login login-submit" value="Edit"></td>
                <td><input type="submit" name="delete+${userTask.id}" class="login login-submit" value="Delete"></td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </form>
      </div>
      <!-- end of #tab1 -->
    </div>
    <!-- end of #tab -->
  </article>
  <!-- end of messages article -->


  <article class="module width_full">
    <header><h3 class="tabs_involved">New Tasks</h3>
    </header>

    <div class="tab_container">
      <div id="tab4" class="tab_content">
        <form action="/java2/taskNew" method="post">
          <table class="tablesorter" cellspacing="0">
            <thead>
            <tr>
              <th>Task Description</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <th>
                <input type="text" name="statDescription" placeholder="Description" value="Description" maxlength="255"
                       size="124">
                <!--textarea name="statDescription" style="width:250px;height:150px;" placeholder="Description" value="Description" maxlength="255"></textarea-->
              </th>
            </tr>
            </tbody>
          </table>
          <table class="tablesorter" cellspacing="0">
            <thead>
            <tr>
              <th>Category</th>
              <th>Value</th>
              <th>Repeatable(Yes/No)</th>
              <th>Repeat Frequency(Days)</th>
              <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <th><select name="statType" value="Health" style="width:92%;">
                <option>Health</option>
                <option>Intelligence</option>
                <option>Communication</option>
              </select></th>
              <th><input type="number" name="statValue" placeholder="1" value="1"></th>
              <th><select name="repeatableYN" value="No" style="width:92%;">
                <option>Yes</option>
                <option>No</option>
              </select></th>
              <th><input type="number" name="repeatFrequencyDays" placeholder="1" value="1"></th>
              <th><input type="submit" name="newTask" class="login login-submit" value="Add New Task"></th>
            </tr>
            </tbody>
          </table>
        </form>
      </div>
      <!-- end of #tab1 -->
    </div>
    <!-- end of #tab -->
  </article>
  <!-- end of messages article -->

</section>


</body>

</html>
