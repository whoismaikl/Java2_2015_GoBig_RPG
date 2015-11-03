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
        User user = new User("1@com", "p1", "n1", "U");

        userDAO.create(user);

        User userFromDB = userDAO.getById(user.getId());
        assertNotNull(userFromDB);
        assertEquals(user.getId(), userFromDB.getId());
        assertEquals(user.getEmail(), userFromDB.getEmail());
        assertEquals(user.getPassword(), userFromDB.getPassword());
    }

    @Test
     public void testMultipleUserCreation() throws DBException {
        User user1 = new User("2@com", "p2", "n2", "U");
        User user2 = new User("3@com", "p3", "n3", "U");
        userDAO.create(user1);
        userDAO.create(user2);
        List<User> users = userDAO.getAll();
        assertEquals(2, users.size());
    }
    @Test
    public void testDeleteUser() throws DBException {
        User user1 = new User("4@com", "p4", "n4", "U");
        User user2 = new User("5@com", "p5", "n5", "U");
        User user3 = new User("6@com", "p6", "n6", "U");
        User user4 = new User("7@com", "p7", "n7", "U");
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