package lv.javaguru.java2.services;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.TaskDAO;
import lv.javaguru.java2.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by mike on 11/24/2015.
 */
@Component
public class CreateTaskService {
    @Autowired
    @Qualifier("TaskDAO_ORM")
    private TaskDAO taskDAO;

    public void createUserTask(Long userId, String statType, int statValue, String statDescription,
                                String repeatableYN, int repeatFrequencyDays, String accomplishedYN) throws DBException {
        Task task = new Task();
        task.setUserID(userId);
        task.setStatType(statType);
        task.setStatValue(statValue);
        task.setStatDescription(statDescription);
        task.setRepeatableYN(repeatableYN);
        task.setRepeatFrequencyDays(repeatFrequencyDays);
        task.setAccomplishedYN(accomplishedYN);
        task.setDateAdded(sqlTimestamp);
        task.setDateAccomplished(sqlTimestamp);
        taskDAO.createTask(task);
    }
    java.sql.Timestamp sqlTimestamp = new TimeService().getSqlTimestamp();
}
