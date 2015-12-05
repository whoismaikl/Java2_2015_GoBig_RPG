package lv.javaguru.java2.services;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.RecordDAO;
import lv.javaguru.java2.database.TaskDAO;
import lv.javaguru.java2.domain.Record;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by mike on 11/24/2015.
 */
@Component
//@Transactional
public class TaskStatisticService {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    @Qualifier("RecordDAO_ORM")
    private RecordDAO recordDAO;


    public List<Record> getAllUserRecords(User user) throws DBException {
        return recordDAO.getAllUserRecords(user);
    }

    public String searchButtonName(final HttpServletRequest request) {
        String buttonName = "";
        Map<String, String[]> paramMap = request.getParameterMap();
        if (!paramMap.isEmpty()) {
            for (Map.Entry<String, String[]> entry : paramMap.entrySet()) {
                buttonName = entry.getKey();
            }
        }
        return buttonName;
    }
    public Long getTaskId(String buttonName){
        String taskId = buttonName.substring(6);
        return Long.valueOf(taskId);
    }
    public String getTaskFunction(String buttonName){
        return buttonName.substring(0,6);
    }
}
