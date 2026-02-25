import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class PQ {
    private List<Integer> list = new ArrayList<>();

    public void add(int x) {
        list.add(x);
        Collections.sort(list);
    }

    public int remove() {
        return list.remove(0);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}

public class MarketPQ {
    public static void main(String[] args) {

        int[] customers = {7, 9, 5, 4, 15, 21, 6, 13, 3, 2};
        double scanTime = 2.7;

        PQ pq = new PQ();
        for (int items : customers) pq.add(items);

        double totalTime = 0;
        double sumCompletion = 0;

        System.out.println("=== PRIORITY QUEUE SIMULATION ===");

        int num = 1;
        while (!pq.isEmpty()) {
            int items = pq.remove();
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
