package lv.javaguru.java2.servlet.controllers;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.HistoryRecordDAO;
import lv.javaguru.java2.database.TaskDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.HistoryRecord;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.ButtonFunctionService;
import lv.javaguru.java2.services.SessionService;
import lv.javaguru.java2.services.TaskService;
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
public class ActiveTasksControllerImpl {

    @RequestMapping(value = "/activeTasks", method = {RequestMethod.GET})
    public ModelAndView execute(HttpServletRequest request) {

        return new ModelAndView("/activeTasks.jsp", "model", "Active Tasks");

    }
}
