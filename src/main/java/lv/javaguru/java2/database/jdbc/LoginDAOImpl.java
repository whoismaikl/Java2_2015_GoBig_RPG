package lv.javaguru.java2.database.jdbc;
import lv.javaguru.java2.database.DBException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by mike on 10/26/2015.
 */
public class LoginDAOImpl extends DAOImpl {

    public boolean checkLoginData(String eMail, String password) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from LOGIN where email = " + eMail + " AND  + password = " + password);
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();

        } catch (Throwable e) {
            System.out.println("Exception while execute LoginDAOImpl.checkLoginData()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }


}
