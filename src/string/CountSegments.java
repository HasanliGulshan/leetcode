package string;

public class CountSegments {
    public static int countSegments(String s) {
        int start = 0, end = s.length() - 1, ans = 0;

        while (start < s.length() && s.charAt(start) == ' ') start++;

        while (end >= 0 && s.charAt(end) == ' ') end--;

        for (int i = start; i <= end; i++) {
            if (s.charAt(i) != ' ') {
                ans++;

                while (i < end && s.charAt(i) != ' ') i++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countSegments("a"));
    }
}
