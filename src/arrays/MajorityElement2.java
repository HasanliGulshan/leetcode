package arrays;

public class MajorityElement2 {
    public static int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    public static void main(String[] args) {
        int arr[] = {7, 7, 5, 7, 5, 1 ,5, 7 , 5, 5, 7, 7 , 5, 5, 5, 5};
        System.out.println(majorityElement(arr));
    }
}
