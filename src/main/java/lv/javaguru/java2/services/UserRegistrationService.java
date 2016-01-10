package lv.javaguru.java2.services;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.DefaultTaskDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.DefaultTask;
import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by JavaCourses on 2015.11.19..
 */
@Component
public class UserRegistrationService {
    @Autowired
    @Qualifier("UserDAO_JDBC")
    private UserDAO userDAO;

    @Autowired
    private CreateTaskService createTaskService;

    @Autowired
    @Qualifier("DefaultTaskDAO_ORM")
    private DefaultTaskDAO defaultTaskDAO;

    public User createUser(HttpServletRequest request) {
        String userName = request.getParameter("username");
        String email = request.getParameter("email");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        if (!userExist(email, userName) && passwordsMatch(password1, password2) && correctEmailSyntax(email)) {
            User user = new User(email, password1, userName, "U");
            try {
                userDAO.createUser(user);
            } catch (DBException e) {
                e.printStackTrace();
            }
            return user;
        } else {
            return null;
        }
    }

    public boolean userExist(String email, String username) {
        try {
            if (!userDAO.getUserByMail(email) && !userDAO.getUserByName(username)) {
                return false;
            } else {
                return true;
            }
        } catch (DBException e) {
            e.printStackTrace();
            return true;
        }
    }

    public boolean passwordsMatch(String password1, String password2) {
        if (password1.equals(password2) && !password1.equals(null) && !password1.equals("")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean correctEmailSyntax(String email) {
        // add string check for xxx@ccc.zz
        return true;
    }
    public void createDefaultTasks(){

    }

    public void addDefaultTasks(User user) throws DBException {
        Long userId = user.getId();
        String statDescription;
        int statValue;
        String statType;
        String repeatableYN;
        int repeatFrequencyDays;
        List<DefaultTask> defaultTaskList = defaultTaskDAO.getDefaultTaskList();
        for(DefaultTask defaultTask : defaultTaskList){
            statDescription = defaultTask.getStatDescription();
            statValue = defaultTask.getStatValue();
            statType = defaultTask.getStatType();
            repeatableYN = defaultTask.getRepeatableYN();
            repeatFrequencyDays = defaultTask.getRepeatFrequencyDays();
            createTaskService.createUserTask(userId,statType,statValue,statDescription,repeatableYN, repeatFrequencyDays, "N");
        }
    }
}