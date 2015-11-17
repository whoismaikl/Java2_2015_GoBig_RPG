package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.UserTask;

import java.util.List;

/**
 * Created by Viktor on 01/07/2014.
 */
public interface UserTaskDAO {

    void createTask(UserTask userTask) throws DBException;

    void deleteTaskByID(Long id) throws DBException;

    //void updateit(Long id) throws DBException;

    UserTask getTaskById(Long id) throws DBException;

    List<UserTask> getAllUserTasks(User user) throws DBException;

    void editTask(UserTask userTask) throws DBException;

    void accomplishTask(Long id) throws DBException;

}
