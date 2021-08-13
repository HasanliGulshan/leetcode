package amazon;

public class LeastSubstring {
    public static int getAns(String s, int k) {
        int count = 0, j = 1;
        int len = s.length();

        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == s.charAt(i - 1) && j < k) {
                j++;
            } else {
              count++;
              j = 1;
            }
        }

        count++;
        return count;
    }

    public static void main(String[] args) {
        System.out.println(getAns("aabbb", 3));
    }
}
