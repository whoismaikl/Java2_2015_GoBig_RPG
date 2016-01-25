package lv.javaguru.java2.servlet.controllers;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.HistoryRecordDAO;
import lv.javaguru.java2.domain.HistoryRecord;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.builders.HistoryRecordBuilder;
import lv.javaguru.java2.services.SessionService;
import lv.javaguru.java2.services.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by AST on 2015.11.03..
 */
@Controller
public class TaskHistoryRecordControllerImpl {
    @Autowired
    @Qualifier("HistoryDAO_ORM")
    private HistoryRecordDAO historyRecordDAO;

    @RequestMapping(value = "/taskHistory", method = {RequestMethod.GET})
    public ModelAndView execute(HttpServletRequest request) throws DBException, IOException {

        HttpSession session = request.getSession();
        final User user = (User) session.getAttribute("user");
        java.sql.Timestamp startDate = (Timestamp) session.getAttribute("startDate");
        java.sql.Timestamp stopDate = (Timestamp) session.getAttribute("stopDate");

        List<HistoryRecord> historyRecordListInRange = historyRecordDAO.getHistoryRecordsInRange(user, startDate, stopDate);
        session.setAttribute("historyRecordListInRange", historyRecordListInRange);

        return  new ModelAndView("/taskHistory.jsp", "model", "History Record List");

    }
}