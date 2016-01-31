package lv.javaguru.java2.servlet.controllers;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.HistoryRecordDAO;
import lv.javaguru.java2.database.TaskDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.HistoryRecord;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.ChartService;
import lv.javaguru.java2.services.TaskService;
import lv.javaguru.java2.services.ButtonFunctionService;
import lv.javaguru.java2.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by AST on 2015.11.03..
 */
@Controller
public class AccomplishTaskControllerImpl{
    @Autowired
    @Qualifier("TaskDAO_ORM")
    private TaskDAO taskDAO;
    @Autowired
    @Qualifier("UserDAO_ORM")
    private UserDAO userDAO;
    @Autowired
    @Qualifier("HistoryDAO_ORM")
    private HistoryRecordDAO historyRecordDAO;
    @Autowired
    private ButtonFunctionService buttonFunctionService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private SessionService sessionService;
    @Autowired
    ChartService chartService;

    @RequestMapping(value = "/accomplishTask", method = {RequestMethod.POST})
    public ModelAndView execute(HttpServletRequest request) throws DBException, IOException, InterruptedException {

        String buttonName = buttonFunctionService.getButtonName(request);

        if (!buttonName.isEmpty()) {
            Long taskId = buttonFunctionService.getId(buttonName);
            Task task = taskDAO.getTaskById(taskId);

            String taskAccomplished = task.getAccomplishedYN();
            if(taskAccomplished.equals("Y"))
                return new ModelAndView("/activeTasks.jsp", "model", "Task Already Accomplished");

            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");

            user = taskService.setUserPropertiesByAccomplishedTask(user, task);
            userDAO.updateUserData(user);

            task = taskService.setTaskAccomplished(task);
            taskDAO.updateTask(task);

            HistoryRecord historyRecord = taskService.buildHistoryRecord(user, task);
            historyRecordDAO.createHistoryRecord(historyRecord);

            sessionService.updateSessionVariables(request);

            return new ModelAndView("/activeTasks.jsp", "model", "Task Accomplished");
        }
        return new ModelAndView("/activeTasks.jsp","model", "Task Accomplish Error");
    }
}
