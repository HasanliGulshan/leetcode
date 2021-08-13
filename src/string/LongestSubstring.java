package string;

import java.util.Arrays;

public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        //This array will track current index for the character.
        int[] arr = new int[256];
        Arrays.fill(arr, -1);
        int i = 0;

        for (int j = 0; j<s.length(); j++) {
            //find last index of s
            //update i as last current index of window and last index plus 1
            i = Math.max(i, arr[s.charAt(j)] + 1);

            //update res if we et larger window
            res = Math.max(res, j - i + 1);

            //update last index of j
            arr[s.charAt(j)] = j;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(" "));
    }
}
