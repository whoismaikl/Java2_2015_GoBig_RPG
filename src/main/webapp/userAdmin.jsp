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
    <title>User Admin Panel</title>
    <link rel="stylesheet" href="css/layout.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="css/gobig.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="css/ie.css" type="text/css" media="screen"/>
  </head>
  <%@ include file="includes/header.jsp" %>
  <%@ include file="includes/menu.jsp" %>
  <body>
    <section id="main" class="column">
      <article class="module width_full">
        <header><h3 class="tabs_involved">User List</h3>
        </header>
        <div class="tab_container">
          <div id="tab1" class="tab_content" -->
            <html>
            <jsp:useBean id="user1" class="lv.javaguru.java2.domain.User" scope="session"/>
            <form action="/java2/deleteUser" method="post">
              <table class="tablesorter" cellspacing="0">
                <thead>
                <tr>
                  <th>User_ID</th>
                  <th>email</th>
                  <th>Name</th>
                  <th>Type</th>
                  <th>Health</th>
                  <th>Intell.</th>
                  <th>Commun.</th>
                  <th>Last_Login</th>
                  <th>Date_Registered</th>
                  <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${userList}">
                  <tr>
                    <td>${user.id}</td>
                    <td>${user.email}</td>
                    <td>${user.userName}</td>
                    <td>${user.userType}</td>
                    <td>${user.health}</td>
                    <td>${user.intelligence}</td>
                    <td>${user.communication}</td>
                    <td>${user.lastLogin}</td>
                    <td>${user.dateRegistered}</td>
                    <td><input type="submit" name="delete${user.id}" class="login login-submit" value="Delete"></td>
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
        <header><h3 class="tabs_involved">Add New User</h3>
        </header>
        <div class="tab_container">
          <div id="tab4" class="tab_content">
            <form action="/java2/createUser" method="post">
              <table class="tablesorter" cellspacing="0">
                <thead>
                <tr>
                  <th>Username</th>
                  <th>email</th>
                  <th>Password</th>
                  <th>Repeat Password</th>
                  <th>User Type</th>
                  <th>Add New User</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                  <th><input type="text" name="username" placeholder="Username"></th>
                  <th><input type="text" name="email" placeholder="email"></th>
                  <th><input type="password" name="password1" placeholder="Password"></th>
                  <th><input type="password" name="password2" placeholder="Repeat Password"></th>
                  <th><select name="userType" value="User" style="width:92%;">
                    <option>User</option>
                    <option>Admin</option>
                  </select></th>
                  <th><input type="submit" name="login" class="login login-submit" value="Add New User"></th>
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
