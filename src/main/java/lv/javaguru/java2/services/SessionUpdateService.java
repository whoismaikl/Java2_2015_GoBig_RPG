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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mike on 11/24/2015.
 */
@Component
public class SessionUpdateService {
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
    BarChart_image barChart_image;

    public void updateSession(HttpServletRequest request) throws DBException, IOException {
        HttpSession session = request.getSession();
        User userFromSession = (User) session.getAttribute("user");
        Long userId = userFromSession.getId();
        User user = userDAO.getUserById(userId);
        session.setAttribute("user", user);

        List<Task> taskList = taskDAO.getAllUserTasks(user);
        session.setAttribute("taskList", taskList);

        List<HistoryRecord> historyRecordList = historyRecordDAO.getAllHistoryRecords(user);
        session.setAttribute("historyList", historyRecordList);

        List<Task> activeTaskList= new ArrayList<Task>();
        List<Task> accomplishedTaskList= new ArrayList<Task>();
        for (Task task : taskList) {
            if(task.getAccomplishedYN().equals("N"))
                activeTaskList.add(task);
            else if(task.getAccomplishedYN().equals("Y"))
                accomplishedTaskList.add(task);
        }
        session.setAttribute("activeTaskList", activeTaskList);
        session.setAttribute("accomplishedTaskList", accomplishedTaskList);

        barChart_image.createBarChart(user);

    }
    java.sql.Timestamp sqlTimestamp = new TimeService().getSqlTimestamp();
}
