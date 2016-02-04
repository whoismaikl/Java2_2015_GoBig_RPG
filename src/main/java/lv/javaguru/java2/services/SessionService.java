package lv.javaguru.java2.services;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.HistoryRecordDAO;
import lv.javaguru.java2.database.TaskDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.HistoryRecord;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by mike on 11/24/2015.
 */
@Component
public class SessionService {
    private final int INITIAL_OFFSET_IN_DAYS = 14;
    @Autowired
    @Qualifier("UserDAO_ORM")
    private UserDAO userDAO;
    @Autowired
    @Qualifier("TaskDAO_ORM")
    private TaskDAO taskDAO;
    @Autowired
    @Qualifier("HistoryDAO_ORM")
    private HistoryRecordDAO historyRecordDAO;
    @Autowired
    TimeService timeService;
    @Autowired
    ChartService chartService;

    public void updateSessionVariables(HttpServletRequest request) throws DBException, IOException {
        HttpSession session = request.getSession();
        User userFromSession = (User) session.getAttribute("user");
        Long userId = userFromSession.getId();

        User user = userDAO.getUserById(userId);
        session.setAttribute("user", user);

        List<Task> taskList = taskDAO.getAllUserTasks(user);
        session.setAttribute("taskList", taskList);

        List<Task> activeTaskList = taskDAO.getActiveTaskList(user);
        session.setAttribute("activeTaskList", activeTaskList);

        List<Task> accomplishedTaskList = taskDAO.getAccomplishedTaskList(user);
        session.setAttribute("accomplishedTaskList", accomplishedTaskList);

    }


    public void initiateSessionVariables(HttpServletRequest request) throws ParseException, DBException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        java.sql.Timestamp stopDate = timeService.getEndOfDateTimestamp();
        String formattedStopDate = new SimpleDateFormat("yyyy-MM-dd").format(stopDate);

        java.sql.Timestamp lastLogin = user.getLastLogin();
        String formattedLastLogin = new SimpleDateFormat("yyyy-MM-dd").format(lastLogin);

        if(!formattedLastLogin.equals(formattedStopDate)) {
            List<Task> taskList = user.getTaskList();
            for (Task task : taskList) {
                task.setAccomplishedYN("N");
            }
            user.setLastLogin(stopDate);
            userDAO.updateUserData(user);
        }

        java.sql.Timestamp startDate = timeService.subtractDays(stopDate, INITIAL_OFFSET_IN_DAYS);
        session.setAttribute("formattedDateToday", formattedStopDate);
        session.setAttribute("startDate", startDate);
        session.setAttribute("stopDate", stopDate);
        session.setAttribute("user", user);

        List<Task> taskList = taskDAO.getAllUserTasks(user);
        session.setAttribute("taskList", taskList);

        List<Task> activeTaskList = taskDAO.getActiveTaskList(user);
        session.setAttribute("activeTaskList", activeTaskList);

        List<Task> accomplishedTaskList = taskDAO.getAccomplishedTaskList(user);
        session.setAttribute("accomplishedTaskList", accomplishedTaskList);

        List<HistoryRecord> historyRecordList = historyRecordDAO.getAllHistoryRecords(user);
        session.setAttribute("historyRecordList", historyRecordList);

        List<HistoryRecord> historyRecordsInRange = historyRecordDAO.getHistoryRecordsInRange(user, startDate, stopDate);
        session.setAttribute("historyRecordsInRange", historyRecordsInRange);

        chartService.createBarChart(user);

        chartService.createTimeSeriesChart(historyRecordsInRange);
    }
}
