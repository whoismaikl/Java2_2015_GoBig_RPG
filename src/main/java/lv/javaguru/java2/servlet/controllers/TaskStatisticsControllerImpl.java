package lv.javaguru.java2.servlet.controllers;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.HistoryRecordDAO;
import lv.javaguru.java2.domain.HistoryRecord;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.TimeSeriesChart_image;
import lv.javaguru.java2.services.TimeService;
import lv.javaguru.java2.servlet.controllers.controllerInterfaces.TaskStatisticsController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by AST on 2015.11.03..
 */
@Component
public class TaskStatisticsControllerImpl implements TaskStatisticsController {
    @Autowired
    private TimeSeriesChart_image timeSeriesChart_image;
    @Autowired
    HistoryRecordDAO historyRecordDAO;
    @Autowired
    TimeService timeService;

    public MVCModel execute(HttpServletRequest request) throws DBException, IOException {

        HttpSession session = request.getSession();
        final User user = (User) session.getAttribute("user");
        Date stopDate = timeService.getSqlTimestamp();
        Date startDate = timeService.getChangedDate(stopDate, -30);
        List<HistoryRecord> historyRecordListInRange = historyRecordDAO.getHistoryRecordsInRange(user, startDate, stopDate);

        timeSeriesChart_image.createChart(historyRecordListInRange);

        return  new MVCModel("Task Statistics", "/taskStatisticChart.jsp");
    }

}
