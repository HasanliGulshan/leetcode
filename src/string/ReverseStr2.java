package string;

public class ReverseStr2 {
    public static String reverseStr(String s, int k) {
        char[] c = s.toCharArray();

        for (int i = 0; i < s.length(); i += 2*k) {
            int start = i, end = Math.min(start + k - 1, s.length() - 1);

            while (start < end) {
                char j = c[start];
                c[start] = c[end];
                c[end] = j;
                start++;
                end--;
            }
        }

        return new String(c);
    }

    public static void main(String[] args) {
        System.out.println(reverseStr("abc", 2));
    }
}
