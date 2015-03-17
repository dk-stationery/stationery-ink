package org.tommy.stationery.ink.domain.cluster;

/**
 * Created by kun7788 on 15. 1. 29..
 */
public class Cluster {
    private String version;
    private String uptime;
    private int supervisors;
    private int usedSlots;
    private int freeSlots;
    private int totalSlots;
    private int executors;
    private int tasks;

    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
    public int getSupervisors() {
        return supervisors;
    }
    public void setSupervisors(int supervisors) {
        this.supervisors = supervisors;
    }
    public String getUptime() {
        return uptime;
    }
    public void setUptime(String uptime) {
        this.uptime = uptime;
    }
    public int getUsedSlots() {
        return usedSlots;
    }
    public void setUsedSlots(int usedSlots) {
        this.usedSlots = usedSlots;
    }
    public int getFreeSlots() {
        return freeSlots;
    }
    public void setFreeSlots(int freeSlots) {
        this.freeSlots = freeSlots;
    }
    public int getTotalSlots() {
        return totalSlots;
    }
    public void setTotalSlots(int totalSlots) {
        this.totalSlots = totalSlots;
    }
    public int getExecutors() {
        return executors;
    }
    public void setExecutors(int executors) {
        this.executors = executors;
    }
    public int getTasks() {
        return tasks;
    }
    public void setTasks(int tasks) {
        this.tasks = tasks;
    }
}
