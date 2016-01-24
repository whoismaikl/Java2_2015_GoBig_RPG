package lv.javaguru.java2.servlet.controllers;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.servlet.controllers.controllerInterfaces.LogoutController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by mike on 11/25/2015.
 */
@Controller
public class LogoutControllerImpl {

    @RequestMapping(value = "/logout", method = {RequestMethod.GET})
    public ModelAndView execute(HttpServletRequest request) throws DBException {

        HttpSession session = request.getSession();
        session.invalidate();

        return new ModelAndView("/index.jsp", "model", "Logout");
    }
}
