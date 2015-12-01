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
  <style>
    ul {
      float: left;
      width: 100%;
      padding: 0;
      margin: 0;
      list-style-type: none;
    }

    a {
      float: left;
      width: 6em;
      text-decoration: none;
      color: white;
      background-color: purple;
      padding: 0.2em 0.6em;
      border-right: 1px solid white;
    }

    a:hover {
      background-color: fuchsia;
    }

    li {
      display: inline;
    }
  </style>

</head>
<%@ include file="includes/header.jsp" %>
<%@ include file="includes/menu.jsp" %>
<body>
<section id="main" class="column">

  <article class="module width_full">
    <header><h3>Help</h3></header>
    <div class="module_content">

      <article>
        <div>
          <p>Instant Gratification</p>
          <p>Whenever you reinforce a positive habit, complete a daily task, or take care of an old to-do,
            API immediately rewards you with experience points.</p>
          <p>Consequences</p>
          <p>Whenever you indulge in a bad habit or fail to complete one of your daily tasks, you lose health.
            If your health drops too low, you lose some of the progress you've made. By providing immediate consequences,
            API can help break bad habits and procrastination cycles before they cause real-world problems.</p>
        </div>
      </article>
      <div class="clear"></div>
    </div>
  </article><!-- end of stats article -->
</section>

</body>

</html>
