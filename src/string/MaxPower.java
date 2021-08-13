package string;

public class MaxPower {
    public static int maxPower(String s) {
        int i = 0, ans = 1, count = 0;

        while (i < s.length() - 1) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                i++;
                count++;
                continue;
            }

            if (count != 0) {
                ans = Math.max(ans, count + 1);
                count = 0;
            } else {
                i++;
            }
        }


        return Math.max(ans, count + 1);
    }

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(maxPower(s));
    }
}
