package lv.javaguru.java2.services;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.TaskDAO;
import lv.javaguru.java2.database.hibernateORM.TaskDAOImpl;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

/**
 * Created by mike on 11/24/2015.
 */
@Component
//@Transactional
public class TaskService {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    @Qualifier("TaskDAO_ORM")
    private TaskDAO taskDAO;

    public MVCModel executeRequest(HttpServletRequest request) throws DBException {
        String taskString = searchButtonName(request);
        if (!taskString.isEmpty()){
            String taskFunction = getTaskFunction(taskString);
            Long taskId = getTaskId(taskString);
            if(taskFunction.equals("delete")){
                taskDAO.deleteTaskByID(taskId);
                return new MVCModel("Refresh Task List", "/taskManagement.jsp");
            }
            else if(taskFunction.equals("edit__")) {
                HttpSession session = request.getSession();
                User user = (User) session.getAttribute("user");
                Task taskForEdit = taskDAO.getTaskById(taskId);
                session.setAttribute("taskForEdit", taskForEdit);
                return new MVCModel("Edit Task", "/editTask.jsp");
            }
            else if(taskFunction.equals("cancel")) {
                //taskDAO.deleteTaskByID(taskId);
                return new MVCModel("Cancel Task Edit", "/taskManagement.jsp");
            }
        }
        return new MVCModel("Refresh Task List", "/taskManagement.jsp");
    }
    public List<Task> getAllUserTasks(User user) throws DBException {
        return taskDAO.getAllUserTasks(user);
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
