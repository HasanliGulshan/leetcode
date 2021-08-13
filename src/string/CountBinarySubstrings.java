package string;

import java.util.ArrayList;
import java.util.List;

public class CountBinarySubstrings {
    public static int countBinarySubstrings(String s) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < s.length();) {
            int count = 0;
            while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                i++;
                count++;
            }

            list.add(count + 1);
            i++;
        }

        System.out.println(list);
        int binarySubs = 0;

        for (int i = 0; i < list.size() - 1; i++) {
            binarySubs += Math.min(list.get(i), list.get(i + 1));
        }

        return binarySubs;
    }

    public static void main(String[] args) {
        System.out.println(countBinarySubstrings("10101"));
    }
}
