package lv.javaguru.java2.servlet.controllers;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.RegistrationService;
import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by AST on 2015.11.03..
 */
@Component
public class RegisterController implements MVCController {

    @Autowired
    private RegistrationService loginService;



    public MVCModel execute(HttpServletRequest request) throws DBException {

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        MVCModel model = new MVCModel("Blank","/noPage.jsp");




        if(!loginService.userExist()){

        }

        if (password1.equals(password2) && !password1.equals(null) && !password1.equals("")) {

            User user = new User(email, password1, username, "U");

            //if optional.Of(user)
            if (!userDAO.getUserByMail(email) && !userDAO.getUserByName(username)){


                userDAO.createUser(user);
                model.setData("User Registered");
                model.setViewName("/index.jsp");
            } else {
                model.setData("User Already Exists!");
                model.setViewName("/register.jsp");
            }
        } else {
            model.setData("Registration Failed, Please Try Again Later!");
            model.setViewName("/register.jsp");

        }
        return model;
    }


}
