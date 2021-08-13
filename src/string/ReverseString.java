package string;

public class ReverseString {
    public static void reverseString(char[] s) {
        int len = s.length - 1;
       for (int i = 0; i < s.length / 2; i++) {
           char c = s[i];
           s[i] = s[len - i];
           s[len - i] = c;
       }
       for (char c : s)
        System.out.print(c + " ");
    }

    public static void main(String[] args) {
       char[] c = new char[]{'H','a','n','n','a','h'};
       reverseString(c);
    }
}
