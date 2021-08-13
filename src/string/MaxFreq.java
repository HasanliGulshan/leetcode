package string;

import java.util.HashMap;

public class MaxFreq {
    public static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        HashMap<String, Integer> map = new HashMap<>();
        String min = "", max = "";
        int maxOccurrence = 0;

        for (int i = 0; i < s.length(); i++) {
            boolean minValid = false;
            boolean maxValid = false;

            if (i + minSize <= s.length()) {
                min = s.substring(i, i + minSize);
                minValid = true;
            }

            if (minSize != maxSize && i + maxSize <= s.length()) {
                max = s.substring(i, i + maxSize);
                maxValid = true;
            }

            int uniqueChars = 0;
            boolean[] count = new boolean[26];

            if (minValid) {
                for (int j = 0; j < minSize; j++) {
                    int index = min.charAt(j) - 'a';
                    if (!count[index]) {
                        uniqueChars++;
                        count[index] = true;
                    }
                }


                if (uniqueChars <= maxLetters) {

                    map.put(min, map.getOrDefault(min, 0) + 1);

                    if (maxValid) {
                        for (int j = minSize; j < maxSize; j++) {
                            int index = max.charAt(j) - 'a';
                            if (!count[index]) {
                                uniqueChars++;
                                count[index] = true;
                            }
                        }

                        if (uniqueChars <= maxLetters) map.put(max, map.getOrDefault(max, 0) + 1);
                    }
                }
            }
        }

        for (int value : map.values()) {
            maxOccurrence = Math.max(value, maxOccurrence);
        }

        return maxOccurrence;
    }

    public static void main(String[] args) {
        System.out.println(maxFreq("aababcaab", 2, 3, 4));
    }
}
