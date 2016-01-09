package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.DefaultTask;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.domain.User;

import java.util.List;

/**
 * Created by Viktor on 01/07/2014.
 */
public interface DefaultTaskDAO {

    void createDefaultTask(DefaultTask task) throws DBException;

    void deleteDefaultTaskByID(Long id) throws DBException;

    DefaultTask getDefaultTaskById(Long id) throws DBException;

    List<DefaultTask> getDefaultTaskList() throws DBException;

    void editDefaultTask(DefaultTask defaultTask) throws DBException;

}
