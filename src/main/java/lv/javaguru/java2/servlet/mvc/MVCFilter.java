package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.SpringConfig;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by AST on 2015.11.03..
 */
public class MVCFilter implements Filter {
    private Map<String, MVCController> controllers;
    private ApplicationContext springContext;
    private static final Logger logger = Logger.getLogger(MVCFilter.class.getName());

    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            springContext = new AnnotationConfigApplicationContext(SpringConfig.class);
            controllers = new HashMap<String, MVCController>();
            controllers.put("/hello", getBean(HelloWorldController.class));
            controllers.put("/login", getBean(LoginController.class));
            controllers.put("/register", getBean(RegisterController.class));
            controllers.put("/main", getBean(MainController.class));
            controllers.put("/task", getBean(TaskController.class));
            controllers.put("/taskNew", getBean(TaskNewController.class));
        } catch (BeansException e) {
            logger.log(Level.INFO, "Spring context failed to start", e);
        }
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse resp = (HttpServletResponse)servletResponse;

        String contextURL = req.getServletPath();

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
    private MVCController getBean(Class clazz){
        return (MVCController) springContext.getBean(clazz);
    }
}
