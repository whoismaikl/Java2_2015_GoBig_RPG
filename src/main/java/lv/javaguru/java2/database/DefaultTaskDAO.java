package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.domain.User;

import java.util.List;

/**
 * Created by Viktor on 01/07/2014.
 */
public interface DefaultTaskDAO {

    void createTask(Task task) throws DBException;

    void deleteTaskByID(Long id) throws DBException;

    //void updateit(Long id) throws DBException;

    Task getTaskById(Long id) throws DBException;

    List<Task> getAllUserTasks(User user) throws DBException;

    void editTask(Task task) throws DBException;

    void accomplishTask(Long id) throws DBException;

}
