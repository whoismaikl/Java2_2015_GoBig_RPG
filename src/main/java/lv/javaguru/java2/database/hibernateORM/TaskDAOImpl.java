package lv.javaguru.java2.database.hibernateORM;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.TaskDAO;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.domain.User;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AST on 2015.11.27..
 */
@Component("TaskDAO_ORM")
@Transactional
public class TaskDAOImpl implements TaskDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void createTask(Task task) throws DBException {
        sessionFactory.getCurrentSession().persist(task);
    }

    public Task getTaskById(Long id) throws DBException {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Task.class);
        criteria.add(Restrictions.eq("id", id));
        return  (Task)criteria.uniqueResult();
    }
    public List<Task> getAllUserTasks(User user) throws DBException {
        Long userId = user.getId();
        List<Task> tasks;
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Task.class);
        criteria.add(Restrictions.eq("userID", userId));
        tasks = (List<Task>) criteria.list();
        return tasks;
    }

    public List<Task> getActiveTaskList(User user) throws DBException {
        Long userId = user.getId();
        List<Task> tasks;
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Task.class);
        criteria.add(Restrictions.eq("userID", userId));
        criteria.add(Restrictions.eq("accomplishedYN", "N"));
        criteria.add(Restrictions.ne("repeatableYN", "No"));
        tasks = (List<Task>) criteria.list();
        return tasks;
    }

    public List<Task> getAccomplishedTaskList(User user) throws DBException {
        Long userId = user.getId();
        List<Task> tasks;
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Task.class);
        criteria.add(Restrictions.eq("userID", userId));
        criteria.add(Restrictions.eq("accomplishedYN", "Y"));
        tasks = (List<Task>) criteria.list();
        return tasks;
    }

    public void deleteTaskByID(Long id) throws DBException {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Task.class);
        criteria.add(Restrictions.eq("id", id));
        Task task = (Task)criteria.uniqueResult();
        sessionFactory.getCurrentSession().delete(task);

    }

    public void updateTask(Task task) throws DBException {

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Task.class);
        criteria.add(Restrictions.eq("id", task.getId()));
        sessionFactory.getCurrentSession().update(task);


    }

    public void accomplishTask(Long id) throws DBException {

    }
}
