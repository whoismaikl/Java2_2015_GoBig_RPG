<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.DateFormat" %>
<%--
  Created by IntelliJ IDEA.
  User: AST
  Date: 2015.11.28.
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
  <section class="column">
    <div class="tab_container">
      <%DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        String formattedDate = df.format(new Date());%>
      <pre><h4>   Date: <%=formattedDate%>      Welcome to GoBig_RPG  -  ${sessionScope.user.userName}</h4></pre>
    </div>
  </section><!-- end of secondary bar -->
</head>
