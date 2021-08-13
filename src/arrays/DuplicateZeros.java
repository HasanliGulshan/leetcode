package arrays;

public class DuplicateZeros {
   /* public static void duplicateZeros(int[] arr) {
        int len = arr.length - 1;
        int elementCount = 0;

        for (int left = 0; left <= len - elementCount; left++) {

            // Count the zeros
            if (arr[left] == 0) {

                // Edge case: This zero can't be duplicated. We have no more space,
                // as left is pointing to the last element which could be included
                if (left == len - elementCount) {
                    // For this zero we just copy it without duplication.
                    arr[len] = 0;
                    len -= 1;
                    break;
                }
                elementCount++;
            }
        }

        int last = len - elementCount;

        for (int i = last; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + elementCount] = 0;
                elementCount--;
                arr[i + elementCount] = 0;
            } else {
                arr[i + elementCount] = arr[i];
            }
        }


        for (int a : arr) System.out.print(a + " ");
    }*/

    public static void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
               for (int j = arr.length - 1; j > i; j--) {
                   arr[j] = arr[j - 1];
               }
               i++;
            }
        }

        for (int a : arr) System.out.print(a + " ");
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros(arr);
    }
}
