/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2016-01-06 18:28:50 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import lv.javaguru.java2.domain.User;

public final class help_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/includes/menu.jsp", Long.valueOf(1452104696682L));
    _jspx_dependants.put("/includes/header.jsp", Long.valueOf(1449088713198L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("  <meta email=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\">\r\n");
      out.write("\r\n");
      out.write("  <meta charset=\"utf-8\"/>\r\n");
      out.write("  <title>Dashboard I Admin Panel</title>\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"css/layout.css\" type=\"text/css\" media=\"screen\" />\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"css/gobig.css\" type=\"text/css\" media=\"screen\" />\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"css/ie.css\" type=\"text/css\" media=\"screen\"/>\r\n");
      out.write("  <style>\r\n");
      out.write("    ul {\r\n");
      out.write("      float: left;\r\n");
      out.write("      width: 100%;\r\n");
      out.write("      padding: 0;\r\n");
      out.write("      margin: 0;\r\n");
      out.write("      list-style-type: none;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    a {\r\n");
      out.write("      float: left;\r\n");
      out.write("      width: 6em;\r\n");
      out.write("      text-decoration: none;\r\n");
      out.write("      color: white;\r\n");
      out.write("      background-color: purple;\r\n");
      out.write("      padding: 0.2em 0.6em;\r\n");
      out.write("      border-right: 1px solid white;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    a:hover {\r\n");
      out.write("      background-color: fuchsia;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    li {\r\n");
      out.write("      display: inline;\r\n");
      out.write("    }\r\n");
      out.write("  </style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("  <section id=\"secondary_bar\">\r\n");
      out.write("    <div class=\"user\">\r\n");
      out.write("      <p> Welcome to GoBig_RPG - ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.user.userName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</p>\r\n");
      out.write("      <!-- <a class=\"logout_user\" href=\"#\" title=\"Logout\">Logout</a> -->\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("  </section><!-- end of secondary bar -->\r\n");
      out.write("</head>\r\n");
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("  ul {\r\n");
      out.write("    float: left;\r\n");
      out.write("    width: 100%;\r\n");
      out.write("    padding: 0;\r\n");
      out.write("    margin: 0;\r\n");
      out.write("    list-style-type: none;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  a {\r\n");
      out.write("    float: left;\r\n");
      out.write("    width: 12em;\r\n");
      out.write("    text-decoration: none;\r\n");
      out.write("    color: white;\r\n");
      out.write("    background-color: purple;\r\n");
      out.write("    padding: 0.4em 0.6em;\r\n");
      out.write("    border-right: 1px solid white;\r\n");
      out.write("    font-size: medium;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  a:hover {\r\n");
      out.write("    background-color: fuchsia;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  li {\r\n");
      out.write("    display: inline;\r\n");
      out.write("  }\r\n");
      out.write("</style>\r\n");
      out.write("<head>\r\n");
      out.write("  <!--section id=\"main\" class=\"column\"-->\r\n");
      out.write("    <article class=\"module width_full\">\r\n");
      out.write("      <div id=\"menu\">\r\n");
      out.write("        <ul>\r\n");
      out.write("          <li><a href=\"/java2/activeTasks\"> Active tasks </a></li>\r\n");
      out.write("          <li><a href=\"/java2/taskManagement\"> Task Management </a></li>\r\n");
      out.write("          <li><a href=\"/java2/taskStatistics\"> Task Statistics </a></li>\r\n");
      out.write("          <li><a href=\"/java2/taskHistory.jsp\"> Task History </a></li>\r\n");
      out.write("          <li><a href=\"/java2/help.jsp\">Help</a></li>\r\n");
      out.write("          ");
User user=(User)session.getAttribute("user");
            String userType=(String)user.getUserType();
            if(userType.equals("A")){
      out.write("\r\n");
      out.write("          <li><a href=\"/java2/admin\">Admin Users</a></li>\r\n");
      out.write("          ");
}
      out.write("\r\n");
      out.write("          <li><a href=\"/java2/logout\">Logout</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("        <!-- end of #tab -->\r\n");
      out.write("    </article>\r\n");
      out.write("  <!--/section><!-- end of secondary bar -->\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<section id=\"main\" class=\"column\">\r\n");
      out.write("\r\n");
      out.write("  <article class=\"module width_full\">\r\n");
      out.write("    <header><h3>Help</h3></header>\r\n");
      out.write("    <div class=\"module_content\">\r\n");
      out.write("\r\n");
      out.write("      <article>\r\n");
      out.write("        <div>\r\n");
      out.write("          <p>Instant Gratification</p>\r\n");
      out.write("          <p>Whenever you reinforce a positive habit, complete a daily task, or take care of an old to-do,\r\n");
      out.write("            API immediately rewards you with experience points.</p>\r\n");
      out.write("          <p>Consequences</p>\r\n");
      out.write("          <p>Whenever you indulge in a bad habit or fail to complete one of your daily tasks, you lose health.\r\n");
      out.write("            If your health drops too low, you lose some of the progress you've made. By providing immediate consequences,\r\n");
      out.write("            API can help break bad habits and procrastination cycles before they cause real-world problems.</p>\r\n");
      out.write("        </div>\r\n");
      out.write("      </article>\r\n");
      out.write("      <div class=\"clear\"></div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </article><!-- end of stats article -->\r\n");
      out.write("</section>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
