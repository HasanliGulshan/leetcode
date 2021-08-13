package amazon;

public class RemovePalindromeSub {
    public static int removePalindromeSub(String s) {
        if (s == null || s.isEmpty()) return 0;

        if (isSubPalindrome( s)) return 1;

        return 2;
    }

    public static boolean isSubPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) return false;

            l++;
            r--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(removePalindromeSub("baabb"));
    }
}
