package hashMap;

import java.util.*;

public class Subarray {
    public Integer start;
    public Integer end;

    public Subarray(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    public static Subarray findSmallestSubarrayCoveringSet(List<String> paragraph,
                                                           Set<String> keywords) {
        Map<String, Integer> keywordsToCover = new HashMap<>();
        for (String keyword : keywords) {
            keywordsToCover.put(keyword, keywordsToCover.containsKey(keyword)
                    ? keywordsToCover.get(keyword) + 1 : 1);
        }
        Subarray result = new Subarray(-1, -1);
        int remainingToCover = keywords.size();
        for (int left = 0, right = 0; right < paragraph.size(); ++right) {
            Integer keywordCount = keywordsToCover.get(paragraph.get(right));
            if (keywordCount != null) {
                keywordsToCover.put(paragraph.get(right), --keywordCount);
                if (keywordCount >= 0){
                    --remainingToCover;
                }
            }
            // Keeps advancing left until it reaches end or keywordsToCover does not
            // have all keywords .
            while (remainingToCover == 0){
                if ((result.start == -1 && result.end == -1)
                        || right - left < result.end - result.start) {
                    result.start = left;
                    result.end = right;
                }
                keywordCount = keywordsToCover.get(paragraph.get(left));
                if (keywordCount != null) {
                    keywordsToCover.put(paragraph.get(left), ++keywordCount);
                    if (keywordCount > 0){
                        ++remainingToCover;
                    }
                }
                ++left;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
       /* My paramount object in this struggle is to save the Union, and is not either to
        save or to destroy slavery. If I could save the Union without freeing any slave I
        would do it, and if I could save it by freeing all the slaves I would do it; and if I
        could save it by freeing some and leaving others alone I would also do that.
            */
        list.add("apple");
        list.add("banana");
        list.add("apple");
        list.add("apple");
        list.add("dog");
        list.add("cat");
        list.add("apple");
        list.add("dog");
        list.add("banana");
        list.add("apple");
        list.add("cat");
        list.add("dog");

        Set<String> set = new HashSet<>();
        set.add("banana");
        set.add("cat");

        Subarray subarray = findSmallestSubarrayCoveringSet(list, set);

        System.out.println(subarray.start + " " + subarray.end);
    }
}
