/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2015-12-01 22:14:21 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class accomplish_005ftask_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/includes/menu.jsp", Long.valueOf(1449006726874L));
    _jspx_dependants.put("/includes/header.jsp", Long.valueOf(1449006726864L));
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

      out.write("\r\n");
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
      out.write("  <div id=\"menu\">\r\n");
      out.write("    <ul>\r\n");
      out.write("      <li><a href=\"/java2/accomplish_task\"> Accomplish tasks </a></li>\r\n");
      out.write("      <li><a href=\"/java2/task_management\"> Task management </a></li>\r\n");
      out.write("      <li><a href=\"/java2/task_statistics\"> Task statistics </a></li>\r\n");
      out.write("      <li><a href=\"/java2/help.jsp\">Help</a></li>\r\n");
      out.write("      <li><a href=\"#\"></a></li>\r\n");
      out.write("      <li><a href=\"#\"></a></li>\r\n");
      out.write("      <li><a href=\"/java2/logout\">Logout</a></li>\r\n");
      out.write("\r\n");
      out.write("    </ul>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  </div>\r\n");
      out.write("  </section><!-- end of secondary bar -->\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<section id=\"main\" class=\"column\">\r\n");
      out.write("\r\n");
      out.write("  <article class=\"module width_full\">\r\n");
      out.write("    <header><h3 class=\"tabs_involved\">Accomplish Tasks</h3>\r\n");
      out.write("    </header>\r\n");
      out.write("    <div class=\"tab_container\">\r\n");
      out.write("      <div id=\"tab1\" class=\"tab_content\"-->\r\n");
      out.write("        <html>\r\n");
      out.write("        ");
      lv.javaguru.java2.domain.Task task = null;
      synchronized (session) {
        task = (lv.javaguru.java2.domain.Task) _jspx_page_context.getAttribute("task", javax.servlet.jsp.PageContext.SESSION_SCOPE);
        if (task == null){
          task = new lv.javaguru.java2.domain.Task();
          _jspx_page_context.setAttribute("task", task, javax.servlet.jsp.PageContext.SESSION_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <form action=\"/java2/accomplish_task\" method=\"post\">\r\n");
      out.write("          <table class=\"tablesorter\" cellspacing=\"0\">\r\n");
      out.write("            <thead>\r\n");
      out.write("            <tr>\r\n");
      out.write("\r\n");
      out.write("              <th>Task Description</th>\r\n");
      out.write("              <th>Category</th>\r\n");
      out.write("              <th>Value</th>\r\n");
      out.write("              <th>Is Task Accomplished ?</th>\r\n");
      out.write("            </tr>\r\n");
      out.write("            </thead>\r\n");
      out.write("            <tbody>\r\n");
      out.write("\r\n");
      out.write("            ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("            </tbody>\r\n");
      out.write("          </table>\r\n");
      out.write("        </form>\r\n");
      out.write("      </div><!-- end of #tab1 -->\r\n");
      out.write("    </div><!-- end of #tab -->\r\n");
      out.write("  </article><!-- end of messages article -->\r\n");
      out.write("\r\n");
      out.write("</section>\r\n");
      out.write("\r\n");
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

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /accomplish_task.jsp(50,12) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("task");
    // /accomplish_task.jsp(50,12) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/accomplish_task.jsp(50,12) '${taskList}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${taskList}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\r\n");
          out.write("              <tr>\r\n");
          out.write("\r\n");
          out.write("                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${task.statDescription}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${task.statType}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${task.statValue}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("                <td>\r\n");
          out.write("                  <input type=\"submit\" value=\"Yes\" name=\"yes\" +");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${task.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\" class=\"alt_btn\">\r\n");
          out.write("                  <input type=\"submit\" value=\"No\" name=\"no\" +");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${task.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\"class=\"alt_btn\">\r\n");
          out.write("                </td>\r\n");
          out.write("              </tr>\r\n");
          out.write("\r\n");
          out.write("            ");
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
}
