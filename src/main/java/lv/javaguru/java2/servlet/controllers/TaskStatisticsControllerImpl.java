package lv.javaguru.java2.servlet.controllers;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.HistoryRecordDAO;
import lv.javaguru.java2.domain.HistoryRecord;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.ChartService;
import lv.javaguru.java2.services.TaskService;
import lv.javaguru.java2.services.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created by AST on 2015.11.03..
 */
@Controller
public class TaskStatisticsControllerImpl{
    @Autowired
    HistoryRecordDAO historyRecordDAO;
    @Autowired
    TimeService timeService;
    @Autowired
    TaskService taskService;

    @RequestMapping(value = "/taskStatistics", method = {RequestMethod.GET})
    public ModelAndView execute(HttpServletRequest request) throws DBException, IOException, ParseException {

        HttpSession session = request.getSession();
        final User user = (User) session.getAttribute("user");
        Date startDate = (Date) session.getAttribute("startDate");
        Date stopDate = (Date) session.getAttribute("stopDate");

        List<HistoryRecord> historyRecordListInRange = historyRecordDAO.getHistoryRecordsInRange(user, startDate, stopDate);

      if (historyRecordListInRange.size()>0){
          List<Integer> scoresAverage = taskService.getScoresAverage(historyRecordListInRange);

          List<HistoryRecord> historyRecordListToday = historyRecordDAO
                  .getHistoryRecordsInRange(user,
                          timeService.getStartOfDateTimestamp(),
                          timeService.getEndOfDateTimestamp());
          List<Integer> scoresToday = taskService.getScoresForDay(historyRecordListToday);

          session.setAttribute("scoresToday", scoresToday);
          session.setAttribute("scoresAverage", scoresAverage);

      }


        return  new ModelAndView("/taskStatisticChart.jsp","model", "Task Statistics");
    }

}
