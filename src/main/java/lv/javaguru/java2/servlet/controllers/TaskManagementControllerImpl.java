package lv.javaguru.java2.servlet.controllers;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.TaskDAO;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.services.ButtonFunctionService;
import lv.javaguru.java2.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by AST on 2015.11.03..
 */
@Controller
public class TaskManagementControllerImpl{
    @Autowired
    @Qualifier("TaskDAO_ORM")
    private TaskDAO taskDAO;
    @Autowired
    private SessionService sessionService;
    @Autowired
    private ButtonFunctionService buttonFunctionService;

    @RequestMapping(value = "/taskManagement", method = {RequestMethod.POST})
    public ModelAndView execute(HttpServletRequest request) throws DBException, IOException {

        String buttonName = buttonFunctionService.getButtonName(request);

        if (!buttonName.isEmpty()) {

            String buttonFunction = buttonFunctionService.getButtonFunction(buttonName);
            Long taskId = buttonFunctionService.getId(buttonName);

            if (buttonFunction.equals("delete")) {
                taskDAO.deleteTaskByID(taskId);
                sessionService.updateSessionVariables(request);
                return new ModelAndView("/taskManagement.jsp","model", "Refresh Task List");
            }
            else if (buttonFunction.equals("edit__")) {
                Task taskForEdit = taskDAO.getTaskById(taskId);
                HttpSession session = request.getSession();
                session.setAttribute("taskForEdit", taskForEdit);
                return new ModelAndView("/editTask.jsp","model","Edit Task");
            }

        }
        return new ModelAndView("/taskManagement.jsp","model", "Button not active");
    }
}
