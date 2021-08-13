package hashMap;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public static List<Integer> partitionLabels(String s) {
        List<Integer> idLength = new ArrayList<>();
        int[] index = new int[26];

        for (int i = 0; i < s.length(); i++) {
            index[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            int lastIndex = index[s.charAt(i) - 'a'];

            int startIndex = i;
            while (startIndex < lastIndex) {
                int check = index[s.charAt(startIndex) - 'a'];

                if (check > lastIndex) {
                    lastIndex = check;
                }

                startIndex++;
            }


            String sub = s.substring(i, lastIndex + 1);
            System.out.println(sub);
            idLength.add(sub.length());
            i = lastIndex;
        }

        return idLength;
    }

    public static void main(String[] args) {
        System.out.println(partitionLabels("eccbbbbdec"));
    }
}
