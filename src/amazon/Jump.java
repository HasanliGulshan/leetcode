package amazon;

public class Jump {
    public static int jump(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; ) {
            int maxJump = 0;
            int index = 0;

            for (int j = i + 1; j < nums[i] + i; j++) {
                if ( maxJump <= nums[j] + j) {
                    maxJump = nums[j] + j;
                    index = j;
                }
            }


            i = index;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {

        //System.out.println(jump(new int[]{7,0,9,6,9,6,1,7,9,0,1,2,9,0,3}));
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
        // System.out.println(jump(new int[]{2,3,0,1,4}));
        //  System.out.println(jump(new int[]{1,2,3}));
    }
}
