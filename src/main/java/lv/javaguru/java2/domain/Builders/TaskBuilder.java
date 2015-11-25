package lv.javaguru.java2.domain.builders;
import lv.javaguru.java2.domain.Task;
import java.util.Date;


/**
 * Created by mike on 11/24/2015.
 */
public class TaskBuilder {

    //  private Long id;
    private Long userID;
    private String statType = " ";
    private int statValue = 0;
    private String statDescription = " ";
    private String repeatableYN = "N";
    private String accomplishedYN = "N";
    private Date dateAdded;
    private Date dateAccomplished;

    private TaskBuilder(){}

    public Task build()
    {
        Task task = new Task();
        task.setUserID(userID);
        task.setStatType(statType);
        task.setStatValue(statValue);
        task.setStatDescription(statDescription);
        task.setRepeatableYN(repeatableYN);
        task.setAccomplishedYN(accomplishedYN);
        task.setDateAdded(dateAdded);
        task.setDateAccomplished(dateAccomplished);
        return task;
    }

    public TaskBuilder withtUserID(Long userID) {
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
    public TaskBuilder withAccomplishedYN(String accomplishedYN) {
        this.accomplishedYN = accomplishedYN;
        return this;
    }
    public TaskBuilder withDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
        return this;
    }

    public TaskBuilder withDateAccomplished(Date dateAccomplished) {
        this.dateAccomplished = dateAccomplished;
        return this;
    }

}
