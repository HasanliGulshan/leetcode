package bits;

public class ReverseBits {
    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++){
            //first make it 0
            result <<=1;

            //if bit is set then plus
            if ((n&1) == 1) {
                result++;
            }

            //then check rightmost bit
            n >>=1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(13));
    }
}
