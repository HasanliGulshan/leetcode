package hashMap;

public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        return xor;
    }

    public static void main(String[] args) {
        int[] n = new int[]{2, 2, 2, 2, 2, 1};
        System.out.println(singleNumber(n));
    }
}
