package lv.javaguru.java2.services;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.HistoryDAO;
import lv.javaguru.java2.database.TaskDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.History;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    private HistoryDAO historyDAO;

    public void updateSession(HttpServletRequest request) throws DBException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        List<Task> taskList = taskDAO.getAllUserTasks(user);
        session.setAttribute("taskList", taskList);

        List<History> historyList = historyDAO.getAllUserRecords(user);
        session.setAttribute("historyList", historyList);

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

    }
    java.sql.Timestamp sqlTimestamp = new TimestampService().getSqlTimestamp();
}
