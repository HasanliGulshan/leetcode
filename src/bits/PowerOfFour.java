package bits;

public class PowerOfFour {
    public static boolean isPowerOfFour(int n) {
        int count = 0;

        //iff  there is only one set bit in n
        int x = n & (n - 1);

        if ( n > 0 && x == 0)
        {
            //count 0 before set bit
            while(n > 1)
            {
                n >>= 1;
                count += 1;
            }
            //16=10000
            //iff zeros even then power of 4
            return count % 2 == 0;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(4));
    }
}
