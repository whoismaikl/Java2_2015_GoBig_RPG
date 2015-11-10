package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by AST on 2015.11.03..
 */
public class LoginController implements MVCController {

    public MVCModel execute(HttpServletRequest request) throws DBException {


        String email = request.getParameter("email");
        String password = request.getParameter("password");

        MVCModel model = new MVCModel("Blank","/noPage.jsp");
        UserDAOImpl userDAO = new UserDAOImpl();
        if (!userDAO.checkLoginData(email, password)){

            //create session;
            //Open user page;
            model.setData("Login Success");
            model.setViewName("/main.jsp");

        } else {
            model.setData("Name Or Password not found in Our Database");
            model.setViewName("/index.jsp");
        }

        return model;
    }


}
