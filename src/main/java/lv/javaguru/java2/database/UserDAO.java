package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.User;

import java.util.List;

/**
 * Created by Viktor on 01/07/2014.
 */
public interface UserDAO {

    public void createUser(User user) throws DBException;

    void deleteUser(Long id) throws DBException;

    void updateUserData(User user) throws DBException;

    User getUserById(Long id) throws DBException;

    List<User> getAllUsers() throws DBException;

    boolean getUserByMail(String mail) throws DBException;

    boolean getUserByName(String name) throws DBException;

    boolean checkLoginData(String email, String password) throws DBException;

    User getUserByLoginData(String email, String password) throws DBException;

    User getPasswordByMail(String email) throws DBException;

}
