package lv.javaguru.java2.servlet.controllers;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.TaskDAOImpl;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.servlet.controllers.controllerInterfaces.AccomplishTaskController;
import lv.javaguru.java2.servlet.controllers.controllerInterfaces.TaskManagementController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by AST on 2015.11.03..
 */
@Component
public class AccomplishTaskControllerImpl implements AccomplishTaskController {
    @Autowired
    private TaskDAOImpl userTaskDAO;

    public MVCModel execute(HttpServletRequest request) throws DBException {

        return  new MVCModel("Accomplish Task", "/accomplish_task.jsp");
    }

}
