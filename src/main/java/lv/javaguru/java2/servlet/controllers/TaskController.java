package lv.javaguru.java2.servlet.controllers;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.UserTaskDAOImpl;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.UserTask;
import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by AST on 2015.11.03..
 */
@Component
public class TaskController implements MVCController {
    @Autowired
    private UserTaskDAOImpl userTaskDAO;

    public MVCModel execute(HttpServletRequest request) throws DBException {

        String taskIdString = searchButtonName(request);

        if(!taskIdString.isEmpty()) {
            Long taskId = Long.valueOf(taskIdString);
            userTaskDAO.deleteTaskByID(taskId);
        }

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<UserTask> userTasks = userTaskDAO.getAllUserTasks(user);
        session.setAttribute("userTasks", userTasks);

        return  new MVCModel("Register", "/main.jsp");
    }
    String searchButtonName(final HttpServletRequest request) {
        String buttonName = "";
        Map<String, String[]> paramMap = request.getParameterMap();
        if (!paramMap.isEmpty()) {
            for (Map.Entry<String, String[]> entry : paramMap.entrySet()) {
                    buttonName = entry.getKey();
            }
        }
        return buttonName;
    }
}
