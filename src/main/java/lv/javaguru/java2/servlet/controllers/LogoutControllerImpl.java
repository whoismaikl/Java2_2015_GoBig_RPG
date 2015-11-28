package lv.javaguru.java2.servlet.controllers;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.servlet.controllers.controllerInterfaces.LogoutController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by mike on 11/25/2015.
 */


@Component
//@RequestMapping("/index.jsp")
public class LogoutControllerImpl implements LogoutController {
    //@RequestMapping(method=RequestMethod.POST)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/index.jsp";
    }

    public MVCModel execute(HttpServletRequest request) throws DBException {
        HttpSession session = request.getSession();
        session.invalidate();
        return new MVCModel("Logout", "/index.jsp");
    }
}
