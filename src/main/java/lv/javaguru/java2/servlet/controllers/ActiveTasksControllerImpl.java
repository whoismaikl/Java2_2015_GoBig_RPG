package lv.javaguru.java2.servlet.controllers;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.servlet.controllers.controllerInterfaces.ActiveTasksController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by AST on 2015.11.03..
 */
@Component
public class ActiveTasksControllerImpl implements ActiveTasksController {

    public MVCModel execute(HttpServletRequest request) throws DBException {

        return new MVCModel("Accomplish Task", "/activeTasks.jsp");
    }

}
