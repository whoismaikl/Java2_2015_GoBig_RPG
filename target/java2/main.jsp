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

  <article class="module width_full">
    <header><h3 class="tabs_involved">Manage Tasks</h3>
    </header>

    <div class="tab_container">
      <div id="tab1" class="tab_content"-->
        <jsp:include page="tasks_List.jsp" />
      </div><!-- end of #tab1 -->
    </div><!-- end of #tab -->
  </article><!-- end of messages article -->

  <article class="module width_full">
    <header><h3 class="tabs_involved">New Tasks</h3>
    </header>

    <div class="tab_container">
      <div id="tab3" class="tab_content"-->
        <jsp:include page="tasks_New.jsp" />
      </div><!-- end of #tab1 -->
    </div><!-- end of #tab -->
  </article><!-- end of messages article -->

  <%--
    <article class="module width_3_quarter">
      <header><h3>New Task</h3></header>
      <div class="module_content">
        <table class="tablesorter" cellspacing="0">
            <fieldset>
                <jsp:include page="tasks_New.jsp" />
            </fieldset>
        </table>
      </div>
      <footer>
        <div class="submit_link">
      </footer>
    </article><!-- end of post new article -->
    --%>
</section>


</body>

</html>
