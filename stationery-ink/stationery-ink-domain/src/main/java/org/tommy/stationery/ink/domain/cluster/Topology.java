package org.tommy.stationery.ink.domain.cluster;

/**
 * Created by kun7788 on 15. 1. 29..
 */
public class Topology {
    private String name;
    private String id;
    private String status;
    private String uptime;
    private int numWorkers;
    private int numExecutors;
    private int numTasks;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getUptime() {
        return uptime;
    }
    public void setUptime(String uptime) {
        this.uptime = uptime;
    }
    public int getNumWorkers() {
        return numWorkers;
    }
    public void setNumWorkers(int numWorkers) {
        this.numWorkers = numWorkers;
    }
    public int getNumExecutors() {
        return numExecutors;
    }
    public void setNumExecutors(int numExecutors) {
        this.numExecutors = numExecutors;
    }
    public int getNumTasks() {
        return numTasks;
    }
    public void setNumTasks(int numTasks) {
        this.numTasks = numTasks;
    }
}
