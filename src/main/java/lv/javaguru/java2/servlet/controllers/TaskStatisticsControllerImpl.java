package lv.javaguru.java2.servlet.controllers;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.TaskDAO;
import lv.javaguru.java2.database.jdbc.TaskDAOImpl;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.servlet.controllers.controllerInterfaces.TaskStatisticsController;
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
public class TaskStatisticsControllerImpl implements TaskStatisticsController {
    @Autowired
    @Qualifier("TaskDAO_ORM")
    private TaskDAO taskDAO;

    public MVCModel execute(HttpServletRequest request) throws DBException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<Task> taskList = taskDAO.getAllUserTasks(user);
        session.setAttribute("taskList", taskList);

        return  new MVCModel("Task Statistics", "/task_statistics.jsp");
    }

}
