package lv.javaguru.java2.servlet.controllers;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;

/**
 * Created by AST on 2015.11.03..
 */
@Controller
public class LoginControllerImpl {
    @Autowired
    @Qualifier("UserDAO_ORM")
    private UserDAO userDAO;
    @Autowired
    private SessionService sessionService;

    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public ModelAndView execute(HttpServletRequest request) throws DBException, IOException, ParseException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = userDAO.getUserByLoginData(email, password);

        if (user!=null){
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            sessionService.initiateSessionVariables(request);

            return new ModelAndView("/activeTasks.jsp", "model","Login Success");
        }
        return new ModelAndView("/index.jsp", "model", "Name Or Password not correct!");
    }
}
