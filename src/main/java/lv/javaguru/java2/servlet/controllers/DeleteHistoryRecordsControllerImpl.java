package lv.javaguru.java2.servlet.controllers;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.HistoryRecordDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.ButtonFunctionService;
import lv.javaguru.java2.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by mike on 2015.11.03..
 */
@Controller
public class DeleteHistoryRecordsControllerImpl {
    @Autowired
    @Qualifier("HistoryDAO_ORM")
    private HistoryRecordDAO historyRecordDAO;
    @Autowired
    SessionService sessionService;

    @RequestMapping(value = "/deleteAllHistoryRecords", method = {RequestMethod.POST})
    public ModelAndView execute(HttpServletRequest request) throws DBException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Long userId = user.getId();

        historyRecordDAO.deleteAllHistoryRecordByUserId(userId);

        sessionService.updateSessionVariables(request);


        return new ModelAndView("/taskHistory.jsp", "model", "All History Record Deleted");
    }
}
