package lv.javaguru.java2.domain;

import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.persistence.Entity;
import java.util.Date;
//@Entity
public class Task {

    private Long id;
    @Ignore
    private Long userID;
    @Ignore
    private String statType = " ";
    @Ignore
    private int statValue = 0;
    @Ignore
    private String statDescription = " ";
    @Ignore
    private String repeatableYN = "N";
    @Ignore
    private int  repeatFrequencyDays;
    @Ignore
    private String accomplishedYN = "N";
    @Ignore
    private Date dateAdded;
    @Ignore
    private Date dateAccomplished;
    public Task(){}

    public int getRepeatFrequencyDays() {
        return repeatFrequencyDays;
    }

    public void setRepeatFrequencyDays(int repeatFrequencyDays) {
        this.repeatFrequencyDays = repeatFrequencyDays;
    }

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


