package lv.javaguru.java2.servlet.controllers;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.LoginService;
import lv.javaguru.java2.services.SessionUpdateService;
import lv.javaguru.java2.servlet.controllers.controllerInterfaces.LoginController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;

/**
 * Created by AST on 2015.11.03..
 */
@Component
public class LoginControllerImpl implements LoginController {
    @Autowired
    @Qualifier("UserDAO_ORM")
    private UserDAO userDAO;
    @Autowired
    private SessionUpdateService sessionUpdateService;

    public MVCModel execute(HttpServletRequest request) throws DBException, IOException, ParseException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        MVCModel model = new MVCModel("Blank","/noPage.jsp");
        User user = userDAO.getUserByLoginData(email, password);

        if (user!=null){

            model.setData("Login Success");
            model.setViewName("/activeTasks.jsp");

            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            sessionUpdateService.initiateSessionVariables(request);
            sessionUpdateService.updateSessionVariables(request);

        } else {
            model.setData("Name Or Password not correct!");
            model.setViewName("/index.jsp");
        }

        return model;
    }


}
