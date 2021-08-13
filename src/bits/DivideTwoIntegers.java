package bits;

public class DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
        if (dividend == 1<<31 && divisor == -1) return Integer.MAX_VALUE;

        long sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;

        long f = dividend;
        long h = divisor;

        f = Math.abs(f);
        h = Math.abs(h);

        long result = 0,  temp = 0;


        for(int i = 31; i>=0; --i) {
            if (temp + (h << i) <= f) {

                temp += h << i;
                result |= 1L << i;

            }
        }

        return (int) (sign * result);
    }

    public static long divide(long x, long y) {
        long sign = ((x < 0) ^ (y < 0)) ? -1 : 1;

        long f = x;
        long h = y;

        f = Math.abs(f);
        h = Math.abs(h);

        long result = 0;
        int power = 32;
        long yPower = y << power;
        while (f >= h) {
            while (yPower > f) {
                yPower >>>= 1;
                --power;
            }
            result += 1L << power;
            f -= yPower;
        }

        return sign * result;
    }


    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        System.out.println(divide(-2147483648, 2));
    }
}
