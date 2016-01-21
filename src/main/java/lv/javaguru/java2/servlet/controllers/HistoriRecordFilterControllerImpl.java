package lv.javaguru.java2.servlet.controllers;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.HistoryRecordDAO;
import lv.javaguru.java2.domain.HistoryRecord;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.builders.HistoryRecordBuilder;
import lv.javaguru.java2.services.SessionUpdateService;
import lv.javaguru.java2.services.TimeService;
import lv.javaguru.java2.servlet.controllers.controllerInterfaces.HistoriRecordFilterController;
import lv.javaguru.java2.servlet.controllers.controllerInterfaces.TaskHistoryController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by AST on 2015.11.03..
 */
@Component
public class HistoriRecordFilterControllerImpl implements HistoriRecordFilterController {
    @Autowired
    private HistoryRecordBuilder historyRecordBuilder;
    @Autowired
    @Qualifier("HistoryDAO_ORM")
    private HistoryRecordDAO historyRecordDAO;
    @Autowired
    private SessionUpdateService sessionUpdateService;
    @Autowired
    private TimeService timeService;

    public MVCModel execute(HttpServletRequest request) throws DBException, IOException, ParseException {

        String startDateStr = request.getParameter("startDate");
        String stopDateStr = request.getParameter("stopDate");
        SimpleDateFormat fomater = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = fomater.parse(startDateStr);
        Date stopDate = fomater.parse(stopDateStr);

        HttpSession session = request.getSession();
        final User user = (User) session.getAttribute("user");
        List<HistoryRecord> historyRecordListInRange = historyRecordDAO.getHistoryRecordsInRange(user, startDate, stopDate);
        session.setAttribute("historyRecordListInRange", historyRecordListInRange);

        //sessionUpdateService.updateSessionVariables(request);

        return  new MVCModel("History Record Filter", "/taskHistory.jsp");
    }
}