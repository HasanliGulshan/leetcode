package hashMap;

import java.util.Arrays;

public class ShortestCompletingWord {
    public static String shortestCompletingWord(String licensePlate, String[] words) {
        int[] freq = new int[26];
        int i = Integer.MAX_VALUE;
        String ans = "";

        for (char c: licensePlate.toCharArray()) {
            if (Character.isLetter(c)) {
                freq[Character.toLowerCase(c) - 'a']++;
            }
        }

        int[] wordFreq = new int[26];

        first:
        for (String word : words) {
            Arrays.fill(wordFreq, 0);

            for (char c: word.toCharArray()) {
                if (Character.isLetter(c)) {
                    wordFreq[Character.toLowerCase(c) - 'a']++;
                }
            }

            for (int j = 0; j < freq.length; j++) {
                if (freq[j] != 0) {
                    if (wordFreq[j] >= freq[j]);
                    else
                        continue first;
                }
            }

            if (word.length() < i) {
                ans = word;
                i = word.length();
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "GrC8950";

        String[] ss = new String[]{"measure","other","every","base","according","level","meeting","none","marriage","rest"};

        System.out.println(shortestCompletingWord(s, ss));
    }
}
