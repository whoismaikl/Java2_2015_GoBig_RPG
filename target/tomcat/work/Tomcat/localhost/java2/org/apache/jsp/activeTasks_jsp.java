/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2016-01-25 09:41:52 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import lv.javaguru.java2.domain.User;

public final class activeTasks_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/includes/menu.jsp", Long.valueOf(1453647484137L));
    _jspx_dependants.put("/includes/header.jsp", Long.valueOf(1453281191368L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("  <head>\n");
      out.write("    <meta email=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\">\n");
      out.write("\n");
      out.write("    <meta charset=\"utf-8\"/>\n");
      out.write("    <title>Active Task Panel</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/layout.css\" type=\"text/css\" media=\"screen\" />\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/gobig.css\" type=\"text/css\" media=\"screen\" />\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/ie.css\" type=\"text/css\" media=\"screen\"/>\n");
      out.write("\n");
      out.write("  </head>\n");
      out.write("  ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("  <section class=\"column\">\r\n");
      out.write("    <div class=\"tab_container\">\r\n");
      out.write("      ");
DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        String formattedDate = df.format(new Date());
      out.write("\r\n");
      out.write("      <pre><h4 class=\"tabs_involved\">   Date: ");
      out.print(formattedDate);
      out.write("      Welcome to GoBig_RPG  -  ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.user.userName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</h4></pre>\r\n");
      out.write("    </div>\r\n");
      out.write("  </section><!-- end of secondary bar -->\r\n");
      out.write("</head>\r\n");
      out.write('\n');
      out.write(' ');
      out.write(' ');
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
      out.write("    width: 10em;\r\n");
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
      out.write("  <!--section id=\"main\" class=\"column menu\"-->\r\n");
      out.write("    <article class=\"module width_full\">\r\n");
      out.write("      <div id=\"menu\">\r\n");
      out.write("        <ul>\r\n");
      out.write("          <li><a href=\"/java2/activeTasks\"> Active tasks </a></li>\r\n");
      out.write("          <li><a href=\"/java2/taskManagement.jsp\"> Task Management </a></li>\r\n");
      out.write("          <li><a href=\"/java2/taskStatistics\"> Task Statistics </a></li>\r\n");
      out.write("          <li><a href=\"/java2/taskHistory\"> Task History </a></li>\r\n");
      out.write("          ");
User user=(User)session.getAttribute("user");
            String userType = user.getUserType();
            if(userType.equals("A")){
      out.write("\r\n");
      out.write("          <li><a href=\"/java2/userAdmin\">Admin Users</a></li>\r\n");
      out.write("          ");
}
      out.write("\r\n");
      out.write("          <li><a href=\"/java2/help.jsp\">Help</a></li>\r\n");
      out.write("          <li><a href=\"/java2/logout\">Logout</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("      </div>\r\n");
      out.write("        <!-- end of #tab -->\r\n");
      out.write("    </article>\r\n");
      out.write("  <!--/section--><!-- end of secondary bar -->\r\n");
      out.write("</head>\r\n");
      out.write("\n");
      out.write("  <body>\n");
      out.write("    <section id=\"main\" class=\"column\">\n");
      out.write("      <article class=\"module width_full\">\n");
      out.write("        <div class=\"tab_container\">\n");
      out.write("          <div id=\"tab12\" class=\"tab_content\">\n");
      out.write("            <img src=\"includes/BarChart.jpeg\" width=\"920\" height=\"100\" alt=\"\" />\n");
      out.write("          </div><!-- end of #tab1 -->\n");
      out.write("        </div><!-- end of #tab -->\n");
      out.write("      </article><!-- end of messages article -->\n");
      out.write("      <article class=\"module width_full\">\n");
      out.write("        <header><h3 class=\"tabs_involved\">Daily To Do Task List</h3>\n");
      out.write("        </header>\n");
      out.write("        <div class=\"tab_container\">\n");
      out.write("          <div id=\"tab1\" class=\"tab_content\">\n");
      out.write("            <form action=\"/java2/accomplishTask\" method=\"post\">\n");
      out.write("              <table class=\"tablesorter\" cellspacing=\"0\">\n");
      out.write("                <thead>\n");
      out.write("                <tr>\n");
      out.write("                  <th>Task Description</th>\n");
      out.write("                  <th>Category</th>\n");
      out.write("                  <th>Value</th>\n");
      out.write("                  <th>Is Task Accomplished ?</th>\n");
      out.write("                </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("              </table>\n");
      out.write("            </form>\n");
      out.write("          </div><!-- end of #tab1 -->\n");
      out.write("        </div><!-- end of #tab -->\n");
      out.write("      </article><!-- end of messages article -->\n");
      out.write("      <article class=\"module width_full\">\n");
      out.write("        <header><h3 class=\"tabs_involved\">Accomplished Task List</h3>\n");
      out.write("        </header>\n");
      out.write("        <div class=\"tab_container\">\n");
      out.write("          <div id=\"tab2\" class=\"tab_content\">\n");
      out.write("            <form action=\"/java2/undoTask\" method=\"post\">\n");
      out.write("              <table class=\"tablesorter\" cellspacing=\"0\">\n");
      out.write("                <thead>\n");
      out.write("                <tr>\n");
      out.write("                  <th>Task Description</th>\n");
      out.write("                  <th>Category</th>\n");
      out.write("                  <th>Value</th>\n");
      out.write("                  <th>Date Accomplished</th>\n");
      out.write("                </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                ");
      if (_jspx_meth_c_005fforEach_005f1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("              </table>\n");
      out.write("            </form>\n");
      out.write("          </div><!-- end of #tab1 -->\n");
      out.write("        </div><!-- end of #tab -->\n");
      out.write("      </article><!-- end of messages article -->\n");
      out.write("    </section>\n");
      out.write("  </body>\n");
      out.write("</html>\n");
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

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /activeTasks.jsp(50,16) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("activeTask");
    // /activeTasks.jsp(50,16) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/activeTasks.jsp(50,16) '${activeTaskList}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${activeTaskList}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                  <tr>\n");
          out.write("                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${activeTask.statDescription}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\n");
          out.write("                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${activeTask.statType}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\n");
          out.write("                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${activeTask.statValue}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\n");
          out.write("                    <td>\n");
          out.write("                      <input type=\"submit\" value=\"Yes\" name=\"accomp");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${activeTask.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\" class=\"alt_btn\">\n");
          out.write("                    </td>\n");
          out.write("                  </tr>\n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f1.setParent(null);
    // /activeTasks.jsp(82,16) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setVar("accomplishedTask");
    // /activeTasks.jsp(82,16) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setItems(new org.apache.jasper.el.JspValueExpression("/activeTasks.jsp(82,16) '${accomplishedTaskList}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${accomplishedTaskList}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int[] _jspx_push_body_count_c_005fforEach_005f1 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f1 = _jspx_th_c_005fforEach_005f1.doStartTag();
      if (_jspx_eval_c_005fforEach_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                  <tr>\n");
          out.write("                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${accomplishedTask.statDescription}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\n");
          out.write("                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${accomplishedTask.statType}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\n");
          out.write("                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${accomplishedTask.statValue}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\n");
          out.write("                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${accomplishedTask.dateAccomplished}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\n");
          out.write("                    <td>\n");
          out.write("                      <input type=\"submit\" value=\"Undo\" name=\"undo__");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${accomplishedTask.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\" class=\"alt_btn\">\n");
          out.write("                    </td>\n");
          out.write("                  </tr>\n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f1.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f1);
    }
    return false;
  }
}
