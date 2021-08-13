package arrays;

public class FindNumbers {
    public static int findNumbers(int[] nums) {
       int ans = 0;

       for (int n : nums) {
           int count = countDigits(n);

           if (count % 2 == 0) ans++;
       }

       return ans;
    }

    static int countDigits(int num) {
        int count = 0;

        while (num > 0) {
            num /= 10;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] n = new int[] {12,345,2,6,7896};
        System.out.println(findNumbers(n));
    }
}
