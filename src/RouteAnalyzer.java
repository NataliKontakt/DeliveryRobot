import java.util.Random;

public class RouteAnalyzer implements Runnable {
    private final String letters;
    private final int length;

    public RouteAnalyzer(String letters, int length) {
        this.letters = letters;
        this.length = length;
    }

    @Override
    public void run() {
        String route = generateRoute(letters, length);
        int rCount = countR(route);

        synchronized (Main.sizeToFreq) {
            Main.sizeToFreq.put(rCount, Main.sizeToFreq.getOrDefault(rCount, 0) + 1);
        }
    }

    private String generateRoute(String letters, int length) {
        Random random = new Random();
        StringBuilder route = new StringBuilder();
        for (int i = 0; i < length; i++) {
            route.append(letters.charAt(random.nextInt(letters.length())));
        }
        return route.toString();
    }

    private int countR(String route) {
        int count = 0;
        for (char c : route.toCharArray()) {
            if (c == 'R') {
                count++;
            }
        }
        return count;
    }
}
