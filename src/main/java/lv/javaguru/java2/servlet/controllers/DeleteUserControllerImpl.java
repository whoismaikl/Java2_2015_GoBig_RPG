package lv.javaguru.java2.servlet.controllers;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.Builders.UserBuilder;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.ButtonFunctionService;
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
public class DeleteUserControllerImpl implements RegistrationController {

    @Autowired
    @Qualifier("UserDAO_ORM")
    private UserDAO userDAO;
    @Autowired
    ButtonFunctionService buttonFunctionService;

    public MVCModel execute(HttpServletRequest request) {
        try {
            String taskString = buttonFunctionService.searchButtonName(request);
            MVCModel mvcModel = null;
            if (!taskString.isEmpty()) {
                String taskFunction = buttonFunctionService.getTaskFunction(taskString);
                Long userId = buttonFunctionService.getId(taskString);
                if (taskFunction.equals("delete")) {
                    userDAO.deleteUser(userId);
                    mvcModel = new MVCModel("User Deleted", "/admin.jsp");
                } else
                    mvcModel = new MVCModel("Delete User - Failed !", "/admin.jsp");
            }
            List<User> userList = userDAO.getAllUsers();
            HttpSession session = request.getSession();
            session.setAttribute("userList", userList);
            return mvcModel;

        } catch (Exception e) {
            return new MVCModel("Delete User - Failed !", "/admin.jsp");
        }
    }
}