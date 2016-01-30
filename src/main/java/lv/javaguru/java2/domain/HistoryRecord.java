package lv.javaguru.java2.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "taskHistory")
public class HistoryRecord {
    @Id
    @Column(name="id",columnDefinition = "BIGINT")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //@Transient
    @Column(name="userID", columnDefinition = "BIGINT", nullable = false)
    private Long userID;
    //@Transient
    @Column(name="taskID", columnDefinition = "BIGINT", nullable = false)
    private Long taskID;
    @Column(name="statType", columnDefinition = "CHAR(17)")
    private String statType = " ";

    //@Transient
    @Column(name="statValue", columnDefinition = "INTEGER")
    private int statValue = 0;

    //@Transient
    @Column(name="health", columnDefinition = "INTEGER")
    private int health;
    //@Transient
    @Column(name="intelligence", columnDefinition = "INTEGER")
    private int intelligence;
    //@Transient
    @Column(name="communication", columnDefinition = "INTEGER")
    private int communication;
    //@Transient
    @Column(name="willPower", columnDefinition = "INTEGER")
    private int willPower;
    //@Transient
    @Column(name="dailyTodo", columnDefinition = "INTEGER")
    private int dailyTodo;
    //@Transient
    @Column(name="dateCompleted", columnDefinition = "DATETIME(6)")
    private java.sql.Timestamp dateCompleted;
    public HistoryRecord(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTaskID() {
        return taskID;
    }

    public void setTaskID(Long taskID) {
        this.taskID = taskID;
    }

    /*@ManyToOne
    //@JoinColumn(name = "id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/
    public String getStatType() {
        return statType;
    }

    public void setStatType(String statType) {
        this.statType = statType;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public int getStatValue() {
        return statValue;
    }

    public void setStatValue(int statValue) {
        this.statValue = statValue;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getCommunication() {
        return communication;
    }

    public void setCommunication(int communication) {
        this.communication = communication;
    }

    public int getWillPower() {
        return willPower;
    }

    public void setWillPower(int willPower) {
        this.willPower = willPower;
    }

    public int getDailyTodo() {
        return dailyTodo;
    }

    public void setDailyTodo(int dailyTodo) {
        this.dailyTodo = dailyTodo;
    }

    public Timestamp getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(Timestamp dateCompleted) {
        this.dateCompleted = dateCompleted;
    }
}


