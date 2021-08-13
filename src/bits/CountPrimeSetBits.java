package bits;

public class CountPrimeSetBits {

    public static int countPrimeSetBits(int L, int R) {
        int res = 0;
        for (int i = L; i <= R; i++) {
            int num = i;
            int count =0;
            while (num > 0) {
                count++;
                num = num & (num -1);
            }

            if (isBoolean(count)) res++;
        }

        return res;
    }

    public static boolean isBoolean(int i) {
        return (i == 2) || (i == 3) || (i == 5) || (i == 7) || (i == 11) ||
                (i == 13) || (i == 17) || (i == 19);
    }

    public static void main(String[] args) {
        System.out.println(countPrimeSetBits(6, 10));
    }
}
