package lv.javaguru.java2.database.hibernateORM;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.HistoryDAO;
import lv.javaguru.java2.domain.History;
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

    public void createRecord(History history) throws DBException {
        sessionFactory.getCurrentSession().persist(history);
    }

    @Override
    public void sendTaskToHistory(History history) throws DBException {

    }

    public List<History> getAllUserRecords(User user) throws DBException {
        Long userId  = user.getId();
        List<History> histories;
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(History.class);
        criteria.add(Restrictions.eq("userID", userId));
        histories = (List<History>)criteria.list();
        return histories;
    }

}
