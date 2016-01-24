package lv.javaguru.java2.servlet.controllers;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.TaskDAO;
import lv.javaguru.java2.domain.builders.TaskBuilder;
import lv.javaguru.java2.services.SessionService;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.services.TimeService;
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
public class CreateTaskControllerImpl {
    @Autowired
    @Qualifier("TaskDAO_ORM")
    private TaskDAO taskDAO;
    @Autowired
    private TaskBuilder taskBuilder;
    @Autowired
    private SessionService sessionService;
    @Autowired
    private TimeService timeService;

    @RequestMapping(value = "/createTask", method = {RequestMethod.POST})
    public ModelAndView execute(HttpServletRequest request) throws DBException, IOException {

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
                .withDateAdded(timeService.getSqlTimestamp())
                .build();

        taskDAO.createTask(task);

        sessionService.updateSessionVariables(request);

        return  new ModelAndView("/taskManagement.jsp", "model", "New Task");
    }
}
