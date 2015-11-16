package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.UserTaskDAOImpl;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.UserTask;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by AST on 2015.11.03..
 */
public class MainController implements MVCController {

    public MVCModel execute(HttpServletRequest request) throws DBException {
        UserTaskDAOImpl userTaskDAO = new UserTaskDAOImpl();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<UserTask> userTasks = userTaskDAO.getAllUserTasks(user);
        session.setAttribute("userTasks", userTasks);



        return  new MVCModel("Register", "/main.jsp");
    }

}
