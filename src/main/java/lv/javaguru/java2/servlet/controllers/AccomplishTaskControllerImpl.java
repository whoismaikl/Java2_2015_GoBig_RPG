package lv.javaguru.java2.servlet.controllers;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.HistoryDAO;
import lv.javaguru.java2.database.TaskDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.History;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.builders.HistoryBuilder;
import lv.javaguru.java2.domain.builders.TaskBuilder;
import lv.javaguru.java2.domain.builders.UserBuilder;
import lv.javaguru.java2.services.ButtonFunctionService;
import lv.javaguru.java2.services.SessionUpdateService;
import lv.javaguru.java2.services.TimestampService;
import lv.javaguru.java2.servlet.controllers.controllerInterfaces.AccomplishTaskController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by AST on 2015.11.03..
 */
@Component
public class AccomplishTaskControllerImpl implements AccomplishTaskController {
    private final String TASK_STATUS_TYPE_HEALTH  = "health";
    private final String TASK_STATUS_TYPE_INTELLIGENCE  = "intelligence";
    private final String TASK_STATUS_TYPE_COMMUNICATION  = "communication";
    @Autowired
    @Qualifier("TaskDAO_ORM")
    private TaskDAO taskDAO;
    @Autowired
    @Qualifier("UserDAO_ORM")
    private UserDAO userDAO;
    @Autowired
    @Qualifier("HistoryDAO_ORM")
    private HistoryDAO historyDAO;
    @Autowired
    private ButtonFunctionService buttonFunctionService;
    @Autowired
    private TimestampService timestampService;
    @Autowired
    private HistoryBuilder historyBuilder;
    @Autowired
    private TaskBuilder taskBuilder;
    @Autowired
    private SessionUpdateService sessionUpdateService;

    public MVCModel execute(HttpServletRequest request) throws DBException {

        String buttonName = buttonFunctionService.getButtonName(request);

        if (!buttonName.isEmpty()) {

            String buttonFunction = buttonFunctionService.getButtonFunction(buttonName);
            Long taskId = buttonFunctionService.getId(buttonName);

            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            Long userID = user.getId();

            Task task = taskDAO.getTaskById(taskId);

            String taskType = task.getStatType();
            int taskValue = task.getStatValue();
            String taskDescription = task.getStatDescription();

            //Update Task
            task.setAccomplishedYN("Y");
            taskDAO.editTask(taskId, task);

            //Update User
            if (taskType.equals(TASK_STATUS_TYPE_HEALTH)) {
                Integer newValue = user.getHealth() + taskValue;
                user.setHealth(newValue);
            } else if (taskType.equals(TASK_STATUS_TYPE_INTELLIGENCE)) {
                Integer newValue = user.getIntelligence() + taskValue;
                user.setIntelligence(newValue);
            } else if (taskType.equals(TASK_STATUS_TYPE_COMMUNICATION)) {
                Integer newValue = user.getCommunication() + taskValue;
                user.setCommunication(newValue);
            }
            userDAO.updateUserData(userID, user);

            //Create Record in History
            History history = historyBuilder.buildHistory()
                    .withUserID(user.getId())
                    .withHealth(user.getHealth())
                    .withIntelligence(user.getIntelligence())
                    .withCommunication(user.getCommunication())
                    .withWillPower(user.getWillPower())
                    .withStatValue(taskValue)
                    .withDateCompleted(timestampService.getSqlTimestamp())
                    .build();
            historyDAO.createHistory(history);

            //Update Session
            sessionUpdateService.updateSession(request);
            return new MVCModel("Task Accomplished", "/activeTasks.jsp");
        }
        return new MVCModel("Button not active", "/activeTasks.jsp");
    }
}
