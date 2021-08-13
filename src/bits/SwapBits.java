package bits;

public class SwapBits {
    public static long swapBits(long x, int i, int j) {
           // Extract the i-th and j-th bits, and see if they differ.
        if (((x >>> i) & 1) != ((x >>> j) & 1)) {


            // i-th and j-th bits differ. We will swap them by flipping their values.
            // Select the bits to flip with bitMask. Since xAl = <9 when x = 1 and 1
            // when x = (9, we can perform the flip XOR .
            long bitMask = (1L << i) | (1L << j);

            System.out.println(bitMask);

            x ^= bitMask;
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(66));
        /*System.out.println(Integer.toBinaryString(-2));
        System.out.println("11111111111111111111111111111110".length());*/
        System.out.println(swapBits(73, 6, 1));
    }
}
