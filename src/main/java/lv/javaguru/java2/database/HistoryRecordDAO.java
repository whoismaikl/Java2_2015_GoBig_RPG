package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.HistoryRecord;
import lv.javaguru.java2.domain.User;

import java.util.Date;
import java.util.List;

/**
 * Created by Mike on 01/07/2014.
 */
public interface HistoryRecordDAO {

    void createHistoryRecord(HistoryRecord historyRecord) throws DBException;

    void sendTaskToHistory(HistoryRecord historyRecord) throws DBException;

    List<HistoryRecord> getAllHistoryRecords(User user) throws DBException; // Po usery i iz HistoryRecord

    List<HistoryRecord> getHistoryRecordsInRange(User user, Date startDate, Date stopDate) throws DBException;

}
