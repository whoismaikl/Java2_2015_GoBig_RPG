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
    <header><h3 class="tabs_involved">Accomplish Tasks</h3>
    </header>
    <div class="tab_container">
      <div id="tab1" class="tab_content"-->
        <html>
        <jsp:useBean id="task" class="lv.javaguru.java2.domain.Task" scope="session"/>

        <form action="/java2/accomplish_task" method="post">
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

            <c:forEach var="task" items="${taskList}">

              <tr>

                <td>${task.statDescription}</td>
                <td>${task.statType}</td>
                <td>${task.statValue}</td>
                <td>
                  <input type="submit" value="Yes" name="yes" +${task.id}" class="alt_btn">
                </td>
              </tr>

            </c:forEach>

            </tbody>
          </table>
        </form>
      </div><!-- end of #tab1 -->
    </div><!-- end of #tab -->
  </article><!-- end of messages article -->

</section>


</body>

</html>
