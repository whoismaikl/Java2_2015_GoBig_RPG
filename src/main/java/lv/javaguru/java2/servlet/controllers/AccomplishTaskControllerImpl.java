package lv.javaguru.java2.servlet.controllers;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.servlet.controllers.controllerInterfaces.AccomplishTaskController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by AST on 2015.11.03..
 */
@Component
public class AccomplishTaskControllerImpl implements AccomplishTaskController {

    public MVCModel execute(HttpServletRequest request) throws DBException {

        return  new MVCModel("Accomplish Task", "/accomplish_task.jsp");
    }

}
