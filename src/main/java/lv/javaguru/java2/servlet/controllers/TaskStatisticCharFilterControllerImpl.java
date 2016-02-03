package lv.javaguru.java2.servlet.controllers;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.HistoryRecordDAO;
import lv.javaguru.java2.domain.HistoryRecord;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.ChartService;
import lv.javaguru.java2.services.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by AST on 2015.11.03..
 */
@Controller
public class TaskStatisticCharFilterControllerImpl {
    @Autowired
    TimeService timeService;

    @RequestMapping(value = "/statisticCharFilter", method = {RequestMethod.POST})
    public ModelAndView execute(HttpServletRequest request) throws DBException, IOException, ParseException {

        String startDateStr = request.getParameter("startDate");
        String stopDateStr = request.getParameter("stopDate");

        java.sql.Timestamp startDate = timeService.setStartOfDateTimestamp(startDateStr);
        java.sql.Timestamp stopDate = timeService.setEndOfDateTimestamp(stopDateStr);

        HttpSession session = request.getSession();
        session.setAttribute("startDate", startDate);
        session.setAttribute("stopDate", stopDate);

        return  new ModelAndView("redirect:/taskStatistics");
    }
}