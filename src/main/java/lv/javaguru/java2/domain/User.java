package lv.javaguru.java2.domain;

/**
    Go Big Project
 */
public class User {

    private long userId;
    private String firstName;
    private String lastName;

    private long intellegence;
    private long health;
    private long communication;
    private long willPower;
    private long dailyTodos;


    public long getUserId() {
        return userId;
    }

    public long getIntellegence() {
        return intellegence;
    }

    public void setIntellegence(long intellegence) {
        this.intellegence = intellegence;
    }

    public long getHealth() {
        return health;
    }

    public void setHealth(long health) {
        this.health = health;
    }

    public long getCommunication() {
        return communication;
    }

    public void setCommunication(long communication) {
        this.communication = communication;
    }

    public long getWillPower() {
        return willPower;
    }

    public void setWillPower(long willPower) {
        this.willPower = willPower;
    }

    public long getDailyTodos() {
        return dailyTodos;
    }

    public void setDailyTodos(long dailyTodos) {
        this.dailyTodos = dailyTodos;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
