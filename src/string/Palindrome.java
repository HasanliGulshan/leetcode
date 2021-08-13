package string;

public class Palindrome {
    public static boolean isPalindrome(String s) {
        int leftIdx = 0;
        int rightIdx = s.length() - 1;

        while (leftIdx < rightIdx) {
            while (leftIdx < rightIdx && !Character.isLetterOrDigit(s.charAt(leftIdx)))
                leftIdx++;

            if (leftIdx == rightIdx)
                return true; // left not found - nothing to check

            int left = s.charAt(leftIdx);

            while (leftIdx <= rightIdx && !Character.isLetterOrDigit(s.charAt(rightIdx)))
                rightIdx--;

            if (Character.toLowerCase(left) != Character.toLowerCase(s.charAt(rightIdx)))
                return false;

            leftIdx++;
            rightIdx--;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = ".,";
        System.out.println(isPalindrome(s));
    }
}
