package arrays;

public class Merge {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        while (m > 0 && n > 0) {

            if (nums1[m - 1] > nums2[n - 1]) {

                nums1[n + m - 1] = nums1[m - 1];
                m--;
            } else {
                nums1[n + m - 1] = nums2[n - 1];
                n--;
            }
        }

        System.out.println(n + " " + m);
        while (n > 0) {
            nums1[n+m - 1] = nums2[n-1];
            n--;
        }

        for (int i=0; i<nums1.length; i++) {
            System.out.print(nums1[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{};
        int[] num2 = new int[]{1};

        merge(num1, 0, num2, 1);
    }
}
