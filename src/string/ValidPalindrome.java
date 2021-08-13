package string;

public class ValidPalindrome {
    public static boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;

            } else {
                return isPalindrome(left, right - 1, s) || isPalindrome(left + 1, right, s);
            }
        }
        return true;
    }

    static boolean isPalindrome (int left, int right, String s) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "cbbcc";
        System.out.println(validPalindrome(s));
    }
}
