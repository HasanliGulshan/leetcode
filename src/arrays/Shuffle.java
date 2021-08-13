package arrays;

public class Shuffle {

    public static int[] shuffle(int[] nums, int n) {
       int[] ans = new int[nums.length];
       int x = 0;

       for (int i = 0; i < nums.length && n < nums.length; i++) {
           ans[x++] = nums[i];
           ans[x++] = nums[n++];
       }

       for (int i : ans) System.out.print(i + " ");

       return ans;
    }

    public static void main(String[] args) {
        int[] n = new int[]{2,5,1,3,4,7};
        System.out.println(shuffle(n, 3));
    }
}
