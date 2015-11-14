package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;
import lv.javaguru.java2.database.jdbc.UserTaskDAOImpl;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.UserTask;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by AST on 2015.11.03..
 */
public class LoginController implements MVCController {

    public MVCModel execute(HttpServletRequest request) throws DBException {



        String email = request.getParameter("email");
        String password = request.getParameter("password");

        MVCModel model = new MVCModel("Blank","/noPage.jsp");
        UserDAOImpl userDAO = new UserDAOImpl();
        UserTaskDAOImpl userTaskDAO = new UserTaskDAOImpl();
        if (userDAO.checkLoginData(email, password)){

            //create session;
            //Open user page;
            model.setData("Login Success");
            model.setViewName("/main.jsp");


            HttpSession session = request.getSession();
            User user = userDAO.getUserByLoginData(email, password);
            String userName = user.getUserName();
            UserTask userTask = new UserTask();
            session.setAttribute("userName", userName);
            session.setAttribute("user", user);
            List<UserTask> userTasks = userTaskDAO.getAll(user);
            request.setAttribute("userTasks", userTasks);


        } else {
            model.setData("Name Or Password not found in Our Database");
            model.setViewName("/index.jsp");
        }

        return model;
    }


}
