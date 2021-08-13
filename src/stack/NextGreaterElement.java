package stack;

import com.sun.javafx.collections.MappingChange;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n2 = nums2.length;
        int[] nums3 = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = n2 - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) stack.pop();
            map.put(nums2[i], !stack.isEmpty() ? stack.peek() : -1);
            stack.push(nums2[i]);
        }

        for (int j = 0; j < nums1.length; j++)
            nums3[j] = map.get(nums1[j]);

        return nums3;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {4,1,2};
        int[] nums2 = new int[] {1,3,4,2};

        int[] nnn = nextGreaterElement(nums1, nums2);

        for (int j = 0; j < nnn.length; j++) {
            System.out.print(nnn[j] + " ");
        }
    }
}
