package lv.javaguru.java2.domain;

import javax.persistence.*;

@Entity
@Table(name = "defaultTasks")
public class DefaultTask {
    @Id
    @Column(name="id",columnDefinition = "BIGINT")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="userID", columnDefinition = "BIGINT", nullable = false)
    private Long userID;

    @Column(name="statType", columnDefinition = "CHAR(17)")
    private String statType = " ";

    @Column(name="statValue", columnDefinition = "INTEGER")
    private int statValue = 0;

    @Column(name="statDescription", columnDefinition = "CHAR(255)")
    private String statDescription = " ";

    @Column(name="repeatableYN", columnDefinition = "CHAR(3)")
    private String repeatableYN = "N";

    @Column(name="repeatFrequencyDays", columnDefinition = "INTEGER")
    private int  repeatFrequencyDays;

    @Column(name="accomplishedYN", columnDefinition = "CHAR(3)")
    private String accomplishedYN = "N";

    @Column(name="dateAdded", columnDefinition = "DATETIME(6)")
    private java.sql.Timestamp dateAdded;

    @Column(name="dateAccomplished", columnDefinition = "DATETIME(6)")
    private java.sql.Timestamp dateAccomplished;

    public DefaultTask(){}

    public void setStatValue(int statValue) {
        this.statValue = statValue;
    }

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

    public java.sql.Timestamp getDateAccomplished() {
        return dateAccomplished;
    }

    public void setDateAccomplished(java.sql.Timestamp dateAccomplished) {
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

    public java.sql.Timestamp getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(java.sql.Timestamp dateAdded) {
        this.dateAdded = dateAdded;
    }
}


