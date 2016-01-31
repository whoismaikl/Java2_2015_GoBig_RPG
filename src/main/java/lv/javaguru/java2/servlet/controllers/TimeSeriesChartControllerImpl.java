package lv.javaguru.java2.servlet.controllers;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.HistoryRecordDAO;
import lv.javaguru.java2.domain.HistoryRecord;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by AST on 2015.11.03..
 */
@Controller
public class TimeSeriesChartControllerImpl {
    @Autowired
    private ChartService chartService;
    @Autowired
    HistoryRecordDAO historyRecordDAO;

    @ResponseBody
    @RequestMapping(value = "/getTaskStatisticChart", method = {RequestMethod.GET}, produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] execute(HttpServletRequest request, HttpServletResponse response) throws IOException, DBException {
        HttpSession session = request.getSession();
        final User user = (User) session.getAttribute("user");
        Date startDate = (Date) session.getAttribute("startDate");
        Date stopDate = (Date) session.getAttribute("stopDate");

        List<HistoryRecord> historyRecordListInRange = historyRecordDAO.getHistoryRecordsInRange(user, startDate, stopDate);

        byte[] byteArray = chartService.createTimeSeriesChart(historyRecordListInRange);
        return byteArray;
    }
}
