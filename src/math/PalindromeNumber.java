package math;

public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;

        int digits = (int) Math.floor(Math.log10(x)) + 1;
        int msdMask = (int) Math.pow(10, digits - 1);

        for (int i = 0; i < (digits/2); i++) {
            int lsd = x%10;
            int rsd = x/msdMask;

            if (lsd != rsd) return false;

            //remove the most significant digit ex : 571 % 100 = 71
            x %= msdMask;

            //remove the least significant digit ex : 71 / 10 = 7
            x /= 10;

            //every time we remove lsd and msd so remove two trailing zeros
            msdMask /= 100;
        }

        //TC O(n)
        //SC (1)

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(157751));
    }
}
