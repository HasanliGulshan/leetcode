package arrays;

public class ReplaceElements {
    public static int[] replaceElements(int[] arr) {
         if (arr.length == 1) {
             arr[0] = -1;
             return arr;
         } else {
             int len = arr.length - 1;
             int temp = arr[len];
             arr[len] = -1;

             for (int i = len - 1; i >= 0; i--) {
                 temp = Math.max(temp, arr[i + 1]);
                 int temp2 = arr[i];
                 arr[i] = temp;
                 temp = temp2;
             }
         }

         for (int i : arr) System.out.print(i + " ");
         return arr;
    }

    public static void main(String[] args) {
        int[] n = new int[] {17};
        System.out.println(replaceElements(n));
    }
}
