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
    <title>Active Task Panel</title>
    <link rel="stylesheet" href="css/layout.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="css/gobig.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="css/ie.css" type="text/css" media="screen"/>

  </head>
  <%@ include file="includes/header.jsp" %>
  <%@ include file="includes/menu.jsp" %>
  <body>
    <section id="main" class="column">
      <article class="module width_full">
        <div class="tab_container">
          <div id="tab11" class="tab_content">
            <img src="java2/includes/BarChart.jpeg" width="920" height="100" alt="" />
          </div><!-- end of #tab1 -->
        </div><!-- end of #tab -->
      </article><!-- end of messages article -->
      <article class="module width_full">
        <header><h3 class="tabs_involved">Daily To Do Task List</h3>
        </header>
        <div class="tab_container">
          <div id="tab1" class="tab_content">
            <form action="/java2/accomplishTask" method="post">
              <table class="tablesorter" cellspacing="0">
                <thead>
                <tr>
                  <th>Task Description</th>
                  <th>Category</th>
                  <th>Value</th>
                  <th>Is Task Accomplished ?</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="activeTask" items="${activeTaskList}">
                  <tr>
                    <td>${activeTask.statDescription}</td>
                    <td>${activeTask.statType}</td>
                    <td>${activeTask.statValue}</td>
                    <td>
                      <input type="submit" value="Yes" name="accomp${activeTask.id}" class="alt_btn">
                    </td>
                  </tr>
                </c:forEach>
                </tbody>
              </table>
            </form>
          </div><!-- end of #tab1 -->
        </div><!-- end of #tab -->
      </article><!-- end of messages article -->
      <article class="module width_full">
        <header><h3 class="tabs_involved">Accomplished Task List</h3>
        </header>
        <div class="tab_container">
          <div id="tab2" class="tab_content">
            <form action="/java2/undoTask" method="post">
              <table class="tablesorter" cellspacing="0">
                <thead>
                <tr>
                  <th>Task Description</th>
                  <th>Category</th>
                  <th>Value</th>
                  <th>Date Accomplished</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="accomplishedTask" items="${accomplishedTaskList}">
                  <tr>
                    <td>${accomplishedTask.statDescription}</td>
                    <td>${accomplishedTask.statType}</td>
                    <td>${accomplishedTask.statValue}</td>
                    <td>${accomplishedTask.dateAccomplished}</td>
                    <td>
                      <input type="submit" value="Undo" name="accomp${accomplishedTask.id}" class="alt_btn">
                    </td>
                  </tr>
                </c:forEach>
                <img src="/webapp/includes/BarChart.jpeg" width="920" height="100" alt="" />
                </tbody>
              </table>
            </form>
          </div><!-- end of #tab1 -->
        </div><!-- end of #tab -->
      </article><!-- end of messages article -->
    </section>
  </body>
</html>
