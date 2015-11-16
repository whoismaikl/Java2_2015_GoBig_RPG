package lv.javaguru.java2.database.jdbc;


import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.UserTaskDAO;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.UserTask;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class UserTaskDAOImpl extends DAOImpl implements UserTaskDAO {

    public void createTask(UserTask userTask) throws DBException {
        if (userTask == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO tasks VALUES (0, ?, ?, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, userTask.getUserID());
            preparedStatement.setString(2, userTask.getStatType());
            preparedStatement.setInt(3, userTask.getStatValue());
            preparedStatement.setString(4, userTask.getStatDescription());
            preparedStatement.setString(5, userTask.getRepeatableYN());
            preparedStatement.setString(6, userTask.getAccomplishedYN());
            preparedStatement.setTimestamp(7, new Timestamp(userTask.getDateAdded().getTime()));
            preparedStatement.setTimestamp(8, new Timestamp(userTask.getDateAccomplished().getTime()));
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                userTask.setId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute UserTaskDAOImpl.createUser()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

    }

    public UserTask getTaskById(Long id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM tasks WHERE id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            UserTask userTask = null;
            if (resultSet.next()) {
                userTask = new UserTask();
                userTask.setId(resultSet.getLong("id"));
                userTask.setUserID(resultSet.getLong("userID"));
                userTask.setStatType(resultSet.getString("statType"));
                userTask.setStatValue(resultSet.getInt("statValue"));
                userTask.setStatDescription(resultSet.getString("statDescription"));
                userTask.setRepeatableYN(resultSet.getString("repeatableYN"));
                userTask.setAccomplishedYN(resultSet.getString("accomplishedYN"));
                userTask.setDateAdded(resultSet.getTimestamp("dateAdded"));
                userTask.setDateAccomplished(resultSet.getTimestamp("dateAccomplished"));
            }
            return userTask;
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
    public List<UserTask> getAllUserTasks(User user) throws DBException {
        List<UserTask> userTasks = new ArrayList<UserTask>();
        Connection connection = null;
        Long userId1 = user.getId();

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM tasks WHERE userID="
                    + userId1);

            ResultSet resultSet = preparedStatement.executeQuery();
            UserTask userTask;
            while (resultSet.next()) {
                userTask = new UserTask();
                userTask.setId(resultSet.getLong("id"));
                userTask.setUserID(resultSet.getLong("userID"));
                userTask.setStatType(resultSet.getString("statType"));
                userTask.setStatValue(resultSet.getInt("statValue"));
                userTask.setStatDescription(resultSet.getString("statDescription"));
                userTask.setRepeatableYN(resultSet.getString("repeatableYN"));
                userTask.setAccomplishedYN(resultSet.getString("accomplishedYN"));
                userTask.setDateAdded(resultSet.getTimestamp("dateAdded"));
                userTask.setDateAccomplished(resultSet.getTimestamp("dateAccomplished"));
                userTasks.add(userTask);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list UserTaskDAOImpl.getList()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return userTasks;
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

    public void update(UserTask userTask) throws DBException {
        if (userTask == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE tasks SET email = ?, password = ?, nickName = ?, userType = ?" + "WHERE id = ?");
            preparedStatement.setLong(1, userTask.getUserID());
            preparedStatement.setString(2, userTask.getStatType());
            preparedStatement.setInt(3, userTask.getStatValue());
            preparedStatement.setString(4, userTask.getStatDescription());
            preparedStatement.setString(5, userTask.getRepeatableYN());
            preparedStatement.setString(6, userTask.getAccomplishedYN());
            preparedStatement.setTimestamp(7, new Timestamp(userTask.getDateAdded().getTime()));
            preparedStatement.setTimestamp(8, new Timestamp(userTask.getDateAccomplished().getTime()));
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
