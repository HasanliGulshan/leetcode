package arrays;

public class Merge2 {
    public static void merge(int[] A, int m, int[] B, int n) {
        // In this code we start comparison from the last index
        //first compare the last non-zero element of A with last element of B

        while(m > 0 && n > 0){ //We need to make sure that both m and n should be initialized first
            if(A[m-1]>B[n-1]) // comparing elements
            {
                A[m+n-1]=A[m-1]; //last element set
                m--; //if the element is set from first array then decrease the m index
            }
            else
            {
                A[m+n-1]=B[n-1]; //last element set
                n--; //if the element is set from second array then decrease the n index
            }
        }
        // Special case where you dont have any initialize element in A and 1 elements in B then copy element of B in A
        while(n>0)
        {
            A[m+n-1]=B[n-1];
            n--;
        }

        for (int i=0; i<A.length; i++) {
            System.out.print(A[i] + " ");
        }

    }

    public static void main(String[] args) {
        int[] num1 = new int[]{};
        int[] num2 = new int[]{1};

        merge(num1, 0, num2, 1);
    }
}
