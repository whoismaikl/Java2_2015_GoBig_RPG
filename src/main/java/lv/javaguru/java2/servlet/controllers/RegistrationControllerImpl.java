package lv.javaguru.java2.servlet.controllers;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.Builders.UserBuilder;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.RegistrationService;
import lv.javaguru.java2.servlet.controllers.controllerInterfaces.RegistrationController;
import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by mike on 2015.11.03..
 */
@Component
public class RegistrationControllerImpl implements RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    public MVCModel execute(HttpServletRequest request) {

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");

        try {
            User user = UserBuilder.createUser()
                    .applyUserName(username)
                    .applyEmail(email)
                    .applyPassword(password1)
                    .create();

            registrationService.createUser(email, password1, password2, email);
            request.getSession().setAttribute("user", user);
            return new MVCModel("User Registered", "/index.jsp");

        } catch (Exception e) {
            return new MVCModel("Registration Failed", "/register.jsp");
        }

    }


}
