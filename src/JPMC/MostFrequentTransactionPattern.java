package JPMC;
import java.util.*;

public class MostFrequentTransactionPattern {
    public static String mostFrequent(String[] arr) {
        Map<String, Integer> freq = new HashMap<>();

        for (String s : arr) {
            freq.put(s, freq.getOrDefault(s, 0) + 1);
        }

        String best = "";
        int bestCount = 0;

        for (Map.Entry<String, Integer> e : freq.entrySet()) {
            String key = e.getKey();
            int count = e.getValue();

            if (count > bestCount || (count == bestCount && key.compareTo(best) < 0)) {
                best = key;
                bestCount = count;
            }
        }

        return best;
    }

    public static void main(String[] args) {
        String[] arr = {"BUY","SELL","BUY","HOLD","SELL","BUY"};
        System.out.println(mostFrequent(arr)); // BUY
    }
}
