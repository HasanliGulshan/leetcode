package string;

public class ConsistentStrings {
    public static int countConsistentStrings(String allowed, String[] words) {
         int ans = 0;
         boolean[] allowedMap = new boolean[26];

         for (char c : allowed.toCharArray())
             allowedMap[c - 'a'] = true;

         for (String s : words) {
             boolean flag = true;

             for (char c : s.toCharArray()) {
                 if (!allowedMap[c - 'a']) {
                     flag = false;
                     break;
                 }
             }

             if (flag)
                 ans++;
         }

         return ans;
    }

    public static void main(String[] args) {
        String allowed = "ab";
        String[] words = new String[]{"ad","bd","aaab","baa","badab"};

        System.out.println(countConsistentStrings(allowed, words));
    }
}
