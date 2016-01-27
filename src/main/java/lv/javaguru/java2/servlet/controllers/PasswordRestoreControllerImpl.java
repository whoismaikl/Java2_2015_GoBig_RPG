package lv.javaguru.java2.servlet.controllers;

import lv.javaguru.java2.database.TaskDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.hibernateORM.UserDAOImpl;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.PasswordService;
import lv.javaguru.java2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by mike on 2015.11.03..
 */
@Controller
public class PasswordRestoreControllerImpl {

    @Autowired
    private UserService userService;
    @Autowired

    @Qualifier("UserDAO_ORM")
    private UserDAO userDAO;

    @RequestMapping(value = "/retreivePassword", method = {RequestMethod.POST})
    public ModelAndView execute(HttpServletRequest request) {

        String email = request.getParameter("email");

        try {
            if (!userService.isValidEmailAddress(email)) {
                return new ModelAndView("/retreivePassword.jsp", "model", "Wrong Email");
            } else {

               // if (userService.getPasswordByMail(email)) {

                    User user = userDAO.getPasswordByMail(email);
                    String userPassword = user.getPassword();
                    PasswordService.sendUserPassword(userPassword,email);

                    return new ModelAndView("/index.jsp", "model", "Password Sent To Email");
              //  }
            }

          //  return new ModelAndView("/retreivePassword.jsp", "model", "Email Not Found In Out Database");

        } catch (Exception e) {
            return new ModelAndView("/retreivePassword.jsp", "model", "Something Wrong -,-");
        }
    }
}
