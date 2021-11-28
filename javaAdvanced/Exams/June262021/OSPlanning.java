package Exams.June262021;

import java.util.*;

public class OSPlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer>Tasks = new ArrayDeque<>();
        ArrayDeque<Integer>Threads = new ArrayDeque<>();
        int TaskToKill = Integer.parseInt(scanner.nextLine());

        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(Tasks::push);
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(Threads::offer);
        while(true) {
            int FirstThread = Threads.poll();
            int LastTask = Tasks.pop();

            if (FirstThread < LastTask) {
                Tasks.push(LastTask);
            }
            if(LastTask==TaskToKill){
                System.out.printf("Thread with value  killed task %s");
                break;
            }
        }

    }
}
