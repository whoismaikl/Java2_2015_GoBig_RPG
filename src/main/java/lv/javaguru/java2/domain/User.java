package lv.javaguru.java2.domain;

import com.sun.prism.impl.Disposer;
import lv.javaguru.java2.services.TimestampService;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Where;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;
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
    private long health;

    @Column(name="intelligence", columnDefinition = "INTEGER")
    private long intelligence;

    @Column(name="communication", columnDefinition = "INTEGER")
    private long communication;

    @Column(name="willPower", columnDefinition = "INTEGER")
    private long willPower;

    @Column(name="dailyTodo", columnDefinition = "INTEGER")
    private long dailyTodo;

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
    private List<History> historyList;

    public List<History> getHistoryList() {
        return historyList;
    }
    public void setHistoryList(List<History> historyList) {
        this.historyList = historyList;
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

    public long getDailyTodo() {
        return dailyTodo;
    }

    public void setDailyTodo(long dailyTodo) {
        this.dailyTodo = dailyTodo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getHealth() {
        return health;
    }

    public void setHealth(long health) {
        this.health = health;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
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


