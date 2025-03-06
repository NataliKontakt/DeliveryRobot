import java.util.*;

public class Main {
    public static final Map<Integer, Integer> sizeToFreq = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < Config.ROUTES_COUNT; i++) {
            Thread thread = new Thread(new RouteAnalyzer(Config.LETTERS, Config.ROUTE_LENGTH));
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.join();
        }

        StatisticsAnalyzer.printStatistics(sizeToFreq);
    }
}