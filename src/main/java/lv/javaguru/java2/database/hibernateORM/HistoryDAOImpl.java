package lv.javaguru.java2.database.hibernateORM;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.HistoryDAO;
import lv.javaguru.java2.domain.Record;
import lv.javaguru.java2.domain.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by AST on 2015.11.27..
 */
@Component("RecordDAO_ORM")
@Transactional
public class HistoryDAOImpl implements HistoryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void createRecord(Record record) throws DBException {
        sessionFactory.getCurrentSession().persist(record);
    }

    public List<Record> getAllUserRecords(User user) throws DBException {
        Long userId  = user.getId();
        List<Record> records;
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Record.class);
        criteria.add(Restrictions.eq("userID", userId));
        records = (List<Record>)criteria.list();
        return records;
    }

}
