package amazon;

public class CanJump {
    public static boolean canJump(int[] nums) {
        int maxReachedIndex = 0;

        for (int i = 0; i < nums.length; i++) {

            if (maxReachedIndex < i) return false;

            maxReachedIndex = Math.max(maxReachedIndex, i +  nums[i]);
        }

        return maxReachedIndex >= nums.length - 1;
    }

    public static void main(String[] args) {

        //0 1 2
        //2 5 0 0
        //2 0 3 8  5
        System.out.println(canJump(new int[]{0 , 1, 2}));
    }
}
