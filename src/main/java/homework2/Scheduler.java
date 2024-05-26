package homework2;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {


    public static void scheduleAndRun(ArrayList<Process> processes) {
        int t = 0;
        ProcessQueue pq = new ProcessQueue();
        Process currentProcess = null;
        Process pausedProcess = null;

        while (true) {
            int finalT = t;
            List<Process> arrivedProcesses = processes.stream().filter(process -> process.getArriveTime() == finalT).toList();
            if (!arrivedProcesses.isEmpty()) {
                arrivedProcesses.forEach(pq::addProcess);
            }

            if (currentProcess == null) currentProcess = pq.runNextProcess();


            System.out.println("t: " + finalT + " | " + (currentProcess == null ? "no process" : currentProcess.getProcessName()));

            currentProcess.setBurstTime(currentProcess.getBurstTime() - 1);
            if (currentProcess.getBurstTime() == 0) currentProcess = null;


            t++;
            if (currentProcess == null && pq.length == 0) break;
        }

        System.out.println("Total time: " + t);

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