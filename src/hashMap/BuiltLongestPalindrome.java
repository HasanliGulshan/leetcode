package hashMap;

public class BuiltLongestPalindrome {
    public static int longestPalindrome(String s) {
        int[] res = new int[128];
        int ans = 0;

        for (char c : s.toCharArray()) {
            res[c]++;
        }

        for (int value : res) {
            ans += value / 2 * 2;
        }

        return ans < s.length() ? ans + 1 : ans;
    }

    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }
}
