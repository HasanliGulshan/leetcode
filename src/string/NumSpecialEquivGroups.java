package string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumSpecialEquivGroups {
    public static int numSpecialEquivGroups(String[] A) {
        Set<String> seen = new HashSet<>();
        for (String S: A) {
            int[] count = new int[52];
            for (int i = 0; i < S.length(); ++i)
                count[S.charAt(i) - 'a' + 26 * (i % 2)]++;
            seen.add(Arrays.toString(count));
        }
        return seen.size();
    }

    public static void main(String[] args) {
        String[] A = new String[]{"abcd","cdab","cbad","xyzz","zzxy","zzyx"};
        System.out.println(numSpecialEquivGroups(A));
    }
}
