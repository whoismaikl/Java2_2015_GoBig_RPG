package lv.javaguru.java2.services;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.HistoryDAO;
import lv.javaguru.java2.domain.History;
import lv.javaguru.java2.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
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
    private HistoryDAO historyDAO;


    public List<History> getAllUserRecords(User user) throws DBException {
        return historyDAO.getAllUserRecords(user);
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
