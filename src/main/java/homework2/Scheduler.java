package homework2;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {


    public static void scheduleAndRun(ArrayList<Process> processes) {
        int t = 0;
        int executedProcesses = 0;
        int finishTimeSum = 0;
        ProcessQueue pq = new ProcessQueue();
        Process currentProcess = null;
        Process pausedProcess = null;
        int burstTimeSum = processes.stream().mapToInt(Process::getBurstTime).sum();
        int arriveTimeSum = processes.stream().mapToInt(Process::getArriveTime).sum();

        do {
            int finalT = t;
            List<Process> arrivedProcesses = processes.stream().filter(process -> process.getArriveTime() == finalT).toList();

            if (!arrivedProcesses.isEmpty()) {
                arrivedProcesses.forEach(pq::addProcess);

                if (currentProcess != null && currentProcess.getPriority() > pq.peekNextProcess().getPriority()) {
                    pausedProcess = currentProcess;
                    currentProcess = pq.runNextProcess();
                }
            }

            if (currentProcess == null && pq.length > 0) {
                currentProcess = pq.runNextProcess();
            }

            System.out.println("t: " + finalT + " | " + (currentProcess == null ? "no process" : currentProcess.getProcessName()));

            if (currentProcess != null) currentProcess.setBurstTime(currentProcess.getBurstTime() - 1);

            if (currentProcess != null && currentProcess.getBurstTime() == 0) {
                executedProcesses++;
                finishTimeSum += finalT + 1;
                currentProcess = null;

                if (pausedProcess != null) {
                    currentProcess = pausedProcess;
                    pausedProcess = null;
                }
            }

            t++;
        } while (executedProcesses != processes.size());


        System.out.println("Total time: " + t);
        System.out.println("Average waiting time: " + ((double)(finishTimeSum - burstTimeSum - arriveTimeSum) / processes.size()));
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