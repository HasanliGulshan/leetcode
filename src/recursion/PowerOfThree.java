package recursion;

public class PowerOfThree {
    public static boolean isPowerOfThree(int n) {
         if (n <= 0) return false;

         return 1162261467 % n == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(27));
    }
}
