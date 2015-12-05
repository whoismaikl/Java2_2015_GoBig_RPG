package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Record;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.domain.User;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Viktor on 01/07/2014.
 */
public interface RecordDAO {

    void createRecord(Record record) throws DBException;

    List<Record> getAllUserRecords(User user) throws DBException;

}
