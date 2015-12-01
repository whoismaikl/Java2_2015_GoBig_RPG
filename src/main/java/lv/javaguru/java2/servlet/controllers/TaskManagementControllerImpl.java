package lv.javaguru.java2.servlet.controllers;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.TaskDAO;
import lv.javaguru.java2.database.jdbc.TaskDAOImpl;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.TaskService;
import lv.javaguru.java2.servlet.controllers.controllerInterfaces.TaskManagementController;
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
public class TaskManagementControllerImpl implements TaskManagementController {
    @Autowired
    @Qualifier("TaskDAO_ORM")
    private TaskDAO taskDAO;
    @Autowired
    private TaskService taskService;

    public MVCModel execute(HttpServletRequest request) throws DBException {
        MVCModel mvcModel = taskService.executeRequest(request);

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<Task> taskList = taskDAO.getAllUserTasks(user);
        session.setAttribute("taskList", taskList);

        return  mvcModel;
        // /new MVCModel("Refresh Task List", "/task_management.jsp");
    }
}