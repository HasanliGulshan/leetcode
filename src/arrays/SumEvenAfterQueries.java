package arrays;

public class SumEvenAfterQueries {
    public static int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int sum = 0;
        int[] ans = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) sum += A[i];
        }

        for (int i = 0; i < A.length; i++) {
            int index = queries[i][1];
            int oldValue = A[index];
            int newValue = queries[i][0] + oldValue;


            if (oldValue % 2 == 0) sum -= oldValue;

            if (newValue % 2 == 0) sum += newValue;

            A[index] = newValue;
            ans[i] = sum;
        }

        for (int a : ans) System.out.print(a + " ");

        return A;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,2,3,4};
        int[][] q = new int[][] {{1,0},{-3,1},{-4,0},{2,3}};

        System.out.println(sumEvenAfterQueries(A, q));
    }
}
