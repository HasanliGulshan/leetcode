package arrays;

public class SortArrayByParity {
    public static int[] sortArrayByParity(int[] A) {
        int even = 0, odd = A.length - 1;

        while (even < odd) {

            if (A[even] %2 != 0 && A[odd] % 2 == 0) {
                int temp = A[even];
                A[even] = A[odd];
                A[odd] = temp;
            }

            if (A[even] %2 == 0)
                even++;

            if (A[odd] %2 != 0)
               odd--;
        }

        for (int n : A) System.out.print(n + " ");

        return A;
    }

    public static void main(String[] args) {
        int[] n = new int[]{3,1,2,4};

        System.out.println(sortArrayByParity(n));
    }
}
