package lv.javaguru.java2.domain.builders;
import lv.javaguru.java2.domain.Task;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * Created by mike on 11/24/2015.
 */
@Component
public class TaskBuilder {
    //  private Long id;
    private Long userID;
    private String statType = "Health";
    private int statValue = 1;
    private String statDescription = "Default";
    private String repeatableYN = "Yes";
    private int repeatFrequencyDays = 1;
    private String accomplishedYN = "No";
    private java.sql.Timestamp dateAdded;
    private java.sql.Timestamp dateAccomplished;

    private TaskBuilder(){}

    public static TaskBuilder buildTask(){return new TaskBuilder();}

    public Task build()
    {
        Task task = new Task();
        task.setUserID(userID);
        task.setStatType(statType);
        task.setStatValue(statValue);
        task.setStatDescription(statDescription);
        task.setRepeatableYN(repeatableYN);
        task.setRepeatFrequencyDays(repeatFrequencyDays);
        task.setAccomplishedYN(accomplishedYN);
        task.setDateAdded(dateAdded);
        task.setDateAccomplished(dateAccomplished);
        return task;
    }

    public TaskBuilder withUserID(Long userID) {
        this.userID = userID;
        return this;
    }

    public TaskBuilder withStatType(String statType) {
        this.statType = statType;
        return this;
    }

    public TaskBuilder withStatValue(int statValue) {
        this.statValue = statValue;
        return this;
    }

    public TaskBuilder withStatDescription(String statDescription) {
        this.statDescription = statDescription;
        return this;
    }

    public TaskBuilder withRepeatableYN(String repeatableYN) {
        this.repeatableYN = repeatableYN;
        return this;
    }
    public TaskBuilder withRepeatFrequencyDays(int repeatFrequencyDays) {
        this.repeatFrequencyDays = repeatFrequencyDays;
        return this;
    }
    public TaskBuilder withAccomplishedYN(String accomplishedYN) {
        this.accomplishedYN = accomplishedYN;
        return this;
    }
    public TaskBuilder withDateAdded(java.sql.Timestamp dateAdded) {
        this.dateAdded = dateAdded;
        return this;
    }

    public TaskBuilder withDateAccomplished(java.sql.Timestamp dateAccomplished) {
        this.dateAccomplished = dateAccomplished;
        return this;
    }

}
