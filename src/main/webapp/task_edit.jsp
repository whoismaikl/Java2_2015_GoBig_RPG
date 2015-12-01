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
<%@ include file="includes/Menu.jsp" %>
<body>
<section id="main" class="column">
  <jsp:useBean id="task" class="lv.javaguru.java2.domain.Task" scope="session"/>
  <article class="module width_full">
    <header><h3 class="tabs_involved">Edit Task</h3>
    </header>
    <div class="tab_container">
      <div id="tab4" class="tab_content">
        <form action="/java2/task_edit" method="post">
          <table class="tablesorter" cellspacing="0">
            <thead>
            <tr>
              <th>Task Description</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <th>
                <input type="text" name="statDescription" placeholder="${taskForEdit.statDescription}" value="${taskForEdit.statDescription}" maxlength="255"
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
              <th><select name="statType" style="width:92%;">
                <option ${taskForEdit.statType.equals("Health") ? 'selected':''}>Health</option>
                <option ${taskForEdit.statType.equals("Intelligence") ? 'selected':''}>Intelligence</option>
                <option ${taskForEdit.statType.equals("Communication") ? 'selected':''}>Communication</option>
              </select></th>
              <th><input type="number" name="statValue" placeholder="${taskForEdit.statValue}" value="${taskForEdit.statValue}"></th>
              <th><select name="repeatableYN" style="width:92%;">
                <option ${taskForEdit.repeatableYN.equals("Yes") ? 'selected':''}>Yes</option>
                <option ${taskForEdit.repeatableYN.equals("No") ? 'selected':''}>No</option>
              </select></th>
              <th><input type="number" name="repeatFrequencyDays" placeholder="${taskForEdit.repeatFrequencyDays}" value="${taskForEdit.repeatFrequencyDays}"></th>
              <th><input type="submit" name="save__" class="login login-submit" value="Save"></th>
            </tr>
            </tbody>
          </table>
        </form>
      </div>
      <!-- end of #tab1 -->
    </div>
    <!-- end of #tab -->
    <div class="tab_container">
      <div id="tab5" class="tab_content">
        <form action="/java2/task_management.jsp" method="post">

          <table class="tablesorter" cellspacing="0">
            <thead>
            <tr>
              <th>Action</th>
            </tr>
            </thead>
            <tbody>
              <tr>
                <th><input type="submit" name="cancel" class="login login-submit" value="Cancel"></th>
              </tr>
            </tbody>
          </table>
        </form>
      </div>
      <!-- end of #tab1 -->
    </div>
  </article>
  <!-- end of messages article -->

</section>


</body>

</html>
