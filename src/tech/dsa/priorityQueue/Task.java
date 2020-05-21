package tech.dsa.priorityQueue;

public class Task {
    String task;
    Integer priority;

    public Task(String task, Integer priority) {
        this.task = task;
        this.priority = priority;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
