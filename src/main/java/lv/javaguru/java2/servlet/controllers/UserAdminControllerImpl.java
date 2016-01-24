package lv.javaguru.java2.servlet.controllers;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.TaskDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.servlet.controllers.controllerInterfaces.UserAdminController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by AST on 2015.11.03..
 */
@Controller
public class UserAdminControllerImpl {

    @Autowired
    @Qualifier("UserDAO_ORM")
    private UserDAO userDAO;

    @RequestMapping(value = "/userAdmin", method = {RequestMethod.GET})
    public ModelAndView execute(HttpServletRequest request) throws DBException {

        HttpSession session = request.getSession();

        List<User> userList = userDAO.getAllUsers();
        session.setAttribute("userList", userList);

        return  new ModelAndView("/userAdmin.jsp", "model", "Refresh UserList");
    }
}
