import java.util.LinkedList;
import java.util.Queue;

public class MarketFIFO {
    public static void main(String[] args) {

        int[] customers = {7, 9, 5, 4, 15, 21, 6, 13, 3, 2};
        double scanTime = 2.7;

        Queue<Integer> queue = new LinkedList<>();
        for (int items : customers) queue.add(items);

        double totalTime = 0;
        double sumCompletion = 0;

        System.out.println("=== FIFO QUEUE SIMULATION ===");

        int num = 1;
        while (!queue.isEmpty()) {
            int items = queue.poll();
            double t = items * scanTime;

            totalTime += t;
            sumCompletion += totalTime;

            System.out.printf("Customer %d (%d items) -> finishes at %.1f sec%n",
                    num, items, totalTime);
            num++;
        }

        double avg = sumCompletion / customers.length;
        System.out.printf("\nAverage completion time: %.1f sec%n", avg);
    }
}
