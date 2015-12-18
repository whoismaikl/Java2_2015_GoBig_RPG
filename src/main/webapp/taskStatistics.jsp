<%--
  Created by IntelliJ IDEA.
  User: AST
  Date: 2015.11.04.
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <header><h3>Task Statistic</h3></header>
    <div class="module_content">
      <article class="stats_graph">
        <img src="includes/LineChart.jpeg" width="640" height="480" alt="" />
      </article>
      <article class="stats_overview">
        <div class="overview_previous">
          <p class="overview_day">Today</p>
          <p class="overview_count">5</p>
          <p class="overview_type">Scores</p>
        </div>
        <div class="overview_previous">
          <p class="overview_day">Daily Average</p>
          <p class="overview_count">6</p>
          <p class="overview_type">Scores</p>
        </div>
        <div class="overview_previous">
          <p class="overview_day">Total</p>
          <p class="overview_count">53</p>
          <p class="overview_type">Scores</p>
        </div>
      </article>
      <div class="clear"></div>
    </div>
  </article><!-- end of stats article -->
</section>


</body>

</html>
