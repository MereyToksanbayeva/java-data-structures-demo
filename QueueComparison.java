import java.util.*;

public class QueueComparison {

    static int[] customers = {7, 9, 5, 4, 15, 21, 6, 13, 3, 2};
    static double scanTime = 2.7;

    public static double simulateFIFO() {
        Queue<Integer> q = new LinkedList<>();
        for (int c : customers) q.add(c);

        double total = 0, sum = 0;
        int num = 1;

        System.out.println("=== FIFO ===");
        while (!q.isEmpty()) {
            int it = q.poll();
            double t = it * scanTime;
            total += t;
            sum += total;
            System.out.printf("Customer %d (%d items) -> %.1f sec%n", num++, it, total);
        }
        double avg = sum / customers.length;
        System.out.println("FIFO AVG = " + avg + "\n");
        return avg;
    }

    public static double simulatePQ() {
        List<Integer> pq = new ArrayList<>();
        for (int c : customers) pq.add(c);

        Collections.sort(pq);

        double total = 0, sum = 0;
        int num = 1;

        System.out.println("=== PQ ===");
        for (int it : pq) {
            double t = it * scanTime;
            total += t;
            sum += total;
            System.out.printf("Customer %d (%d items) -> %.1f sec%n", num++, it, total);
        }
        double avg = sum / customers.length;
        System.out.println("PQ AVG = " + avg + "\n");
        return avg;
    }

    public static void main(String[] args) {
        simulateFIFO();
        simulatePQ();
    }
}
