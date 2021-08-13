package string;

public class TruncateSentence {
    public static String truncateSentence(String s, int k) {
         StringBuilder sb = new StringBuilder();

         for (int i = 0; i < s.length() && k > 0; i++) {
             if (s.charAt(i) == ' ') {
                 k--;
             }

             if (k != 0)
                sb.append(s.charAt(i));
         }

         return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(truncateSentence("chopper is not a tanuki", 5));
    }
}
