package lv.javaguru.java2.servlet.controllers;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.HistoryRecordDAO;
import lv.javaguru.java2.domain.HistoryRecord;
import lv.javaguru.java2.domain.builders.HistoryRecordBuilder;
import lv.javaguru.java2.services.SessionService;
import lv.javaguru.java2.services.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by AST on 2015.11.03..
 */
@Controller
public class TaskHistoryRecordControllerImpl {

    @RequestMapping(value = "/taskHistory", method = {RequestMethod.GET})
    public ModelAndView execute(HttpServletRequest request) throws DBException, IOException {

        return  new ModelAndView("/taskHistory.jsp", "model", "History Record List");

    }
}