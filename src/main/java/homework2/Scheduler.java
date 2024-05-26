package homework2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Scheduler {

    public static void scheduleAndRun(ArrayList<Process> processes) {
        int t = 0;
        ProcessQueue pq = new ProcessQueue();
        Process currentProcess = null;

        while (true) {
            int finalT = t;
            List<Process> arrivedProcesses = processes.stream().filter(process -> process.getArriveTime() == finalT).toList();
            if (!arrivedProcesses.isEmpty()) arrivedProcesses.forEach(pq::addProcess);

            System.out.println("Time: " + finalT + " Processes: " + arrivedProcesses);

            t++;
            if (finalT == 50) break;
        }

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