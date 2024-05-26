package homework2;

public class Process implements Comparable<Process> {
    private String processName;
    private int priority;
    private int burstTime;
    private int arriveTime;

    public Process(String processName, int priority, int burstTime, int arriveTime) {
        this.processName = processName;
        this.priority = priority;
        this.burstTime = burstTime;
        this.arriveTime = arriveTime;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public int getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(int arriveTime) {
        this.arriveTime = arriveTime;
    }

    @Override
    public int compareTo(Process other) {
        return Integer.compare(this.getPriority(), other.getPriority());
    }
}