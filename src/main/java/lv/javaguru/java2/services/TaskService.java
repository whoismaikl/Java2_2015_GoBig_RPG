package lv.javaguru.java2.services;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.HistoryRecordDAO;
import lv.javaguru.java2.domain.HistoryRecord;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.builders.HistoryRecordBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by AST on 2016.01.16..
 */
@Component
public class TaskService {
    private final String TASK_STATUS_TYPE_HEALTH = "Health";
    private final String TASK_STATUS_TYPE_INTELLIGENCE = "Intelligence";
    private final String TASK_STATUS_TYPE_COMMUNICATION = "Communication";
    private final int COUNT_OF_STATUSES = 3;
    @Autowired
    private TimeService timeService;
    @Autowired
    private HistoryRecordBuilder historyRecordBuilder;
    @Autowired
    HistoryRecordDAO historyRecordDAO;

    public User setUserPropertiesByAccomplishedTask(User user, Task task) {
        String taskType = task.getStatType();
        int taskValue = task.getStatValue();

        if (taskType.equals(TASK_STATUS_TYPE_HEALTH)) {
            Integer newValue = user.getHealth() + taskValue;
            user.setHealth(newValue);
        } else if (taskType.equals(TASK_STATUS_TYPE_INTELLIGENCE)) {
            Integer newValue = user.getIntelligence() + taskValue;
            user.setIntelligence(newValue);
        } else if (taskType.equals(TASK_STATUS_TYPE_COMMUNICATION)) {
            Integer newValue = user.getCommunication() + taskValue;
            user.setCommunication(newValue);
        }
        user.setWillPower(calculateWillPower(user));
        return user;
    }

    private int calculateWillPower(User user) {
        return (user.getHealth() + user.getIntelligence() + user.getCommunication()) / COUNT_OF_STATUSES;
    }

    public Task setTaskAccomplished(Task task) {
        task.setAccomplishedYN("Y");
        task.setDateAccomplished(timeService.getSqlTimestamp());
        return task;
    }

    public Task setTaskNotAccomplished(Task task) {
        task.setAccomplishedYN("N");
        return task;
    }

    public HistoryRecord buildHistoryRecord(User user, Task task) {
        HistoryRecord historyRecord = historyRecordBuilder.buildHistoryRecord()
                .withUserID(user.getId())
                .withTaskID(task.getId())
                .withStatType(task.getStatType())
                .withHealth(user.getHealth())
                .withIntelligence(user.getIntelligence())
                .withCommunication(user.getCommunication())
                .withWillPower(user.getWillPower())
                .withStatValue(task.getStatValue())
                .withDateCompleted(timeService.getSqlTimestamp())
                .build();
        return historyRecord;
    }

    public Long getHistoryRecordId(List<HistoryRecord> historyRecordsInRange, Long accomplishedTaskId) {
        Long historyRecordId = null;
        Long historyRecordTaskId = null;
        for (HistoryRecord historyRecord : historyRecordsInRange) {
            historyRecordTaskId = historyRecord.getTaskID();
            if (historyRecordTaskId.equals(accomplishedTaskId)) {
                historyRecordId = historyRecord.getId();
                return historyRecordId;
            }
        }
        return historyRecordId;
    }

    public User resetUserPropertiesByAccomplishedTask(User user, Task task) {
        String taskType = task.getStatType();
        int taskValue = task.getStatValue();

        if (taskType.equals(TASK_STATUS_TYPE_HEALTH)) {
            Integer newValue = user.getHealth() - taskValue;
            user.setHealth(newValue);
        } else if (taskType.equals(TASK_STATUS_TYPE_INTELLIGENCE)) {
            Integer newValue = user.getIntelligence() - taskValue;
            user.setIntelligence(newValue);
        } else if (taskType.equals(TASK_STATUS_TYPE_COMMUNICATION)) {
            Integer newValue = user.getCommunication() - taskValue;
            user.setCommunication(newValue);
        }
        user.setWillPower(calculateWillPower(user));
        return user;
    }

    public List<Integer> getScoresForDay(List<HistoryRecord> historyRecordsForDay) {
        List<Integer> scores = new ArrayList<Integer>();
        Integer scoresHealth = 0;
        Integer scoresIntelligence = 0;
        Integer scoresCommunication = 0;
        String statType;
        for (HistoryRecord historyRecord : historyRecordsForDay) {
            statType = historyRecord.getStatType();
            if (statType.equals(TASK_STATUS_TYPE_HEALTH)) {
                scoresHealth += historyRecord.getStatValue();
            } else if (statType.equals(TASK_STATUS_TYPE_INTELLIGENCE)) {
                scoresIntelligence += historyRecord.getStatValue();
            } else if (statType.equals(TASK_STATUS_TYPE_COMMUNICATION)) {
                scoresCommunication += historyRecord.getStatValue();
            }
        }
        scores.add(scoresHealth);
        scores.add(scoresIntelligence);
        scores.add(scoresCommunication);
        return scores;
    }

    public List<Double> getScoresAverage(List <HistoryRecord> historyRecordsInRange) throws ParseException {
        List<Double> scoresAverage = new ArrayList<Double>();
        Integer scoresHealth = 0;
        Integer scoresIntelligence = 0;
        Integer scoresCommunication = 0;
        String startDate;
        String stopDate = timeService.getFormattedDate(historyRecordsInRange.get(historyRecordsInRange.size() - 1).getDateCompleted());
        int dateCount = 1;
        String statType;
        for (HistoryRecord historyRecord : historyRecordsInRange) {
            startDate = timeService.getFormattedDate(historyRecord.getDateCompleted());
            if (!startDate.equals(stopDate))
                dateCount++;
            statType = historyRecord.getStatType();
            if (statType.equals(TASK_STATUS_TYPE_HEALTH)) {
                scoresHealth += historyRecord.getStatValue();
            } else if (statType.equals(TASK_STATUS_TYPE_INTELLIGENCE)) {
                scoresIntelligence += historyRecord.getStatValue();
            } else if (statType.equals(TASK_STATUS_TYPE_COMMUNICATION)) {
                scoresCommunication += historyRecord.getStatValue();
            }
        }
        scoresAverage.add(((double)scoresHealth / dateCount));
        scoresAverage.add(((double)scoresIntelligence / dateCount));
        scoresAverage.add(((double)scoresCommunication / dateCount));
        return scoresAverage;
    }
}
