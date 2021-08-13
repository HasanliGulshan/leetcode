package recursion;

import java.util.Arrays;

public class Tribonacci {
    public static int tribonacci(int n) {
        if (n == 0) return n;

        if (n == 2 || n == 1) return 1;

        int[] r = new int[n + 1];
        Arrays.fill(r,-1);

        r[0] = 0;
        r[1] = 1;
        r[2] = 1;

       /* if (n >= 3)
            return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);

        */
       
        int sum = tri(n, r);
        for (int i : r) {
            System.out.println(i);
        }
        return sum;
    }

    public static int tri(int n, int[] r) {
        if (r[n] != -1) {return r[n];}
        else {
            r[n] = tri(n - 1, r) + tri(n - 2, r) + tri(n - 3, r);
        }
return r[n];
    }

    public static void main(String[] args) {
        System.out.println(tribonacci(4));
    }
}
