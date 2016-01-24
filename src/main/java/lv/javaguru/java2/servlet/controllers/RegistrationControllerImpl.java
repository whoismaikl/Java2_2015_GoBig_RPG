package lv.javaguru.java2.servlet.controllers;

import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by mike on 2015.11.03..
 */
@Controller
public class RegistrationControllerImpl {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = {RequestMethod.POST})
    public ModelAndView execute(HttpServletRequest request) {

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");

        try {
            if(userService.userExist(email, username))
                return new ModelAndView("/register.jsp", "model", "Registration Failed - Username and email already exist!");

            if(!userService.passwordsMatches(password1, password2))
                return new ModelAndView("/register.jsp", "model", "Registration Failed - Passwords do'nt matches!");

            if(!userService.correctEmailSyntax(email))
                return new ModelAndView("/register.jsp", "model", "Registration Failed - email not correct!");

            User user = userService.createUser(email, password1, password2, username);

            userService.addDefaultTasks(user);

            return new ModelAndView("/index.jsp", "model", "User Registration Successful");

        } catch (Exception e) {
            return new ModelAndView("/register.jsp", "model", "Registration Failed");
        }
    }
}
