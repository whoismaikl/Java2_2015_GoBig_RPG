package lv.javaguru.java2.domain;

/**
    Go Big Project
 */
public class User {

    private long userId;
    private String firstName;
    private String lastName;

    private long IntellegenceLevel;
    private long HealthLevel;
    private long CommunicationLevel;
    private long Willpower;



    public long getIntellegenceLevel() {
        return IntellegenceLevel;
    }

    public void setIntellegenceLevel(long intellegenceLevel) {
        IntellegenceLevel = intellegenceLevel;
    }

    public long getHealthLevel() {
        return HealthLevel;
    }

    public void setHealthLevel(long healthLevel) {
        HealthLevel = healthLevel;
    }

    public long getCommunicationLevel() {
        return CommunicationLevel;
    }

    public void setCommunicationLevel(long communicationLevel) {
        CommunicationLevel = communicationLevel;
    }

    public long getWillpower() {
        return Willpower;
    }

    public void setWillpower(long willpower) {
        Willpower = willpower;
    }

    public long getUserId() {
        return userId;
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
