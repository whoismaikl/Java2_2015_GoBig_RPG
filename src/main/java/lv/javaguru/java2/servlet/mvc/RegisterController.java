package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;
import lv.javaguru.java2.domain.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by AST on 2015.11.03..
 */
public class RegisterController implements MVCController {

    public MVCModel execute(HttpServletRequest request) throws DBException {
        String username =  request.getParameter("username");
        String email =  request.getParameter("email");
        String password =  request.getParameter("password");
        String password2 =  request.getParameter("password2");
        if(password.equals(password2)){
            User user = new User(email,password,username,"U");
            UserDAOImpl userDAO = new UserDAOImpl();
            userDAO.create(user);
        }

        return  new MVCModel("Register", "/register.jsp");
    }
}
