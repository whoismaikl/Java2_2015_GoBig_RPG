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
    <title>Task History Panel</title>
    <link rel="stylesheet" href="css/layout.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="css/gobig.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="css/ie.css" type="text/css" media="screen"/>
  </head>
  <%@ include file="includes/header.jsp" %>
  <%@ include file="includes/menu.jsp" %>
  <body>
    <section id="main" class="column">
      <article class="module width_full">
        <header><h3 class="tabs_involved">Accomplished Task List</h3>
        </header>
        <div class="tab_container">
          <div id="tab1" class="tab_content">
            <html>
            <jsp:useBean id="record" class="lv.javaguru.java2.domain.HistoryRecord" scope="session"/>
            <form action="/java2/deleteHistory" method="post">
              <table class="tablesorter" cellspacing="0">
                <thead>
                <tr>
                  <th>Record ID</th>
                  <th>Health</th>
                  <th>Intell.</th>
                  <th>Commun.</th>
                  <th>Stat Value</th>
                  <th>Date Completed</th>
                  <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="historyRecord" items="${historyRecordList}">
                  <tr>
                    <td>${historyRecord.id}</td>
                    <td>${historyRecord.health}</td>
                    <td>${historyRecord.intelligence}</td>
                    <td>${historyRecord.communication}</td>
                    <td>${historyRecord.statValue}</td>
                    <td>${historyRecord.dateCompleted}</td>
                    <td><input type="submit" name="delete${record.id}" class="login login-submit" value="Delete"></td>
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
        <header><h3 class="tabs_involved">New Record</h3>
        </header>
        <div class="tab_container">
          <div id="tab4" class="tab_content">
            <form action="/java2/createHistory" method="post">
              <table class="tablesorter" cellspacing="0">
                <thead>
                <tr>
                  <th>health</th>
                  <th>intelligence</th>
                  <th>communication</th>
                  <th>statValue</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                  <th><input type="text" name="health" placeholder="1"></th>
                  <th><input type="text" name="intelligence" placeholder="2"></th>
                  <th><input type="text" name="communication" placeholder="3"></th>
                  <th><input type="text" name="statValue" placeholder="6"></th>
                </tr>
                <tr>
                  <th>dateCompleted</th>
                  <th>New History Record</th>
                </tr>
                <tr>
                  <th><input type="text" name="dateCompleted" placeholder="2015-11-17 10:07:46"></th>
                  <th><input type="submit" name="New History" class="login login-submit" value="Add New History"></th>
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
      <article class="module width_full">
        <header><h3 class="tabs_involved">Response</h3>
        </header>
        <div class="tab_container">
          <br><h3><%= request.getAttribute("model")%></h3>
        </div>
        <!-- end of #tab -->
      </article>
    </section>
  </body>
</html>
