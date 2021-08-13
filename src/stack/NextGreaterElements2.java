package stack;

import java.util.Arrays;
import java.util.Stack;

//using stack
public class NextGreaterElements2 {

    public static int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);

        for (int i =  2 * len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i % len] >= nums[stack.peek()]) {
                stack.pop();
            }

            if (!stack.isEmpty())
                   res[i % len] = nums[stack.peek()];

            stack.push(i % len);
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
