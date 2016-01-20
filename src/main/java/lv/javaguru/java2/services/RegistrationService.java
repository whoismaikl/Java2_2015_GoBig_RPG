package lv.javaguru.java2.services;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.DefaultTaskDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.DefaultTask;
import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.List;

/**
 * Created by JavaCourses on 2015.11.19..
 */
@Component
public class RegistrationService {
    @Autowired
    @Qualifier("UserDAO_ORM")
    private UserDAO userDAO;

    @Autowired
    private CreateTaskService createTaskService;

    @Autowired
    @Qualifier("DefaultTaskDAO_ORM")
    private DefaultTaskDAO defaultTaskDAO;

    public User createUser(String email, String password1, String password2, String userName) {


        if (!userExist(email, userName) && passwordsMatches(password1, password2) && correctEmailSyntax(email)) {
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

    public boolean passwordsMatches(String password1, String password2) {
        if (password1.equals(password2) && !password1.equals(null) && !password1.equals("")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean correctEmailSyntax(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddress = new InternetAddress(email);
            emailAddress.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
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