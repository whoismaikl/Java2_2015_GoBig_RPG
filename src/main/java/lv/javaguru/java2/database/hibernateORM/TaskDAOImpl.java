package lv.javaguru.java2.database.hibernateORM;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.TaskDAO;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.domain.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
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
        Long userId  = user.getId();
        List<Task> tasks;
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Task.class);
        criteria.add(Restrictions.eq("userID", userId));
        tasks = (List<Task>)criteria.list();
        return tasks;
    }

    public void deleteTaskByID(Long id) throws DBException {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Task.class);
        criteria.add(Restrictions.eq("id", id));
        Task task = (Task)criteria.uniqueResult();
        sessionFactory.getCurrentSession().delete(task);

    }

    public void editTask(Task task) throws DBException {
        Long id = task.getId();
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Task.class);
        criteria.add(Restrictions.eq("id", id));
        //Task taskFromDAO = (Task)criteria.uniqueResult();
        //taskFromDAO = task;
        sessionFactory.getCurrentSession().update(task);
    }

    public void accomplishTask(Long id) throws DBException {

    }

    // getAllUserTasks nado budet dodelat', tk v dannom QueryBudut pokazyvatsja vse taski i vypolnennye i nevypolnennye
    // ili dobavit' metod getActiveTasks where AccomplishedYN = N
    // i getCompltedTasks wgere AccomplishedYN = Y


}
