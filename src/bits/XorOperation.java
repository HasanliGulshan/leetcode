package bits;

public class XorOperation {
    public static int xorOperation(int n, int start) {
        int result = 0;

        for (int i = 0; i < n; i++) {
            int j = start + i * 2;
            result ^= j;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(xorOperation(1, 7));
    }
}
