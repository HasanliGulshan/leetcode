package bits;

public class HammingDistance {
    public static int hammingDistance(int x, int y) {
        //^ is 1 when two bits are different, so first calculate XOR of x and y, then count number of set bits
        int n = x^y;
        int count = 0;
         while (n>0) {
             count++;

             n &= (n - 1);
         }

         return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1,4));
    }
}
