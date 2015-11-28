package lv.javaguru.java2.servlet.controllers;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.jdbc.TaskDAOImpl;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.servlet.controllers.controllerInterfaces.LoginController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by AST on 2015.11.03..
 */
@Component
public class LoginControllerImpl implements LoginController {
    @Autowired
    @Qualifier("UserDAO_JDBC")
    private UserDAO userDAO;

    public MVCModel execute(HttpServletRequest request) throws DBException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        MVCModel model = new MVCModel("Blank","/noPage.jsp");

        if (userDAO.checkLoginData(email, password)){

            model.setData("Login Success");
            model.setViewName("/accomplish_task.jsp");

            HttpSession session = request.getSession();
            User user = userDAO.getUserByLoginData(email, password);
            session.setAttribute("user", user);

            TaskDAOImpl userTaskDAO = new TaskDAOImpl();
            List<Task> tasks = userTaskDAO.getAllUserTasks(user);
            session.setAttribute("userTasks", tasks);

        } else {
            model.setData("Name Or Password not found in Our Database");
            model.setViewName("/index.jsp");
        }

        return model;
    }


}
