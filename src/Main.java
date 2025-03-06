import java.util.*;

public class Main {
    public static final Map<Integer, Integer> sizeToFreq = new HashMap<>();
    public static final int ROUTES_COUNT = 1000;
    public static final String LETTERS = "RLRFR";
    public static final int ROUTE_LENGTH = 100;

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < ROUTES_COUNT; i++) {
            Thread thread = new Thread(new RouteAnalyzer(LETTERS, ROUTE_LENGTH));
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.join();
        }

        int mostFrequentCount = 0;
        int maxFrequency = 0;

        for (Map.Entry<Integer, Integer> entry : sizeToFreq.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                mostFrequentCount = entry.getKey();
                maxFrequency = entry.getValue();
            }
        }

        System.out.println("Самое частое количество повторений " + mostFrequentCount + " (встретилось " + maxFrequency + " раз)");
        System.out.println("Другие размеры:");
        for (Map.Entry<Integer, Integer> entry : sizeToFreq.entrySet()) {
            if (entry.getKey() != mostFrequentCount) {
                System.out.println("- " + entry.getKey() + " (" + entry.getValue() + " раз)");
            }
        }
    }
}