package bits;

public class DecToHex {
    public static String toHex(int num) {
        String c = "0123456789abcdef";
        StringBuilder sb = new StringBuilder();
        long carry = 0;

        for (long i = num > 0 ? num : num&0xffffffffL; i != 0; i>>=4)
        {
            /*System.out.println("i:    " + Integer.toBinaryString((int)i));
            System.out.println("0xf:  " + Integer.toBinaryString(0xf));
            System.out.println("&&&&   " + Integer.toBinaryString((int)i&0xf));*/
            carry = i % 16;
            sb.insert(0, c.charAt((int)carry));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
       // System.out.println(toHex(-1));
        System.out.println(Integer.toBinaryString(-4));

        //toBinaryString is same with unsigned long y, we get correct binary value of negative number with AND 0xffffffffL
        //-4 to get binary we invert and add 1 to get this result
        int x = -4;
        long y = x & 0xffffffffL;

        System.out.println("y: " + Integer.toBinaryString((int)y));

        System.out.println(Integer.toBinaryString(5));
// dont need for positive values, 5 already 101 in binary
        long h = 5 & 0xffffffffL;
        System.out.println(Integer.toBinaryString((int) h));

    }
}
