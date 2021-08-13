package string;



public class ReverseVowels {
    public static String reverseVowels(String s) {
        int start = 0;
        int end = s.length() - 1;
        char[] reverse = s.toCharArray();
        StringBuilder sb = new StringBuilder(s);

        while (start < end) {
            if (!isVowel(reverse[start])) {
                start++;
                continue;
            }

            if (!isVowel(reverse[end])) {
                end--;
                continue;
            }

            char endChar = reverse[end];
            char startChar = reverse[start];
            reverse[end] = startChar;
            reverse[start] = endChar;

            start++;
            end--;
        }
         return new String(reverse);
    }


    public static boolean isVowel(char c) {
        return c == 'a' || c == 'A'
                || c == 'e' || c == 'E'
                || c == 'i' || c == 'I'
                || c == 'o' || c == 'O'
                || c == 'u' || c == 'U';
    }

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(reverseVowels(s));
    }
}
