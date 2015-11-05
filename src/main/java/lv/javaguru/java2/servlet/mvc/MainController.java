package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;
import lv.javaguru.java2.domain.User;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by AST on 2015.11.03..
 */
public class MainController implements MVCController {

    public MVCModel execute(HttpServletRequest request) throws DBException {
        String username =  request.getParameter("username");
        String email =  request.getParameter("email");
        String password1 =  request.getParameter("password1");
        String password2 =  request.getParameter("password2");
        if(password1.equals(password2)){
            User user = new User(email,password1,username,"U");
            UserDAOImpl userDAO = new UserDAOImpl();
            userDAO.create(user);
        }
        return  new MVCModel("Register", "/main.jsp");
    }
}
