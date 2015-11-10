package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.DBException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by AST on 2015.11.03..
 */
public class MVCFilter implements Filter {
    private Map<String, MVCController> controllers;


    public void init(FilterConfig filterConfig) throws ServletException {

        controllers = new HashMap<String, MVCController>();
        controllers.put("/hello", new HelloWorldController());
        controllers.put("/login", new LoginController());
        controllers.put("/register", new RegisterController());
        controllers.put("/main", new MainController());

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse resp = (HttpServletResponse)servletResponse;

        String contextURL = req.getServletPath();

        //req.getMethod();

        MVCController controller = controllers.get(contextURL);

        if(controller != null){
            MVCModel model = null;
            try {
                model = controller.execute(req);
            } catch (DBException e) {
                e.printStackTrace();
            }


            req.setAttribute("model", model.getData());

            ServletContext context = req.getServletContext();
            RequestDispatcher requestDispatcher = context.getRequestDispatcher(model.getViewName());
            requestDispatcher.forward(req, resp);
        }
        else filterChain.doFilter(servletRequest,servletResponse);

    }

    public void destroy() {

    }
}
