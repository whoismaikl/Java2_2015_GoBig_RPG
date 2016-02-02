package lv.javaguru.java2.database.hibernateORM;

import lv.javaguru.java2.config.SpringConfig;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.HistoryRecordDAO;
import lv.javaguru.java2.database.TaskDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.jdbc.DatabaseCleaner;
import lv.javaguru.java2.domain.HistoryRecord;
import lv.javaguru.java2.domain.builders.HistoryRecordBuilder;
import lv.javaguru.java2.domain.builders.UserBuilder;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.services.TaskService;
import lv.javaguru.java2.services.TimeService;
import lv.javaguru.java2.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
//@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
@WebAppConfiguration
public class TaskDAOImplTest {

    @Autowired
    @Qualifier("TaskDAO_ORM")
    private TaskDAO taskDAO;

    @Autowired
    @Qualifier("HistoryDAO_ORM")
    private HistoryRecordDAO historyRecordDAO;

    @Autowired
    @Qualifier("UserDAO_ORM")
    private UserDAO userDAO;
    @Autowired
    private TaskService taskService;
    @Autowired
    private UserBuilder userBuilder;
    @Autowired
    private HistoryRecordBuilder historyRecordBuilder;

    private DatabaseCleaner databaseCleaner = new DatabaseCleaner();
    java.sql.Timestamp sqlTimestamp = new TimeService().getSqlTimestamp();

    @Before
    public void init() throws DBException {
        databaseCleaner.cleanDatabase();
    }

    @Test
    public void testCreate() throws DBException {
        java.sql.Timestamp sqlTimestamp = new TimeService().getSqlTimestamp();
        Task task = new Task();
        User user1 = new User("2@com", "p2", "n2", "U");
        User user2 = new User("3@com", "p3", "n3", "U");
        userDAO.createUser(user1);
        userDAO.createUser(user2);
        Long userId = user2.getId();
        task = createUserTask(userId, "Health", 5, "Description1", "Y", "N");
        taskDAO.createTask(task);

        Task taskFromDB = taskDAO.getTaskById(task.getId());
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
        taskDAO.createTask(task1);
        taskDAO.createTask(task2);
        taskDAO.createTask(task3);
        List<Task> usersTasks = taskDAO.getAllUserTasks(user1);
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
        taskDAO.createTask(task1);
        taskDAO.createTask(task2);
        taskDAO.createTask(task3);
        taskDAO.createTask(task4);

        List<Task> tasks = taskDAO.getAllUserTasks(user1);
        assertEquals(4, tasks.size());
        Long task2Id = task2.getId();
        taskDAO.deleteTaskByID(task2Id);
        tasks = taskDAO.getAllUserTasks(user1);
        assertEquals(3, tasks.size());
    }
    @Test
    public void testEditTask() throws DBException {
        User user1 = new User("2@com", "p2", "n2", "U");

        userDAO.createUser(user1);

        Long userId = user1.getId();
        Task task1 = createUserTask(userId, "Health1", 1, "Description1", "Y", "N");
        Task task2 = createUserTask(userId, "Health2", 2, "Description2", "N", "Y");
        taskDAO.createTask(task1);
        Long task1Id = task1.getId();
        Task taskBeforeEdit = taskDAO.getTaskById(task1Id);
        task2.setId(task1Id);
        taskDAO.updateTask(task2);
        Task taskAfterEdit = taskDAO.getTaskById(task1Id);

        assertNotEquals(taskBeforeEdit.getStatType(), taskAfterEdit.getStatType());
        assertNotEquals(taskBeforeEdit.getStatValue(), taskAfterEdit.getStatValue());
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

    @Test
    public void testOneToMany() throws DBException {

        User user1 = new User("2@com14", "p14", "n14", "U");
        User user2 = new User("3@com15", "p15", "n15", "U");
        userDAO.createUser(user1);
        userDAO.createUser(user2);
        Long userId1 = user1.getId();
        Long userId2 = user2.getId();
        Task task1 = createUserTask(userId1, "Health", 5, "Description1", "Y", "N");
        Task task2 = createUserTask(userId1, "Health", 4, "Description2", "Y", "N");
        Task task3 = createUserTask(userId2, "Health", 6, "Description3", "Y", "N");

        taskDAO.createTask(task1);
        taskDAO.createTask(task2);
        taskDAO.createTask(task3);
        User user3 = userDAO.getUserById(userId1);

        List<Task> taskList = user3.getTaskList();
        assertEquals(2, taskList.size());

    }
    @Test
    public void testDeleteUserTasksHistory() throws DBException {
        User user1 = new User("2@com14", "p14", "n14", "U");
        User user2 = new User("3@com15", "p15", "n15", "U");
        userDAO.createUser(user1);
        userDAO.createUser(user2);
        Long userId1 = user1.getId();
        Long userId2 = user2.getId();

        Task task1 = createUserTask(userId1, "Health", 5, "Description1", "Y", "N");
        Task task2 = createUserTask(userId1, "Health", 4, "Description2", "Y", "N");
        Task task3 = createUserTask(userId2, "Health", 6, "Description3", "Y", "N");
        Task task4 = createUserTask(userId2, "Health", 7, "Description4", "Y", "N");
        taskDAO.createTask(task1);
        taskDAO.createTask(task2);
        taskDAO.createTask(task3);
        taskDAO.createTask(task4);

        HistoryRecord historyRecord1 = taskService.buildHistoryRecord(user1, task1);
        historyRecordDAO.createHistoryRecord(historyRecord1);
        HistoryRecord historyRecord2 = taskService.buildHistoryRecord(user1, task2);
        historyRecordDAO.createHistoryRecord(historyRecord2);
        HistoryRecord historyRecord3 = taskService.buildHistoryRecord(user2, task3);
        historyRecordDAO.createHistoryRecord(historyRecord3);

        //userDAO.deleteUser(userId2);
        User user3 = userDAO.getUserById(userId1);


        List<HistoryRecord> historyRecordList = user3.getHistoryRecordList();
        assertEquals(2, historyRecordList.size());
        for(HistoryRecord historyRecord : historyRecordList) {
            historyRecordDAO.deleteHistoryRecordById(historyRecord.getId());
        }
        user3 = userDAO.getUserById(userId1);
        historyRecordList = user3.getHistoryRecordList();
        assertEquals(0, historyRecordList.size());
    }
    @Test
    public void testUpdateTasks() throws DBException {

        User user = userBuilder.buildUser()
                .withEmail("e")
                .withUserName("user101")
                .withPassword("p")
                .withUserType("U")
                .build();
        User user1 = new User("2@com14", "p14", "n14", "U");
        userDAO.createUser(user);
        userDAO.createUser(user1);
        Long userId1 = user1.getId();
        Task task1 = createUserTask(userId1, "Health", 5, "Description1", "Y", "N");
        Task task2 = createUserTask(userId1, "Health", 4, "Description2", "Y", "N");
        taskDAO.createTask(task1);
        taskDAO.createTask(task2);
        Long taskId1 = task1.getId();
        task1.setAccomplishedYN("Y");
        taskDAO.updateTask(task1);

    }
}