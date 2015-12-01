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
  <jsp:useBean id="userTask" class="lv.javaguru.java2.domain.Task" scope="session"/>
  <article class="module width_full">
    <header><h3 class="tabs_involved">Edit Task</h3>
    </header>
    <div class="tab_container">
      <div id="tab4" class="tab_content">
        <form action="/java2/taskEdit" method="post">
          <table class="tablesorter" cellspacing="0">
            <thead>
            <tr>
              <th>Task Description</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <th>
                <input type="text" name="statDescription" placeholder="${userTask.statDescription}" value="${userTask.statDescription}" maxlength="255"
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
              <th><select name="statType" value="${userTask.statType}" style="width:92%;">
                <option>Health</option>
                <option>Intelligence</option>
                <option>Communication</option>
              </select></th>
              <th><input type="number" name="statValue" placeholder="${userTask.statValue}" value="${userTask.statValue}"></th>
              <th><select name="repeatableYN" value="${userTask.repeatableYN}" style="width:92%;">
                <option>Yes</option>
                <option>No</option>
              </select></th>
              <th><input type="number" name="repeatFrequencyDays" placeholder="${userTask.repeatFrequencyDays}" value="${userTask.repeatFrequencyDays}"></th>
              <th><input type="submit" name="save__" class="login login-submit" value="Save"></th>
            </tr>
            <tr>
              <th><input type="submit" name="cancel" class="login login-submit" value="Cancel"></th>
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
