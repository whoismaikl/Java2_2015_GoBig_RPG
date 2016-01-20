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
        <header><h3 class="tabs_involved">Task Statistic Chart</h3></header>
        <div class="tab_container">
          <div id="tab1" class="tab_content">
            <img src="includes/LineChart.jpeg" width="920" height="480" alt="" />
          </div>
        </div>
      </article><!-- end of messages article -->
      <article class="module width_full">
        <header><h3 class="tabs_involved">Task Statistic Scores</h3></header>
        </header>
        <div class="tab_container">
          <div id="tab3" class="tab_content">

            <form action="/java2/editHistory" method="post">
              <table class="tablesorter" cellspacing="0">
                <thead>
                <tr>
                  <th>Category</th>
                  <th>Today</th>
                  <th>Daily Average</th>
                  <th>Total</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                  <th>Health</th>
                  <th>${user.health}</th>
                  <th>6</th>
                  <th>${user.health}</th>
                </tr>
                <tr>
                  <th>Intelligence</th>
                  <th>${user.intelligence}</th>
                  <th>5</th>
                  <th>${user.intelligence}</th>
                </tr>
                <tr>
                  <th>Communication</th>
                  <th>${user.communication}</th>
                  <th>6</th>
                  <th>${user.communication}</th>
                </tr>
                </tbody>
              </table>
            </form>
          </div>
        </div><!-- end of #tab -->
      </article><!-- end of messages article -->
    </section>
  </body>
</html>
