package lv.javaguru.java2.services;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;
import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by JavaCourses on 2015.11.19..
 */
@Component
public class RegistrationService {
    @Autowired
    private UserDAOImpl userDAO;


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


    public boolean correctEmailSyntax() {
        return true;
    }
    public User createUser(){

      User user = new User(email, password1, username, "U");


    userDAO.createUser(user);


}
