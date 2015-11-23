package lv.javaguru.java2.domain;

import java.util.Date;


public class User {

    private Long id;
    private String email;
    private String password;
    private String userName;
    private String userType;
    private long health;
    private long intelligence;
    private long communication;
    private long willPower;
    private long dailyTodo;
    private Date lastLogin;
    private Date dateRegistered;
    private String accountActivetYN;


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
        setLastLogin(date);
        setDateRegistered(date);
        setAccountActivetYN("Y");
    }

    Date date = new Date();

    public User() {

    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
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

    public java.sql.Date getSqlDate(Date date){
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        return sqlDate;
    }

    public String getAccountActivetYN() {
        return accountActivetYN;
    }

    public void setAccountActivetYN(String accountActivetYN) {
        this.accountActivetYN = accountActivetYN;
    }


}


