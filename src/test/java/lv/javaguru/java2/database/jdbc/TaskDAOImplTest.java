package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.services.TimeService;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.Task;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class TaskDAOImplTest {

    private DatabaseCleaner databaseCleaner = new DatabaseCleaner();
    java.sql.Timestamp sqlTimestamp = new TimeService().getSqlTimestamp();

    private TaskDAOImpl userTaskDAO = new TaskDAOImpl();
    private UserDAOImpl userDAO = new UserDAOImpl();


    @Before
    public void init() throws DBException {
        databaseCleaner.cleanDatabase();
    }

    @Test
    public void testCreate() throws DBException {
        Date date = new Date();
        Task task = new Task();
        User user1 = new User("2@com", "p2", "n2", "U");
        User user2 = new User("3@com", "p3", "n3", "U");
        userDAO.createUser(user1);
        userDAO.createUser(user2);
        Long userId = user2.getId();
        task = createUserTask(userId, "Health", 5, "Description1", "Y", "N");
        userTaskDAO.createTask(task);

        Task taskFromDB = userTaskDAO.getTaskById(task.getId());
        assertNotNull(taskFromDB);
        assertEquals(task.getId(), taskFromDB.getId());
        assertEquals(task.getUserID(), taskFromDB.getUserID());
        assertEquals(task.getStatDescription(), taskFromDB.getStatDescription());
    }

    @Test
     public void testMultipleTaskCreation() throws DBException {
        User user1 = new User("2@com", "p2", "n2", "U");
        User user2 = new User("3@com", "p3", "n3", "U");
        userDAO.createUser(user1);
        userDAO.createUser(user2);
        Long userId1 = user1.getId();
        Long userId2 = user2.getId();
        Task task1 = createUserTask(userId1, "Health", 5, "Description1", "Y", "N");
        Task task2 = createUserTask(userId1, "Health", 4, "Description2", "Y", "N");
        Task task3 = createUserTask(userId2, "Health", 6, "Description3", "Y", "N");
        userTaskDAO.createTask(task1);
        userTaskDAO.createTask(task2);
        userTaskDAO.createTask(task3);
        List<Task> usersTasks = userTaskDAO.getAllUserTasks(user1);
        assertEquals(2, usersTasks.size());
    }
    @Test
    public void testDeleteUserTask() throws DBException {
        User user1 = new User("4", "p4", "n4", "U");
        User user2 = new User("5", "p5", "n5", "U");

        userDAO.createUser(user1);
        userDAO.createUser(user2);
        Long userId1 = user1.getId();
        Long userId2 = user2.getId();
        Task task1 = createUserTask(userId1, "Health", 3, "Description1", "Y", "N");
        Task task2 = createUserTask(userId1, "Health", 4, "Description2", "Y", "N");
        Task task3 = createUserTask(userId1, "Health", 5, "Description3", "Y", "N");
        Task task4 = createUserTask(userId1, "Health", 6, "Description4", "Y", "N");
        userTaskDAO.createTask(task1);
        userTaskDAO.createTask(task2);
        userTaskDAO.createTask(task3);
        userTaskDAO.createTask(task4);

        List<Task> tasks = userTaskDAO.getAllUserTasks(user1);
        assertEquals(4, tasks.size());
        userTaskDAO.deleteTaskByID(task2.getId());
        tasks = userTaskDAO.getAllUserTasks(user1);
        assertEquals(3, tasks.size());
    }

    private Task createUserTask(Long userId, String statType, int statValue, String statDescription,
                                    String repeatableYN, String accomplishedYN) {
    Task task = new Task();

        task.setUserID(userId);
        task.setStatType(statType);
        task.setStatValue(statValue);
        task.setStatDescription(statDescription);
        task.setRepeatableYN(repeatableYN);
        task.setAccomplishedYN(accomplishedYN);
        task.setDateAdded(sqlTimestamp);
        task.setDateAccomplished(sqlTimestamp);
        return task;
    }
}