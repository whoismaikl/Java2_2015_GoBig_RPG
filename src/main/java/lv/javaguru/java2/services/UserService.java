package lv.javaguru.java2.services;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.DefaultTaskDAO;
import lv.javaguru.java2.database.TaskDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.DefaultTask;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.builders.TaskBuilder;
import lv.javaguru.java2.domain.builders.UserBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by mike on 2015.11.19..
 */
@Component
public class UserService {
    @Autowired
    @Qualifier("UserDAO_ORM")
    private UserDAO userDAO;
    @Autowired
    @Qualifier("TaskDAO_ORM")
    private TaskDAO taskDAO;
    @Autowired
    @Qualifier("DefaultTaskDAO_ORM")
    private DefaultTaskDAO defaultTaskDAO;
    @Autowired
    private TaskBuilder taskBuilder;
    @Autowired
    private UserBuilder userBuilder;
    @Autowired
    private TimeService timeService;

    public User createUser(String email, String password1, String password2, String userName) throws DBException {

        User user = userBuilder.buildUser()
                .withUserName(userName)
                .withEmail(email)
                .withPassword(password1)
                .withDateRegistered(timeService.getSqlTimestamp())
                .withLastLogin(timeService.getSqlTimestamp())
                .build();
        userDAO.createUser(user);
        return user;
    }

    public boolean userExist(String email ) {
        try {

            String useremail = userDAO.getUserByMail(email);
            if (useremail != "" && useremail != null) {
                return true;
            }

            return false;

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

    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }
/*/
    public boolean checkEmailExistence(String email){
        boolean result = false;
        try {
            if (userDAO.getUserByMail(email)){
                result = true;
            }
        } catch (DBException e) {

            e.printStackTrace();
            result = false;
        }
        return result;
    }
/*/


    public void addDefaultTasks(User user) throws DBException {
        Task task;
        List<DefaultTask> defaultTaskList = defaultTaskDAO.getDefaultTaskList();
        for (DefaultTask defaultTask : defaultTaskList) {
            task = taskBuilder.buildTask()
                    .withUserID(user.getId())
                    .withStatType(defaultTask.getStatType())
                    .withStatValue(defaultTask.getStatValue())
                    .withStatDescription(defaultTask.getStatDescription())
                    .withRepeatableYN(defaultTask.getRepeatableYN())
                    .withRepeatFrequencyDays(defaultTask.getRepeatFrequencyDays())
                    .withDateAdded(timeService.getSqlTimestamp())
                    .build();

            taskDAO.createTask(task);
        }
    }
}