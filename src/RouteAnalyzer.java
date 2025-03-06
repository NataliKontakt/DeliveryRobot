public class RouteAnalyzer implements Runnable {
    private final String letters;
    private final int length;

    public RouteAnalyzer(String letters, int length) {
        this.letters = letters;
        this.length = length;
    }

    @Override
    public void run() {
        String route = RouteGenerator.generate(letters, length);
        int rCount = countR(route);

        synchronized (Main.sizeToFreq) {
            Main.sizeToFreq.put(rCount, Main.sizeToFreq.getOrDefault(rCount, 0) + 1);
        }
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