package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.History;
import lv.javaguru.java2.domain.User;

import java.util.List;

/**
 * Created by Mike on 01/07/2014.
 */
public interface HistoryDAO {

    void sendTaskToHistory(History history) throws DBException;

    List<History> getAllUserRecords(User user) throws DBException; // Po usery i iz History

}
