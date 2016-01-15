package lv.javaguru.java2.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "taskHistory")
public class History {
    @Id
    @Column(name="id",columnDefinition = "BIGINT")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //@Transient
    @Column(name="userID", columnDefinition = "BIGINT", nullable = false)
    private Long userID;
    //@Transient
    @Column(name="statValue", columnDefinition = "INTEGER")
    private int statValue = 0;
    //@Transient
    @Column(name="health", columnDefinition = "INTEGER")
    private long health;
    //@Transient
    @Column(name="intelligence", columnDefinition = "INTEGER")
    private long intelligence;
    //@Transient
    @Column(name="communication", columnDefinition = "INTEGER")
    private long communication;
    //@Transient
    @Column(name="willPower", columnDefinition = "INTEGER")
    private long willPower;
    //@Transient
    @Column(name="dailyTodo", columnDefinition = "INTEGER")
    private long dailyTodo;
    //@Transient
    @Column(name="dateCompleted", columnDefinition = "DATETIME(6)")
    private java.sql.Timestamp dateCompleted;

    /*@ManyToOne
    //@JoinColumn(name = "id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/

    public History(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public long getHealth() {
        return health;
    }

    public void setHealth(long health) {
        this.health = health;
    }

    public long getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(long intelligence) {
        this.intelligence = intelligence;
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

    public long getDailyTodo() {
        return dailyTodo;
    }

    public void setDailyTodo(long dailyTodo) {
        this.dailyTodo = dailyTodo;
    }

    public Timestamp getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(Timestamp dateCompleted) {
        this.dateCompleted = dateCompleted;
    }
}


