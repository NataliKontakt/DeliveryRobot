import java.util.Map;

public class StatisticsAnalyzer {
    public static void printStatistics(Map<Integer, Integer> sizeToFreq) {
        int mostFrequentCount = 0;
        int maxFrequency = 0;

        for (Map.Entry<Integer, Integer> entry : sizeToFreq.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                mostFrequentCount = entry.getKey();
                maxFrequency = entry.getValue();
            }
        }

        System.out.println("Самое частое количество повторений " + mostFrequentCount +
                " (встретилось " + maxFrequency + " раз)");
        System.out.println("Другие размеры:");
        for (Map.Entry<Integer, Integer> entry : sizeToFreq.entrySet()) {
            if (entry.getKey() != mostFrequentCount) {
                System.out.println("- " + entry.getKey() + " (" + entry.getValue() + " раз)");
            }
        }
    }
}