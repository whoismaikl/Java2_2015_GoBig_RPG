<%--
  Created by IntelliJ IDEA.
  User: AST
  Date: 2015.11.28.
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    width: 12em;
    text-decoration: none;
    color: white;
    background-color: purple;
    padding: 0.4em 0.6em;
    border-right: 1px solid white;
    font-size: medium;
  }

  a:hover {
    background-color: fuchsia;
  }

  li {
    display: inline;
  }
</style>
<head>
  <div id="menu">
    <ul>
      <li><a href="/java2/activeTasks"> Active tasks </a></li>
      <li><a href="/java2/taskManagement"> Task Management </a></li>
      <li><a href="/java2/taskStatistics"> Task Statistics </a></li>
      <li><a href="/java2/taskHistory.jsp"> Task History </a></li>
      <li><a href="/java2/help.jsp">Help</a></li>
      <li><a href="#"></a></li>
      <li><a href="/java2/logout">Logout</a></li>
    </ul>


  </div>
  </section><!-- end of secondary bar -->
</head>
