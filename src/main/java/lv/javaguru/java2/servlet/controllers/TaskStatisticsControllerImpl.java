package lv.javaguru.java2.servlet.controllers;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.HistoryRecordDAO;
import lv.javaguru.java2.domain.HistoryRecord;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.ChartService;
import lv.javaguru.java2.services.TimeSeriesChart_image;
import lv.javaguru.java2.services.TimeService;
import lv.javaguru.java2.servlet.controllers.controllerInterfaces.TaskStatisticsController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by AST on 2015.11.03..
 */
@Controller
public class TaskStatisticsControllerImpl{
    @Autowired
    private ChartService chartService;
    @Autowired
    HistoryRecordDAO historyRecordDAO;
    @Autowired
    TimeService timeService;

    @RequestMapping(value = "/taskStatistics", method = {RequestMethod.GET})
    public ModelAndView execute(HttpServletRequest request) throws DBException, IOException {

        HttpSession session = request.getSession();
        final User user = (User) session.getAttribute("user");
        Date startDate = (Date) session.getAttribute("startDate");
        Date stopDate = (Date) session.getAttribute("stopDate");

        List<HistoryRecord> historyRecordListInRange = historyRecordDAO.getHistoryRecordsInRange(user, startDate, stopDate);

        chartService.createTimeSeriesChart(historyRecordListInRange);

        return  new ModelAndView("/taskStatisticChart.jsp","model", "Task Statistics");
    }

}
