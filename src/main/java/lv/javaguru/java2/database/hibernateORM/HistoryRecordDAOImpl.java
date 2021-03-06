package lv.javaguru.java2.database.hibernateORM;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.HistoryRecordDAO;
import lv.javaguru.java2.domain.HistoryRecord;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.domain.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by AST on 2015.11.27..
 */
@Component("HistoryDAO_ORM")
@Transactional
public class HistoryRecordDAOImpl implements HistoryRecordDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void createHistoryRecord(HistoryRecord historyRecord) throws DBException {
        sessionFactory.getCurrentSession().persist(historyRecord);
    }


    public void sendTaskToHistory(HistoryRecord historyRecord) throws DBException {

    }

    public List<HistoryRecord> getAllHistoryRecords(User user) throws DBException {
        Long userId = user.getId();
        List<HistoryRecord> histories;
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(HistoryRecord.class);
        criteria.add(Restrictions.eq("userID", userId));
        histories = (List<HistoryRecord>) criteria.list();
        return histories;
    }

    public void deleteHistoryRecordById(Long historyRecordId) throws DBException {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(HistoryRecord.class);
        criteria.add(Restrictions.eq("id", historyRecordId));
        HistoryRecord historyRecord = (HistoryRecord)criteria.uniqueResult();
        sessionFactory.getCurrentSession().delete(historyRecord);
    }

    public void deleteAllHistoryRecordByUserId(Long userId) throws DBException {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(HistoryRecord.class);
        criteria.add(Restrictions.eq("userID", userId));
        List<HistoryRecord> histories = (List<HistoryRecord>) criteria.list();

        for (int i = 0; i < histories.size(); i++) {
            sessionFactory.getCurrentSession().delete(histories.get(i));
        }
    }

    public List<HistoryRecord> getHistoryRecordsInRange(User user, Date startDate, Date stopDate) throws DBException{
        Long userId = user.getId();
        List<HistoryRecord> histories;
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(HistoryRecord.class);
        criteria.add(Restrictions.eq("userID", userId));
        criteria.add(Restrictions.between("dateCompleted", startDate, stopDate));
        histories = (List<HistoryRecord>) criteria.list();
        return histories;
    }
}
