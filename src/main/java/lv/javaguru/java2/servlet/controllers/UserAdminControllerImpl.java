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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by AST on 2015.11.03..
 */
@Component
public class UserAdminControllerImpl implements UserAdminController {

    @Autowired
    @Qualifier("UserDAO_ORM")
    private UserDAO userDAO;

    public MVCModel execute(HttpServletRequest request) throws DBException {

        HttpSession session = request.getSession();

        List<User> userList = userDAO.getAllUsers();
        session.setAttribute("userList", userList);

        return  new MVCModel("Refresh UserList", "/userAdmin.jsp");
    }
}
