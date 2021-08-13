package heap;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {
    public static String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Pair<Character, Integer>> queue = new PriorityQueue<>(new Comparator<Pair<Character, Integer>>() {
            @Override
            public int compare(Pair<Character, Integer> o1, Pair<Character, Integer> o2) {
                return o1.getValue() > o2.getValue() ? -1 : 1;
            }
        });

        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            queue.add(new Pair<>(m.getKey(), m.getValue()));
        }

        StringBuilder ans = new StringBuilder();

        while (!queue.isEmpty()) {
            Pair<Character, Integer> p = queue.poll();
            int value = p.getValue();
            while (value --> 0) {
                ans.append(p.getKey());
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("Aabb"));
    }
}
