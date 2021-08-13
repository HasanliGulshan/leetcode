package bits;

import java.util.ArrayList;
import java.util.List;

public class CountBits {
   /* public static short countBits(int x) {
        short numBits = 0;

        while (x != 0){
            numBits += (x & 1);

            //right shift to check ith bit with AND operation if it is set or unset
            x >>>= 1;
        }
        return numBits;
    }*/

   public static int countBits2(int x) {
       short count=0;

       while (x > 0) {
           count++;
           x = x & (x -1);
       }

       return count;
   }

    public static void main(String[] args) {
        //System.out.println(countBits(5));
        System.out.println(countBits2(5));

        byte ff = 127;
        List<Integer> list = new ArrayList<>();
        //we are passing as a parameter (primitive type int) to list
        list.add(5);
        //we are assigning primitive type to corresponding wrapper class
        Integer a = 5;
        a = Integer.valueOf(5);

        //here above two do not apply, so compile time error
        //Character[] c = new char[]{'a', 'b'};
       // Integer[] integers = new int[]{1,2};

        Integer[] integers1 = new Integer[]{1,2};

        System.out.println(Integer.toBinaryString(-16));
        System.out.println(Integer.toBinaryString(16));

        System.out.println(Integer.toBinaryString(-2));
        System.out.println(Integer.toBinaryString(2));
    }
}
