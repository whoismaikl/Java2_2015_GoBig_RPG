package lv.javaguru.java2.database.jdbc;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.User;


public class UserDAOImplTest {

    private DatabaseCleaner databaseCleaner = new DatabaseCleaner();

    private UserDAOImpl userDAO = new UserDAOImpl();


    @Before
    public void init() throws DBException {
        databaseCleaner.cleanDatabase();
    }

    @Test
    public void testCreate() throws DBException {
        User user = new User("Bob", "Wilson", "Gotcha", "U");

        userDAO.create(user);

        User userFromDB = userDAO.getById(user.getId());
        assertNotNull(userFromDB);
        assertEquals(user.getId(), userFromDB.getId());
        assertEquals(user.getName(), userFromDB.getName());
        assertEquals(user.getSurname(), userFromDB.getSurname());
    }

    @Test
     public void testMultipleUserCreation() throws DBException {
        User user1 = new User("Ken", "Razor", "Gang", "U");
        User user2 = new User("Admin", "admin", "adm", "A");
        userDAO.create(user1);
        userDAO.create(user2);
        List<User> users = userDAO.getAll();
        assertEquals(2, users.size());
    }
    @Test
    public void testDeleteUser() throws DBException {
        User user1 = new User("N1", "S1", "Nik1", "U");
        User user2 = new User("N2", "S2", "Nik2", "A");
        User user3 = new User("N3", "S3", "Nik3", "U");
        User user4 = new User("N4", "S4", "Nik4", "A");
        userDAO.create(user1);
        userDAO.create(user2);
        userDAO.create(user3);
        userDAO.create(user4);
        List<User> users = userDAO.getAll();
        assertEquals(4, users.size());
        userDAO.delete(user2.getId());
        users = userDAO.getAll();
        assertEquals(3, users.size());
    }


/*
    private User createUser(String name, String surame) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return user;
    }
*/
}