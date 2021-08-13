package arrays;

public class MajorityElement {
    public  int majorityElement(int[] arr) {
        // Number of bits in the integer
        int len = 32;// 4 byte 32 bits
        int n = arr.length;
        // Variable to calculate majority element
        int number = 0;

        // Loop to iterate through all the bits of number
        for (int i = 0; i < len; i++) {
            int count = 0;
            // Loop to iterate through all elements in array
            // to count the total set bit
            // at position i from right
            for (int j = 0; j < n; j++) {
                System.out.println("1 << i " + (1<<i));
                if ((arr[j] & (1 << i)) != 0)
                    count++;
            }

            // If the total set bits exceeds n/2,
            // this bit should be present in majority Element.
            if (count > (n / 2))
                number += (1 << i);
        }

        int count = 0;

        // iterate through array get
        // the count of candidate majority element
        for (int i = 0; i < n; i++)
            if (arr[i] == number)
                count++;

        return (n / 2) < count ? number : 0;
    }

    public static void main(String[] args) {
        int arr[] = {3, 3, 4};
        //majorityElement(arr);
    }
}
