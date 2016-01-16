package lv.javaguru.java2.servlet.mvc;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.config.SpringConfig;
import lv.javaguru.java2.servlet.controllers.*;
import lv.javaguru.java2.servlet.originals.HelloWorldController;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
        } catch (BeansException e) {
            logger.log(Level.INFO, "Spring context failed to start", e);
        }
        controllers = new HashMap<String, MVCController>();
        controllers.put("/hello", getBean(HelloWorldController.class));
        controllers.put("/login", getBean(LoginControllerImpl.class));
        controllers.put("/logout", getBean(LogoutControllerImpl.class));
        controllers.put("/register", getBean(RegistrationControllerImpl.class));
        controllers.put("/createTask", getBean(CreateTaskControllerImpl.class));
        controllers.put("/taskManagement", getBean(TaskManagementControllerImpl.class));
        controllers.put("/activeTasks", getBean(ActiveTasksControllerImpl.class));
        controllers.put("/taskStatistics", getBean(TaskStatisticsControllerImpl.class));
        controllers.put("/editTask", getBean(EditTaskControllerImpl.class));
        controllers.put("/admin", getBean(UserAdminControllerImpl.class));
        controllers.put("/createUser", getBean(CreateUserControllerImpl.class));
        controllers.put("/deleteUser", getBean(DeleteUserControllerImpl.class));
        controllers.put("/createHistory", getBean(TaskHistoryControllerImpl.class));
        controllers.put("/accomplishTask", getBean(AccomplishTaskControllerImpl.class));
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
