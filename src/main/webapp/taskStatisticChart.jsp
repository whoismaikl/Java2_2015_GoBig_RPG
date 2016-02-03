<%--
  Created by IntelliJ IDEA.
  User: AST
  Date: 2015.11.04.
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">

  <head>
    <meta email="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <meta charset="utf-8"/>
    <title>Active Task Panel</title>
    <link rel="stylesheet" href="css/layout.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="css/gobig.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="css/ie.css" type="text/css" media="screen"/>

    <link rel="stylesheet" href="calendarview/stylesheets/calendarview.css" type="text/css" media="screen">
    <style>
      body {
        font-family: Trebuchet MS;
      }
      div.calendar {
        max-width: 240px;
        margin-left: auto;
        margin-right: auto;
      }
      div.calendar table {
        width: 100%;
      }
      div.dateField {
        width: 300px;
        padding: 6px;
        -webkit-border-radius: 6px;
        -moz-border-radius: 6px;
        color: #555;
        background-color: white;
        margin-left: auto;
        margin-right: auto;
        text-align: center;
      }
      div#popupDateField:hover {
        background-color: #cde;
        cursor: pointer;
      }
    </style>

    <script type="text/javascript" src="calendarview/javascripts/prototype.js"></script>
    <script type="text/javascript" src="calendarview/javascripts/calendarview.js"></script>
    <script>
      function setupCalendars() {

        // Popup Calendar
        Calendar.setup(
                {
                  dateField: 'startDate',
                  triggerElement: 'popupDateField2'
                }
        )
        Calendar.setup(
                {
                  dateField: 'stopDate',
                  triggerElement: 'popupDateField3'
                }
        )
      }

      Event.observe(window, 'load', function() { setupCalendars() })
    </script>
  </head>
  <%@ include file="includes/header.jsp" %>
  <%@ include file="includes/menu.jsp" %>
  <body>
    <section id="main" class="column">
      <article class="module width_full">
        <header><h3 class="tabs_involved">History Record Filter</h3>
        </header>
        <div class="tab_container">
          <div id="tab5" class="tab_content">
            <html>
            <jsp:useBean id="record2" class="lv.javaguru.java2.domain.HistoryRecord" scope="session"/>
            <form action="/java2/statisticCharFilter" method="post">
              <table class="tablesorter" cellspacing="0">
                <tr>
                  <td width="100">Select time range.</td>
                  <th width="60">Start Date:</th>
                  <td width="80">
                    <div>
                      <div id="popupDateField2">
                        <input type="date" name="startDate" id="startDate"
                               value="<fmt:formatDate value='${startDate}' pattern='yyyy-MM-dd'/>">
                        <!--input type="button" id="calendarButton" value="Set Date"-->
                      </div>
                    </div>
                  </td>
                  <th width="60">Stop Date:</th>
                  <td width="80">
                    <div>
                      <div id="popupDateField3">
                        <input type="date" name="stopDate" id="stopDate"
                               value="<fmt:formatDate value='${stopDate}' pattern='yyyy-MM-dd'/>">
                        <!--input type="button" id="calendarButton" value="Set Date"-->
                      </div>
                    </div>
                  </td>
                  <td width="50"><input type="submit" name="select" class="login login-submit" value="Filter"></td>
                </tr>
              </table>
            </form>
          </div>
          <!-- end of #tab1 -->
        </div>
        <!-- end of #tab -->
      </article>
      <article class="module width_full">
        <header><h3 class="tabs_involved">Task Statistic Chart</h3></header>
          <div class="tab_container">
            <div id="tab1" class="tab_content">
              <img src="/java2/getTaskStatisticChart" width="920" height="480" alt="" />
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
                  <td>Today</td>
                  <td>Daily Average</td>
                  <td>Total</td>
                </tr>
                </thead>
                <tbody>
                <tr>
                  <th>Health</th>
                  <td>${scoresToday[0]}</td>
                  <td><fmt:formatNumber type="number" maxFractionDigits="2" value="${scoresAverage[0]}" /></td>
                  <td>${user.health}</td>
                </tr>
                <tr>
                  <th>Intelligence</th>
                  <td>${scoresToday[1]}</td>
                  <td><fmt:formatNumber type="number" maxFractionDigits="2" value="${scoresAverage[1]}" /></td>
                  <td>${user.intelligence}</td>
                </tr>
                <tr>
                  <th>Communication</th>
                  <td>${scoresToday[2]}</td>
                  <td><fmt:formatNumber type="number" maxFractionDigits="2" value="${scoresAverage[2]}" /></td>
                  <td>${user.communication}</td>
                </tr>
                <tr>
                  <th>Will Power</th>
                  <td></td>
                  <td></td>
                  <td>${user.willPower}</td>
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
