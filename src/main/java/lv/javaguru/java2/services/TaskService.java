package lv.javaguru.java2.services;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.hibernateORM.TaskDAOImpl;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

/**
 * Created by mike on 11/24/2015.
 */
//@Component
//@Transactional
public class TaskService {
    @Autowired
    @Qualifier("TaskDAO_ORM")
    private TaskDAOImpl userTaskDAO;

    public MVCModel executeRequest(HttpServletRequest request) throws DBException {
        String taskString = searchButtonName(request);
        if (!taskString.isEmpty()){
        String taskFunction = getTaskFunction(taskString);
        Long taskId = getTaskId(taskString);
            if(taskFunction.equals("delete")){
                userTaskDAO.deleteTaskByID(taskId);
                return new MVCModel("Refresh Task List", "/task_management.jsp");
            }
            else if(taskFunction.equals("edit__")) {
                userTaskDAO.deleteTaskByID(taskId);
                return new MVCModel("Edit Task", "/taskEdit.jsp");
            }
            else if(taskFunction.equals("cancel")) {
                userTaskDAO.deleteTaskByID(taskId);
                return new MVCModel("Edit Task", "/task_management.jsp");
            }
        }
        return new MVCModel("Refresh Task List", "/task_management.jsp");
    }
    public List<Task> getAllUserTasks(User user) throws DBException {
        return userTaskDAO.getAllUserTasks(user);
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
