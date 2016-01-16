package lv.javaguru.java2.servlet.controllers;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.HistoryDAO;
import lv.javaguru.java2.domain.History;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.TimeSeriesChart_image;
import lv.javaguru.java2.servlet.controllers.controllerInterfaces.TaskStatisticsController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by AST on 2015.11.03..
 */
@Component
public class TaskStatisticsControllerImpl implements TaskStatisticsController {
    @Autowired
    @Qualifier("HistoryDAO_ORM")
    private HistoryDAO historyDAO;
    @Autowired
    private TimeSeriesChart_image timeSeriesChart_image;

    public MVCModel execute(HttpServletRequest request) throws DBException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<History> historyList = user.getHistoryList();
        session.setAttribute("recordList", historyList);
        timeSeriesChart_image.createChart(historyList);

        return  new MVCModel("Task Statistics", "/taskStatistics.jsp");
    }

}
