package lv.javaguru.java2.servlet.controllers;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.HistoryDAO;
import lv.javaguru.java2.database.TaskDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.History;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.SessionUpdateService;
import lv.javaguru.java2.services.TaskService;
import lv.javaguru.java2.servlet.controllers.controllerInterfaces.AdminController;
import lv.javaguru.java2.servlet.controllers.controllerInterfaces.TaskHistoryController;
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
public class TaskHistoryControllerImpl implements TaskHistoryController {

    @Autowired
    @Qualifier("TaskDAO_ORM")
    private TaskDAO taskDAO;
    @Autowired
    @Qualifier("HistoryDAO_ORM")
    private HistoryDAO historyDAO;
    @Autowired
    private TaskService taskService;
    @Autowired
    @Qualifier("UserDAO_ORM")
    private UserDAO userDAO;
    @Autowired
    private SessionUpdateService sessionUpdateService;

    public MVCModel execute(HttpServletRequest request) throws DBException {

        sessionUpdateService.updateSession(request);

       /* HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<History> historyList = user.getHistoryList();
        session.setAttribute("historyList", historyList);*/

        return  new MVCModel("Accomplished Task History", "/taskHistory.jsp");
    }
}
