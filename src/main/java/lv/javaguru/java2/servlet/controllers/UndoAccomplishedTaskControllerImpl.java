package lv.javaguru.java2.servlet.controllers;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.HistoryRecordDAO;
import lv.javaguru.java2.database.TaskDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.HistoryRecord;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by AST on 2015.11.03..
 */
@Controller
public class UndoAccomplishedTaskControllerImpl {
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
    TimeService timeService;
    @Autowired
    ChartService chartService;

    @RequestMapping(value = "/undoTask", method = {RequestMethod.POST})
    public ModelAndView execute(HttpServletRequest request) throws DBException, IOException, InterruptedException {

        String buttonName = buttonFunctionService.getButtonName(request);

        if (!buttonName.isEmpty()) {
            Long accomplishedTaskId = buttonFunctionService.getId(buttonName);
            Task task = taskDAO.getTaskById(accomplishedTaskId);

            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            user = taskService.resetUserPropertiesByAccomplishedTask(user, task);
            userDAO.updateUserData(user);

            java.sql.Timestamp stopDate = timeService.getEndOfDateTimestamp();
            java.sql.Timestamp startDate = timeService.getStartOfDateTimestamp();

            List<HistoryRecord> historyRecordsInRange = historyRecordDAO.getHistoryRecordsInRange(user, startDate, stopDate);

            Long historyRecordId = taskService.getHistoryRecordId(historyRecordsInRange, accomplishedTaskId);
            historyRecordDAO.deleteHistoryRecordById(historyRecordId);

            task = taskService.setTaskNotAccomplished(task);
            taskDAO.updateTask(task);

            sessionService.updateSessionVariables(request);

            user = (User) session.getAttribute("user");
            chartService.createBarChart(user);

            //TimeUnit.SECONDS.sleep(1);

            return new ModelAndView("/activeTasks.jsp", "model", "Task Accomplished");
        }
        return new ModelAndView("/activeTasks.jsp","model", "Task Accomplish Error");
    }
}
