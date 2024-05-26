package homework2;

import java.util.ArrayList;

public class Scheduler {

    public static void scheduleAndRun(ArrayList<Process> processes) {
        ProcessQueue pq = new ProcessQueue();
        processes.forEach(pq::addProcess);
        System.out.println(pq.peekNextProcess().getPriority());
    }

    public static void main(String[] args) {
        ArrayList<Process> processes = new ArrayList<>();

        processes.add(new Process("P1", 1, 4, 0));
        processes.add(new Process("P2", 2, 3, 0));
        processes.add(new Process("P3", 1, 7, 6));
        processes.add(new Process("P4", 3, 4, 11));
        processes.add(new Process("P5", 2, 2, 12));

        scheduleAndRun(processes);
    }
}