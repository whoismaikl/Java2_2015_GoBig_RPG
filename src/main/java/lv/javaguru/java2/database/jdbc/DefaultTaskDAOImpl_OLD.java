package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.DefaultTaskDAO;
import lv.javaguru.java2.domain.DefaultTask;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component("DefaultTaskDAO_JDBC")
public class DefaultTaskDAOImpl_OLD extends DAOImpl_OLD implements DefaultTaskDAO {

    public void createDefaultTask(DefaultTask task) throws DBException {
        if (task == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO defaultTasks VALUES (0, ?, ?, ?, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
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
            System.out.println("Exception while execute DefaultTaskDAOImpl.createDefaultTask()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

    }

    public DefaultTask getDefaultTaskById(Long id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM defaultTasks WHERE id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            DefaultTask task = null;
            if (resultSet.next()) {
                task = new DefaultTask();
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
            System.out.println("Exception while execute DefaultTaskDAOImpl.getDefaultTaskById()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public List<DefaultTask> getDefaultTaskList() throws DBException {
        List<DefaultTask> tasks = new ArrayList<DefaultTask>();
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM defaultTasks");

            ResultSet resultSet = preparedStatement.executeQuery();
            DefaultTask task;
            while (resultSet.next()) {
                task = new DefaultTask();
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
            System.out.println("Exception while getting customer list DefaultTaskDAOImpl.getDefaultTaskList()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return tasks;
    }

    public void deleteDefaultTaskByID(Long id) throws DBException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM defaultTasks WHERE id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute DefaultTaskDAOImpl.deleteDefaultTask()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public void editDefaultTask(DefaultTask task) throws DBException {
        if (task == null) {
            return;
        }
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE defaultTasks SET statType = ?, statValue = ?, statDescription = ?, repeatableYN = ?, dateAdded = ?" + "WHERE id = ?");
            preparedStatement.setString(1, task.getStatType());
            preparedStatement.setInt(2, task.getStatValue());
            preparedStatement.setString(3, task.getStatDescription());
            preparedStatement.setString(4, task.getRepeatableYN());
            preparedStatement.setTimestamp(5, new Timestamp(task.getDateAdded().getTime()));
            preparedStatement.setLong(6, task.getId());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute DefaultTaskDAOImpl.updateDefaultTask()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }
}
