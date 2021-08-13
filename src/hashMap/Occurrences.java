package hashMap;

import java.util.ArrayList;
import java.util.List;

public class Occurrences {
    public static String[] findOccurrences(String text, String first, String second) {
         String[] words = text.split(" ");
         List<String> ans = new ArrayList<>();

         for (int i = 0; i < words.length - 1; i++) {
             if (words[i].equals(first) && words[i + 1].equals(second)) {
                 if ((i + 2) <= words.length - 1)
                     ans.add(words[i + 2]);
             }
         }

         String[] res = new String[ans.size()];

         return ans.toArray(res);
    }

    public static void main(String[] args) {
       String text = "we will we will rock you", first = "we", second = "will";
        System.out.println(findOccurrences(text, first, second));
    }
}
