package lv.javaguru.java2.domain.builders;
import lv.javaguru.java2.domain.HistoryRecord;
import org.springframework.stereotype.Component;


/**
 * Created by AST on 2016.01.15.
 */
@Component
public class HistoryRecordBuilder {
    //  private Long id;
    private Long userID;
    private Long taskID;
    private String statType;
    private int health;
    private int intelligence;
    private int communication;
    private int statValue;
    private int willPower;
    private int dailyTodo;
    private java.sql.Timestamp dateCompleted;

    private HistoryRecordBuilder(){}

    public  static HistoryRecordBuilder buildHistoryRecord(){return new HistoryRecordBuilder();}

    public HistoryRecord build()
    {
        HistoryRecord historyRecord = new HistoryRecord();
        historyRecord.setUserID(userID);
        historyRecord.setTaskID(taskID);
        historyRecord.setStatType(statType);
        historyRecord.setHealth(health);
        historyRecord.setIntelligence(intelligence);
        historyRecord.setCommunication(communication);
        historyRecord.setStatValue(statValue);
        historyRecord.setWillPower(willPower);
        historyRecord.setDailyTodo(dailyTodo);
        historyRecord.setDateCompleted(dateCompleted);
        return historyRecord;
    }

    public HistoryRecordBuilder withUserID(Long userID) {
        this.userID = userID;
        return this;
    }
    public HistoryRecordBuilder withTaskID(Long taskID) {
        this.taskID = taskID;
        return this;
    }
    public HistoryRecordBuilder withStatType(String statType) {
        this.statType = statType;
        return this;
    }
    public HistoryRecordBuilder withHealth(int health) {
        this.health = health;
        return this;
    }
    public HistoryRecordBuilder withIntelligence(int intelligence) {
        this.intelligence = intelligence;
        return this;
    }
    public HistoryRecordBuilder withCommunication(int communication) {
        this.communication = communication;
        return this;
    }
    public HistoryRecordBuilder withStatValue(int statValue) {
        this.statValue = statValue;
        return this;
    }
    public HistoryRecordBuilder withWillPower(int willPower) {
        this.willPower = willPower;
        return this;
    }
    public HistoryRecordBuilder withDailyTodo(int dailyTodo) {
        this.dailyTodo = dailyTodo;
        return this;
    }
    public HistoryRecordBuilder withDateCompleted(java.sql.Timestamp dateCompleted) {
        this.dateCompleted = dateCompleted;
        return this;
    }

}
