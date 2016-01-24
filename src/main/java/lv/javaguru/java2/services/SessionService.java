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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mike on 11/24/2015.
 */
@Component
public class SessionService {
    private final int INITIAL_OFFSET_IN_DAYS = 30;
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

        List<HistoryRecord> historyRecordList = historyRecordDAO.getAllHistoryRecords(user);
        session.setAttribute("historyRecordList", historyRecordList);

    }


    public void initiateSessionVariables(HttpServletRequest request) throws ParseException, DBException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        java.sql.Timestamp dateToday = timeService.getSqlTimestamp();
        String formattedDateToday = new SimpleDateFormat("yyyy-MM-dd").format(dateToday);

        java.sql.Timestamp lastLogin = user.getLastLogin();
        String formattedLastLogin = new SimpleDateFormat("yyyy-MM-dd").format(lastLogin);

        if(!formattedLastLogin.equals(formattedDateToday)) {
            List<Task> taskList = user.getTaskList();
            for (Task task : taskList) {
                task.setAccomplishedYN("N");
            }
            user.setLastLogin(dateToday);
            userDAO.updateUserData(user);
        }

        Date startDate = timeService.subtractDays(dateToday, INITIAL_OFFSET_IN_DAYS);
        session.setAttribute("formattedDateToday", formattedDateToday);
        session.setAttribute("startDate", startDate);
        session.setAttribute("stopDate", dateToday);
        session.setAttribute("user", user);

        List<Task> taskList = taskDAO.getAllUserTasks(user);
        session.setAttribute("taskList", taskList);

        List<Task> activeTaskList = taskDAO.getActiveTaskList(user);
        session.setAttribute("activeTaskList", activeTaskList);

        List<Task> accomplishedTaskList = taskDAO.getAccomplishedTaskList(user);
        session.setAttribute("accomplishedTaskList", accomplishedTaskList);

        List<HistoryRecord> historyRecordList = historyRecordDAO.getAllHistoryRecords(user);
        session.setAttribute("historyRecordList", historyRecordList);
    }
}
