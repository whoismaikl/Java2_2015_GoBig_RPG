package lv.javaguru.java2.servlet.controllers;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.HistoryDAO;
import lv.javaguru.java2.database.TaskDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.History;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.domain.builders.HistoryBuilder;
import lv.javaguru.java2.services.CreateTaskService;
import lv.javaguru.java2.services.SessionUpdateService;
import lv.javaguru.java2.services.TimestampService;
import lv.javaguru.java2.servlet.controllers.controllerInterfaces.TaskHistoryController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by AST on 2015.11.03..
 */
@Component
public class TaskHistoryControllerImpl implements TaskHistoryController {
    @Autowired
    private HistoryBuilder historyBuilder;
    @Autowired
    @Qualifier("HistoryDAO_ORM")
    private HistoryDAO historyDAO;
    @Autowired
    private SessionUpdateService sessionUpdateService;
    @Autowired
    private TimestampService timestampService;

    public MVCModel execute(HttpServletRequest request) throws DBException, IOException {

        int health = Integer.parseInt(request.getParameter("health"));
        int intelligence = Integer.parseInt(request.getParameter("intelligence"));
        int communication = Integer.parseInt(request.getParameter("communication"));
        int statValue = Integer.parseInt(request.getParameter("statValue"));
        //String dateCompleted = java.sql.Timestamp.parseTimestamp(request.getParameter("dateCompleted"));

        History history = historyBuilder.buildHistory()
                .withHealth(health)
                .withIntelligence(intelligence)
                .withCommunication(communication)
                .withStatValue(statValue)
                .withDateCompleted(timestampService.getSqlTimestamp())
                .build();

        historyDAO.createHistory(history);

        sessionUpdateService.updateSession(request);

        return  new MVCModel("New Task", "/taskManagement.jsp");
    }
}