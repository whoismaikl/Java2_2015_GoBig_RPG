package lv.javaguru.java2.database.hibernateORM;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.DefaultTaskDAO;
import lv.javaguru.java2.database.TaskDAO;
import lv.javaguru.java2.domain.DefaultTask;
import lv.javaguru.java2.domain.Task;
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
@Component("DefaultTaskDAO_ORM")
@Transactional
public class DefaultTaskDAOImpl implements DefaultTaskDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void createDefaultTask(DefaultTask task) throws DBException {
        sessionFactory.getCurrentSession().persist(task);
    }

    public DefaultTask getDefaultTaskById(Long id) throws DBException {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(DefaultTask.class);
        criteria.add(Restrictions.eq("id", id));
        return  (DefaultTask)criteria.uniqueResult();
    }
    public List<DefaultTask> getDefaultTaskList() throws DBException {
        List<DefaultTask> tasks;
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(DefaultTask.class);
        tasks = (List<DefaultTask>)criteria.list();
        return tasks;
    }

    public void deleteDefaultTaskByID(Long id) throws DBException {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(DefaultTask.class);
        criteria.add(Restrictions.eq("id", id));
        DefaultTask task = (DefaultTask)criteria.uniqueResult();
        sessionFactory.getCurrentSession().delete(task);

    }

    public void editDefaultTask(DefaultTask task) throws DBException {
        Long id = task.getId();
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(DefaultTask.class);
        criteria.add(Restrictions.eq("id", id));
        sessionFactory.getCurrentSession().update(task);
    }
}
