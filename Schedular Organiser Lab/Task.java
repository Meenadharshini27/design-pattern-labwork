public class Task {
    private String description;
    private String startTime;
    private String endTime;
    private String priority;

    public Task(String description, String startTime, String endTime, String priority) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    @Override
public String toString() {
    return "Task: " + description + ", Start Time: " + startTime + ", End Time: " + endTime + ", Priority: " + priority;
}

}
