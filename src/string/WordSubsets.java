package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSubsets {
    public static List<String> wordSubsets(String[] A, String[] B) {
        List<String> ans = new ArrayList<>();
        boolean check;

        int[] res = count("");

        //get word from B with max letters;
        for (int i = 0; i < B.length; i++) {
            int[] countLetters = count(B[i]);

            for (int j = 0; j < 26; j++) {
                res[j] = Math.max(res[j], countLetters[j]);
            }
        }

        for (int i = 0; i < A.length; i++) {
            int[] countLetters = count(A[i]);
            check = true;

            for (int j = 0; j < 26; j++) {
                if (res[j] != 0 && countLetters[j] < res[j]) {
    /* here if false continue */                check = false;
                    break;
                }
            }

            if (check) ans.add(A[i]);
        }

        //can make last decision with continue statement in second loop without using boolean value
        return ans;
    }

    public static int[] count(String b) {
        int[] res = new int[26];

        for (char c : b.toCharArray()) {
            res[c - 'a']++;
        }
        return res;
    }

    public static void main(String[] args) {
        String[] A = new String[]{"amazon","apple","facebook","google","leetcode"};
        String[] B = new String[]{"ec","oc","ceo"};

        System.out.println(wordSubsets(A, B));
    }
}
