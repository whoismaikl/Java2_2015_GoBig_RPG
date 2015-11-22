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
import java.util.Date;
import java.util.List;

/**
 * Created by AST on 2015.11.03..
 */
@Component
public class TaskNewController implements MVCController {
    @Autowired
    private UserTaskDAOImpl userTaskDAO;


    public MVCModel execute(HttpServletRequest request) throws DBException {

        String statDescription = request.getParameter("statDescription");
        int statValue = Integer.parseInt(request.getParameter("statValue"));
        String statType = request.getParameter("statType");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        UserTask userTask = createUserTask(user.getId(),statType,statValue,statDescription,"N","N");
        userTaskDAO.createTask(userTask);

        List<UserTask> userTasks = userTaskDAO.getAllUserTasks(user);
        session.setAttribute("userTasks", userTasks);

        return  new MVCModel("Register", "/main.jsp");
    }
    private UserTask createUserTask(Long userId, String statType, int statValue, String statDescription,
                                    String repeatableYN, String accomplishedYN) {
        UserTask userTask = new UserTask();
        userTask.setUserID(userId);
        userTask.setStatType(statType);
        userTask.setStatValue(statValue);
        userTask.setStatDescription(statDescription);
        userTask.setRepeatableYN(repeatableYN);
        userTask.setAccomplishedYN(accomplishedYN);
        userTask.setDateAdded(date);
        userTask.setDateAccomplished(date);
        return userTask;
    }
    Date date = new Date();
}