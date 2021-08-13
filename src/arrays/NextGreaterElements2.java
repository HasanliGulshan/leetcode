package arrays;

public class NextGreaterElements2 {
    public static int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            // if not found default value for i th will be -1
            res[i] = -1;
            for (int j = 0; j < len; j++) {
                if (nums[i] < nums[(i + j) % len]) {
                    //have found next greater element for ith then break
                    res[i] = nums[(i + j) % len];
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = new int[]{1,2,1};
        int[] r = nextGreaterElements(res);

        for (int h : r) {
            System.out.print(h + " ");
        }
    }
}
