package arrays;

public class TwoSum {
    public static int[] twoSum(int[] numbers, int target) {
         int[] sum = new int[2];
         int j = numbers.length - 1;
         int i = 0;

         while (i < numbers.length && j>=0) {
             if (numbers[i] + numbers[j] > target)
                 j--;
             if (numbers[i] + numbers[j] < target)
                 i++;
             if (numbers[i] + numbers[j] == target) {
                 sum[0] = i + 1;
                 sum[1] = j + 1;
                 return sum;
             }
         }
         return sum;
    }

    public static void main(String[] args) {
        int[] n = new int[]{2,7,11,15};
        System.out.println(twoSum(n, 9));
    }
}
