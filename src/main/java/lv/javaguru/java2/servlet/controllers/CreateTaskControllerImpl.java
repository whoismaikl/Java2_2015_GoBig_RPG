package lv.javaguru.java2.servlet.controllers;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.TaskDAO;
import lv.javaguru.java2.domain.History;
import lv.javaguru.java2.domain.builders.TaskBuilder;
import lv.javaguru.java2.services.CreateTaskService;
import lv.javaguru.java2.services.SessionUpdateService;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.services.TimestampService;
import lv.javaguru.java2.servlet.controllers.controllerInterfaces.TaskNewController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AST on 2015.11.03..
 */
@Component
public class CreateTaskControllerImpl implements TaskNewController{
    @Autowired
    @Qualifier("TaskDAO_ORM")
    private TaskDAO taskDAO;
    @Autowired
    private TaskBuilder taskBuilder;
    @Autowired
    private SessionUpdateService sessionUpdateService;
    @Autowired
    private TimestampService timestampService;

    public MVCModel execute(HttpServletRequest request) throws DBException, IOException {

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
                .withDateAdded(timestampService.getSqlTimestamp())
                .build();

        taskDAO.createTask(task);

        sessionUpdateService.updateSession(request);

        return  new MVCModel("New Task", "/taskManagement.jsp");
    }
}
