package hashMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindNearestRepetition {
    public static int findNearestRepetition(List<String> paragraph) {
        Map<String, Integer> wordToLatestIndex = new HashMap<>();
        int nearestRepeatedDistance = Integer.MAX_VALUE;
        for (int i = 0; i < paragraph.size(); ++i) {
            if (wordToLatestIndex.containsKey(paragraph.get(i))) {
                nearestRepeatedDistance
                        = Math.min(nearestRepeatedDistance,
                        i - wordToLatestIndex.get(paragraph.get(i)));
            }
            wordToLatestIndex.put(paragraph.get(i), i);
        }
        return nearestRepeatedDistance;
    }

    public static void main(String[] args) {

    }
}
