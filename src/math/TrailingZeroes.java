package math;

public class TrailingZeroes {
    public static int trailingZeroes(int n) {
int zeros = 0;
        while (n / 5 > 0) {
            zeros += n / 5;
            n /= 5;
        }

        return zeros;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(14));
    }
}
