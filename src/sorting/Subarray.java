package sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subarray {
    public Integer start;
    public Integer end;

    public Subarray(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    public static Subarray findSmallestSequentiallyCoveringSubset(List<String> paragraph, List<String> keywords) {
        Map<String, Integer> keywordToIdx = new HashMap<>();
        List<Integer> latestOccurrence = new ArrayList<>(keywords.size());
        List<Integer> shortestSubarrayLength = new ArrayList<>(keywords.size());

        for (int i = 0; i < keywords.size(); ++i) {
            latestOccurrence.add(-1);
            shortestSubarrayLength.add(Integer.MAX_VALUE);
            keywordToIdx.put(keywords.get(i), i);
        }

        int shortestDistance = Integer.MAX_VALUE;

        Subarray result = new Subarray(-1, -1);
        for (int i = 0; i < paragraph.size(); ++i) {
            Integer keywordIdx = keywordToIdx.get(paragraph.get(i));
            if (keywordIdx != null) {
                if (keywordIdx == 0) { // First keyword.
                    shortestSubarrayLength.set(0, 1);
                } else if (shortestSubarrayLength.get(keywordIdx - 1) != Integer.MAX_VALUE) {
                    int distanceToPreviousKeyword
                            = i - latestOccurrence.get(keywordIdx - 1);

                    shortestSubarrayLength.set(keywordIdx, distanceToPreviousKeyword + shortestSubarrayLength.get(keywordIdx - 1));
                }

                latestOccurrence.set(keywordIdx, i);
// Last keyword, look for improved subarray.
                if (keywordIdx == keywords.size() - 1 && shortestSubarrayLength.get(shortestSubarrayLength.size() - 1) < shortestDistance) {
                    shortestDistance = shortestSubarrayLength.get(shortestSubarrayLength.size() - 1);
                    result.start = i - shortestSubarrayLength.get(shortestSubarrayLength.size() - 1) + 1;
                    result.end = i;
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> parag = new ArrayList<>();
        parag.add("apple");
        parag.add("banana");
        parag.add("cat");
        parag.add("apple");

        List<String> keyword = new ArrayList<>();
        keyword.add("banana");
        keyword.add("apple");


        //out 1, 3
        Subarray subarray = findSmallestSequentiallyCoveringSubset(parag, keyword);

        System.out.println(subarray.start + " " + subarray.end);
    }
}
