package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.UserTask;

import java.util.List;

/**
 * Created by Viktor on 01/07/2014.
 */
public interface UserTaskDAO {

    void create(UserTask userTask) throws DBException;

    void delete(Long id) throws DBException;

    void update(UserTask userTask) throws DBException;

    UserTask getById(Long id) throws DBException;

    List<UserTask> getAll(User user) throws DBException;

}
