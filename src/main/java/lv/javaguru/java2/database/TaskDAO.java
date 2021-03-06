package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.Task;

import java.util.List;

/**
 * Created by Viktor on 01/07/2014.
 */
public interface TaskDAO {

    void createTask(Task task) throws DBException;

    void deleteTaskByID(Long id) throws DBException;

    Task getTaskById(Long id) throws DBException;

    List<Task> getAllUserTasks(User user) throws DBException;

    List<Task> getActiveTaskList(User user) throws DBException;

    List<Task> getAccomplishedTaskList(User user) throws DBException;

    void updateTask(Task task) throws DBException;

    void accomplishTask(Long id) throws DBException;

}
