package lv.javaguru.java2.services;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by JavaCourses on 2015.11.19..
 */
@Component
public class RegistrationService {
    @Autowired
    @Qualifier("UserDAO_JDBC")
    private UserDAO userDAO;


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
//
    public User createUser(String email, String password1, String password2, String userName) {

        if (!userExist(email, userName) && passwordsMatch(password1, password2) && correctEmailSyntax(email)) {
            Optional user1 = Optional.empty();
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

}