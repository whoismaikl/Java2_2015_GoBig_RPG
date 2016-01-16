package lv.javaguru.java2.servlet.controllers;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.TaskDAO;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.builders.TaskBuilder;
import lv.javaguru.java2.services.ButtonFunctionService;
import lv.javaguru.java2.services.SessionUpdateService;
import lv.javaguru.java2.servlet.controllers.controllerInterfaces.EditTaskController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by AST on 2015.11.03..
 */
@Component
public class EditTaskControllerImpl implements EditTaskController {
    @Autowired
    @Qualifier("TaskDAO_ORM")
    private TaskDAO taskDAO;
    @Autowired
    private TaskBuilder taskBuilder;
    @Autowired
    private SessionUpdateService sessionUpdateService;
    @Autowired
    private ButtonFunctionService buttonFunctionService;


    public MVCModel execute(HttpServletRequest request) throws DBException {

        String buttonName = buttonFunctionService.getButtonName(request);

        if (!buttonName.isEmpty()) {

            String buttonFunction = buttonFunctionService.getButtonFunction(buttonName);
            Long taskId = buttonFunctionService.getId(buttonName);

            String statType = request.getParameter("statType");
            int statValue = Integer.parseInt(request.getParameter("statValue"));
            String statDescription = request.getParameter("statDescription");
            String repeatableYN = request.getParameter("repeatableYN");
            int repeatFrequencyDays = Integer.parseInt(request.getParameter("repeatFrequencyDays"));

            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");

            Task task = taskBuilder.buildTask()
                    .withUserID(user.getId())
                    .withStatType(statType)
                    .withStatValue(statValue)
                    .withStatDescription(statDescription)
                    .withRepeatableYN(repeatableYN)
                    .withRepeatFrequencyDays(repeatFrequencyDays)
                    .build();

            if (buttonFunction.equals("save__")) {
                taskDAO.editTask(taskId, task);
                sessionUpdateService.updateSession(request);
                return new MVCModel("Edit Task", "/taskManagement.jsp");
            } else if (buttonFunction.equals("cancel")) {
                sessionUpdateService.updateSession(request);
                return new MVCModel("Cancel Task Edit", "/taskManagement.jsp");
            }
        }
        return new MVCModel("Button not active", "/taskManagement.jsp");
    }
}
