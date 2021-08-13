package bits;

public class PowerOfTwo {

    //time exceed
    /*public static boolean isPowerOfTwo(int n) {
       // if (n == 1) return true;
        while (n%2 == 0) {
            n = n >> 1;
        }

        return n ==1;
    }*/

    //for every number that is power of two have only 1 set bit ex : 10
    //when we subtract 1 all unset bits becomes set and all set bits becomes all unset ex : 4 = 100 ,  4-1 =011
    //above condition belongs to power of two numbers
    //these two numbers with AND operation will be 0 if powerFOTwo and not 0 if not
    public static boolean isPowerOfTwo(int n) {
        if (n >= 0) {
            return n!=0 & ((n&(n-1)) == 0);
        }
        //negative number is not power of two
        return false;
    }

    public static void main(String[] args) {
      //  System.out.println(isPowerOfTwo(1000000));
        System.out.println(isPowerOfTwo(-2147483648));
    }
}
