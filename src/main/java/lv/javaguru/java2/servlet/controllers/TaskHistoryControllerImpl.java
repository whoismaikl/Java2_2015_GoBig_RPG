package lv.javaguru.java2.servlet.controllers;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.HistoryRecordDAO;
import lv.javaguru.java2.domain.HistoryRecord;
import lv.javaguru.java2.domain.builders.HistoryRecordBuilder;
import lv.javaguru.java2.services.SessionUpdateService;
import lv.javaguru.java2.services.TimeService;
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
    private HistoryRecordBuilder historyRecordBuilder;
    @Autowired
    @Qualifier("HistoryDAO_ORM")
    private HistoryRecordDAO historyRecordDAO;
    @Autowired
    private SessionUpdateService sessionUpdateService;
    @Autowired
    private TimeService timeService;

    public MVCModel execute(HttpServletRequest request) throws DBException, IOException {

        int health = Integer.parseInt(request.getParameter("health"));
        int intelligence = Integer.parseInt(request.getParameter("intelligence"));
        int communication = Integer.parseInt(request.getParameter("communication"));
        int statValue = Integer.parseInt(request.getParameter("statValue"));
        //String dateCompleted = java.sql.Timestamp.parseTimestamp(request.getParameter("dateCompleted"));

        HistoryRecord historyRecord = historyRecordBuilder.buildHistoryRecord()
                .withHealth(health)
                .withIntelligence(intelligence)
                .withCommunication(communication)
                .withStatValue(statValue)
                .withDateCompleted(timeService.getSqlTimestamp())
                .build();

        historyRecordDAO.createHistoryRecord(historyRecord);

        sessionUpdateService.updateSessionVariables(request);

        return  new MVCModel("New Task", "/taskManagement.jsp");
    }
}