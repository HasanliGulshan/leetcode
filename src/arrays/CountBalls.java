package arrays;

public class CountBalls {

    public static int countBalls(int lowLimit, int highLimit) {
        int[] count = new int[46];
        int res = 0;

        for (int i = lowLimit; i < highLimit + 1; i++) {
            int ans = 0;
            int temp = i;
            while (temp > 0) {
                ans += temp%10;
                temp /= 10;
            }

            count[ans] ++;
        }

        for (int c : count)
            if (c >= res)
                res = c;

        return res;
    }

    public static void main(String[] args) {
        System.out.println(countBalls(19, 28));
    }
}
