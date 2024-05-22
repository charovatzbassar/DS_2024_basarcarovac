package homework2;

public class Process implements Comparable<Process> {
    private String processName;
    private int priority;
    private double burstTime;
    private double arriveTime;

    public Process(String processName, int priority, double burstTime, double arriveTime) {
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

    public double getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(double burstTime) {
        this.burstTime = burstTime;
    }

    public double getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(double arriveTime) {
        this.arriveTime = arriveTime;
    }

    @Override
    public int compareTo(Process other) {
        return Integer.compare(this.getPriority(), other.getPriority());
    }
}