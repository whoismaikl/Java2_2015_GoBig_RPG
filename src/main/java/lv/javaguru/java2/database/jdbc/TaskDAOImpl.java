package lv.javaguru.java2.database.jdbc;

import java.util.Date;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.TaskDAO;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.Task;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component("TaskDAO_JDBC")
public class TaskDAOImpl extends DAOImpl implements TaskDAO {

    public void createTask(Task task) throws DBException {
        if (task == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO tasks VALUES (0, ?, ?, ?, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, task.getUserID());
            preparedStatement.setString(2, task.getStatType());
            preparedStatement.setInt(3, task.getStatValue());
            preparedStatement.setString(4, task.getStatDescription());
            preparedStatement.setString(5, task.getRepeatableYN());
            preparedStatement.setInt(6, task.getStatValue());
            preparedStatement.setString(7, task.getAccomplishedYN());
            preparedStatement.setTimestamp(8, new Timestamp(task.getDateAdded().getTime()));
            preparedStatement.setTimestamp(9, new Timestamp(task.getDateAccomplished().getTime()));
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                task.setId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute UserTaskDAOImpl.createUser()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

    }

    public Task getTaskById(Long id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM tasks WHERE id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Task task = null;
            if (resultSet.next()) {
                task = new Task();
                task.setId(resultSet.getLong("id"));
                task.setUserID(resultSet.getLong("userID"));
                task.setStatType(resultSet.getString("statType"));
                task.setStatValue(resultSet.getInt("statValue"));
                task.setStatDescription(resultSet.getString("statDescription"));
                task.setRepeatableYN(resultSet.getString("repeatableYN"));
                task.setStatValue(resultSet.getInt("repeatFrequencyDays"));
                task.setAccomplishedYN(resultSet.getString("accomplishedYN"));
                task.setDateAdded(resultSet.getTimestamp("dateAdded"));
                task.setDateAccomplished(resultSet.getTimestamp("dateAccomplished"));
            }
            return task;
        } catch (Throwable e) {
            System.out.println("Exception while execute UserTaskDAOImpl.getUserById()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }
    // getAllUserTasks nado budet dodelat', tk v dannom QueryBudut pokazyvatsja vse taski i vypolnennye i nevypolnennye
    // ili dobavit' metod getActiveTasks where AccomplishedYN = N
    // i getCompltedTasks wgere AccomplishedYN = Y
    public List<Task> getAllUserTasks(User user) throws DBException {
        List<Task> tasks = new ArrayList<Task>();
        Connection connection = null;
        Long userId1 = user.getId();

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM tasks WHERE userID="
                    + userId1);

            ResultSet resultSet = preparedStatement.executeQuery();
            Task task;
            while (resultSet.next()) {
                task = new Task();
                task.setId(resultSet.getLong("id"));
                task.setUserID(resultSet.getLong("userID"));
                task.setStatType(resultSet.getString("statType"));
                task.setStatValue(resultSet.getInt("statValue"));
                task.setStatDescription(resultSet.getString("statDescription"));
                task.setRepeatableYN(resultSet.getString("repeatableYN"));
                task.setStatValue(resultSet.getInt("repeatFrequencyDays"));
                task.setAccomplishedYN(resultSet.getString("accomplishedYN"));
                task.setDateAdded(resultSet.getTimestamp("dateAdded"));
                task.setDateAccomplished(resultSet.getTimestamp("dateAccomplished"));
                tasks.add(task);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list UserTaskDAOImpl.getList()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return tasks;
    }

    public void deleteTaskByID(Long id) throws DBException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM tasks WHERE id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.deleteUser()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public void editTask(Task task) throws DBException {
        if (task == null) {
            return;
        }
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE tasks SET statType = ?, statValue = ?, statDescription = ?, repeatableYN = ?, dateAdded = ?" + "WHERE id = ?");
            preparedStatement.setString(1, task.getStatType());
            preparedStatement.setInt(2, task.getStatValue());
            preparedStatement.setString(3, task.getStatDescription());
            preparedStatement.setString(4, task.getRepeatableYN());
            preparedStatement.setTimestamp(5, new Timestamp(task.getDateAdded().getTime()));
            preparedStatement.setLong(6, task.getId());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.updateUserData()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }
    public void accomplishTask(Long id) throws DBException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE tasks SET accomplishedYN = ?, dateAccomplished = ?" + "WHERE id = ?");
            preparedStatement.setString(1, "Y");
            preparedStatement.setTimestamp(2,  new java.sql.Timestamp(new Date().getTime()));
            preparedStatement.setLong(3, id);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.updateUserData()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

}
