package lv.javaguru.java2.domain.builders;
import lv.javaguru.java2.domain.HistoryRecord;
import org.springframework.stereotype.Component;


/**
 * Created by AST on 2016.01.15.
 */
@Component
public class HistoryBuilder {
    //  private Long id;
    private Long userID;
    private int health;
    private int intelligence;
    private int communication;
    private int statValue;
    private int willPower;
    private int dailyTodo;
    private java.sql.Timestamp dateCompleted;

    private HistoryBuilder(){}

    public  static HistoryBuilder buildHistory(){return new HistoryBuilder();}

    public HistoryRecord build()
    {
        HistoryRecord historyRecord = new HistoryRecord();
        historyRecord.setUserID(userID);
        historyRecord.setHealth(health);
        historyRecord.setIntelligence(intelligence);
        historyRecord.setCommunication(communication);
        historyRecord.setStatValue(statValue);
        historyRecord.setWillPower(willPower);
        historyRecord.setDailyTodo(dailyTodo);
        historyRecord.setDateCompleted(dateCompleted);
        return historyRecord;
    }

    public HistoryBuilder withUserID(Long userID) {
        this.userID = userID;
        return this;
    }
    public HistoryBuilder withHealth(int health) {
        this.health = health;
        return this;
    }
    public HistoryBuilder withIntelligence(int intelligence) {
        this.intelligence = intelligence;
        return this;
    }
    public HistoryBuilder withCommunication(int communication) {
        this.communication = communication;
        return this;
    }
    public HistoryBuilder withStatValue(int statValue) {
        this.statValue = statValue;
        return this;
    }
    public HistoryBuilder withWillPower(int willPower) {
        this.willPower = willPower;
        return this;
    }
    public HistoryBuilder withDailyTodo(int dailyTodo) {
        this.dailyTodo = dailyTodo;
        return this;
    }
    public HistoryBuilder withDateCompleted(java.sql.Timestamp dateCompleted) {
        this.dateCompleted = dateCompleted;
        return this;
    }

}
