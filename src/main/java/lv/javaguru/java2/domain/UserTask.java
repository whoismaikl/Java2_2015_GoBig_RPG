package lv.javaguru.java2.domain;

import java.util.Date;

public class UserTask {

    private Long id;
    private Long userID;
    private String statType = " ";
    private int statValue = 0;
    private String statDescription = " ";
    private String repeatableYN = "N";
    private String accomplishedYN = "N";
    private Date dateAdded;
    private Date dateAccomplished;

    public UserTask(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateAccomplished() {
        return dateAccomplished;
    }

    public void setDateAccomplished(Date dateAccomplished) {
        this.dateAccomplished = dateAccomplished;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getStatType() {
        return statType;
    }

    public void setStatType(String statType) {
        this.statType = statType;
    }

    public int getStatValue() {
        return statValue;
    }

    public void setStatValue(Integer statValue) {
        this.statValue = statValue;
    }

    public String getStatDescription() {
        return statDescription;
    }

    public void setStatDescription(String statDescription) {
        this.statDescription = statDescription;
    }

    public String getRepeatableYN() {
        return repeatableYN;
    }

    public void setRepeatableYN(String repeatableYN) {
        this.repeatableYN = repeatableYN;
    }

    public String getAccomplishedYN() {
        return accomplishedYN;
    }

    public void setAccomplishedYN(String accomplishedYN) {
        this.accomplishedYN = accomplishedYN;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }
}


