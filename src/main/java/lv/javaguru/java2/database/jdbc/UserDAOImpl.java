package lv.javaguru.java2.database.jdbc;


import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Viktor on 01/07/2014.
 */
@SuppressWarnings("DefaultFileTemplate")
public class UserDAOImpl extends DAOImpl implements UserDAO {

    public void create(User user) throws DBException {
        if (user == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO users VALUES (default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getNickName());
            preparedStatement.setString(4, user.getUserType());
            preparedStatement.setLong(5, user.getHealth());
            preparedStatement.setLong(6, user.getIntelligence());
            preparedStatement.setLong(7, user.getCommunication());
            preparedStatement.setLong(8, user.getWillPower());
            preparedStatement.setLong(9, user.getDailyTodo());
            preparedStatement.setTimestamp(10, new java.sql.Timestamp(user.getLastLogin().getTime()));
            preparedStatement.setTimestamp(11, new java.sql.Timestamp(user.getDateRegistered().getTime()));
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                user.setId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.create()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

    }

    public User getById(Long id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM users WHERE id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setNickName(resultSet.getString("nickName"));
                user.setUserType(resultSet.getString("userType"));
            }
            return user;
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.getById()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public List<User> getAll() throws DBException {
        List<User> users = new ArrayList<User>();
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users");

            ResultSet resultSet = preparedStatement.executeQuery();
            User user;
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setNickName(resultSet.getString("nickName"));
                user.setUserType(resultSet.getString("userType"));
                users.add(user);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list UserDAOImpl.getList()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return users;
    }

    public User getUserByName(String name) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM users WHERE name = ?");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setNickName(resultSet.getString("nickName"));
                user.setUserType(resultSet.getString("userType"));
            }
            return user;
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.getByLogin()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public void delete(Long id) throws DBException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM users WHERE id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public void update(User user) throws DBException {
        if (user == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE users SET email = ?, password = ?, nickName = ?, userType = ?" + "WHERE id = ?");
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getNickName());
            preparedStatement.setString(4, user.getUserType());

            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

}
