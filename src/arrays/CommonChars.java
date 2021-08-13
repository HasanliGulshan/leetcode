package arrays;

import java.util.ArrayList;
import java.util.List;

public class CommonChars {
    public static List<String> commonChars(String[] A) {
        List<String> list = new ArrayList<>();
        int[] ans = new int[26];
        int[] map;

        count(A[0], ans);

        for (int i = 1; i < A.length; i++) {
            map = new int[26];
            count(A[i], map);

            for (int j = 0; j < 26; j++) {
                /*if (ans[j] > 0 && map[j] == 0) {
                //ex : roller does not has b so to et intersect we make 0 in ans
                    ans[j] = 0;
                } else if (ans[j] > map[j]) {
                ex: lock has 1 o to et intersect we assign 1 o to ans
                basically get Math.min
                    ans[j] = map[j];
                    //or use Math.min or et rid of two if ans use Math.min
                    //
                }*/
                ans[j] = Math.min(ans[j], map[j]);
            }
        }

        for (int i = 0; i < 26; i++) {
            int value = ans[i];
            char c = (char) (i + 'a');

            while (value -->0) {
                list.add(Character.toString(c));
            }
            System.out.print(ans[i] + " ");
        }
        return list;
    }

    public static int[] count(String word, int[] c) {
        for (int i = 0; i < word.length(); i++)
            c[word.charAt(i) - 'a']++;

        return  c;
    }

    public static void main(String[] args) {
         String[] s= new String[]{"bella","label","roller"};

        System.out.println(commonChars(s));
    }
}
