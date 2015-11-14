package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.UserTask;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class UserTaskDAOImplTest {

    private DatabaseCleaner databaseCleaner = new DatabaseCleaner();
    Date date = new Date();

    private UserTaskDAOImpl userTaskDAO = new UserTaskDAOImpl();
    private UserDAOImpl userDAO = new UserDAOImpl();


    @Before
    public void init() throws DBException {
        databaseCleaner.cleanDatabase();
    }

    @Test
    public void testCreate() throws DBException {
        Date date = new Date();
        UserTask userTask = new UserTask();
        User user1 = new User("2@com", "p2", "n2", "U");
        User user2 = new User("3@com", "p3", "n3", "U");
        userDAO.create(user1);
        userDAO.create(user2);
        Long userId = user2.getId();
        userTask = createUserTask(userId, "Health", 5, "Description1", "Y", "N");
        userTaskDAO.create(userTask);

        UserTask userTaskFromDB = userTaskDAO.getById(userTask.getId());
        assertNotNull(userTaskFromDB);
        assertEquals(userTask.getId(), userTaskFromDB.getId());
        assertEquals(userTask.getUserID(), userTaskFromDB.getUserID());
        assertEquals(userTask.getStatDescription(), userTaskFromDB.getStatDescription());
    }

    @Test
     public void testMultipleTaskCreation() throws DBException {
        User user1 = new User("2@com", "p2", "n2", "U");
        User user2 = new User("3@com", "p3", "n3", "U");
        userDAO.create(user1);
        userDAO.create(user2);
        Long userId1 = user1.getId();
        Long userId2 = user2.getId();
        UserTask task1 = createUserTask(userId1, "Health", 5, "Description1", "Y", "N");
        UserTask task2 = createUserTask(userId1, "Health", 4, "Description2", "Y", "N");
        UserTask task3 = createUserTask(userId2, "Health", 6, "Description3", "Y", "N");
        userTaskDAO.create(task1);
        userTaskDAO.create(task2);
        userTaskDAO.create(task3);
        List<UserTask> usersTasks = userTaskDAO.getAll(user1);
        assertEquals(3, usersTasks.size());
    }
    @Test
    public void testDeleteUserTask() throws DBException {
        User user1 = new User("4", "p4", "n4", "U");
        User user2 = new User("5", "p5", "n5", "U");

        userDAO.create(user1);
        userDAO.create(user2);
        Long userId1 = user1.getId();
        Long userId2 = user2.getId();
        UserTask task1 = createUserTask(userId1, "Health", 3, "Description1", "Y", "N");
        UserTask task2 = createUserTask(userId1, "Health", 4, "Description2", "Y", "N");
        UserTask task3 = createUserTask(userId1, "Health", 5, "Description3", "Y", "N");
        UserTask task4 = createUserTask(userId1, "Health", 6, "Description4", "Y", "N");
        userTaskDAO.create(task1);
        userTaskDAO.create(task2);
        userTaskDAO.create(task3);
        userTaskDAO.create(task4);

        List<UserTask> userTasks = userTaskDAO.getAll(user1);
        assertEquals(4, userTasks.size());
        userTaskDAO.delete(task2.getId());
        userTasks = userTaskDAO.getAll(user1);
        assertEquals(3, userTasks.size());
    }

    private UserTask createUserTask(Long userId, String statType, int statValue, String statDescription,
                                    String repeatableYN, String accomplishedYN) {
    UserTask userTask = new UserTask();

        userTask.setUserID(userId);
        userTask.setStatType(statType);
        userTask.setStatValue(statValue);
        userTask.setStatDescription(statDescription);
        userTask.setRepeatableYN(repeatableYN);
        userTask.setAccomplishedYN(accomplishedYN);
        userTask.setDateAdded(date);
        userTask.setDateAccomplished(date);
        return userTask;
    }
}