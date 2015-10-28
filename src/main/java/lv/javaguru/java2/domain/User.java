package lv.javaguru.java2.domain;

public class User {

    private Long id;
    private String name;
    private String surname;
    private String nickName;
    private long health;
    private String userType;
    private long intelligence;
    private long communication;
    private long willPower;
    private long dailyTodos;

    public User(){}

    public User(String name, String surname, String nickName, String userType){
        setName(name);
        setSurname(surname);
        setNickName(nickName);
        setUserType(userType);
        setHealth(50);
        setIntelligence(50);
        setCommunication(50);
        setWillPower(30);
        setDailyTodos(0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getDailyTodos() {
        return dailyTodos;
    }

    public void setDailyTodos(long dailyTodos) {
        this.dailyTodos = dailyTodos;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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
}
