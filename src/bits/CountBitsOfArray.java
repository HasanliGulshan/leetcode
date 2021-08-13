package bits;

public class CountBitsOfArray {
    public static int[] countBits(int num) {
       int[] bitsNum = new int[num + 1];
       bitsNum[0] = 0;

       for (int i = 1; i < num  + 1; i++) {
           if ((i % 2) == 0) {
               bitsNum[i] = bitsNum[i / 2];
           } else {
               bitsNum[i] = 1 + bitsNum[i / 2];
           }

           //can be like that also if even %2 will be 0 else will be 1, no need if condition
           //bitsNum[i] = bitsNum[i / 2] + i%2;

       }

       return bitsNum;
    }

    public static void main(String[] args) {
         int[] b = countBits(2);
         for (int j : b) {
             System.out.print(j + " ");
         }
    }
}
