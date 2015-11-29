package lv.javaguru.java2.servlet.controllers;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.TaskDAOImpl;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.TaskService;
import lv.javaguru.java2.servlet.controllers.controllerInterfaces.MainController;
import lv.javaguru.java2.servlet.controllers.controllerInterfaces.TaskManagementController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

/**
 * Created by AST on 2015.11.03..
 */
@Component
public class TaskManagementControllerImpl implements TaskManagementController {
    @Autowired
   // @Qualifier("TaskDAO_ORM")
    private TaskDAOImpl userTaskDAO;
    //@Autowired
    //private TaskService taskService;

    public MVCModel execute(HttpServletRequest request) throws DBException {
        TaskService taskService = new TaskService();
        MVCModel mvcModel = taskService.executeRequest(request);

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<Task> tasks = userTaskDAO.getAllUserTasks(user);
        session.setAttribute("userTasks", tasks);

        return  mvcModel;
        // /new MVCModel("Refresh Task List", "/task_management.jsp");
    }
}
