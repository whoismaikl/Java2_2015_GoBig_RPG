package lv.javaguru.java2.domain.Builders;
import lv.javaguru.java2.domain.User;

import java.util.Date;

public class UserBuilder {


//mo\hno propisyvat'defoltnye znachenija
    private Long id;
    private String email;
    private String password;
    private String userName;
    private String userType ="U";
    private long health = 50;
    private long intelligence= 50;
    private long communication= 50;
    private long willPower= 25;
    private long dailyTodo;
    private java.sql.Timestamp lastLogin;
    private java.sql.Timestamp dateRegistered;
    private String accountActiveYN;

// chtoby nebylo vozmozhnosti sozdat' eksempljar
    private UserBuilder() {}

    public static UserBuilder createUser() {
        return new UserBuilder();
    }

    public User create()
    {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setUserName(userName);
        user.setUserType(userType);
        user.setHealth(health);
        user.setIntelligence(intelligence);
        user.setCommunication(communication);
        user.setWillPower(willPower);
        user.setDailyTodo(dailyTodo);
        user.setLastLogin(lastLogin);
        user.setDateRegistered(dateRegistered);
        user.setAccountActivetYN(accountActiveYN);
        return user;
    }

    // with metody vozvraschajut builder class nazad
    // kogda stroim cepochku  withOv, oni vyzuvajutsaj na tom zhe objekte
    //i oni zaolnajut atributy objekta, i potom vy\zyvetsja metod build,
    // kotoryj sozdaet objekt s zadannymi poljmi
    public UserBuilder applyEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder applyPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder applyUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public UserBuilder applyUserType(String userType) {
        this.userName = userName;
        return this;
    }

    public UserBuilder applyHealth(Long health) {
        this.health = health;
        return this;
    }

    public UserBuilder applyIntellegence(Long intelligence) {
        this.intelligence = intelligence;
        return this;
    }

    public UserBuilder applyCommunication(Long communication) {
        this.communication = communication;
        return this;
    }

    public UserBuilder applyWillPower(Long willPower) {
        this.willPower = willPower;
        return this;
    }

    public UserBuilder applyDailyToDo(Long dailyTodo) {
        this.dailyTodo = dailyTodo;
        return this;
    }

    public UserBuilder applyLastLogin(java.sql.Timestamp LastLogin) {
        this.lastLogin = LastLogin;
        return this;
    }

    public UserBuilder applyDateRegistered(java.sql.Timestamp dateRegistered) {
        this.dateRegistered = dateRegistered;
        return this;
    }

    public UserBuilder applyAccountActiveYN(String AccountActiveYN) {
        this.accountActiveYN = AccountActiveYN;
        return this;
    }


}


