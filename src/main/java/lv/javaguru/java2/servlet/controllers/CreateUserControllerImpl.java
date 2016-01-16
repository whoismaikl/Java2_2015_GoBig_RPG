package lv.javaguru.java2.servlet.controllers;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.builders.UserBuilder;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.RegistrationService;
import lv.javaguru.java2.servlet.controllers.controllerInterfaces.RegistrationController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by mike on 2015.11.03..
 */
@Component
public class CreateUserControllerImpl implements RegistrationController {

    @Autowired
    @Qualifier("UserDAO_ORM")
    private UserDAO userDAO;
    @Autowired
    private RegistrationService registrationService;

    public MVCModel execute(HttpServletRequest request) {

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");

        try {
            User user = UserBuilder.buildUser()
                    .withUserName(username)
                    .withEmail(email)
                    .withPassword(password1)
                    .build();

            user = registrationService.createUser(email, password1, password2, email);
            registrationService.addDefaultTasks(user);
            List<User> userList = userDAO.getAllUsers();
            HttpSession session = request.getSession();
            session.setAttribute("userList", userList);
            return new MVCModel("User Registered", "/admin.jsp");

        } catch (Exception e) {
            return new MVCModel("Create User - Failed !", "/admin.jsp");
        }

    }

}
