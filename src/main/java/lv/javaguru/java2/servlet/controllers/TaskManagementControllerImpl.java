package lv.javaguru.java2.servlet.controllers;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.TaskDAO;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.services.ButtonFunctionService;
import lv.javaguru.java2.services.SessionUpdateService;
import lv.javaguru.java2.servlet.controllers.controllerInterfaces.TaskManagementController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by AST on 2015.11.03..
 */
@Component
public class TaskManagementControllerImpl implements TaskManagementController {
    @Autowired
    @Qualifier("TaskDAO_ORM")
    private TaskDAO taskDAO;
    @Autowired
    private SessionUpdateService sessionUpdateService;
    @Autowired
    private ButtonFunctionService buttonFunctionService;

    public MVCModel execute(HttpServletRequest request) throws DBException, IOException {

        String buttonName = buttonFunctionService.getButtonName(request);

        if (!buttonName.isEmpty()) {

            String buttonFunction = buttonFunctionService.getButtonFunction(buttonName);
            Long taskId = buttonFunctionService.getId(buttonName);

            if (buttonFunction.equals("delete")) {
                taskDAO.deleteTaskByID(taskId);
                sessionUpdateService.updateSessionVariables(request);
                return new MVCModel("Refresh Task List", "/taskManagement.jsp");
            } else if (buttonFunction.equals("edit__")) {
                Task taskForEdit = taskDAO.getTaskById(taskId);
                HttpSession session = request.getSession();
                session.setAttribute("taskForEdit", taskForEdit);
                return new MVCModel("Edit Task", "/editTask.jsp");
            }

        }
        return new MVCModel("Button not active", "/taskManagement.jsp");
    }
}
