package lv.javaguru.java2.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name="id",columnDefinition = "BIGINT")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="email", columnDefinition = "CHAR(40)")
    private String email;

    @Column(name="password", columnDefinition = "CHAR(40)")
    private String password;

    @Column(name="userName", columnDefinition = "CHAR(30)")
    private String userName;

    @Column(name="userType", columnDefinition = "CHAR(1)")
    private String userType;

    @Column(name="health", columnDefinition = "INTEGER")
    private int health;

    @Column(name="intelligence", columnDefinition = "INTEGER")
    private int intelligence;

    @Column(name="communication", columnDefinition = "INTEGER")
    private int communication;

    @Column(name="willPower", columnDefinition = "INTEGER")
    private int willPower;

    @Column(name="dailyTodo", columnDefinition = "INTEGER")
    private int dailyTodo;

    @Column(name="lastLogin", columnDefinition = "DATETIME")
    private java.sql.Timestamp lastLogin;

    @Column(name="dateRegistered", columnDefinition = "DATETIME")
    private java.sql.Timestamp dateRegistered;

    @Column(name="accountActivetYN", columnDefinition = "CHAR")
    private String accountActivetYN;

    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy = "userID")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Task> taskList;

    public List<Task> getTaskList() {
        return taskList;
    }
    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy = "userID")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<HistoryRecord> historyRecordList;

    public List<HistoryRecord> getHistoryRecordList() {
        return historyRecordList;
    }
    public void setHistoryRecordList(List<HistoryRecord> historyRecordList) {
        this.historyRecordList = historyRecordList;
    }

    public User(String email, String password, String userName, String userType){
        setEmail(email);
        setPassword(password);
        setUserName(userName);
        setUserType(userType);
        setHealth(50);
        setIntelligence(50);
        setCommunication(50);
        setWillPower(30);
        setDailyTodo(0);
        setLastLogin(getSqlTimestamp());
        setDateRegistered(getSqlTimestamp());
        setAccountActivetYN("Y");
    }

    public User() {

    }

    public java.sql.Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(java.sql.Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    public java.sql.Timestamp getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(java.sql.Timestamp dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDailyTodo() {
        return dailyTodo;
    }

    public void setDailyTodo(int dailyTodo) {
        this.dailyTodo = dailyTodo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
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

    public String getAccountActivetYN() {
        return accountActivetYN;
    }

    public void setAccountActivetYN(String accountActivetYN) {
        this.accountActivetYN = accountActivetYN;
    }

    public java.sql.Timestamp getSqlTimestamp(){
        java.util.Date utilDate = new java.util.Date();
        java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(utilDate.getTime());
        return sqlTimestamp;
    }
}


