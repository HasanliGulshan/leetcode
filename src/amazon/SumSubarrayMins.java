package amazon;

public class SumSubarrayMins {
    public static int sumSubarrayMins(int[] A) {
        long sum = 0;

        for (int n : A) {
            sum += n;
        }

        for (int i = 0; i < A.length; i++) {
            int min = Integer.MAX_VALUE;
            int local = A[i];
            for (int j = i + 1; j < A.length; j++) {
                local = Math.min(local, A[j]);
                min = Math.min(local, min);
                sum += min;
            }
        }

        long M = 1000000007;
        return (int) (sum % M);
    }

    public static void main(String[] args) {
        System.out.println(sumSubarrayMins(new int[]{95,58,46,67,100}));
    }
}
