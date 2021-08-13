package recursion;

public class CheckPowersOfThree {

    public static boolean checkPowersOfThree(int n) {
        for (int i = 15; i >= 0; i--) {
            int x = (int)Math.pow(3, i);

            if (x <= n) n -= x;

            if (n == 0) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkPowersOfThree(91));
    }
}
