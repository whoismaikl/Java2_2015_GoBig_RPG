package lv.javaguru.java2.database.hibernateORM;

import lv.javaguru.java2.config.SpringConfig;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.HistoryRecordDAO;
import lv.javaguru.java2.database.TaskDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.jdbc.DatabaseCleaner;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.builders.HistoryRecordBuilder;
import lv.javaguru.java2.domain.builders.UserBuilder;
import lv.javaguru.java2.services.BarChart_image;
import lv.javaguru.java2.services.TimeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

import static org.junit.Assert.*;

//@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class ServiceTest {

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
    private UserBuilder userBuilder;
    @Autowired
    private HistoryRecordBuilder historyRecordBuilder;

    @Autowired
    BarChart_image barChart_image;

    private DatabaseCleaner databaseCleaner = new DatabaseCleaner();
    java.sql.Timestamp sqlTimestamp = new TimeService().getSqlTimestamp();

    @Before
    public void init() throws DBException {
        databaseCleaner.cleanDatabase();
    }

    @Test
    public void testBarChart() throws DBException, IOException {

        User user = userBuilder.buildUser()
                .withEmail("e")
                .withUserName("user101")
                .withPassword("p")
                .withUserType("U")
                .withHealth(39)
                .withIntellegence(18)
                .withCommunication(27)
                .build();
        userDAO.createUser(user);
        barChart_image.createBarChart(user);


        assertEquals(1, 1);
    }
}