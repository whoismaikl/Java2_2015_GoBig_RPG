package lv.javaguru.java2.domain.uilders;
import lv.javaguru.java2.domain.History;
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

    public History build()
    {
        History history= new History();
        history.setUserID(userID);
        history.setHealth(health);
        history.setIntelligence(intelligence);
        history.setCommunication(communication);
        history.setStatValue(statValue);
        history.setWillPower(willPower);
        history.setDailyTodo(dailyTodo);
        history.setDateCompleted(dateCompleted);
        return history;
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
