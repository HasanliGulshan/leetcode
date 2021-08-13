package heap;

import javafx.util.Pair;

import java.util.*;

public class TopKFrequent2 {
    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Pair<String, Integer>> queue = new PriorityQueue<>(k, new Comparator<Pair<String, Integer>>() {
            @Override
            public int compare(Pair<String, Integer> o1, Pair<String, Integer> o2) {
                int firstCondition = Integer.compare(o2.getValue(), o1.getValue());

                return firstCondition == 0 ? o1.getKey().compareTo(o2.getKey()) : firstCondition;
            }
        });

        for (Map.Entry<String, Integer> m : map.entrySet()) {
            queue.add(new Pair<>(m.getKey(), m.getValue()));
        }

        List<String> list = new ArrayList<>();

        while (!queue.isEmpty() && k -- > 0) {
            list.add(queue.poll().getKey());
        }

        return list;
    }

    public static void main(String[] args) {
        String[] s = new String[]{"i", "love", "leetcode", "i", "love", "coding"};

        System.out.println(topKFrequent(s, 2));
    }
}
