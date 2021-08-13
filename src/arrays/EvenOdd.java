package arrays;

public class EvenOdd {
    public static void evenOdd(int[] A) {
        int nextEven = 0, nextOdd = A.length - 1;

        while (nextEven < nextOdd) {
            if (A[nextEven] % 2 == 0) {
                nextEven++;
            } else {
                int temp = A[nextEven];
                A[nextEven] = A[nextOdd];
                A[nextOdd--] = temp;
            }
        }
        for (int i : A) System.out.print(i + " ");
    }

    public static void main(String[] args) {
        int[] n = new int[]{9, 8, 6, 5 ,4, 7};
        evenOdd(n);
    }
}
