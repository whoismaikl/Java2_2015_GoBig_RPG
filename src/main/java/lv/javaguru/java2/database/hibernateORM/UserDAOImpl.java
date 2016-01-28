package lv.javaguru.java2.database.hibernateORM;

//import lv.javaguru.java2.database.DBException;
//import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by mike on 2015.11.26..
 */

@Component ("UserDAO_ORM")
@Transactional
public class UserDAOImpl implements UserDAO {


    @Autowired
    private SessionFactory sessionFactory;

    public void createUser(User user) throws DBException {
        sessionFactory.getCurrentSession().persist(user);
    }

    public User getUserById(Long id) throws DBException {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("id", id));
        return  (User) criteria.uniqueResult();
    }

    public void deleteUser(Long id) throws DBException {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("id", id));
        User user = (User)criteria.uniqueResult();
        sessionFactory.getCurrentSession().delete(user);

    }

    public void updateUserData(User user) throws DBException {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("id", user.getId()));
        sessionFactory.getCurrentSession().update(user);
    }


    public List<User> getAllUsers() throws DBException {
        List<User> users;
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        users = (List<User>)criteria.list();
        return users;
    }

    public boolean getUserByMail(String mail) throws DBException {
        return false;
    }

    public boolean getUserByName(String name) throws DBException {
        return false;
    }

    public boolean checkLoginData(String email, String password) throws DBException {
        return false;
    }

    public User getUserByLoginData(String email, String password) throws DBException {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("email", email));
        criteria.add(Restrictions.eq("password", password));
        return  (User) criteria.uniqueResult();
    }

    public User getPasswordByMail(String email) {

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("email", email));
        return (User) criteria.uniqueResult();
    }


}
