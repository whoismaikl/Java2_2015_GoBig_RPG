package lv.javaguru.java2.servlet.controllers;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.ButtonFunctionService;
import lv.javaguru.java2.servlet.controllers.controllerInterfaces.RegistrationController;
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
 * Created by mike on 2015.11.03..
 */
@Controller
public class DeleteUserControllerImpl {
    @Autowired
    @Qualifier("UserDAO_ORM")
    private UserDAO userDAO;
    @Autowired
    private ButtonFunctionService buttonFunctionService;

    @RequestMapping(value = "/deleteUser", method = {RequestMethod.POST})
    public ModelAndView execute(HttpServletRequest request) throws DBException {
        String taskString = buttonFunctionService.getButtonName(request);

        if (!taskString.isEmpty()) {
            String taskFunction = buttonFunctionService.getButtonFunction(taskString);
            Long userId = buttonFunctionService.getId(taskString);

            if (taskFunction.equals("delete")) {
                userDAO.deleteUser(userId);
                List<User> userList = userDAO.getAllUsers();
                HttpSession session = request.getSession();
                session.setAttribute("userList", userList);
                return new ModelAndView("/userAdmin.jsp", "model", "User Deleted");
            }
        }
        return new ModelAndView("/userAdmin.jsp", "model", "Delete User - Failed !");
    }
}
