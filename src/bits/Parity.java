package bits;

public class Parity {

    //time complexity is O(n) where n is the length of word
    public static short parity(int x) {
        System.out.println(Integer.toBinaryString(x));
        short result = 0;
        while (x != 0) {
            result ^= x & 1;
            x >>>= 1;
            System.out.println(Integer.toBinaryString(x));
        }

        return result;
    }

    //time complexity is O(k) where k is number of set bits
    public static short parity2(int x) {
        System.out.println(Integer.toBinaryString(x));
        short result = 0;
        while (x != 0) {
            result ^= 1;
            x &= (x - 1);
            System.out.println(Integer.toBinaryString(x));
        }

        return result;
    }

    public static void main(String[] args) {
        //System.out.println("ans: " + parity(11));
        System.out.println("ans: " + parity(9));
    }
}
