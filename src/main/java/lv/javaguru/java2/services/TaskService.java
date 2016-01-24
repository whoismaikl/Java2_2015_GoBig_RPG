package lv.javaguru.java2.services;
import lv.javaguru.java2.domain.HistoryRecord;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.builders.HistoryRecordBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    private int calculateWillPower(User user){
        return (user.getHealth()+user.getIntelligence()+user.getCommunication())/COUNT_OF_STATUSES;
    }

    public Task setTaskAccomplished(Task task){
        task.setAccomplishedYN("Y");
        task.setDateAccomplished(timeService.getSqlTimestamp());
        return task;
    }

    public Task setTaskNotAccomplished(Task task){
        task.setAccomplishedYN("N");
        //task.setDateAccomplished(null);
        return task;
    }

    public HistoryRecord buildHistoryRecord(User user, Task task) {
        HistoryRecord historyRecord = historyRecordBuilder.buildHistoryRecord()
                .withUserID(user.getId())
                .withTaskID(task.getId())
                .withHealth(user.getHealth())
                .withIntelligence(user.getIntelligence())
                .withCommunication(user.getCommunication())
                .withWillPower(user.getWillPower())
                .withStatValue(task.getStatValue())
                .withDateCompleted(timeService.getSqlTimestamp())
                .build();
        return historyRecord;
    }

    public Long getAccomplishedTaskId(List<Task> accomplishedTaskList, User user, Task task) {
        Long userId = user.getId();
        Long taskId = task.getId();
        Long accomplishedTaskUserId = null;
        Long accomplishedTaskId = null;
        Long historyRecordId = null;

        for (Task accomplishedTask : accomplishedTaskList) {
            accomplishedTaskUserId = accomplishedTask.getUserID();
            accomplishedTaskId = accomplishedTask.getId();
            if(accomplishedTaskUserId.equals(userId) && accomplishedTaskId.equals(taskId)) {
                return accomplishedTaskId;
            }
        }
        return accomplishedTaskId;
    }
    public Long getHistoryRecordId(List<HistoryRecord> historyRecordsInRange, Long accomplishedTaskId) {
        Long historyRecordId = null;
        Long historyRecordTaskId = null;
        for (HistoryRecord historyRecord: historyRecordsInRange){
            historyRecordTaskId = historyRecord.getTaskID();
            if(historyRecordTaskId.equals(accomplishedTaskId)){
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
}
