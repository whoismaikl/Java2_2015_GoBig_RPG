package lv.javaguru.java2.database.hibernateORM;

import lv.javaguru.java2.config.SpringConfig;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.jdbc.DatabaseCleaner;
import lv.javaguru.java2.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class UserDAOImplTest {


    private DatabaseCleaner databaseCleaner = new DatabaseCleaner();

    @Autowired
    @Qualifier("UserDAO_ORM")
    private UserDAO userDAO;

    @Before
    public void init() throws DBException {
        databaseCleaner.cleanDatabase();
    }

    @Test
    public void testCreate() throws DBException {
        User user = new User("1@com", "p1", "n1", "U");

        userDAO.createUser(user);

        User userFromDB = userDAO.getUserById(user.getId());
        assertNotNull(userFromDB);
        assertEquals(user.getId(), userFromDB.getId());
        assertEquals(user.getEmail(), userFromDB.getEmail());
        assertEquals(user.getPassword(), userFromDB.getPassword());
    }

}