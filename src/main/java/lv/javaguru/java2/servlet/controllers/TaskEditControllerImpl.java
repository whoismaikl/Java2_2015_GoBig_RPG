package lv.javaguru.java2.servlet.controllers;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.TaskDAO;
import lv.javaguru.java2.database.jdbc.TaskDAOImpl;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.TaskService;
import lv.javaguru.java2.services.TimestampService;
import lv.javaguru.java2.servlet.controllers.controllerInterfaces.TaskEditController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by AST on 2015.11.03..
 */
@Component
public class TaskEditControllerImpl implements TaskEditController {
    @Autowired
    @Qualifier("TaskDAO_ORM")
    private TaskDAO taskDAO;
    @Autowired
    private TaskService taskService;

    public MVCModel execute(HttpServletRequest request) throws DBException {
            String statDescription = request.getParameter("statDescription");
            int statValue = Integer.parseInt(request.getParameter("statValue"));
            String statType = request.getParameter("statType");
            String repeatableYN = request.getParameter("repeatableYN");
            int repeatFrequencyDays = Integer.parseInt(request.getParameter("repeatFrequencyDays"));

            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");

            Task task = (Task) session.getAttribute("taskForEdit");
            task = editTask(task, user.getId(), statType, statValue, statDescription, repeatableYN, repeatFrequencyDays, "N");
            taskDAO.editTask(task);

            List<Task> taskList = taskDAO.getAllUserTasks(user);
            session.setAttribute("taskList", taskList);

            return new MVCModel("New Task", "/task_management.jsp");
        }

    private Task editTask(Task task, Long userId, String statType, int statValue, String statDescription,
                                String repeatableYN, int repeatFrequencyDays, String accomplishedYN) {
        task.setUserID(userId);
        task.setStatType(statType);
        task.setStatValue(statValue);
        task.setStatDescription(statDescription);
        task.setRepeatableYN(repeatableYN);
        task.setRepeatFrequencyDays(repeatFrequencyDays);
        task.setAccomplishedYN(accomplishedYN);
        return task;
    }

    java.sql.Timestamp sqlTimestamp = new TimestampService().getSqlTimestamp();
}
