package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;
import lv.javaguru.java2.database.jdbc.UserTaskDAOImpl;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.UserTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by AST on 2015.11.03..
 */
@Component
public class LoginController implements MVCController {
    @Autowired
    private UserDAOImpl userDAO;

    public MVCModel execute(HttpServletRequest request) throws DBException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        MVCModel model = new MVCModel("Blank","/noPage.jsp");

        if (userDAO.checkLoginData(email, password)){

            model.setData("Login Success");
            model.setViewName("/main.jsp");


            HttpSession session = request.getSession();
            User user = userDAO.getUserByLoginData(email, password);
            session.setAttribute("user", user);

            UserTaskDAOImpl userTaskDAO = new UserTaskDAOImpl();
            List<UserTask> userTasks = userTaskDAO.getAllUserTasks(user);
            session.setAttribute("userTasks", userTasks);

        } else {
            model.setData("Name Or Password not found in Our Database");
            model.setViewName("/index.jsp");
        }

        return model;
    }


}
