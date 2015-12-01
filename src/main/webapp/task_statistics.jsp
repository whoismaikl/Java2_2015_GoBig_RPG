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
<%@ include file="dir/header.jsp" %>
<%@ include file="dir/menu.jsp" %>
<body>

<section id="main" class="column">

  <article class="module width_full">
    <header><h3>Task Statistics</h3></header>
    <div class="module_content">
      <article class="stats_graph">
        <img src="http://chart.apis.google.com/chart?chxr=0,0,3000&chxt=y&chs=520x140&cht=lc&chco=76A4FB,80C65A&chd=s:Tdjpsvyvttmiihgmnrst,OTbdcfhhggcTUTTUadfk&chls=2|2&chma=40,20,20,30" width="520" height="140" alt="" />
      </article>

      <article class="stats_overview">
        <div class="overview_today">
          <p class="overview_day">Today</p>
          <p class="overview_count">6</p>
          <p class="overview_type">Scores</p>
        </div>
        <div class="overview_previous">
          <p class="overview_day">Average</p>
          <p class="overview_count">5</p>
          <p class="overview_type">Scores</p>
        </div>
      </article>
      <div class="clear"></div>
    </div>
  </article><!-- end of stats article -->
</section>


</body>

</html>
