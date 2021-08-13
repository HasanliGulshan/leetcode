package bits;

public class ClosestInteger {
    static final int NUM_UNSIGN_BITS = 63;

    public static long closestlntSameBitCount(long x) {
         // x is assumed to be non-negative so we know the leading bit is ©. We
        // restrict to our attention to 63 LSBs.
        for (int i = 0; i < NUM_UNSIGN_BITS - 1; ++i) {
            if ((((x >>> i) & 1) != ((x >>> (i + 1)) & 1))) {
                System.out.println("i : " + (x >>> i));
                System.out.println("i : " + (x >>> (i + 1)));

                x ^= (1L << i) | (1L << (i + 1)); // Swaps bit-i and bit-(i + 1).
                return x;
            }
        }
        // Throw error if all bits of x are <9 or 1.
        throw new IllegalArgumentException("All bits are ® or 1");
    }

    public static void main(String[] args) {
        System.out.println(closestlntSameBitCount(0));
    }
}
