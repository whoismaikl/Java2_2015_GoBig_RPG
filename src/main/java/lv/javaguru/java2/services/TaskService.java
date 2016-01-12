package lv.javaguru.java2.services;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.TaskDAO;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by mike on 11/24/2015.
 */
@Component
public class TaskService {
    @Autowired
    ButtonFunctionService buttonFunctionService;
    @Autowired
    @Qualifier("TaskDAO_ORM")
    private TaskDAO taskDAO;

    public MVCModel executeRequest(HttpServletRequest request) throws DBException {
        String taskString = buttonFunctionService.searchButtonName(request);
        if (!taskString.isEmpty()){
            String taskFunction = buttonFunctionService.getTaskFunction(taskString);
            Long taskId = buttonFunctionService.getId(taskString);
            if(taskFunction.equals("delete")){
                taskDAO.deleteTaskByID(taskId);
                return new MVCModel("Refresh Task List", "/taskManagement.jsp");
            }
            else if(taskFunction.equals("edit__")) {
                HttpSession session = request.getSession();
                Task taskForEdit = taskDAO.getTaskById(taskId);
                session.setAttribute("taskForEdit", taskForEdit);
                return new MVCModel("Edit Task", "/editTask.jsp");
            }
            else if(taskFunction.equals("cancel")) {
                return new MVCModel("Cancel Task Edit", "/taskManagement.jsp");
            }
            else if(taskFunction.equals("accompl")) {
                HttpSession session = request.getSession();
                Task taskForEdit = taskDAO.getTaskById(taskId);
                session.setAttribute("taskForEdit", taskForEdit);
                return new MVCModel("Accomplish Task", "/activeTask.jsp");
            }
        }
        return new MVCModel("Refresh Task List", "/taskManagement.jsp");
    }
}
